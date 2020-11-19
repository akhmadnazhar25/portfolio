package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.text.NumberFormat;
import java.util.Locale;

public class ShopActivity extends AppCompatActivity {
    SQLiteDatabase db;
    OrderHelper orderHelper;
    TextView jumlah1, jumlah2, jumlah3, jumlah4, jumlah5, total;
    Button reset, chekout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        reset = (Button) findViewById(R.id.reset);
        chekout = (Button) findViewById(R.id.checkout);
        jumlah1 = (TextView) findViewById(R.id.jumlah1);
        jumlah2 = (TextView) findViewById(R.id.jumlah2);
        jumlah3 = (TextView) findViewById(R.id.jumlah3);
        jumlah4 = (TextView) findViewById(R.id.jumlah4);
        jumlah5 = (TextView) findViewById(R.id.jumlah5);
        total = (TextView) findViewById(R.id.total);
        Integer harga = 0;

        orderHelper = new OrderHelper(getApplicationContext());
        db = orderHelper.getWritableDatabase();
        Cursor u1 = db.rawQuery("SELECT * FROM tbl_order WHERE nama_item='item_1'", null);
        u1.moveToFirst();
        String jum_1 = u1.getString(1);
        jumlah1.setText(jum_1);
        harga += (Integer.parseInt(jum_1)*75000);

        Cursor u2 = db.rawQuery("SELECT * FROM tbl_order WHERE nama_item='item_2'", null);
        u2.moveToFirst();
        String jum_2 = u2.getString(1);
        jumlah2.setText(jum_2);
        harga += (Integer.parseInt(jum_2)*85000);

        Cursor u3 = db.rawQuery("SELECT * FROM tbl_order WHERE nama_item='item_3'", null);
        u3.moveToFirst();
        String jum_3 = u3.getString(1);
        jumlah3.setText(jum_3);
        harga += (Integer.parseInt(jum_3)*25000);

        Cursor u4 = db.rawQuery("SELECT * FROM tbl_order WHERE nama_item='item_4'", null);
        u4.moveToFirst();
        String jum_4 = u4.getString(1);
        jumlah4.setText(jum_4);
        harga += (Integer.parseInt(jum_4)*15000);

        Cursor u5 = db.rawQuery("SELECT * FROM tbl_order WHERE nama_item='item_5'", null);
        u5.moveToFirst();
        String jum_5 = u5.getString(1);
        jumlah5.setText(jum_5);
        harga += (Integer.parseInt(jum_5)*13000);

        total.setText("Rp. "+ NumberFormat.getNumberInstance(Locale.US).format(harga));

        final SharedPreferences sp = getSharedPreferences("statusLogin", MODE_PRIVATE);
        SharedPreferences.Editor e = sp.edit();
        e.putString("total", NumberFormat.getNumberInstance(Locale.US).format(harga));
        e.commit();

        chekout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sp.getString("total", "").equals(null)|sp.getString("total", "").equals("0")){
                    Toast.makeText(getApplicationContext(),"Silahkan pesan terlebih dahulu",Toast.LENGTH_LONG).show();
                }else {
                    Intent i = new Intent(ShopActivity.this, PaymentActivity.class);
                    startActivity(i);
                }
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.execSQL("UPDATE tbl_order SET jumlah = ('0') WHERE nama_item='item_1'");
                db.execSQL("UPDATE tbl_order SET jumlah = ('0') WHERE nama_item='item_2'");
                db.execSQL("UPDATE tbl_order SET jumlah = ('0') WHERE nama_item='item_3'");
                db.execSQL("UPDATE tbl_order SET jumlah = ('0') WHERE nama_item='item_4'");
                db.execSQL("UPDATE tbl_order SET jumlah = ('0') WHERE nama_item='item_5'");
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });
    }
}
