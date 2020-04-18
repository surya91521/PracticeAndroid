package com.example.androidpractice;

public class ExampleItem {

    private String mImageUrl;
    private String mCreator;
    private int mLikes;

    public ExampleItem(String imageUrl , String creator , int likes)
    {
        mImageUrl=mImageUrl;
        mCreator=creator;
        mLikes = likes;
    }

    public String getImageUrl()
    {
        return  mImageUrl;
    }

    public String getCreator()
    {
        return mCreator;
    }

    public int getLikeCount()
    {
        return mLikes;
    }




}
