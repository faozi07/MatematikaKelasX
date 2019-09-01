package com.android.unsmk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class PilihSemester extends AppCompatActivity {

    LinearLayout laySmt1, laySmt2;
    ImageView imgBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pilih_semester);

        init();
    }

    public void init() {
        laySmt1 = findViewById(R.id.laySmt1);
        laySmt2 = findViewById(R.id.laySmt2);
        imgBack = findViewById(R.id.imgBack);

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        laySmt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SoundBtn.soundBtn(PilihSemester.this);
                KategoriSoal.isSmt1 = true;
                startActivity(new Intent(PilihSemester.this, KategoriSoal.class));
            }
        });

        laySmt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SoundBtn.soundBtn(PilihSemester.this);
                KategoriSoal.isSmt1 = false;
                startActivity(new Intent(PilihSemester.this, KategoriSoal.class));
            }
        });
    }
}
