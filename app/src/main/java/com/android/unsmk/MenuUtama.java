package com.android.unsmk;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MenuUtama extends AppCompatActivity {

    MediaPlayer mpSound1 = new MediaPlayer();
    Button btnPlay,btnUjian;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mpSound1 = MediaPlayer.create(MenuUtama.this, R.raw.backsound);
        mpSound1.start();
        mpSound1.setLooping(true);
        mpSound1.setVolume(1,0);

        btnPlay = findViewById(R.id.btnPlay);
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SoundBtn.soundBtn(MenuUtama.this);
                startActivity(new Intent(MenuUtama.this, PilihSemester.class));
            }
        });
        btnUjian = findViewById(R.id.btnUjian);
        btnUjian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SoundBtn.soundBtn(MenuUtama.this);
//                startActivity(new Intent(MenuUtama.this, Penjualan.class));
            }
        });
    }
    @Override
    public void onBackPressed() {
        SoundBtn.soundBtn(MenuUtama.this);
        showDialog();
    }
    private void showDialog(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                this);
        alertDialogBuilder.setTitle("Apa benar kamu ingin keluar Aplikasi ?");
        alertDialogBuilder
                .setMessage("Klik Ya untuk keluar")
                .setCancelable(false)
                .setPositiveButton("Ya",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        SoundBtn.soundBtn(MenuUtama.this);
                        finish();
                    }
                })
                .setNegativeButton("Tidak",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        SoundBtn.soundBtn(MenuUtama.this);
                        dialog.cancel();
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
