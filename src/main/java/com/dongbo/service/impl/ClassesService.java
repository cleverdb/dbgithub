package com.dongbo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dongbo.entity.Classes;
import com.dongbo.mapper.BaseMapper;
import com.dongbo.mapper.ClassesMapper;
import com.dongbo.service.BaseService;

@Service
public class ClassesService extends BaseService<Classes>{
	
	@Autowired
	private ClassesMapper mapper;
	
	@Override
	public BaseMapper<Classes> getMapper(){
		return  mapper;
	}

}
