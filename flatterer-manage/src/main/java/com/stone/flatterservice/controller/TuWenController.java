package com.stone.flatterservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stone.flatterservice.pojo.base.requert.ReqData;
import com.stone.flatterservice.pojo.base.resp.BaseResp;
import com.stone.flatterservice.service.TuWenService;

@RestController
@RequestMapping("tuwen")
public class TuWenController
{
	
	private static final Logger log = LoggerFactory.getLogger(TuWenController.class);

	
	
	@Autowired
	private TuWenService tuWenService;
	
	/**
	 * 随机一条土味情话
	 * @param reqData
	 * @return
	 */
	@CrossOrigin(origins = "http://192.168.0.156:8080")
	@GetMapping(value = "queryByRandom")//, consumes = "application/json", produces = "application/json"
	public BaseResp queryByRandom() {
		BaseResp br = BaseResp.builder().build();
//		TuWenInfo suggest = TuWenInfo.builder().build();
//		try {
//			suggest = JSONObject.parseObject(reqData.getBizInfo().getJSONObject("tuWenInfo").toJSONString(), 
//					TuWenInfo.class);
//		} catch (Exception e) {
//			e.printStackTrace();
//			br.setCode("1");
//			br.setMsg("对象解析错误");
//			return br;
//		}
		br = tuWenService.queryByRandom();
		return br ;
	}
	/**
	 * 随机一条骂人
	 * @param reqData
	 * @return
	 */
	@CrossOrigin(origins = "http://192.168.0.156:8080")
	@GetMapping(value = "queryByRandomFuck")//, consumes = "application/json", produces = "application/json"
	public BaseResp queryByRandomFuck() {
		BaseResp br = BaseResp.builder().build();
		br = tuWenService.queryByRandomFuck();
		return br ;
	}
	
	/**
	 * 随机一条哲理
	 * @param reqData
	 * @return
	 */
	@CrossOrigin(origins = "http://192.168.0.156:8080")
	@GetMapping(value = "queryByRandomZheli")//, consumes = "application/json", produces = "application/json"
	public BaseResp queryByRandomZheli() {
		BaseResp br = BaseResp.builder().build();
		br = tuWenService.queryByRandomZheli();
		return br ;
	}
}
