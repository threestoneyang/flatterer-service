package com.stone.flatterservice.pojo.base.requert;

import java.io.Serializable;

import com.alibaba.fastjson.JSONObject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReqData implements Serializable {
	private static final long serialVersionUID = -8475400611980210145L;

	private BaseInfo baseInfo;

	private JSONObject bizInfo;

}
