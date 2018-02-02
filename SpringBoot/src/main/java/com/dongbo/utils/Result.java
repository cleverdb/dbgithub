package com.dongbo.utils;

import java.io.Serializable;

public class Result implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private boolean flag = true;
		
	private String messsge;
	
	private Object rows;
	
	private long total;
	
	private long totalPage;

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String getMesssge() {
		return messsge;
	}

	public void setMesssge(String messsge) {
		this.messsge = messsge;
	}

	public Object getRows() {
		return rows;
	}

	public void setRows(Object rows) {
		this.rows = rows;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public long getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}
	
	
}
