package com.stone.flatterservice.util;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.security.MessageDigest;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 字符串工具
 * 
 * @author geekerlone
 *
 */
public class StringUtil {

	/**
	 * 
	 * Function: 对象是否为空
	 * 
	 * @author geekerlone
	 * @DateTime 2019年3月13日 上午11:55:31
	 * @param obj
	 * @return
	 */
	public static boolean isNotBlankForObj(Object obj) {
		return !isEmpty(obj);
	}

	public static boolean isBlankForObj(Object obj) {
		return isEmpty(obj);
	}

	public static boolean isNotBlankAnd0(String value) {
		return !"0".equals(value) && !"".equals(value) && null != value;
	}

	public static boolean isBlankAnd0(String value) {
		return "0".equals(value) && "".equals(value) && null == value;
	}

	public static boolean isEmpty(Object obj) {
		if (obj == null)
			return true;
		else if (obj instanceof CharSequence)
			return ((CharSequence) obj).length() == 0;
		else if (obj instanceof Collection)
			return ((Collection) obj).isEmpty();
		else if (obj instanceof List)
			return ((List) obj).isEmpty();
		else if (obj instanceof Map)
			return ((Map) obj).isEmpty();
		else if (obj.getClass().isArray())
			return Array.getLength(obj) == 0;

		return false;
	}

	/**
	 * 是否为空白（空字符串或者null）
	 * 
	 * @return
	 */
	public static boolean isBlank(String string) {
		return (null == string || string.isEmpty());
	}

	/**
	 * 至少又一个字符串是空字符串
	 * 
	 * @return
	 */
	public static boolean isBlankSomeone(String... strings) {
		for (String string : strings) {
			if (isBlank(string)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 是否不为空白（空字符串或者null）
	 * 
	 * @return
	 */
	public static boolean isNotBlank(String string) {
		return !isBlank(string);
	}

	/**
	 * 所有字符串都不为空
	 * 
	 * @param strings
	 * @return
	 */
	public static boolean isNotBlankAll(String... strings) {
		for (String string : strings) {
			if (isBlank(string)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 多个字符串求MD5（大写）
	 * 
	 * @param strings
	 * @return
	 */
	public static String MD5(String... strings) {
		String newStr = "";
		for (String string : strings) {
			newStr += string;
		}
		return MD5(newStr);
	}

	/**
	 * 多个字符串求MD5（小写）
	 * 
	 * @param strings
	 * @return
	 */
	public static String md5(String... strings) {
		String newStr = "";
		for (String string : strings) {
			newStr += string;
		}
		return md5(newStr);
	}

	/**
	 * md5加密（小写）
	 * 
	 * @param str
	 * @return
	 */
	public static String md5(String str) {
		return MD5(str).toLowerCase();
	}

	/**
	 * MD5加密（大写）
	 * 
	 * @param pwd
	 * @return
	 */
	public static String MD5(String pwd) {
		// 用于加密的字符
		char md5String[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		try {
			// 使用平台的默认字符集将此 String 编码为 byte序列，并将结果存储到一个新的 byte数组中
			byte[] btInput = pwd.getBytes("utf-8");
			// 信息摘要是安全的单向哈希函数，它接收任意大小的数据，并输出固定长度的哈希值。
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			// MessageDigest对象通过使用 update方法处理数据， 使用指定的byte数组更新摘要
			mdInst.update(btInput);
			// 摘要更新之后，通过调用digest（）执行哈希计算，获得密文
			byte[] md = mdInst.digest();
			// 把密文转换成十六进制的字符串形式
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) { // i = 0
				byte byte0 = md[i]; // 95
				str[k++] = md5String[byte0 >>> 4 & 0xf]; // 5
				str[k++] = md5String[byte0 & 0xf]; // F
			}
			// 返回经过加密后的字符串
			return new String(str);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 字符串中包含任意一个指定的字符串
	 * 
	 * @param src
	 * @param strings
	 * @return
	 */
	public static boolean containsAnyOne(String src, String... strings) {
		for (String string : strings) {
			if (src.contains(string)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 字符串中不包含任意一个指定的字符串
	 * 
	 * @param src
	 * @param strings
	 * @return
	 */
	public static boolean notContainsAnyOne(String src, String... strings) {
		return !containsAnyOne(src, strings);
	}

	/**
	 * 随机一个指定长度的数字字符串
	 * 
	 * @param length
	 * @return
	 */
	public static String randomNumberStr(int length) {
		String str = "";
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			str += random.nextInt(10);
		}
		return str;
	}

	/**
	 * 尝试转码为UTF8
	 * 
	 * @param text
	 * @return
	 */
	public static String tryTranscodingUTF8(String text) {
		try {
			if (isNotBlank(text)) {
				if (text.equals(new String(text.getBytes("ISO8859-1"), "ISO8859-1"))) {
					text = new String(text.getBytes("ISO8859-1"), "UTF-8");
				}
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return text;
	}

	/**
	 * 格式化JSON字符串
	 * 
	 * @param jsonStr
	 * @return
	 */
	public static String formatJson(String jsonStr) {
		if (null == jsonStr || "".equals(jsonStr))
			return "";
		StringBuilder sb = new StringBuilder();
		char last = '\0';
		char current = '\0';
		int indent = 0;
		boolean isInQuotationMarks = false;
		for (int i = 0; i < jsonStr.length(); i++) {
			last = current;
			current = jsonStr.charAt(i);
			switch (current) {
			case '"':
				if (last != '\\') {
					isInQuotationMarks = !isInQuotationMarks;
				}
				sb.append(current);
				break;
			case '{':
			case '[':
				sb.append(current);
				if (!isInQuotationMarks) {
					sb.append('\n');
					indent++;
					addIndentBlank(sb, indent);
				}
				break;
			case '}':
			case ']':
				if (!isInQuotationMarks) {
					sb.append('\n');
					indent--;
					addIndentBlank(sb, indent);
				}
				sb.append(current);
				break;
			case ',':
				sb.append(current);
				if (last != '\\' && !isInQuotationMarks) {
					sb.append('\n');
					addIndentBlank(sb, indent);
				}
				break;
			default:
				sb.append(current);
			}
		}

		return sb.toString();
	}

	/**
	 * 添加space
	 * 
	 * @param sb
	 * @param indent
	 * @author lizhgb
	 * @Date 2015-10-14 上午10:38:04
	 */
	private static void addIndentBlank(StringBuilder sb, int indent) {
		for (int i = 0; i < indent; i++) {
			sb.append('\t');
		}
	}

	/**
	 * 生成6位数验证码
	 */
	public static String getCode() {
		return String.valueOf((int) ((Math.random() * 9 + 1) * 100000));
	}

}
