package com.wilbert.springeurekaconsumer.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wuweizhao
 * @version 创建时间：2020/4/29 9:55 PM
 */
@RestController
public class ConfigGetController {

	@NacosValue(value = "${testConfig:1234}", autoRefreshed = true)
	private String testConfig;

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	@ResponseBody
	public String get() {
		return testConfig;
	}
}
