package com.myrp.a16023022.c302photostoreclientps;

public class Category {
    private int catId;
    private String name;
    private String desc;

    public Category(int catId, String name, String desc) {
        this.catId = catId;
        this.name = name;
        this.desc = desc;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getCatId() {
        return catId;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }
}
