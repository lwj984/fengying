package com.dubbo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.dubbo.mapper.UserMapper;
import com.dubbo.service.TestService;

public class TestServiceImpl implements TestService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public String sayHello(String str) {
		return str + ",hello " + userMapper.selectByPrimaryKey(9).getName();
	}

}
