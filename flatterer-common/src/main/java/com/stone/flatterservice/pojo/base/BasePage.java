package com.stone.flatterservice.pojo.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BasePage {
	/**
	 * 分页参数 当前页
	 */
	private int page=1;

	/**
	 * 分页参数 每页条数
	 */
	private int rows=10;
}
