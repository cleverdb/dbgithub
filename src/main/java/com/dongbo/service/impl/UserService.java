package com.dongbo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dongbo.entity.User;
import com.dongbo.mapper.BaseMapper;
import com.dongbo.mapper.UserMapper;
import com.dongbo.service.BaseService;

@Service
public class UserService extends BaseService<User>{
	
	@Autowired
	private UserMapper mapper;
	
	@Override
	public BaseMapper<User> getMapper(){
		return  mapper;
	}

}
