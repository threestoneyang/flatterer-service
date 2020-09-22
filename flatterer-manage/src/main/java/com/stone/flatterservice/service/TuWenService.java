package com.stone.flatterservice.service;

import com.stone.flatterservice.pojo.base.resp.BaseResp;

public interface TuWenService
{
	/**
	 * 随机查询
	 * @param suggest
	 * @return
	 */
	public BaseResp queryByRandom();
	/**
	 * 骂人的话随机一条
	 * @return
	 */
	public BaseResp queryByRandomFuck();
	/**
	 * 哲理话
	 * @return
	 */
	public BaseResp queryByRandomZheli();

}
