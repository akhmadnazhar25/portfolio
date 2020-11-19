package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SignHelper extends SQLiteOpenHelper {
    private static String db_name = "user";
    private static SQLiteDatabase.CursorFactory factory =null;
    private static Integer version = 1;
    private String tbl_name = "tbl_user";


    public SignHelper(@Nullable Context context) {
        super(context, db_name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + this.tbl_name +  " (username TEXT, password TEXT, email TEXT, no_hp TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +this.tbl_name);
        onCreate(db);
    }
}
