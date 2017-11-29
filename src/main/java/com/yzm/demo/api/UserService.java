package com.yzm.demo.api;

import com.yzm.demo.Config;

public class UserService {

	public static String login(UserInfo userInfo) {
		if (!MyControl.isNull(userInfo.getUid()) && !MyControl.isNull(userInfo.getPwd())) {
			try {
				String param = String.format("uid=%s&pwd=%s", userInfo.getUid().trim(), userInfo.getPwd());
				System.out.println(param);
				return HttpHelper.getHtml(Config.loginUrl, param);
			} catch (Exception ex) {
				ex.printStackTrace();
				return "";
			}
		} else {
			return "";
		}
	}

	public static String getUserInfo(String userName, String token) {
		try {
			String para = String.format("uid=%s&token=%s", userName, token);
			String url = Config.getUserInfos + para;
			System.out.println(url);
			return HttpHelper.getHtml(url);
		} catch (Exception ex) {
			return "";
		}
	}

	public static String getMobileNum(String pid, String uid, String token) {
		try {
			String para = String.format("pid=%s&uid=%s&token=%s&mobile=&size=%s", pid, uid, token, 1);
			String url = Config.getMobilenum + para;
			return HttpHelper.getHtml(url);
		} catch (Exception ex) {
			return "";
		}
	}

	public static String addIgnore(String mobileNum, String uid, String token, String pid) {
		try {
			String para = String.format("uid=%s&token=%s&mobiles=%s&pid=%s", uid, token, mobileNum, pid);
			String url = Config.addIgnoreList + para;
			return HttpHelper.getHtml(url);
		} catch (Exception ex) {
			return "";
		}
	}

	public static String getVcodeAndReleaseMobile(String uid, String token, String mobileNum, String author_uid) {
		try {
			String para = String.format("uid=%s&token=%s&mobile=%s&author_uid=%s", uid, token, mobileNum, author_uid);
			String url = Config.getVcodeAndReleaseMobile + para;
			return HttpHelper.getHtml(url);
		} catch (Exception ex) {
			return "";
		}
	}

	public static String getVcodeAndHoldMobilenum(String uid, String token, String mobileNum, String nextId, String author_uid) {
		try {
			String para = String.format("uid=%s&token=%s&mobile=%s&next_pid=%s&author_uid=%s", uid, token, mobileNum, nextId, author_uid);
			String url = Config.getVcodeAndHoldMobilenum + para;
			return HttpHelper.getHtml(url);
		} catch (Exception ex) {
			return "";
		}
	}

	public static String getRecvingInfo(String uid, String token, String pid) {
		try {
			String para = String.format("uid=%s&pid=%s&token=%s", uid, pid, token);
			String url = Config.getRecvingInfo + para;
			return HttpHelper.getHtml(url);
		} catch (Exception ex) {
			return "";
		}
	}
}
