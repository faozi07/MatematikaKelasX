package com.android.unsmk;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import io.github.kexanie.library.MathView;

public class SoalUjian extends AppCompatActivity {

    public static boolean isRegistered = false, registerSukses = false;
    public static String noSoal = "", jawabanBenar = "", bab = "";
    public static int noSoal2 = 0;
    public static Double nilai = 0d;
    public static MathView teksSoal, teksJawabA, teksJawabB, teksJawabC, teksJawabD;
    LinearLayout layJwbA, layJwbB, layJwbC, layJwbD, layBab2, teksJwbA, teksJwbB, teksJwbC, teksJwbD;
    ImageView imgBack;
    TextView teksA, teksB, teksC, teksD;
    public static ImageView imgSoal;
    public static TextView teksJmlSoal, teksNilai, teksTimer;
    public static String soal= "", jawabA= "", jawabB= "", jawabC="", jawabD="";
    public static boolean isFirst = true;
    public static Activity act;
    MediaPlayer mpSoundWrong = new MediaPlayer();
    MediaPlayer mpSoundTrue = new MediaPlayer();
//    public static JSONArray arrSoalUjian = new JSONArray();
    public static ArrayList<modelSoal> arrSoalUjian = new ArrayList<>();
    CountDownTimer countDownTimer;

    @Override
    protected void onResume() {
        super.onResume();
        isRegistered = false;
        registerSukses = false;

        modelSoal modelSoal = arrSoalUjian.get(noSoal2);
        noSoal = modelSoal.getNosoal();
        jawabanBenar = modelSoal.getJawabBenar();
        bab = modelSoal.getBab();
        setTextSoal(modelSoal.getSoal(), modelSoal.getJawabA(), modelSoal.getJawabB(), modelSoal.getJawabC(), modelSoal.getJawabD());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.soal);

        init();
        action();

        try {
            modelSoal modelSoal = arrSoalUjian.get(noSoal2);
            noSoal = modelSoal.getNosoal();
            jawabanBenar = modelSoal.getJawabBenar();
            bab = modelSoal.getBab();
            setTextSoal(modelSoal.getSoal(), modelSoal.getJawabA(), modelSoal.getJawabB(), modelSoal.getJawabC(), modelSoal.getJawabD());

            countDownTimer = new CountDownTimer(3600000, 1000) {
                public void onTick(long millisUntilFinished) {

                    long hours = TimeUnit.MILLISECONDS.toHours(millisUntilFinished);
                    long minutes = TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) % TimeUnit.HOURS.toMinutes(1);
                    long seconds = TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) % TimeUnit.MINUTES.toSeconds(1);

                    String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d:%02d", hours, minutes, seconds);
                    teksTimer.setText(timeLeftFormatted);
                }

                public void onFinish() {
                    teksTimer.setText("Waktu Habis");
                    showDialog();
                }
            }.start();
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

        layJwbA = findViewById(R.id.layJwbA);
        layJwbB = findViewById(R.id.layJwbB);
        layJwbC = findViewById(R.id.layJwbC);
        layJwbD = findViewById(R.id.layJwbD);

        layBab2 = findViewById(R.id.layBab2);
        if (bab.equals("2")) {
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

        mpSoundWrong = MediaPlayer.create(SoalUjian.this, R.raw.wrong);
        mpSoundWrong.setVolume(30,30);

        mpSoundTrue = MediaPlayer.create(SoalUjian.this, R.raw.trues);
        mpSoundTrue.setVolume(30,30);
        act = this;
    }

    private void action() {
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SoundBtn.soundBtn(SoalUjian.this);
                finish();
                noSoal2 = 0;
                nilai = 0d;
                isFirst = true;
                countDownTimer.cancel();
            }
        });
        layJwbA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SoundBtn.soundBtn(SoalUjian.this);

                if (noSoal2 >= 39) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            showDialog();
                        }
                    },1000);
                } else {
                    if (teksJawabA.getText().equals(jawabanBenar)) {
                        nilai = nilai+2.5d;
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
                }
            }
        });
        layJwbB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SoundBtn.soundBtn(SoalUjian.this);

                if (noSoal2 >= 39) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            showDialog();
                        }
                    },1000);
                } else {
                    if (teksJawabB.getText().equals(jawabanBenar)) {
                        nilai = nilai+2.5d;
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
                }
            }
        });

        layJwbC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SoundBtn.soundBtn(SoalUjian.this);

                if (noSoal2 >= 39) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            showDialog();
                        }
                    },1000);
                } else {
                    if (teksJawabC.getText().equals(jawabanBenar)) {
                        nilai = nilai+2.5d;
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
                }
            }
        });

        layJwbD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SoundBtn.soundBtn(SoalUjian.this);
                if (noSoal2 >= 39) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            showDialog();
                        }
                    },1000);
                } else {
                    if (teksJawabD.getText().equals(jawabanBenar)) {
                        nilai = nilai+2.5d;
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
                }
            }
        });
        teksNilai.setText("Nilai : "+nilai);
    }

    private void setBg(final TextView teks, final LinearLayout layTeks) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
