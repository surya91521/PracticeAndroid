package com.example.androidpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class jsoup extends AppCompatActivity {

    TextView textView;
    Button button;

    String url ="https://animefrenzy.net/";
    String title,link,src;
    ProgressDialog progressDialog;

    ImageView imageView1;
    ImageView imageView2;

    ArrayList list = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jsoup);

        textView = (TextView)findViewById(R.id.title);
        button = (Button)findViewById(R.id.fetch);

        imageView1 = (ImageView)findViewById(R.id.imageView);
        imageView2 = (ImageView)findViewById(R.id.imageView2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Content content = new Content();
                content.execute();
            }
        });


    }


    private class Content extends AsyncTask<Void,Void,Void>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = new ProgressDialog(jsoup.this);
            progressDialog.show();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            textView.setText(title);
            Picasso.get().load(list.get(0).toString()).into(imageView1);
            Picasso.get().load(list.get(1).toString()).into(imageView2);


            progressDialog.cancel();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            try {
                Document doc = Jsoup.connect(url).get();
                title=doc.title();            //gives the title of page
               // Elements links = doc.select("a[href]");  (Gives the title of all strings in page)
                //link = links.text().toString();

                Elements img = doc.getElementsByTag("img");
                for(Element el: img){

                    src=el.absUrl("src");
                    list.add(src);
               }

                Log.d("imageLinks : ",list.toString());


            } catch (IOException e) {
                e.printStackTrace();
            }


            return null;
        }
    }

}
