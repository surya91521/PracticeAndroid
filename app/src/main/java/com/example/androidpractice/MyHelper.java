package com.example.androidpractice;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyHelper extends SQLiteOpenHelper {

    private static final String  dbname ="mydb";
    private static final int version =1;

    String name;
    String description;
    double price;

    public MyHelper(Context context){
        super(context,dbname,null,version);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE PRODUCTS ( _id INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT , DESCRIPTION TEXT ,PRICE REAL)";
        db.execSQL(sql);

        insertData("Jam","Bean Jam",300.50,db);
        insertData("Soup","Knorr Soup",30.50,db);
        insertData("Chicken","Tandoori Chicken",5500.50,db);


    }

    private void insertData(String name , String description , double price, SQLiteDatabase database){

        ContentValues values =  new ContentValues();
        values.put("NAME",name);
        values.put("DESCRIPTION",description);
        values.put("PRICE",price);

        database.insert("PRODUCTS",null,values);
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
