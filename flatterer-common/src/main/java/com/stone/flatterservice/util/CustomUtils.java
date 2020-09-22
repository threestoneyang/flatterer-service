package com.stone.flatterservice.util;

import java.io.IOException;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomUtils {
	
	/**
	 * object转String
	 * @param object
	 * @return String
	 */
	public static String toStr(Object object){
		if(object==null){
			return "";
		}
		return object.toString();
	}
	
	/**
	 * 脱敏信息
	 * @param StringBuffer sb 脱敏内容
	 * @param int start 开始位置
	 * @param int end 结束位置
	 * @param String replace 替换符号
	 * @return boolean
	 */
	public static void tuomin(StringBuffer sb, int start, int end, String replace) {
		if(null != sb && StringUtils.isNotBlank(sb.toString())) {
			for (int i = start; i < end; i++) {
				sb.replace(i, i + 1, replace);
			}
		}		
	}
	
	/**
	 * json格式的字符串解析成Map对象
	 * 2017.03.29
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> jsonStringToMap(String jsonString) {
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> data = null;
		try {
			data = om.readValue(jsonString, Map.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
	/**
	 * 解析回传数据
	 */
	public static Object stringToObjectResponse(String jdp_response,Object obj) {
		ObjectMapper om = new ObjectMapper();
		om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); //
		Object resp = null;
		try {
			resp = om.readValue(jdp_response, obj.getClass());
			
		} catch (JsonParseException e) {
 			e.printStackTrace();
		} catch (JsonMappingException e) {
 			e.printStackTrace();
		} catch (IOException e) {
 			e.printStackTrace();
		}
		return resp;
	}
	
	/**
	 * 计算是否有下一页
	 */
	public static boolean hasNextPage(int total, int pageNo,int rows){	
		int pageTotal = total/rows;
		if(total%rows>0) {
			pageTotal += 1;
		}
		if(pageTotal>pageNo) {
			return true;
		}
		return false;
	}
	
	public static boolean isInteger(String str) {  
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");  
        return pattern.matcher(str).matches();  
	}
	
	public static void main(String[] args) {
		
	}
}
