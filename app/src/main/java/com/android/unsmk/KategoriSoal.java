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
    LinearLayout layKat1,layKat2, layKat3, layKat4;
    ImageView imgBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kategori_soal);
        init();
        action();
    }

    private void init() {
        layKat1 = findViewById(R.id.layKat1);
        layKat2 = findViewById(R.id.layKat2);
        layKat3 = findViewById(R.id.layKat3);
        layKat4 = findViewById(R.id.layKat4);

        teksKategori1 = findViewById(R.id.teksKategori1);
        teksKategori2 = findViewById(R.id.teksKategori2);
        teksKategori3 = findViewById(R.id.teksKategori3);
        teksKategori4 = findViewById(R.id.teksKategori4);

        imgBack = findViewById(R.id.imgBack);
    }

    private void action() {
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        layKat1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isSmt1) {
                    Soal.noSoal = "bab1soal1";
                    startActivity(new Intent(KategoriSoal.this, Soal.class));
                }
                else {
                    Soal.noSoal = "bab5soal1";
                }
                SoundBtn.soundBtn(KategoriSoal.this);
            }
        });

        layKat2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isSmt1) {
                    Soal.noSoal = "bab2soal1";
                    startActivity(new Intent(KategoriSoal.this, Soal.class));
                }
                else {
                    Soal.noSoal = "bab6soal1";
                }
                SoundBtn.soundBtn(KategoriSoal.this);
            }
        });

        layKat3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isSmt1) {
                    Soal.noSoal = "bab3soal1";
                    startActivity(new Intent(KategoriSoal.this, Soal.class));
                }
                else {
                    Soal.noSoal = "bab7soal1";
                }
                SoundBtn.soundBtn(KategoriSoal.this);
            }
        });

        layKat4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isSmt1) {
                    Soal.noSoal = "bab4soal1";
                    startActivity(new Intent(KategoriSoal.this, Soal.class));
                }
                else {
                    Soal.noSoal = "bab8soal1";
                }
                SoundBtn.soundBtn(KategoriSoal.this);
            }
        });

        if (isSmt1) {
            teksKategori1.setText(katSmt1[0]);
            teksKategori2.setText(katSmt1[1]);
            teksKategori3.setText(katSmt1[2]);
            teksKategori4.setText(katSmt1[3]);
        }
        else {
            teksKategori1.setText(katSmt2[0]);
            teksKategori2.setText(katSmt2[1]);
            teksKategori3.setText(katSmt2[2]);
            teksKategori4.setText(katSmt2[3]);
        }
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
