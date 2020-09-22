
package com.stone.flatterservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @author 
 * @create 2018/12/30.
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.stone.flatterservice.mapper")
@EnableFeignClients
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {

		HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
		httpRequestFactory.setConnectionRequestTimeout(10000);
		httpRequestFactory.setConnectTimeout(10000);
		httpRequestFactory.setReadTimeout(10000);
		// 原本
		// return builder.build();
		return new RestTemplate(httpRequestFactory);
	}
}
