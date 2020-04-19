package com.example.androidpractice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder>{

     Context mcontext;
     ArrayList<ExampleItem> mExampleList;

    public ExampleAdapter(Context context,ArrayList<ExampleItem> exampleList)
    {
        this.mcontext = context;
        this.mExampleList = exampleList;
    }




    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item,parent,false);
        return new ExampleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        ExampleItem currentItem = mExampleList.get(position);

        String imageUrl = currentItem.getImageUrl();
        String creatorName =  currentItem.getCreator();
        int likeCount = currentItem.getLikeCount();

        holder.mTextViewCreator.setText(creatorName);
        holder.mTextViewLikes.setText("Likes : "+ String.valueOf(likeCount));
        Picasso.get().load(imageUrl).fit().centerInside().into(holder.mImageView);



    }


    @Override
    public int getItemCount()
    {
       return  mExampleList.size();
    }

    public class ExampleViewHolder extends  RecyclerView.ViewHolder{

        public ImageView mImageView;
        public TextView mTextViewCreator;
        public TextView mTextViewLikes;

        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);

            mImageView = itemView.findViewById(R.id.imageView);
            mTextViewCreator = itemView.findViewById(R.id.text_view_creator);
            mTextViewLikes=itemView.findViewById(R.id.text_view_likes);

        }
    }


}
