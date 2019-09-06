package com.android.unsmk;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
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
    LinearLayout layJwbA, layJwbB, layJwbC, layJwbD, layBab2, teksJwbA, teksJwbB, teksJwbC, teksJwbD;
    ImageView imgBack;
    TextView teksA, teksB, teksC, teksD;
    public static ImageView imgSoal;
    public static TextView teksJmlSoal, teksNilai, teksTimer;
    DB DB;
    public static String soal= "", jawabA= "", jawabB= "", jawabC="", jawabD="";
    public static boolean isFirst = true;
    public static Activity act;
    MediaPlayer mpSoundWrong = new MediaPlayer();
    MediaPlayer mpSoundTrue = new MediaPlayer();

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
        teksTimer = findViewById(R.id.teksTimer);
        teksTimer.setVisibility(View.GONE);

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
        imgSoal = findViewById(R.id.imgSoal);
        teksJmlSoal = findViewById(R.id.teksJmlSoal);
        teksNilai = findViewById(R.id.teksNilai);

        teksA = findViewById(R.id.teksA);
        teksB = findViewById(R.id.teksB);
        teksC = findViewById(R.id.teksC);
        teksD = findViewById(R.id.teksD);

        teksJwbA = findViewById(R.id.teksJwbA);
        teksJwbB = findViewById(R.id.teksJwbB);
        teksJwbC = findViewById(R.id.teksJwbC);
        teksJwbD = findViewById(R.id.teksJwbD);

        mpSoundWrong = MediaPlayer.create(Soal.this, R.raw.wrong);
        mpSoundWrong.setVolume(30,30);

        mpSoundTrue = MediaPlayer.create(Soal.this, R.raw.trues);
        mpSoundTrue.setVolume(30,30);
        act = this;
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
                if (teksJawabA.getText().equals(jawabanBenar)) {
                    nilai = nilai+10;
                    teksNilai.setText("Nilai : "+nilai);
                    teksA.setBackground(getResources().getDrawable(R.drawable.bg_jawaban_benar));
                    teksJwbA.setBackground(getResources().getDrawable(R.drawable.bg_jawaban_benar));
                    setBg(teksA, teksJwbA);
                    mpSoundTrue.start();
                }
                else {
                    teksA.setBackground(getResources().getDrawable(R.drawable.bg_jawaban_salah));
                    teksJwbA.setBackground(getResources().getDrawable(R.drawable.bg_jawaban_salah));
                    setBg(teksA, teksJwbA);
                    mpSoundWrong.start();
                }

                if (noSoal2 >= 10) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            showDialog();
                        }
                    },1000);
                }
            }
        });
        layJwbB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SoundBtn.soundBtn(Soal.this);
                if (teksJawabB.getText().equals(jawabanBenar)) {
                    nilai = nilai+10;
                    teksNilai.setText("Nilai : "+nilai);
                    teksB.setBackground(getResources().getDrawable(R.drawable.bg_jawaban_benar));
                    teksJwbB.setBackground(getResources().getDrawable(R.drawable.bg_jawaban_benar));
                    setBg(teksB, teksJwbB);
                    mpSoundTrue.start();
                }
                else {
                    teksB.setBackground(getResources().getDrawable(R.drawable.bg_jawaban_salah));
                    teksJwbB.setBackground(getResources().getDrawable(R.drawable.bg_jawaban_salah));
                    setBg(teksB, teksJwbB);
                    mpSoundWrong.start();
                }
                if (noSoal2 >= 10) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            showDialog();
                        }
                    },1000);
                }
            }
        });

        layJwbC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SoundBtn.soundBtn(Soal.this);
                if (teksJawabC.getText().equals(jawabanBenar)) {
                    nilai = nilai+10;
                    teksNilai.setText("Nilai : "+nilai);
                    teksC.setBackground(getResources().getDrawable(R.drawable.bg_jawaban_benar));
                    teksJwbC.setBackground(getResources().getDrawable(R.drawable.bg_jawaban_benar));
                    setBg(teksC, teksJwbC);
                    mpSoundTrue.start();
                }
                else {
                    teksC.setBackground(getResources().getDrawable(R.drawable.bg_jawaban_salah));
                    teksJwbC.setBackground(getResources().getDrawable(R.drawable.bg_jawaban_salah));
                    setBg(teksC, teksJwbC);
                    mpSoundWrong.start();
                }

                if (noSoal2 >= 10) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            showDialog();
                        }
                    },1000);
                }
            }
        });

        layJwbD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SoundBtn.soundBtn(Soal.this);
                if (teksJawabD.getText().equals(jawabanBenar)) {
                    nilai = nilai+10;
                    teksNilai.setText("Nilai : "+nilai);
                    teksD.setBackground(getResources().getDrawable(R.drawable.bg_jawaban_benar));
                    teksJwbD.setBackground(getResources().getDrawable(R.drawable.bg_jawaban_benar));
                    setBg(teksD, teksJwbD);
                    mpSoundTrue.start();
                }
                else {
                    teksD.setBackground(getResources().getDrawable(R.drawable.bg_jawaban_salah));
                    teksJwbD.setBackground(getResources().getDrawable(R.drawable.bg_jawaban_salah));
                    setBg(teksD, teksJwbD);
                    mpSoundWrong.start();
                }

                if (noSoal2 >= 10) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            showDialog();
                        }
                    },1000);
                }
            }
        });
        teksNilai.setText("Nilai : "+nilai);
    }

    private void setBg(final TextView teks, final LinearLayout layTeks) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                String noSoals = noSoal.substring(0, noSoal.length()-1);
                DB.loadSoalByNoSoal(noSoals+(noSoal2+1));
                teks.setBackground(getResources().getDrawable(R.drawable.background));
                layTeks.setBackground(getResources().getDrawable(R.drawable.background));
            }
        },1000);
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
        if (noSoal.contains("bab4") && noSoal2==4) {
            imgSoal.setVisibility(View.VISIBLE);
            imgSoal.setImageDrawable(act.getResources().getDrawable(R.drawable.img_bab4_soal4));
        } else if (noSoal.contains("bab4") && noSoal2==5) {
            imgSoal.setVisibility(View.VISIBLE);
            imgSoal.setImageDrawable(act.getResources().getDrawable(R.drawable.img_bab4_soal5));
        } else if (noSoal.contains("bab4") && noSoal2==7) {
            imgSoal.setVisibility(View.VISIBLE);
            imgSoal.setImageDrawable(act.getResources().getDrawable(R.drawable.img_bab4_soal7));
        } else if (noSoal.contains("bab4") && noSoal2==9) {
            imgSoal.setVisibility(View.VISIBLE);
            imgSoal.setImageDrawable(act.getResources().getDrawable(R.drawable.img_bab4_soal9));
        } else {
            imgSoal.setVisibility(View.GONE);
        }
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
