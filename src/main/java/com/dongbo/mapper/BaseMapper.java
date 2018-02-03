package com.dongbo.mapper;

import java.util.List;

public interface BaseMapper<T> {
	
	int insert(T t);
	
	int update(T t);
	
	int delete(T t);
	
	List<T> query(T t);

}
