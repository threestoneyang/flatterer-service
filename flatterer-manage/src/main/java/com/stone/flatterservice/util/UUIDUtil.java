package com.stone.flatterservice.util;

import java.util.UUID;

/**
 * UUID生成工具
 * 
 * @author geekerlone
 *
 */
public class UUIDUtil {

	/**
	 * 自动生成32位的UUID
	 * 
	 * @return
	 */
	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}

}