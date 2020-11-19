package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignActivity extends AppCompatActivity {
    SQLiteDatabase db;
    SignHelper signHelper;
    EditText username, password, email, no_hp;
    String u,p,e,n;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);
        btn = (Button) findViewById(R.id.daftar);

        signHelper = new SignHelper(getApplicationContext());
        db = signHelper.getWritableDatabase();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = (EditText) findViewById(R.id.username);
                password = (EditText) findViewById(R.id.password);
                email = (EditText) findViewById(R.id.email);
                no_hp = (EditText) findViewById(R.id.no_hp);
                u = username.getText().toString();
                p = password.getText().toString();
                e = email.getText().toString();
                n = no_hp.getText().toString();

                if (u.equals("") || p.equals("") || e.equals("") || n.equals("")) {
                    if (u.equals("")) {
                        username.setError("Username harus diisi");
                        username.requestFocus();
                    }
                    if (p.equals("")) {
                        password.setError("Password harus diisi");
                        password.requestFocus();
                    }
                    if (e.equals("")) {
                        email.setError("Email harus diisi");
                        email.requestFocus();
                    }
                    if (n.equals("")) {
                        no_hp.setError("No Hp harus diisi");
                        no_hp.requestFocus();
                    }
                }else {
                    db = signHelper.getWritableDatabase();
                    Toast.makeText(getApplicationContext(),"Akun Berhasil Dibuat",Toast.LENGTH_LONG).show();
                    db.execSQL("INSERT INTO tbl_user VALUES('" +u + "', '" + p + "', '" + e + "','" + n+ "')");
                    Intent i = new Intent(SignActivity.this, LoginActivity.class);
                    startActivity(i);
                }
            }
        });
    }
}
