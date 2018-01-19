package com.yzm.demo;

import com.fly.httptest.utils.HttpClientUtils;
import com.yzm.demo.api.UserInfo;
import com.yzm.demo.api.UserService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/1/19.
 */
public class Candy {
    private static UserInfo userInfo = new UserInfo();

    /**
     * 发送验证码
     * @param inviteId
     * @param phone
     * @param ip
     * @param port
     * @return
     */
    private static boolean candySend(String inviteId, String phone, String ip, int port) {
        try {
            String url = "https://candy.one/i/" + inviteId;
            Header[] validCodeHeader = new Header[]{
                    new BasicHeader("Host", "candy.one"),
                    new BasicHeader("Connection", "keep-alive"),
                    new BasicHeader("Origin", "https://candy.one"),
                    new BasicHeader("Upgrade-Insecure-Requests", "1"),
                    new BasicHeader("Content-Type", "application/x-www-form-urlencoded"),
                    new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36"),
                    new BasicHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8"),
                    new BasicHeader("Referer", url),
                    new BasicHeader("Accept-Encoding", "gzip, deflate, br"),
                    new BasicHeader("Accept-Language", "zh-CN,zh;q=0.9")
            };
            List<NameValuePair> paramList = new ArrayList<NameValuePair>();
            paramList.add(new BasicNameValuePair("phone", phone));
            paramList.add(new BasicNameValuePair("dialcode", "86"));
            paramList.add(new BasicNameValuePair("countrycode", "cn"));
            paramList.add(new BasicNameValuePair("status", "login"));
            paramList.add(new BasicNameValuePair("enroll_id", inviteId));

            String resultStr = HttpClientUtils.postWithProxyParamList(url, paramList, validCodeHeader, ip, port);
            if (null != resultStr && resultStr.contains("//服务器访问正常")) { // 发送短信成功
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    private void getCode(String inviteId, String phone, String ip, int port) {
        try {
            // 获取验证码
            String valid = getVcodeAndReleaseMobile(phone, "mephistodemon", 0);
            System.out.println(String.format("[%s]获取验证码方法执行成功...", valid));
            if (StringUtils.isNotBlank(valid)) {
                FileUtils.write(new File("candy_phone.txt"), valid + "\n", "utf-8", true);
                // 解析验证码
                String code = valid.split(" ")[2].substring(0, 6);
                if (StringUtils.isNotBlank(code)) {
                    String checkUrl = "https://candy.one/check_msg?phone=86" + phone + "&code=" + code;
                    Header[] checkHeader = new Header[]{
                            new BasicHeader("Host", "candy.one"),
                            new BasicHeader("Connection", "keep-alive"),
                            new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.94 Safari/537.36"),
                            new BasicHeader("Accept", "*/*"),
                            new BasicHeader("Referer", "https://candy.one/i/" + inviteId),
                            new BasicHeader("Accept-Encoding", "gzip, deflate, br"),
                            new BasicHeader("Accept-Language", "zh-CN,zh;q=0.9")
                    };
                    String result = HttpClientUtils.getWithProxyHeader(checkUrl, checkHeader, ip, port);
                    if (null != result && result.equals("ok")) {

                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取验证码并不再使用本号
     *
     * @param mobileNum 用getMobilenum方法获取到的手机号
     * @param author_uid 软件开发者用户名(可选, 可得10%的消费分成)
     * @return 成功返回：手机号码|验证码短信 失败请参考文档
     */
    private static String getVcodeAndReleaseMobile(String mobileNum, String author_uid, int times) {
        try {
            if (userInfo.isLogin()) {
                String result = UserService.getVcodeAndReleaseMobile(userInfo.getUid(), userInfo.getToken(), mobileNum, author_uid);
                System.out.println(result);
                if ("not_receive".equals(result) || "message|please try again later".equals(result)) {
                    try {
                        if (times < 10) {
                            Thread.sleep(5000);
                            return getVcodeAndReleaseMobile(mobileNum, author_uid, ++times);
                        } else {
                            return "";
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                return result;
            }
        } catch (Exception e) {
            return getVcodeAndReleaseMobile(mobileNum, author_uid, ++times);
        }
        return "";
    }

}
