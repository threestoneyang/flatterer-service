package com.stone.flatterservice.util;

import java.io.UnsupportedEncodingException;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

/**
 * AES加密解密算法 确定了
 */
public class AesEncryptionUtil {

	/** 算法/模式/填充 **/
	private static final String CipherMode = "AES/CBC/PKCS5Padding";

	/** 创建密钥 **/
	private static SecretKeySpec createKey(String key) {
		byte[] data = null;
		if (key == null) {
			key = "";
		}
		StringBuffer sb = new StringBuffer(16);
		sb.append(key);
		while (sb.length() < 16) {
			sb.append("0");
		}
		if (sb.length() > 16) {
			sb.setLength(16);
		}
		System.out.println("key:" + sb.toString());
		try {
			data = sb.toString().getBytes("UTF-8");
			for (byte b : data) {
//				System.out.print("keys:" + b);
			}
			System.out.println();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return new SecretKeySpec(data, "AES");
	}

	/**
	 * 使用CBC模式，需要一个向量iv，可增加加密算法的强度
	 */
	private static IvParameterSpec createIV(String password) {

		byte[] data = null;
		if (password == null) {
			password = "";
		}
		StringBuffer sb = new StringBuffer(16);
		sb.append(password);
		while (sb.length() < 16) {
			sb.append("0");
		}
		if (sb.length() > 16) {
			sb.setLength(16);
		}
		System.out.println("iv:" + sb.toString());
		try {
			data = sb.toString().getBytes("UTF-8");
			for (byte b : data) {
//				System.out.print("偏移iv:" + b);
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return new IvParameterSpec(data);
	}

	/** 加密字节数据 **/
	public static byte[] encrypt(byte[] content, String password, String iv) {
		try {
			SecretKeySpec key = createKey(password);

			Cipher cipher = Cipher.getInstance(CipherMode);
			cipher.init(Cipher.ENCRYPT_MODE, key, createIV(iv));
			byte[] result = cipher.doFinal(content);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/** 加密(结果为16进制字符串) **/
	public static String encrypt(String content, String password, String iv) {
		byte[] data = null;
		try {
			data = content.getBytes("UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		data = encrypt(data, password, iv);
		// String result = byte2hex(data);
		String result = new Base64().encodeToString(data);
		return result;
	}

	/** 解密字节数组 **/
	public static byte[] decrypt(byte[] content, String password, String iv) {
		try {
			SecretKeySpec key = createKey(password);
			Cipher cipher = Cipher.getInstance(CipherMode);
			cipher.init(Cipher.DECRYPT_MODE, key, createIV(iv));
			byte[] result = cipher.doFinal(content);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/** 解密(输出结果为字符串) **/
	public static String decrypt(String content, String password, String iv) {
		byte[] data = null;
		try {
			// data = hex2byte(content);
			data = new Base64().decode(content);
		} catch (Exception e) {
			e.printStackTrace();
		}
		data = decrypt(data, password, iv);
		if (data == null)
			return null;
		String result = null;
		try {
			result = new String(data, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}

	/** 字节数组转成16进制字符串 **/
	public static String byte2hex(byte[] b) { // 一个字节的数，
		StringBuffer sb = new StringBuffer(b.length * 2);
		String tmp = "";
		for (int n = 0; n < b.length; n++) {
			// 整数转成十六进制表示
			tmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
			if (tmp.length() == 1) {
				sb.append("0");
			}
			sb.append(tmp);
		}
		return sb.toString().toUpperCase(); // 转成大写
	}

	/** 将hex字符串转换成字节数组 **/
	private static byte[] hex2byte(String inputString) {
		if (inputString == null || inputString.length() < 2) {
			return new byte[0];
		}
		inputString = inputString.toLowerCase();
		int l = inputString.length() / 2;
		byte[] result = new byte[l];
		for (int i = 0; i < l; ++i) {
			String tmp = inputString.substring(2 * i, 2 * i + 2);
			result[i] = (byte) (Integer.parseInt(tmp, 16) & 0xFF);
		}
		return result;
	}

//	public static void main(String[] args) {
//		String str = "{\"baseInfo\":{\"client\":\"outtest\",\"time\":\"201801261821291\",\"token\":\"f15dad8ee32f467c0260a90ca81fbd61\"},\"bizInfo\":{\"enterpriseOrder\":{\"enterpriseOrderId\":7517607758397440}}}";
//		String miwen = encrypt(str, "1234567890123456", "1234567890123456");
//		System.out.println(miwen);
//		System.out.println(decrypt(
//				"IOuQnfeFEIrs7s7KmCy3zuhq1xx4xDm0zlnzmAzZd1Jcv7Y7Ie12vQ7UTnUGC39Q0QPOa9Gcwm4uXgAxJ9P2KFP9viwVWbUqZOuu5bxwYVjuizXOxe3U5FRucmWSISsFAQEFMkdxjgR4Tfo/Jxjiyf/jTuHaCUoQ3+MyE/t7Y7fMFF5b9dut6jJIeHpSU1kTd/JUruU8RQoTUfGTUgZHgAaUrKI1Y6oVUOOEKEDK370=",
//				"1234567890123456", "1234567890123456"));
//	}
}