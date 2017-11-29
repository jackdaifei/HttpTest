package com.yzm.demo;

import com.alibaba.fastjson.JSONObject;
import com.fly.httptest.utils.HttpClientUtils;
import com.yzm.demo.api.MyControl;
import com.yzm.demo.api.UserInfo;
import com.yzm.demo.api.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class Test {
	private static UserInfo userInfo = new UserInfo();

	/**
	 * 主入口，在这里调用登陆，获取手机号，验证码等方法
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		Boolean loginBoolean = login("mephistodemon", "fishcatdog1");
		if (loginBoolean) {
			getUserInfos();

			boolean isUse = true;
			String phone = "";
			List<JSONObject> proxyInfoList = getProxyInfo();
			int count = 1;
			for (JSONObject proxyInfo : proxyInfoList) {
				System.out.println("-------------------------" + count++);
				String ip = proxyInfo.getString("ip");
				int port = proxyInfo.getIntValue("port");

				String result = HttpClientUtils.getWithProxy("https://www.baidu.com/", ip, port);
				if (null != result && result.contains("<!--STATUS OK-->")) { // 检测代理有效

					if (isUse) {
						phone = getMobileNum("33544").split("\\|")[0]; // 获取手机号
						isUse = false;
					}

					String jsonStr = "{\"phone\":\"+86%s\",\"purpose\":\"SESSION\"}";
					// 发送验证码
					JSONObject jsonObject = HttpClientUtils.postWithProxy("https://api.mixin.one/verifications", String.format(jsonStr, phone), ip, port);
					if (null == jsonObject) {
						continue;
					}
					Thread.sleep(10000);
					// 获取验证码
					String valid = getVcodeAndReleaseMobile(phone, "mephistodemon", 0);
//					System.out.println(valid);
					if (StringUtils.isNotBlank(valid)) {
						// 解析验证码
						String code = valid.split("\\|")[1].split(" ")[2];
						System.out.println(code);
						if (StringUtils.isNotBlank(code)) {
							// 注册
							String verification_id = jsonObject.getJSONObject("data").getString("id");
							String jsonStr2 = "{\"code\":\"" + code + "\",\"phone\":\"+86" + phone + "\",\"verification_id\":\"" + verification_id + "\",\"invitation_code\":\"274565\",\"purpose\":\"SESSION\",\"platform\":\"Web\"}";
							HttpClientUtils.postWithProxy("https://api.mixin.one/verifications/" + verification_id, jsonStr2, ip, port);
							isUse = true;
						}
					} else {
						addIgnore(phone, "33544");
						isUse = true;
					}
				}
			}

		} else {
			System.out.println("登陆失败");
		}

//        String proxyUrl = "113.122.0.178";
//        int proxyPort = 808;
//        String code = "0840";
//        String verification_id = "d56d26d1-9a19-4607-bf56-b3a0450ff404";
//        String jsonStr2 = "{\"code\":\"" + code + "\",\"phone\":\"+86" + "13152807102" + "\",\"verification_id\":\"" + verification_id + "\",\"invitation_code\":\"198353\",\"purpose\":\"SESSION\",\"platform\":\"Web\"}";
//        HttpClientUtils.postWithProxy("https://api.mixin.one/verifications/" + verification_id, jsonStr2, proxyUrl, proxyPort);

//		String valid = "15604457404|Mixin code 5300 [PIN]";
//		String code = valid.split("\\|")[1].split(" ")[2];
//		System.out.println(code);
	}

	private static List<JSONObject> getProxyInfo() throws Exception {
		Header[] headers = new Header[]{
				new BasicHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8"),
				new BasicHeader("Accept-Encoding", "gzip, deflate"),
				new BasicHeader("Accept-Language", "zh-CN,zh;q=0.9"),
				new BasicHeader("Cache-Control", "max-age=0"),
				new BasicHeader("Connection", "keep-alive"),
				new BasicHeader("Host", "www.xicidaili.com"),
				new BasicHeader("Referer", "http://www.xicidaili.com/nn/2"),
				new BasicHeader("Upgrade-Insecure-Requests", "1"),
				new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.94 Safari/537.36")
		};
		String agent = "http://www.xicidaili.com/nn/";
		String content = HttpClientUtils.getResponseString(agent, headers);
		Document document = Jsoup.parse(content);
		Elements elements = document.select("#ip_list tr");
		List<JSONObject> proxyInfoList = new ArrayList<JSONObject>();
		for (int i = 1; i < elements.size(); i++) {
			Element e = elements.get(i);
			String ip = e.child(1).text();
			String port = e.child(2).text();
			JSONObject proxyInfo = new JSONObject();
			proxyInfo.put("ip", ip);
			proxyInfo.put("port", port);
			proxyInfoList.add(proxyInfo);
		}
		return proxyInfoList;
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
	 *
	 * @param mobileNum 用getMobilenum方法获取到的手机号
	 * @param pid 项目ID
	 * @return 成功返回：加黑成功的号码数量 失败请参考文档
	 */
	public static String addIgnore(String mobileNum, String pid) {
		try {
			if (userInfo.isLogin()) {
				String result = UserService.addIgnore(mobileNum, userInfo.getUid(), userInfo.getToken(), pid);
				System.out.println(result);
				return result;
			}
		} catch (Exception e) {
			addIgnore(mobileNum, pid);
		}
		return "";
	}

	/**
	 * 获取验证码并不再使用本号
	 *
	 * @param mobileNum 用getMobilenum方法获取到的手机号
	 * @param author_uid 软件开发者用户名(可选, 可得10%的消费分成)
	 * @return 成功返回：手机号码|验证码短信 失败请参考文档
	 */
	public static String getVcodeAndReleaseMobile(String mobileNum, String author_uid, int times) {
		try {
			if (userInfo.isLogin()) {
				String result = UserService.getVcodeAndReleaseMobile(userInfo.getUid(), userInfo.getToken(), mobileNum, author_uid);
				System.out.println(result);
				if ("not_receive".equals(result) || "message|please try again later".equals(result)) {
					try {
						if (times < 10) {
							Thread.sleep(5000);
							return getVcodeAndReleaseMobile(mobileNum, author_uid, ++times);
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

	/**
	 *
	 * @param mobileNum 用getMobilenum方法获取到的手机号
	 * @param author_uid 软件开发者用户名(可选, 可得10%的消费分成)
	 * @param nextId 下个要接收的项目ID
	 * @return 成功返回：发送号码|验证码|token 失败请参考文档
	 */
	public static String getVcodeAndHoldMobilenum(String mobileNum, String author_uid, String nextId) {
		if (userInfo.isLogin()) {
			String result = UserService.getVcodeAndHoldMobilenum(userInfo.getUid(), userInfo.getToken(), mobileNum, nextId, author_uid);
			System.out.println(result);
			return result;
		}
		return "";
	}

	public static String getRecvingInfo(String pid) {
		if (userInfo.isLogin()) {
			String result = UserService.getRecvingInfo(userInfo.getUid(), userInfo.getToken(), pid);
			System.out.println(result);
			return result;
		}
		return "";
	}
}
