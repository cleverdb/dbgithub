package com.dongbo.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dongbo.entity.User;
import com.dongbo.service.impl.UserService;
import com.dongbo.utils.Constants;
import com.dongbo.utils.Result;

@Controller
public class LoginController {
	
	@Autowired
	private UserService service;
	
	@RequestMapping(value= "/login")
	public String login(){
		return "login";
	}
	
	@RequestMapping(value= "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request, User user , Model model){
		if(request.getSession().getAttribute(Constants.SESSION_KEY)!=null) return "index";
		Result result = service.query(user);
		@SuppressWarnings("unchecked")
		List<User> list = (List<User>) result.getRows();
		if(list == null || list.size() == 0){
			return "login";
		}
		request.getSession().setAttribute(Constants.SESSION_KEY, user.getUserName());
		model.addAttribute(user);
		return "index";
	}
	
	@RequestMapping(value= "/logout" , method = RequestMethod.POST)
	public String logout(HttpServletRequest request){
		request.getSession().removeAttribute(Constants.SESSION_KEY);
		return "login";
	}
	
	@RequestMapping(value= "/")
	public String index(HttpServletRequest request){
		return "index";
	}
}