//                if (noSoal3 == 4) {
//                    modelSoal modelSoal = arrSoalUjian.get(0);
//                    jawabanBenar = modelSoal.getJawabBenar();
//                    bab = modelSoal.getBab();
//                    if (bab.equals("2")) {
//                        layBab2.setVisibility(View.VISIBLE);
//                    } else {
//                        layBab2.setVisibility(View.GONE);
//                    }
//                    setTextSoal(modelSoal.getSoal(), modelSoal.getJawabA(), modelSoal.getJawabB(), modelSoal.getJawabC(), modelSoal.getJawabD());
//                } else {

                noSoal2 = noSoal2+1;
                if (noSoal2 <= 40) {
                    modelSoal modelSoal = arrSoalUjian.get(noSoal2);
                    noSoal = modelSoal.getNosoal();
                    jawabanBenar = modelSoal.getJawabBenar();
                    bab = modelSoal.getBab();
                    if (bab.equals("2")) {
                        layBab2.setVisibility(View.VISIBLE);
                    } else {
                        layBab2.setVisibility(View.GONE);
                    }
                    setTextSoal(modelSoal.getSoal(), modelSoal.getJawabA(), modelSoal.getJawabB(), modelSoal.getJawabC(), modelSoal.getJawabD());
                }

                teks.setBackground(getResources().getDrawable(R.drawable.background));
                layTeks.setBackground(getResources().getDrawable(R.drawable.background));
            }
        },500);
    }

    public static void setTextSoal(String soal, String jawabA, String jawabB, String jawabC, String jawabD) {
        teksJmlSoal.setText("Soal "+(noSoal2+1)+" /40");
        teksSoal.setText(soal);
        teksJawabA.setText(jawabA);
        teksJawabB.setText(jawabB);
        teksJawabC.setText(jawabC);
        teksJawabD.setText(jawabD);
        if (noSoal.equals("bab4soal4")) {
            imgSoal.setVisibility(View.VISIBLE);
            imgSoal.setImageDrawable(act.getResources().getDrawable(R.drawable.img_bab4_soal4));
        } else if (noSoal.equals("bab4soal5")) {
            imgSoal.setVisibility(View.VISIBLE);
            imgSoal.setImageDrawable(act.getResources().getDrawable(R.drawable.img_bab4_soal5));
        } else if (noSoal.equals("bab4soal7")) {
            imgSoal.setVisibility(View.VISIBLE);
            imgSoal.setImageDrawable(act.getResources().getDrawable(R.drawable.img_bab4_soal7));
        } else if (noSoal.equals("bab4soal9")) {
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
                .setMessage("Nilai ujian kamu adalah = "+nilai)
                .setCancelable(false)
                .setPositiveButton("OK",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        SoundBtn.soundBtn(SoalUjian.this);
                        finish();
                        noSoal2 = 0;
                        nilai = 0d;
                        isFirst = true;
                        countDownTimer.cancel();
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    @Override
    public void onBackPressed() {
        finish();
        noSoal2 = 0;
        nilai = 0d;
        isFirst = true;
        countDownTimer.cancel();
        SoundBtn.soundBtn(SoalUjian.this);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

}
