package com.dongbo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dongbo.entity.User;
import com.dongbo.service.impl.UserService;
import com.dongbo.utils.Result;

@RestController
public class UserController {

	@Autowired
	private UserService service;
	
	@RequestMapping(value = "/user/{id}")
	public Result getAllUser(@PathVariable("id")String id){
		User user = new User();
		user.setId(id);
		Result result = service.query(user);
		return result;
	}
}
