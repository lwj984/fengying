package com.dubbo.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dubbo.service.TestService;

@Controller
public class TestController {
	
	@Autowired
	private TestService testService;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@ResponseBody
	public String testSay() {
		return testService.sayHello("hunbohui");
	}
	
}
