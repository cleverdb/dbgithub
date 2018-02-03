package com.dongbo.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.dongbo.mapper.BaseMapper;
import com.dongbo.utils.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


public abstract class BaseService<T> {

	private static final Logger logger =LoggerFactory.getLogger(BaseService.class);
	
	@Autowired
    private  Environment environment;
	
	public BaseMapper<T> mapper;
	
	public abstract BaseMapper<T> getMapper();
	/**
	 * @param t
	 * @return
	 */
	public Result insert(T t){
		Result result = new Result();
		try{
			int i = getMapper().insert(t);
			if(i > 0 ){
				result.setMesssge(environment.getProperty("msg.insert.sucess"));
				return result;
			}
		}catch(Exception e){
			logger.error(e.getMessage());	
		}
		result.setFlag(false);
		result.setMesssge(environment.getProperty("msg.insert.fail"));
		return result;
	}
	
	
	/**
	 * @param t
	 * @return
	 */
	public Result update(T t){
		Result result = new Result();
		try{
			int i = getMapper().update(t);
			if(i > 0 ){
				result.setMesssge(environment.getProperty("msg.update.sucess"));
				return result;
			}
		}catch(Exception e){
			logger.error(e.getMessage());	
		}
		result.setFlag(false);
		result.setMesssge(environment.getProperty("msg.update.fail"));
		return result;
	}
	
	/**
	 * @param t
	 * @return
	 */
	public Result delete(T t){
		Result result = new Result();
		try{
			int i = getMapper().delete(t);
			if(i > 0 ){
				result.setMesssge(environment.getProperty("msg.delete.sucess"));
				return result;
			}
		}catch(Exception e){
			logger.error(e.getMessage());	
		}
		result.setFlag(false);
		result.setMesssge(environment.getProperty("msg.delete.fail"));
		return result;
	}
	
	/**
	 * @param t
	 * @param size
	 * @param page
	 * @return
	 */
	public Result query(T t ,int size , int page){
		Result result = new Result();
		try{
			PageHelper.startPage(page, size);
			List<T> list = getMapper().query(t);
			PageInfo<T> pageInfo = new PageInfo<>(list);
			result.setTotal(pageInfo.getTotal());
			result.setTotalPage(pageInfo.getPages());
			result.setRows(list);
			return result;
		}catch(Exception e){
			logger.error(e.getMessage());	
		}
		result.setFlag(false);
		result.setMesssge(environment.getProperty("msg.query.fail"));
		return result;
	}
	
	/**
	 * @param t
	 * @return
	 */
	public Result query(T t ){
		Result result = new Result();
		try{
			List<T> list = getMapper().query(t);
			result.setRows(list);
			return result;
		}catch(Exception e){
			logger.error(e.getMessage());	
		}
		result.setFlag(false);
		result.setMesssge(environment.getProperty("msg.query.fail"));
		return result;
	}
	
}
