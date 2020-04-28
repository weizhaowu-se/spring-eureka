package com.wilbert.springeurekaconsumer.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author wuweizhao
 * @version 创建时间：2020/4/28 9:46 PM
 */
@FeignClient(value = "SERVICE-HELLO")
public interface HelloService {
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	String hello();
}
