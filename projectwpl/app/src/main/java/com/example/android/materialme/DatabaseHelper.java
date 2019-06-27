package com.example.android.materialme;


import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="project_wpl";
    public static final int DATABASE_VERSION=1;

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME,null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE user (id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(255), email VARCHAR(255), password TEXT);";
//        Log.d("DATA","onCreate:" + sql);
        db.execSQL(sql);
//        sql = "INSERT INTO user (name, email, password) VALUES" +
//                "('admin','admin@wpl.com','admin');" ;
//        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }
}

