package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.widget.Toast.*;

public class LoginActivity extends AppCompatActivity {
    EditText username, password;
    Button signIn, signUp;
    SQLiteDatabase db;
    SignHelper signHelper;
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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        signHelper = new SignHelper(getApplicationContext());

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        signIn = (Button) findViewById(R.id.sign_in);
        signUp = (Button) findViewById(R.id.sign_up);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this,SignActivity.class);
                startActivity(i);
            }
        });

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = signHelper.getWritableDatabase();
                String u = username.getText().toString();
                String p = password.getText().toString();
                Cursor uc = db.rawQuery("SELECT * FROM tbl_user WHERE username='" + u + "'", null);
                if(String.valueOf(uc.moveToFirst()).equals("true")) {
                    String ud = uc.getString(0);
                    String pd = uc.getString(1);

                    if (u.equals("") || p.equals("")) {
                        if (u.equals("")) {
                            username.setError("Username harus diisi");
                            username.requestFocus();
                        }

                        if (p.equals("")) {
                            password.setError("Password harus diisi");
                            password.requestFocus();
                        }
                    } else {
                        if (u.equals(ud) && p.equals(pd)) {
                            SharedPreferences sp = getSharedPreferences("statusLogin", MODE_PRIVATE);

                            SharedPreferences.Editor e = sp.edit();

                            e.putString("username", u);

                            e.commit();

                            Intent i = new Intent(LoginActivity.this, WelcomeActivity.class);
                            startActivity(i);
                        } else {
                            makeText(getApplicationContext(), "Akun tidak terdaftar", LENGTH_LONG).show();

                            username.setText("");
                            password.setText("");
                            username.requestFocus();
                        }
                    }
                }
            }
        });
    }
}
