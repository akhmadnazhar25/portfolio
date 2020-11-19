package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ConfimActivity extends AppCompatActivity {
    SharedPreferences sp;
    String metode;
    ImageView logo_metode;
    TextView pilihan_metode,total_pembayaran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confim);
        logo_metode = (ImageView) findViewById(R.id.logo_metode);
        pilihan_metode = (TextView) findViewById(R.id.pilihan_metode);
        sp = getSharedPreferences("statusLogin",MODE_PRIVATE);
        metode = sp.getString("metode", "");
        if (metode == "toBca" | metode == "tmBca"){
            logo_metode.setImageResource(R.drawable.bca);
        } else if (metode == "toBri" | metode == "tmBri"){
            logo_metode.setImageResource(R.drawable.bri);
        } else if (metode == "toBni" | metode == "tmBni"){
            logo_metode.setImageResource(R.drawable.bni);
        } else if (metode == "toMnd" | metode == "tmMnd"){
            logo_metode.setImageResource(R.drawable.bri);
        } else if (metode == "grAlf"){
            logo_metode.setImageResource(R.drawable.alfamart);
        } else{
            logo_metode.setImageResource(R.drawable.indomaret);
        }
        if (metode == "toBca" | metode == "toBri" | metode == "toBni" | metode == "toMnd"){
            pilihan_metode.setText("Transfer Otomatis");
        } else if(metode == "tmBca" | metode == "tmBri" | metode == "tmBni" | metode == "tmMnd"){
            pilihan_metode.setText("Transfer Manual");
        }else{
            pilihan_metode.setText("Pembayaran Gerai");
        }
        total_pembayaran = (TextView) findViewById(R.id.total_pembayaran);
        total_pembayaran.setText("Rp. "+sp.getString("total", ""));
    }
}
