package com.example.androidpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.androidpractice.sqlite.sqlite;

public class List extends AppCompatActivity {

    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        button1 = (Button)findViewById(R.id.Login);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(List.this,MainActivity.class);
                startActivity(intent);
            }
        });

        Button button2 = (Button)findViewById(R.id.sqlite);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(List.this, sqlite.class);
                startActivity(intent);
            }
        });

        Button button3 = (Button)findViewById(R.id.maps);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(List.this,maps.class);
                startActivity(intent);
            }
        });


        Button button4 = (Button)findViewById(R.id.jsoup);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(List.this,jsoup.class);
                startActivity(intent);
            }
        });

        Button button5 = (Button)findViewById(R.id.json);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(List.this,gson.class);
                startActivity(intent);
            }
        });



    }
}
