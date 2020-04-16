package com.example.androidpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class jsoup extends AppCompatActivity {

    TextView textView;
    Button button;

    String url ="https://developer.android.com/";
    String title;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jsoup);

        textView = (TextView)findViewById(R.id.title);
        button = (Button)findViewById(R.id.fetch);

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
            progressDialog.cancel();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            try {
                Document doc = Jsoup.connect(url).get();
                title=doc.title();
            } catch (IOException e) {
                e.printStackTrace();
            }


            return null;
        }
    }

}
