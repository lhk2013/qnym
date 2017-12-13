package com.qnym.common.util;

import java.util.regex.Pattern;

public class PatternUtils {

	private static final Pattern mobilePattern = Pattern.compile(
			"^1[3|4|5|7|8|9]\\d{9}$",
			Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE | Pattern.CANON_EQ);

	public static final boolean matchMobile(String mobile) {
		return mobilePattern.matcher(mobile).matches();
	}

	public static void main(String[] args) {
		System.out.println(matchMobile("17349238318"));
	}
}
