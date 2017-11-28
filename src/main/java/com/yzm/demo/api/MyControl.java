package com.yzm.demo.api;

public class MyControl {
	public static Boolean isNull(String s) {
		if (s == null || "".equals(s) || s.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
}
