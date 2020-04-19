package com.example.androidpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

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


        mExampleAdapter = new ExampleAdapter(gson.this,mExampleList);
        mRecyclerView.setAdapter(mExampleAdapter);

        parseJson();


    }

    private void parseJson() {
        String url ="https://api.spoonacular.com/recipes/search?query=cheese&number=10&apiKey=ee489750f6d44bcfa4de0808433058ec";


        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            JSONArray jsonArray = response.getJSONArray("results");
                            for(int i=0;i<jsonArray.length();i++)
                            {

                                JSONObject hit = jsonArray.getJSONObject(i);

                                ExampleItem exampleItem = new ExampleItem();

                                 exampleItem.setCreator(hit.getString("title"));
                                 exampleItem .setImageUrl(hit.getString("image"));
                                exampleItem.setLikeCount(hit.getInt("servings"));


                                mExampleList.add(exampleItem);

                                Log.d("Values",mExampleList.toString());
                            }

                          Log.d("Creator name:",mExampleList.toString());
                            mExampleAdapter.notifyDataSetChanged();

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
