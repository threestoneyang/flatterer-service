package com.stone.flatterservice.pojo.base.resp;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * Class Name: BaseResp.java Function: 返回数据，基础数据 Modifications:
 * 
 * @author Administrator
 * @DateTime 2017年10月19日 下午4:27:51
 * @version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BaseResp implements Serializable {
	private static final long serialVersionUID = -6309274767776271020L;

	private int code;

	private String msg;

	private Object data;

}
