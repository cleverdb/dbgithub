package com.dongbo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dongbo.entity.Clothes;
import com.dongbo.service.impl.ClothesService;
import com.dongbo.utils.Constants;
import com.dongbo.utils.Result;

/**
 * @author V.Bo.Dong
 *
 */

@RestController
public class ClothesController {
	
	@Autowired
	private ClothesService service;
	
	@RequestMapping(value = "/clothes" , method = RequestMethod.POST)
	public Result insert(Clothes clothes,@RequestParam(value = Constants.USER_ID)String userId){
		return service.insert(clothes);
	}
	
	@RequestMapping(value = "/clothes" , method = RequestMethod.DELETE)
	public Result delete(Clothes clothes,@RequestParam(value = Constants.USER_ID)String userId){
		return service.insert(clothes);
	}
	
	@RequestMapping(value = "/clothes" , method = RequestMethod.PUT)
	public Result update(Clothes clothes,@RequestParam(value = Constants.USER_ID)String userId){
		return service.insert(clothes);
	}
	
	@RequestMapping(value = "/clothes/{page}/{size}" , method = RequestMethod.GET)
	public Result query(Clothes clothes ,@PathVariable("page")int page , @PathVariable("size") int size,@RequestParam(value = Constants.USER_ID)String userId){
		return service.query(clothes, size, page);
	}
	
	@RequestMapping(value = "/clothes" , method = RequestMethod.GET)
	public Result queryOne(Clothes clothes,@RequestParam(value = Constants.USER_ID)String userId){
		return service.query(clothes);
	}
}
