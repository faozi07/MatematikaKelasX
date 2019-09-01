package com.android.unsmk;

import android.app.ProgressDialog;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
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
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("no_soal","bab2soal1");
            jsonObject.put("soal","Tentukan himpunan penyelesaian dari |2x - 7| = 3");
            jsonObject.put("semester","1");
            jsonObject.put("bab","2");
            jsonObject.put("jawab_a","{2,5}");
            jsonObject.put("jawab_b","{4,6}");
            jsonObject.put("jawab_c","{9,7}");
            jsonObject.put("jawab_d","{8,5}");
            jsonObject.put("jawab_benar","{2,5}");

            JSONObject jsonObject2 = new JSONObject();
            jsonObject2.put("no_soal","bab2soal2");
            jsonObject2.put("soal","Tentukan himpunan penyelesaian dari |2x - 1| < 7 ...");
            jsonObject2.put("semester","1");
            jsonObject2.put("bab","2");
            jsonObject2.put("jawab_a","{7 < x < 5}");
            jsonObject2.put("jawab_b","{-3 > x > 4}\n");
            jsonObject2.put("jawab_c","{-4 > x > -3}");
            jsonObject2.put("jawab_d","{-3 < x < 4}");
            jsonObject2.put("jawab_benar","{-3 < x < 4}");

            JSONObject jsonObject3 = new JSONObject();
            jsonObject3.put("no_soal","bab2soal3");
            jsonObject3.put("soal","Tentukan penyelesaian dari |3x - 2| ≥ |2x + 7| ...");
            jsonObject3.put("semester","1");
            jsonObject3.put("bab","2");
            jsonObject3.put("jawab_a","{x ≥ -1  atau  x ≤ 9}");
            jsonObject3.put("jawab_b","{x ≤ -1  atau  x ≥ 9}");
            jsonObject3.put("jawab_c","{x ≤ -5  atau  x ≥ 3}");
            jsonObject3.put("jawab_d","{x ≥ 2  atau  x ≤ -6}");
            jsonObject3.put("jawab_benar","{x ≤ -1  atau  x ≥ 9}");

            JSONObject jsonObject4 = new JSONObject();
            jsonObject4.put("no_soal","bab2soal4");
            jsonObject4.put("soal","Tentukan nilai-nilai x yang memenuhi persamaan |x + 1| + |2x - 4| = 9 ...");
            jsonObject4.put("semester","1");
            jsonObject4.put("bab","2");
            jsonObject4.put("jawab_a","x = 2  atau  x = -4");
            jsonObject4.put("jawab_b","x = -3  atau  x = -2");
            jsonObject4.put("jawab_c","x = -2  atau  x = 4");
            jsonObject4.put("jawab_d","x = 8  atau  x = -8");
            jsonObject4.put("jawab_benar","x = -2  atau  x = 4");

            JSONObject jsonObject5 = new JSONObject();
            jsonObject5.put("no_soal","bab2soal5");
            jsonObject5.put("soal","Tentukanlah himpunan dari |3x – 1| = |x + 4| ...");
            jsonObject5.put("semester","1");
            jsonObject5.put("bab","2");
            jsonObject5.put("jawab_a","{-3, 6} ");
            jsonObject5.put("jawab_b","{1, 5}");
            jsonObject5.put("jawab_c","{7, 1}");
            jsonObject5.put("jawab_d","{-1, 5}");
            jsonObject5.put("jawab_benar","{-1, 5}");

            JSONObject jsonObject6 = new JSONObject();
            jsonObject6.put("no_soal","bab2soal6");
            jsonObject6.put("soal","Tentukanlah  himpunan penyelesaian |4x + 2| ≥ 6 ...");
            jsonObject6.put("semester","1");
            jsonObject6.put("bab","2");
            jsonObject6.put("jawab_a","(x ≤ -2 atau x ≥ 1)");
            jsonObject6.put("jawab_b","(x ≤ 2 atau x ≥ -1)");
            jsonObject6.put("jawab_c","(x ≥ -6 atau x ≤ -2)");
            jsonObject6.put("jawab_d","(x ≥ 4 atau x ≤ -3)");
            jsonObject6.put("jawab_benar","(x ≤ -2 atau x ≥ 1)");

            JSONObject jsonObject7 = new JSONObject();
            jsonObject7.put("no_soal","bab2soal7");
            jsonObject7.put("soal","Selesaikan persamaan nilai mutlak dari –5|x – 7| + 2 = –13 ...");
            jsonObject7.put("semester","1");
            jsonObject7.put("bab","2");
            jsonObject7.put("jawab_a","{3, 7}");
            jsonObject7.put("jawab_b","{-10, 8}");
            jsonObject7.put("jawab_c","{4, 10}");
            jsonObject7.put("jawab_d","{-4, 12}");
            jsonObject7.put("jawab_benar","{4, 10}");

            JSONObject jsonObject8 = new JSONObject();
            jsonObject8.put("no_soal","bab2soal8");
            jsonObject8.put("soal","Tentukan hasil persamaan dari |5x+10| = -|x2+2x| ...");
            jsonObject8.put("semester","1");
            jsonObject8.put("bab","2");
            jsonObject8.put("jawab_a","{-5}");
            jsonObject8.put("jawab_b","{-2}");
            jsonObject8.put("jawab_c","{9}");
            jsonObject8.put("jawab_d","{6}");
            jsonObject8.put("jawab_benar","{-2}");

            JSONObject jsonObject9 = new JSONObject();
            jsonObject9.put("no_soal","bab2soal9");
            jsonObject9.put("soal","Tentukan himpunan penyelesaian dari persamaan nilai mutlak |3x + 4| = x – 8 ...");
            jsonObject9.put("semester","1");
            jsonObject9.put("bab","2");
            jsonObject9.put("jawab_a","{-4}");
            jsonObject9.put("jawab_b","{5}");
            jsonObject9.put("jawab_c","{-9}");
            jsonObject9.put("jawab_d","{2}");
            jsonObject9.put("jawab_benar","{2}");

            JSONObject jsonObject10 = new JSONObject();
            jsonObject10.put("no_soal","bab2soal10");
            jsonObject10.put("soal","Tentukan himpunan penyelesaian dari persamaan nilai mutlak |–2x| + 5 = 13 ...");
            jsonObject10.put("semester","1");
            jsonObject10.put("bab","2");
            jsonObject10.put("jawab_a","x = –4 atau x = 4");
            jsonObject10.put("jawab_b","x = 4 atau x = -3");
            jsonObject10.put("jawab_c","x = –5 atau x = -4");
            jsonObject10.put("jawab_d","x = 3 atau x = 5");
            jsonObject10.put("jawab_benar","x = –4 atau x = 4");

            DB = new DB(this);
//            DB.insertSoal(jsonObject);
//            DB.insertSoal(jsonObject2);
//            DB.insertSoal(jsonObject3);
//            DB.insertSoal(jsonObject4);
//            DB.insertSoal(jsonObject5);
//            DB.insertSoal(jsonObject6);
//            DB.insertSoal(jsonObject7);
//            DB.insertSoal(jsonObject8);
//            DB.insertSoal(jsonObject9);
//            DB.insertSoal(jsonObject10);

            DB.loadSoalByNoSoal(noSoal);
        }
        catch (JSONException e) {
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

    @Override
    public void onBackPressed() {
        finish();
        noSoal2 = 0;
        nilai = 0;
        SoundBtn.soundBtn(Soal.this);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

}
