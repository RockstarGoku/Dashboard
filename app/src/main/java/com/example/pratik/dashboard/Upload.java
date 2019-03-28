package com.example.pratik.dashboard;

public class Upload {
    private String mName;
    private String mImageUrl;
    private String type;

    public Upload() {
        //empty constructor needed
    }

    public Upload(String name, String imageUrl,String type) {
        if (name.trim().equals("")) {
            name = "No Name";
        }

        mName = name;
        mImageUrl = imageUrl;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }

}
