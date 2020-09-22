package com.stone.flatterservice.pojo.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BaseProductCode {
	private String expertProductCode;
	private String productCode;
}
