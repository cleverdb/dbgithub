package com.dongbo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dongbo.entity.Clothes;
import com.dongbo.mapper.BaseMapper;
import com.dongbo.mapper.ClothesMapper;
import com.dongbo.service.BaseService;

@Service
public class ClothesService extends BaseService<Clothes>{
	
	@Autowired
	private ClothesMapper mapper;
	
	@Override
	public BaseMapper<Clothes> getMapper(){
		return  mapper;
	}

}
