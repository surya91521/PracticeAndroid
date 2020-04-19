package com.example.androidpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class gson extends AppCompatActivity {

     RecyclerView mRecyclerView;
      ExampleAdapter mExampleAdapter;
     ArrayList<ExampleItem> mExampleList;
     RequestQueue mRequestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gson);

         mRecyclerView = findViewById(R.id.recycler_view);
         mRecyclerView.setHasFixedSize(true);
         mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

         mExampleList = new ArrayList<>();

         mRequestQueue = Volley.newRequestQueue(this);
         parseJson();

        mExampleAdapter = new ExampleAdapter(gson.this,mExampleList);
        mRecyclerView.setAdapter(mExampleAdapter);


    }

    private void parseJson() {
        String url ="https://pixabay.com/api/?key=16109116-b7cbd34642076b463cbf74508&q=kitten&imag_type=photo&pretty=true";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            JSONArray jsonArray = response.getJSONArray("hits");
                            for(int i=0;i<jsonArray.length();i++)
                            {
                                JSONObject hit = jsonArray.getJSONObject(i);

                                String creatorName = hit.getString("user");
                                String imageUrl = hit.getString("webformatURL");
                                int likeCount = hit.getInt("likes");

                                mExampleList.add(new ExampleItem(imageUrl,creatorName,likeCount));
                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                    error.printStackTrace();
            }
        });

        mRequestQueue.add(request);
    }
}
