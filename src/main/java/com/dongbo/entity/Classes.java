package com.dongbo.entity;

import java.io.Serializable;

/**
 * @author V.Bo.Dong
 *
 */
public class Classes implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;

    private String classesName;

    private String remark;

    private String parentId;

    private String userId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getClassesName() {
        return classesName;
    }

    public void setClassesName(String classesName) {
        this.classesName = classesName == null ? null : classesName.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }
}