package com.android.unsmk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class KategoriSoal extends AppCompatActivity {

    String[] katSmt1 = {
            "Bilangan Berpangkat, Bentuk Akar, dan Logaritma",
            "Persamaan dan Pertidaksamaan Linear Satu Variabel Yang Memuat Nilai Mutlak",
            "Sistem Persamaan Linear",
            "Program Linear"};

    String[] katSmt2 = {
            "Barisan dan Deret",
            "Trigonometri",
            "Matriks",
            "Vektor"};

    public static boolean isSmt1 = false;

    TextView teksKategori1, teksKategori2, teksKategori3, teksKategori4;
    ImageView imgBack, imgCat1, imgCat2, imgCat3, imgCat4, imgCat5, imgCat6, imgCat7, imgCat8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kategori_soal);
        init();
        action();
    }

    private void init() {

//        teksKategori1 = findViewById(R.id.teksKategori1);
//        teksKategori2 = findViewById(R.id.teksKategori2);
//        teksKategori3 = findViewById(R.id.teksKategori3);
//        teksKategori4 = findViewById(R.id.teksKategori4);

        imgBack = findViewById(R.id.imgBack);
        imgCat1 = findViewById(R.id.imgCat1);
        imgCat2 = findViewById(R.id.imgCat2);
        imgCat3 = findViewById(R.id.imgCat3);
        imgCat4 = findViewById(R.id.imgCat4);
        imgCat5 = findViewById(R.id.imgCat5);
        imgCat6 = findViewById(R.id.imgCat6);
        imgCat7 = findViewById(R.id.imgCat7);
        imgCat8 = findViewById(R.id.imgCat8);

//        if (isSmt1) {
//             imgCat1.setImageDrawable(getResources().getDrawable(R.drawable.bab1));
//            imgCat2.setImageDrawable(getResources().getDrawable(R.drawable.bab2));
//            imgCat3.setImageDrawable(getResources().getDrawable(R.drawable.bab3));
//            imgCat4.setImageDrawable(getResources().getDrawable(R.drawable.bab4));
//        } else {
//            imgCat1.setImageDrawable(getResources().getDrawable(R.drawable.bab5));
//            imgCat2.setImageDrawable(getResources().getDrawable(R.drawable.bab6));
//            imgCat3.setImageDrawable(getResources().getDrawable(R.drawable.bab3));
//            imgCat4.setImageDrawable(getResources().getDrawable(R.drawable.bab4));
//        }
    }

    private void action() {
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        imgCat1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Soal.noSoal = "bab1soal1";
                startActivity(new Intent(KategoriSoal.this, Soal.class));
                SoundBtn.soundBtn(KategoriSoal.this);
            }
        });

        imgCat2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Soal.noSoal = "bab2soal1";
                startActivity(new Intent(KategoriSoal.this, Soal.class));
                SoundBtn.soundBtn(KategoriSoal.this);
            }
        });

        imgCat3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Soal.noSoal = "bab3soal1";
                startActivity(new Intent(KategoriSoal.this, Soal.class));
                SoundBtn.soundBtn(KategoriSoal.this);
            }
        });

        imgCat4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Soal.noSoal = "bab4soal1";
                startActivity(new Intent(KategoriSoal.this, Soal.class));
                SoundBtn.soundBtn(KategoriSoal.this);
            }
        });

        imgCat5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Soal.noSoal = "bab5soal1";
                startActivity(new Intent(KategoriSoal.this, Soal.class));
                SoundBtn.soundBtn(KategoriSoal.this);
            }
        });

        imgCat6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Soal.noSoal = "bab6soal1";
                startActivity(new Intent(KategoriSoal.this, Soal.class));
                SoundBtn.soundBtn(KategoriSoal.this);
            }
        });

        imgCat7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Soal.noSoal = "bab7soal1";
                startActivity(new Intent(KategoriSoal.this, Soal.class));
                SoundBtn.soundBtn(KategoriSoal.this);
            }
        });

        imgCat8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Soal.noSoal = "bab8soal1";
                startActivity(new Intent(KategoriSoal.this, Soal.class));
                SoundBtn.soundBtn(KategoriSoal.this);
            }
        });

//        if (isSmt1) {
//            teksKategori1.setText(katSmt1[0]);
//            teksKategori2.setText(katSmt1[1]);
//            teksKategori3.setText(katSmt1[2]);
//            teksKategori4.setText(katSmt1[3]);
//        }
//        else {
//            teksKategori1.setText(katSmt2[0]);
//            teksKategori2.setText(katSmt2[1]);
//            teksKategori3.setText(katSmt2[2]);
//            teksKategori4.setText(katSmt2[3]);
//        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {
        SoundBtn.soundBtn(KategoriSoal.this);
        finish();
    }
}
