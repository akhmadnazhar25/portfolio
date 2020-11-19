package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    SQLiteDatabase db;
    Button checkout;
    OrderHelper orderHelper;
    String[] mTitle = {"Black Forest", "Red Velvet", "Cupcake", "Chocolatte Doughnut", "Sugar Doughnut"};
    String[] mDescription = {"Beautiful Black Forest Cake,  dilapisi krim kocok dan cokelat. Kue cokelat dua lapis ini dilapisi sirup ceri manis, krim kocok, cokelat parut, dan ceri segar."
            , "Red Velvet tiga lapis yang lembab serta menakjubkan diisi dan diberi lapisan atas krim keju halus dan diakhiri dengan serutan cokelat putih dan hitam yang meleleh di mulut Anda dan gerimis cokelat putih; kue ini pasti akan menjadi favorit baru Anda."
            , "Cupcake diisi dan dipanggang dengan isian chocolate chip cheesecake, ditambah dengan frosting dan chocolate chips cheesecake"
            , "Bittersweet Vintage Plantation, glasir cokelat atasnya dengan biji kakao renyah digulung dengan gula kayu manis yang diisi dengan Nutella yang krem dan selesai dengan gula bubuk di atasnya"
            , "Doughnut digulung dalam campuran manis kayu manis Meksiko yang baru ditumbuk dan gula pasir yang dibumbui dengan ekstrak vanila murni dan sentuhan garam"};
    int[] images = {R.drawable.black, R.drawable.red, R.drawable.cupcake, R.drawable.chocolatte, R.drawable.sugar};
    String[] mHarga = {"Rp.75.000","Rp.85.000","Rp.25.000","Rp.15.000","Rp.13.000"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        Myadapter adapter = new Myadapter(this,mTitle,mDescription,images,mHarga);
        listView.setAdapter(adapter);

        checkout = (Button) findViewById(R.id.checkout);
        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,ShopActivity.class);
                startActivity(i);
            }
        });

    }
    class Myadapter extends ArrayAdapter<String>{
        Context context;
        String[] rTitle;
        String[] rDescription;
        int[] rImgs;
        String[] rHarga;

        Myadapter (Context c, String[] title, String[] description, int[] imgs, String[] harga){
            super(c, R.layout.row, R.id.textView1, title);
            this.context = c;
            this.rTitle= title;
            this.rDescription= description;
            this.rImgs = imgs;
            this.rHarga = harga;
        }

        @NonNull
        @Override
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent,false);
            ImageView images = row.findViewById(R.id.image);
            final TextView myTitle = row.findViewById(R.id.textView1);
            TextView myDescription = row.findViewById(R.id.textView2);
            TextView myHarga = row.findViewById(R.id.hargaText);
            final ElegantNumberButton button = row.findViewById(R.id.button);
            orderHelper = new OrderHelper(getApplicationContext());
            db = orderHelper.getWritableDatabase();
            if (position == 0){
                button.setOnClickListener(new ElegantNumberButton.OnClickListener() {
                    public void onClick(View view) {
                        String num = button.getNumber();
                        db.execSQL("UPDATE tbl_order SET jumlah = ('"+num+"') WHERE nama_item='item_1'");
                    }
                });
            } else if (position == 1){
                button.setOnClickListener(new ElegantNumberButton.OnClickListener() {
                    public void onClick(View view) {
                        String num = button.getNumber();
                        db.execSQL("UPDATE tbl_order SET jumlah = ('"+num+"') WHERE nama_item='item_2'");
                    }
                });
            } else if (position == 2){
                button.setOnClickListener(new ElegantNumberButton.OnClickListener() {
                    public void onClick(View view) {
                        String num = button.getNumber();
                        db.execSQL("UPDATE tbl_order SET jumlah = ('"+num+"') WHERE nama_item='item_3'");
                    }
                });
            } else if (position == 3){
                button.setOnClickListener(new ElegantNumberButton.OnClickListener() {
                    public void onClick(View view) {
                        String num = button.getNumber();
                        db.execSQL("UPDATE tbl_order SET jumlah = ('"+num+"') WHERE nama_item='item_4'");
                    }
                });
            } else{
                button.setOnClickListener(new ElegantNumberButton.OnClickListener() {
                    public void onClick(View view) {
                        String num = button.getNumber();
                        db.execSQL("UPDATE tbl_order SET jumlah = ('"+num+"') WHERE nama_item='item_5'");
                    }
                });
            }


            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);
            myHarga.setText(rHarga[position]);


            return row;
        }
    }
}
