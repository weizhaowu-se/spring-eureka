package com.wilbert.springeurekaconsumer.controller;

import com.wilbert.springeurekaconsumer.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author wuweizhao
 * @version 创建时间：2020/4/9 10:07 PM
 */
@RestController
public class HelloConsumerController {
	@Autowired
	RestTemplate restTemplate;

	@Autowired
	HelloService helloService;

	@RequestMapping(value = "/helloConsumer", method = RequestMethod.GET)
	public String helloConsumer() {
		return restTemplate.getForEntity("http://SERVICE-HELLO/hello", String.class).getBody();
	}

	@RequestMapping(value = "/helloConsumerFeignClient", method = RequestMethod.GET)
	public String helloConsumerFeignClient() {
		return helloService.hello();
	}
}
