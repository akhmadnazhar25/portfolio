package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class OrderHelper extends SQLiteOpenHelper {
    private static String db_name = "order";
    private static SQLiteDatabase.CursorFactory factory =null;
    private static Integer version = 1;
    private String tbl_name = "tbl_order";


    public OrderHelper(@Nullable Context context) {
        super(context, db_name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + this.tbl_name +  " (nama_item TEXT, jumlah TEXT)");
        db.execSQL("INSERT INTO " + this.tbl_name + " VALUES ('item_1','0')");
        db.execSQL("INSERT INTO " + this.tbl_name + " VALUES ('item_2','0')");
        db.execSQL("INSERT INTO " + this.tbl_name + " VALUES ('item_3','0')");
        db.execSQL("INSERT INTO " + this.tbl_name + " VALUES ('item_4','0')");
        db.execSQL("INSERT INTO " + this.tbl_name + " VALUES ('item_5','0')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +this.tbl_name);
        onCreate(db);
    }
}
