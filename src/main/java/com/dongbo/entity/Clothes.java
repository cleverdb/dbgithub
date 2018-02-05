package com.dongbo.entity;

public class Clothes {
    private String id;

    private String cloName;

    private String cloColor;

    private Double cloPrice;

    private String cloPicture;

    private String cloStart;

    private String classesId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCloName() {
        return cloName;
    }

    public void setCloName(String cloName) {
        this.cloName = cloName == null ? null : cloName.trim();
    }

    public String getCloColor() {
        return cloColor;
    }

    public void setCloColor(String cloColor) {
        this.cloColor = cloColor == null ? null : cloColor.trim();
    }

    public Double getCloPrice() {
        return cloPrice;
    }

    public void setCloPrice(Double cloPrice) {
        this.cloPrice = cloPrice;
    }

    public String getCloPicture() {
        return cloPicture;
    }

    public void setCloPicture(String cloPicture) {
        this.cloPicture = cloPicture == null ? null : cloPicture.trim();
    }

    public String getCloStart() {
        return cloStart;
    }

    public void setCloStart(String cloStart) {
        this.cloStart = cloStart == null ? null : cloStart.trim();
    }

    public String getClassesId() {
        return classesId;
    }

    public void setClassesId(String classesId) {
        this.classesId = classesId == null ? null : classesId.trim();
    }
}