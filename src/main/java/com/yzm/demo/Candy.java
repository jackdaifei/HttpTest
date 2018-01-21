package com.yzm.demo;

import com.fly.httptest.utils.HttpClientUtils;
import com.yzm.demo.api.MyControl;
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

    public static void main(String[] args) {
        try {

            Boolean loginBoolean = login("mephistodemon", "fishcatdog1");
            String projectId = "38100";
            String inviteId = "189225";
            String ip = "";
            int port = 0;

            if (loginBoolean) {
                getUserInfos();
                String phone = null;
                boolean isPhoneUse = false;
                if (!isPhoneUse) {
                    phone = getMobileNum("38100").split("\\|")[0]; // 获取手机号
                }
                boolean isSend = candySend(inviteId, phone, ip, port);
                if (isSend) {
                    Thread.sleep(10000);
                    String code = getCode(inviteId, phone, ip, port);
                    if (StringUtils.isBlank(code)) {
                        submitUser(inviteId, phone, code,ip, port);
                    }

                }



            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    /**
     * 登 陆
     *
     * @param userName 用户名
     * @param password 密码
     * @return true or false
     */
    public static Boolean login(String userName, String password) {
        userInfo.setUid(userName);
        userInfo.setPwd(password);
        String result = UserService.login(userInfo);
        if (MyControl.isNull(result)) {
            System.out.println("login fail  result = " +result);
            return false;
        }
        if (result.toLowerCase().startsWith(userInfo.getUid().toLowerCase())) {
            String[] strings = result.split("\\|");
            userInfo.setToken(strings[1]);
            return true;
        }
        else{
            System.out.println("login fail  result = " +result);
            return false;
        }
    }

    /**
     * 获取用户个人信息
     *
     * @return 成功返回：用户名;积分;余额;可同时获取号码数 失败请参考文档
     */
    public static String getUserInfos() {
        if (userInfo.isLogin()) {
            String result = UserService.getUserInfo(userInfo.getUid(), userInfo.getToken());
            System.out.println(result);
            return result;
        }
        return "";
    }

    /**
     * 获取手机号码
     *
     * @param pid 项目ID
     * @return 成功返回：手机号码|token 失败请参考文档
     */
    public static String getMobileNum(String pid) {
        if (userInfo.isLogin()) {
            String result = UserService.getMobileNum(pid, userInfo.getUid(), userInfo.getToken());
            System.out.println(result);
            return result;
        }
        return "";
    }

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

    /**
     * 获取验证码
     * @param inviteId
     * @param phone
     * @param ip
     * @param port
     */
    private static String getCode(String inviteId, String phone, String ip, int port) {
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
                    if (null != result && result.equals("ok")) { // 验证码通过
                        return code;
                    }
                    System.out.println("check验证码失败, result=" + result);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void submitUser(String inviteId, String phone, String code, String ip, int port) {
        try {
            String submitUrl = "https://candy.one/user";
            Header[] submitHeader = new Header[]{
                    new BasicHeader("Host", "candy.one"),
                    new BasicHeader("Connection", "keep-alive"),
                    new BasicHeader("Origin", "https://candy.one"),
                    new BasicHeader("Upgrade-Insecure-Requests", "1"),
                    new BasicHeader("Content-Type", "application/x-www-form-urlencoded"),
                    new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.94 Safari/537.36"),
                    new BasicHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8"),
                    new BasicHeader("Referer", "https://candy.one/i/" + inviteId),
                    new BasicHeader("Accept-Encoding", "gzip, deflate, br"),
                    new BasicHeader("Accept-Language", "zh-CN,zh;q=0.9"),
            };
            List<NameValuePair> paramSubmitList = new ArrayList<NameValuePair>();
            paramSubmitList.add(new BasicNameValuePair("phone", "86" + phone));
            paramSubmitList.add(new BasicNameValuePair("code", code));
            paramSubmitList.add(new BasicNameValuePair("countrycode", "CN"));
            paramSubmitList.add(new BasicNameValuePair("status", "send_msg"));
            String submitResult = HttpClientUtils.postWithProxyParamList(submitUrl, paramSubmitList, submitHeader, ip, port);
            System.out.println(submitResult);
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
