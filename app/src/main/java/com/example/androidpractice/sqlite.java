package com.example.androidpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
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

        ContentValues values = new ContentValues();
        values.put("PRICE",320.88);

      //  sqLiteDatabase.update("PRODUCTS",values,"_id = ?",new String[]{"1"});
       // sqLiteDatabase.delete("PRODUCTS","_id = ?",new String[]{"1"});
     //  sqLiteDatabase.update("PRODUCTS",values,"NAME = ? AND DESCRIPTION = ?",new String[]{"Soup","Knorr Soup"});

        Cursor cursor =  sqLiteDatabase.rawQuery("SELECT NAME ,PRICE FROM PRODUCTS", new String[]{});

     // Cursor cursor =   sqLiteDatabase.rawQuery("SELECT NAME ,PRICE FROM PRODUCTS WHERE NAME = ?", new String[]{"CHICKEN"});

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
