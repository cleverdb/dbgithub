package com.dongbo.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dongbo.entity.User;
import com.dongbo.service.impl.UserService;
import com.dongbo.utils.Constants;
import com.dongbo.utils.DES;
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
	public String login(HttpServletRequest request, User user , Model model,@RequestParam(required = false , value = Constants.USER_ID)String userId){
		User loginUser = null;
		HttpSession session = request.getSession();
		if(session.getAttribute(Constants.SESSION_U_N)!=null && session.getAttribute(Constants.SESSION_U_I) != null ) return "index";
		Result result = service.query(user);
		@SuppressWarnings("unchecked")
		List<User> list = (List<User>) result.getRows();
		if(list == null || list.size() == 0){
			return "login";
		}
		loginUser = list.get(0);
		try{
			request.getSession().setAttribute(Constants.SESSION_U_N, DES.encrypt(loginUser.getUserName(), Constants.DES_KEY));
			request.getSession().setAttribute(Constants.SESSION_U_I,DES.encrypt(loginUser.getId(), Constants.DES_KEY) );
		}catch(Exception e){
			e.printStackTrace();
			return "login";
		}
		
		model.addAttribute(loginUser);
		return "index";
	}
	
	@RequestMapping(value= "/logout" , method = RequestMethod.POST)
	public String logout(HttpServletRequest request){
		request.getSession().removeAttribute(Constants.SESSION_U_N);
		return "login";
	}
	
	@RequestMapping(value= "/")
	public String index(HttpServletRequest request){
		return "index";
	}
}
