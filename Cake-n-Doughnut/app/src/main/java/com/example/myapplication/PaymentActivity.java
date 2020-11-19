package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class PaymentActivity extends AppCompatActivity {
    ImageButton toBca,toBri,toBni,toMnd,tmBca,tmBri,tmBni,tmMnd,grInd,grAlf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        toBca = (ImageButton) findViewById(R.id.toBca);
        toBri = (ImageButton) findViewById(R.id.toBri);
        toBni = (ImageButton) findViewById(R.id.toBni);
        toMnd = (ImageButton) findViewById(R.id.toMnd);
        tmBca = (ImageButton) findViewById(R.id.tmBca);
        tmBri = (ImageButton) findViewById(R.id.tmBri);
        tmBni = (ImageButton) findViewById(R.id.tmBni);
        tmMnd = (ImageButton) findViewById(R.id.tmMnd);
        grAlf = (ImageButton) findViewById(R.id.grAlf);
        grInd = (ImageButton) findViewById(R.id.grInd);

        toBca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp = getSharedPreferences("statusLogin", MODE_PRIVATE);
                SharedPreferences.Editor e = sp.edit();
                e.putString("metode", "toBca");
                e.commit();
                Intent i = new Intent(PaymentActivity.this,ConfimActivity.class);
                startActivity(i);
            }
        });
        toBri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp = getSharedPreferences("statusLogin", MODE_PRIVATE);
                SharedPreferences.Editor e = sp.edit();
                e.putString("metode", "toBri");
                e.commit();
                Intent i = new Intent(PaymentActivity.this,ConfimActivity.class);
                startActivity(i);
            }
        });
        toBni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp = getSharedPreferences("statusLogin", MODE_PRIVATE);
                SharedPreferences.Editor e = sp.edit();
                e.putString("metode", "toBni");
                e.commit();
                Intent i = new Intent(PaymentActivity.this,ConfimActivity.class);
                startActivity(i);
            }
        });
        toMnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp = getSharedPreferences("statusLogin", MODE_PRIVATE);
                SharedPreferences.Editor e = sp.edit();
                e.putString("metode", "toMnd");
                e.commit();
                Intent i = new Intent(PaymentActivity.this,ConfimActivity.class);
                startActivity(i);
            }
        });
        tmBca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp = getSharedPreferences("statusLogin", MODE_PRIVATE);
                SharedPreferences.Editor e = sp.edit();
                e.putString("metode", "tmBca");
                e.commit();
                Intent i = new Intent(PaymentActivity.this,ConfimActivity.class);
                startActivity(i);
            }
        });
        tmBri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp = getSharedPreferences("statusLogin", MODE_PRIVATE);
                SharedPreferences.Editor e = sp.edit();
                e.putString("metode", "tmBri");
                e.commit();
                Intent i = new Intent(PaymentActivity.this,ConfimActivity.class);
                startActivity(i);
            }
        });
        tmBni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp = getSharedPreferences("statusLogin", MODE_PRIVATE);
                SharedPreferences.Editor e = sp.edit();
                e.putString("metode", "tmBni");
                e.commit();
                Intent i = new Intent(PaymentActivity.this,ConfimActivity.class);
                startActivity(i);
            }
        });
        tmMnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp = getSharedPreferences("statusLogin", MODE_PRIVATE);
                SharedPreferences.Editor e = sp.edit();
                e.putString("metode", "tmMnd");
                e.commit();
                Intent i = new Intent(PaymentActivity.this,ConfimActivity.class);
                startActivity(i);
            }
        });
        grInd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp = getSharedPreferences("statusLogin", MODE_PRIVATE);
                SharedPreferences.Editor e = sp.edit();
                e.putString("metode", "grInd");
                e.commit();
                Intent i = new Intent(PaymentActivity.this,ConfimActivity.class);
                startActivity(i);
            }
        });
        grAlf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp = getSharedPreferences("statusLogin", MODE_PRIVATE);
                SharedPreferences.Editor e = sp.edit();
                e.putString("metode", "grAlf");
                e.commit();
                Intent i = new Intent(PaymentActivity.this,ConfimActivity.class);
                startActivity(i);
            }
        });
    }
}
