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
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AccountActivity extends AppCompatActivity {
    SharedPreferences sp;
    Button signOut;
    TextView username,email,no_hp;
    SQLiteDatabase db;
    SignHelper signHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        sp = getSharedPreferences("statusLogin",MODE_PRIVATE);
        username = (TextView) findViewById(R.id.username);
        email = (TextView) findViewById(R.id.email);
        no_hp = (TextView) findViewById(R.id.no_hp);
        signHelper = new SignHelper(getApplicationContext());
        db = signHelper.getWritableDatabase();

        Cursor uc = db.rawQuery("SELECT * FROM tbl_user WHERE username='" + sp.getString("username", "") + "'", null);
        uc.moveToFirst();

        username.setText(uc.getString(uc.getColumnIndex("username")));
        email.setText(uc.getString(uc.getColumnIndex("email")));
        no_hp.setText(uc.getString(3));

        signOut = (Button) findViewById(R.id.signOut);

        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor e = sp.edit();

                e.clear();
                e.commit();

                Intent i = new Intent(AccountActivity.this, LoginActivity.class);

                startActivity(i);
            }
        });
    }
}
