package com.qnym.common.util;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author liuhaikuo
 */
public class CookieOperator {

	public static final String LOGIN_COOKIE_HEAD = "QNYM-UID";
	public static final String LOGIN_COOKIE_NICK = "QNYM-NICK";
	public static final String LOGIN_COOKIE_PATH = "/";


	public final static Cookie getCookie(HttpServletRequest request) {
		return getCookie(request,LOGIN_COOKIE_HEAD);
	}

	public final static Cookie getCookie(HttpServletRequest request,String name) {
		Cookie ret = null;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(name)) {
					ret = cookie;
					break;
				}
			}
		}
		return ret;
	}


	public final static void updateCookie(HttpServletResponse response, Cookie cookie, String domain, String value,int timeOut){
		updateCookie(response,CookieOperator.LOGIN_COOKIE_HEAD,cookie,domain,value,timeOut);
	}

	public final static void updateCookie(HttpServletResponse response,String name, Cookie cookie, String domain, String value,
			int timeOut) {
		if (cookie == null) {
			name = name==null?CookieOperator.LOGIN_COOKIE_HEAD:name;
			cookie = new Cookie(name, value);
		}
		cookie.setDomain(domain);
		cookie.setHttpOnly(true);
		cookie.setPath(CookieOperator.LOGIN_COOKIE_PATH);
		cookie.setValue(value);
		cookie.setMaxAge(timeOut);
		response.addCookie(cookie);
	}

	public final static Cookie writeCookie(HttpServletResponse response, Cookie cookie, String domain, String value,int timeOut){
		return writeCookie(response,CookieOperator.LOGIN_COOKIE_HEAD,cookie,domain,value,timeOut);
	}

	public final static Cookie writeCookie(HttpServletResponse response,String name,Cookie cookie, String domain, String value,
		int timeOut) {
		if (cookie == null) {
			name = name==null?CookieOperator.LOGIN_COOKIE_HEAD:name;
			cookie = new Cookie(name, value);
		}
		cookie.setDomain(domain);
		cookie.setHttpOnly(true);
		cookie.setPath(CookieOperator.LOGIN_COOKIE_PATH);
		cookie.setValue(value);
		cookie.setMaxAge(timeOut);
		response.addCookie(cookie);
		return cookie;
	}
}
