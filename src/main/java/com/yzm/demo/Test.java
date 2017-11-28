package com.yzm.demo;

import com.alibaba.fastjson.JSONObject;
import com.fly.httptest.utils.HttpClientUtils;
import com.yzm.demo.api.MyControl;
import com.yzm.demo.api.UserInfo;
import com.yzm.demo.api.UserService;
import org.apache.commons.lang3.StringUtils;

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
			String phone = getMobileNum("33544").split("\\|")[0];

			String jsonStr = "{\"phone\":\"+86%s\",\"purpose\":\"SESSION\"}";
			JSONObject jsonObject = HttpClientUtils.postWithAgent("https://api.mixin.one/verifications", String.format(jsonStr, phone));
			Thread.sleep(5000);
			String valid = getVcodeAndReleaseMobile(phone, "mephistodemon", 0);
			if (StringUtils.isNotBlank(valid)) {
				String code = valid.split("\\|")[1].split(" ")[2];
				System.out.println(code);
				if (StringUtils.isNotBlank(code)) {
					String verification_id = jsonObject.getJSONObject("data").getString("id");
					String jsonStr2 = "{\"code\":\"" + code + "\",\"phone\":\"+86" + phone + "\",\"verification_id\":\"" + verification_id + "\",\"invitation_code\":\"198353\",\"purpose\":\"SESSION\",\"platform\":\"Web\"}";
					System.out.println(HttpClientUtils.post("https://api.mixin.one/verifications/" + verification_id, jsonStr2));
				}
			}
		} else {
			System.out.println("登陆失败");
		}

//		String code = "4840";
//		if (StringUtils.isNotBlank(code)) {
//			String verification_id = "3adcfc95-34b4-4f68-b18f-4ae9ea56a6c4";
//			String jsonStr2 = "{\"code\":\"" + code + "\",\"phone\":\"+86" + "13136400047" + "\",\"verification_id\":\"" + verification_id + "\",\"invitation_code\":\"198353\",\"purpose\":\"SESSION\",\"platform\":\"Web\"}";
//			System.out.println(HttpClientUtils.post("https://api.mixin.one/verifications/" + verification_id, jsonStr2));
//		}

//		String valid = "15604457404|Mixin code 5300 [PIN]";
//		String code = valid.split("\\|")[1].split(" ")[2];
//		System.out.println(code);
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
		if (userInfo.isLogin()) {
			String result = UserService.addIgnore(mobileNum, userInfo.getUid(), userInfo.getToken(), pid);
			System.out.println(result);
			return result;
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
		if (userInfo.isLogin()) {
			String result = UserService.getVcodeAndReleaseMobile(userInfo.getUid(), userInfo.getToken(), mobileNum, author_uid);
			System.out.println(result);
			if ("not_receive".equals(result) || "message|please try again later".equals(result)) {
				try {
					if (times < 10) {
						Thread.sleep(5000);
						getVcodeAndReleaseMobile(mobileNum, author_uid, ++times);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			return result;
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
}
