package com.stone.flatterservice.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stone.flatterservice.mapper.TuWenMapper;
import com.stone.flatterservice.pojo.TuWenInfo;
import com.stone.flatterservice.pojo.base.resp.BaseResp;
import com.stone.flatterservice.service.TuWenService;

@Service
public class TuWenServiceImpl implements TuWenService {
	Log log = LogFactory.getLog(this.getClass());
	@Autowired
	private TuWenMapper dao;
	@Override
	public BaseResp queryByRandom() {
		BaseResp baseResp = BaseResp.builder().build();
		TuWenInfo info = dao.queryByRandom();
		if(null!=info) {
			baseResp.setCode(0);
			baseResp.setData(info);
			baseResp.setMsg("查询成功");
		}else {
			baseResp.setCode(1);
			baseResp.setMsg("未查询到数据");
		}
		return baseResp;
	}
	@Override
	public BaseResp queryByRandomFuck() {
		BaseResp baseResp = BaseResp.builder().build();
		TuWenInfo info = dao.queryByRandomFuck();
		if(null!=info) {
			baseResp.setCode(0);
			baseResp.setData(info);
			baseResp.setMsg("查询成功");
		}else {
			baseResp.setCode(1);
			baseResp.setMsg("未查询到数据");
		}
		return baseResp;
	}
	@Override
	public BaseResp queryByRandomZheli() {
		BaseResp baseResp = BaseResp.builder().build();
		TuWenInfo info = dao.queryByRandomZheli();
		if(null!=info) {
			baseResp.setCode(0);
			baseResp.setData(info);
			baseResp.setMsg("查询成功");
		}else {
			baseResp.setCode(1);
			baseResp.setMsg("未查询到数据");
		}
		return baseResp;
	}

}
