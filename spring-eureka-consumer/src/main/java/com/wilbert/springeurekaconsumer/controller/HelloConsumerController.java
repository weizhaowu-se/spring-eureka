package com.wilbert.springeurekaconsumer.controller;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.wilbert.springeurekaconsumer.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

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

	@RequestMapping(value = "/helloConsumer", method = GET)
	public String helloConsumer() {
		return restTemplate.getForEntity("http://SERVICE-HELLO/hello", String.class).getBody();
	}

	@RequestMapping(value = "/helloConsumerFeignClient", method = GET)
	public String helloConsumerFeignClient() {
		return helloService.hello();
	}

	@NacosInjected
	private NamingService namingService;

	@RequestMapping(value = "/get", method = GET)
	@ResponseBody
	public List<Instance> get(@RequestParam String serviceName) throws NacosException {
		return namingService.getAllInstances(serviceName);
	}
}
