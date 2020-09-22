package com.stone.flatterservice.pojo.base.requert;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * Class Name: BaseInfo.java Function: 数据包基本数据，用于请求接口的认证 Modifications:
 * 
 * @author Administrator
 * @DateTime 2017年10月19日 下午3:57:33
 * @version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseInfo implements Serializable {
	private static final long serialVersionUID = 3239837082434906385L;

	private String time;

	private String token;

	private String mobile;
	
	private String client;

}
