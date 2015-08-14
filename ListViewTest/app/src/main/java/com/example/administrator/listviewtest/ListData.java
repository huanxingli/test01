package com.example.administrator.listviewtest;

/**
 * Created by Administrator on 2015/8/14.
 */
public class ListData {
    private String name;
    private int imageId;
    public ListData(String name,int imageId){
        this.name = name;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
