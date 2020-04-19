package com.example.androidpractice;

public class ExampleItem {

     String mImageUrl;
     String mCreator;
     int mLikes;

    public ExampleItem(String imageUrl , String creator , int likes)
    {
       this.mImageUrl=imageUrl;
        this.mCreator=creator;
        this.mLikes = likes;
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

    public void setImageUrl(String mImageUrl){ this.mImageUrl=mImageUrl;}

    public void setCreator(String mCreator){ this.mCreator=mCreator;}

    public void setLikeCount(int mLikes){ this.mLikes=mLikes;}

}
