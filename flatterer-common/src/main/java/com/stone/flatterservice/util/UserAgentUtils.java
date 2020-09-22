package com.stone.flatterservice.util;

import javax.servlet.http.HttpServletRequest;

import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;

public class UserAgentUtils {
	/**
	 * 获取request的设备类型
	 * 
	 * @param request
	 * @return
	 */
	public static String getRequestDeviceType(HttpServletRequest request) {
		UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
		OperatingSystem os = userAgent.getOperatingSystem();
		String type = os.getDeviceType().getName();
		return type;
	}

	/**
	 * 获取request的浏览器类型
	 * 
	 * @param request
	 * @return
	 */
	public static String getRequestBrowser(HttpServletRequest request) {
		UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
		Browser browser = userAgent.getBrowser();
		OperatingSystem os = userAgent.getOperatingSystem();
		return browser.getName();
	}

	/**
	 * 获取request的操作系统
	 * 
	 * @param request
	 * @return
	 */
	public static String getRequestOperatingSystem(HttpServletRequest request) {
		UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
		OperatingSystem os = userAgent.getOperatingSystem();
		return os.getName();
	}
}
