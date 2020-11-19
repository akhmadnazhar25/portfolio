package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class WelcomeActivity extends AppCompatActivity {
    CarouselView carouselView;
    ImageButton menu,checkout,bayar,akun;
    TextView nama;
    SQLiteDatabase db;
    SharedPreferences sp;
    SignHelper signHelper;

    int[] sampleImages = {R.drawable.iklan1,R.drawable.iklan2};

    private boolean doubleBackToExitPressedOnce;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Press again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sp = getSharedPreferences("statusLogin",MODE_PRIVATE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        menu = (ImageButton) findViewById(R.id.shopmenu);
        checkout = (ImageButton) findViewById(R.id.checkout);
        bayar = (ImageButton) findViewById(R.id.pay);
        akun = (ImageButton) findViewById(R.id.account);
        nama = (TextView) findViewById(R.id.Welcome);
        signHelper = new SignHelper(getApplicationContext());
        db = signHelper.getWritableDatabase();
        final SharedPreferences sp;

        sp = getSharedPreferences("statusLogin",MODE_PRIVATE);
        Cursor uc = db.rawQuery("SELECT * FROM tbl_user WHERE username='" + sp.getString("username", "") + "'", null);
        uc.moveToFirst();

        nama.setText("Selamat Datang "+uc.getString(uc.getColumnIndex("username"))+"!");

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(WelcomeActivity.this,MainActivity.class);
                startActivity(i);
            }
        });
        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sp.getString("total", "").equals(null)|sp.getString("total", "").equals("0")){
                    Toast.makeText(getApplicationContext(),"Silahkan pesan terlebih dahulu",Toast.LENGTH_LONG).show();
                }else{
                    Intent i = new Intent(WelcomeActivity.this,ShopActivity.class);
                    startActivity(i);
                }
            }
        });
        bayar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sp.getString("total", "").equals(null)|sp.getString("total", "").equals("0")){
                    Toast.makeText(getApplicationContext(),"Silahkan pesan terlebih dahulu",Toast.LENGTH_LONG).show();
                }else {
                    Intent i = new Intent(WelcomeActivity.this, PaymentActivity.class);
                    startActivity(i);
                }
            }
        });

        akun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(WelcomeActivity.this,AccountActivity.class);
                startActivity(i);
            }
        });

        carouselView = (CarouselView) findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);
        carouselView.setImageListener(imageListener);
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };
}