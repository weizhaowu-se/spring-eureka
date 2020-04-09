package com.wilbert.springeurekaclient.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wuweizhao
 * @version 创建时间：2020/4/9 9:56 PM
 */
@RestController
public class HelloController {
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello() {
		return "hello springeurekaclient";
	}
}
