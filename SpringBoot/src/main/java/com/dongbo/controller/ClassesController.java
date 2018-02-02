package com.dongbo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dongbo.entity.Classes;
import com.dongbo.service.impl.ClassesService;
import com.dongbo.utils.Result;

/**
 * @author V.Bo.Dong
 *
 */

@RestController
public class ClassesController {
	
	@Autowired
	private ClassesService service;
	
	@RequestMapping(value = "classes" , method = RequestMethod.POST)
	public Result insert(Classes classes){
		
		return service.insert(classes);
	}
	
	@RequestMapping(value = "classes" , method = RequestMethod.DELETE)
	public Result delete(Classes classes){
		
		return service.insert(classes);
	}
	
	@RequestMapping(value = "classes" , method = RequestMethod.PUT)
	public Result update(Classes classes){
		
		return service.insert(classes);
	}
	
	@RequestMapping(value = "classes/{page}/{size}" , method = RequestMethod.GET)
	public Result query(Classes classes ,@PathVariable("page")int page , @PathVariable("size") int size){
		
		return service.query(classes, size, page);
	}
	
	@RequestMapping(value = "classes/" , method = RequestMethod.GET)
	public Result queryOne(Classes classes){
		
		return service.query(classes);
	}
}
