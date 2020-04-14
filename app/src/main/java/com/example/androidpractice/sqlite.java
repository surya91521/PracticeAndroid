package com.example.androidpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class sqlite extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);

        MyHelper helper = new MyHelper(this);
        SQLiteDatabase sqLiteDatabase = helper.getWritableDatabase();

        Cursor cursor =  sqLiteDatabase.rawQuery("SELECT NAME ,PRICE FROM PRODUCTS", new String[]{});

        if(cursor!=null){
            cursor.moveToFirst();
        }

        StringBuilder builder = new StringBuilder();

        do{
            String name = cursor.getString(0);
            double price = cursor.getDouble(1);

            builder.append("NAME -"+name + "Price -" + price);

        }while(cursor.moveToNext());

        TextView textView = (TextView)findViewById(R.id.textView);
        textView.setText(builder.toString());

    }
}
