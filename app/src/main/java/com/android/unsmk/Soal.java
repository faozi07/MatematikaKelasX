package com.android.unsmk;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import io.github.kexanie.library.MathView;

public class Soal extends AppCompatActivity {

    public static boolean isRegistered = false, registerSukses = false;
    public static String noSoal = "", jawabanBenar = "";
    public static int noSoal2 = 0, nilai = 0;
    public static MathView teksSoal, teksJawabA, teksJawabB, teksJawabC, teksJawabD;
    LinearLayout layJwbA, layJwbB, layJwbC, layJwbD, layBab2;
    ImageView imgBack;
    public static TextView teksJmlSoal, teksNilai;
    DB DB;
    public static String soal= "", jawabA= "", jawabB= "", jawabC="", jawabD="";
    public static boolean isFirst = true;

    @Override
    protected void onResume() {
        super.onResume();
        isRegistered = false;
        registerSukses = false;

        setTextSoal(soal, jawabA, jawabB, jawabC, jawabD);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.soal);

        init();
        action();

        try {
            DB = new DB(this);
            DB.loadSoalByNoSoal(noSoal);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void init() {
        teksSoal = findViewById(R.id.mathSoal);
        teksJawabA = findViewById(R.id.mathJwbA);
        teksJawabB = findViewById(R.id.mathJwbB);
        teksJawabC = findViewById(R.id.mathJwbC);
        teksJawabD = findViewById(R.id.mathJwbD);

        layJwbA = findViewById(R.id.layJwbA);
        layJwbB = findViewById(R.id.layJwbB);
        layJwbC = findViewById(R.id.layJwbC);
        layJwbD = findViewById(R.id.layJwbD);

        layBab2 = findViewById(R.id.layBab2);
        if (noSoal.contains("bab2")) {
          layBab2.setVisibility(View.VISIBLE);
        } else {
            layBab2.setVisibility(View.GONE);
        }
        imgBack = findViewById(R.id.imgBack);
        teksJmlSoal = findViewById(R.id.teksJmlSoal);
        teksNilai = findViewById(R.id.teksNilai);
    }

    private void action() {
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SoundBtn.soundBtn(Soal.this);
                finish();
                noSoal2 = 1;
                nilai = 0;
                isFirst = true;
            }
        });
        layJwbA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SoundBtn.soundBtn(Soal.this);
                if (noSoal2 < 10) {
                    String noSoals = noSoal.substring(0, noSoal.length()-1);
                    DB.loadSoalByNoSoal(noSoals+(noSoal2+1));
                    if (teksJawabA.getText().equals(jawabanBenar)) {
                        nilai = nilai+20;
                        teksNilai.setText("Nilai : "+nilai);
                    }
                } else {
                    showDialog();
                }
            }
        });
        layJwbB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SoundBtn.soundBtn(Soal.this);
                if (noSoal2 < 10) {
                    String noSoals = noSoal.substring(0, noSoal.length()-1);
                    DB.loadSoalByNoSoal(noSoals+(noSoal2+1));
                    if (teksJawabB.getText().equals(jawabanBenar)) {
                        nilai = nilai+20;
                        teksNilai.setText("Nilai : "+nilai);
                    }
                } else {
                    showDialog();
                }
            }
        });

        layJwbC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SoundBtn.soundBtn(Soal.this);
                if (noSoal2 < 10) {
                    String noSoals = noSoal.substring(0, noSoal.length()-1);
                    DB.loadSoalByNoSoal(noSoals+(noSoal2+1));

                    if (teksJawabC.getText().equals(jawabanBenar)) {
                        nilai = nilai+20;
                        teksNilai.setText("Nilai : "+nilai);
                    }
                } else {
                    showDialog();
                }
            }
        });

        layJwbD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SoundBtn.soundBtn(Soal.this);
                if (noSoal2 < 10) {
                    String noSoals = noSoal.substring(0, noSoal.length()-1);
                    DB.loadSoalByNoSoal(noSoals+(noSoal2+1));

                    if (teksJawabD.getText().equals(jawabanBenar)) {
                        nilai = nilai+20;
                        teksNilai.setText("Nilai : "+nilai);
                    }
                } else {
                    showDialog();
                }
            }
        });
        teksNilai.setText("Nilai : "+nilai);
    }

    public static void setTextSoal(String soal, String jawabA, String jawabB, String jawabC, String jawabD) {
        if (isFirst) {
          isFirst = false;
          noSoal2 = 0;
        } else {
            noSoal2 = noSoal2+1;
        }
        teksJmlSoal.setText("Soal "+noSoal2+" /10");
        teksSoal.setText(soal);
        teksJawabA.setText(jawabA);
        teksJawabB.setText(jawabB);
        teksJawabC.setText(jawabC);
        teksJawabD.setText(jawabD);
    }

    private void showDialog(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                this);
        alertDialogBuilder.setTitle("Hai");
        alertDialogBuilder
                .setMessage("Nilai kamu di BAB ini adalah = "+nilai)
                .setCancelable(false)
                .setPositiveButton("OK",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        SoundBtn.soundBtn(Soal.this);
                        finish();
                        noSoal2 = 1;
                        nilai = 0;
                        isFirst = true;
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    @Override
    public void onBackPressed() {
        finish();
        noSoal2 = 0;
        nilai = 0;
        isFirst = true;
        SoundBtn.soundBtn(Soal.this);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

}
