package com.android.unsmk;

import android.app.Activity;
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

import org.json.JSONException;
import org.json.JSONObject;

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
                startActivity(new Intent(MenuUtama.this, KategoriSoal.class));
            }
        });
        btnUjian = findViewById(R.id.btnUjian);
        btnUjian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SoundBtn.soundBtn(MenuUtama.this);
                startActivity(new Intent(MenuUtama.this, SoalUjian.class));
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

    public static void soalSmt2 (Activity activity) {
        try {
            //  ========================================= Soal Bab 5
            JSONObject jsonObjects = new JSONObject();
            jsonObjects.put("no_soal", "bab5soal1");
            jsonObjects.put("soal", "Suku ke-25 dari barisan deret aritmatika : 1, 3, 5, 7, ... adalah ...");
            jsonObjects.put("semester", "2");
            jsonObjects.put("bab", "5");
            jsonObjects.put("jawab_a", "27");
            jsonObjects.put("jawab_b", "98");
            jsonObjects.put("jawab_c", "49");
            jsonObjects.put("jawab_d", "28");
            jsonObjects.put("jawab_benar", "49");


            JSONObject jsonObjects2 = new JSONObject();
            jsonObjects2.put("no_soal","bab5soal2");
            jsonObjects2.put("soal","Jika diketahui nilai dari suku ke-15 dari suatu deret arimatika adalah 32 dan beda deret adalah 2, maka  nilai dari suku pertamanya adalah ...");
            jsonObjects2.put("semester","2");
            jsonObjects2.put("bab","5");
            jsonObjects2.put("jawab_a", "1");
            jsonObjects2.put("jawab_b", "2");
            jsonObjects2.put("jawab_c", "3");
            jsonObjects2.put("jawab_d", "4");
            jsonObjects2.put("jawab_benar", "4");


            JSONObject jsonObjects3 = new JSONObject();
            jsonObjects3.put("no_soal","bab5soal3");
            jsonObjects3.put("soal","Dalam suatu barisan aritmatika, jika U3 + U7 = 56 dan U6 + U10 = 86 , maka suku ke-2 deret tersebut adalah ...");
            jsonObjects3.put("semester","2");
            jsonObjects3.put("bab","5");
            jsonObjects3.put("jawab_a","13");
            jsonObjects3.put("jawab_b","12");
            jsonObjects3.put("jawab_c","14");
            jsonObjects3.put("jawab_d","17");
            jsonObjects3.put("jawab_benar","13");

            JSONObject jsonObjects4 = new JSONObject();
            jsonObjects4.put("no_soal", "bab5soal4");
            jsonObjects4.put("soal", "Suatu deret aritmatika mempunyai beda 2 dan jumlah 20 suku pertamanya adalah 240, jumlah 7 suku pertamanya adalah ...");
            jsonObjects4.put("semester", "2");
            jsonObjects4.put("bab", "5");
            jsonObjects4.put("jawab_a","-8");
            jsonObjects4.put("jawab_b","-7");
            jsonObjects4.put("jawab_c","-9");
            jsonObjects4.put("jawab_d","-3");
            jsonObjects4.put("jawab_benar","-7");

            JSONObject jsonObjects5 = new JSONObject();
            jsonObjects5.put("no_soal", "bab5soal5");
            jsonObjects5.put("soal", "Dari suatu deret aritmatika dengan suku ke-n adalah U . diketahui U3 + U6 + U9 + U12 = 72. Jumlah 14 suku pertama deret ini adalah ...");
            jsonObjects5.put("semester", "2");
            jsonObjects5.put("bab", "5");
            jsonObjects5.put("jawab_a","239");
            jsonObjects5.put("jawab_b","138");
            jsonObjects5.put("jawab_c","252");
            jsonObjects5.put("jawab_d","394");
            jsonObjects5.put("jawab_benar","252");

            JSONObject jsonObjects6 = new JSONObject();
            jsonObjects6.put("no_soal", "bab5soal6");
            jsonObjects6.put("soal", "Misal Bayu punya sejumlah kelereng. Kelereng tersebut akan saya bagikan habis ke 5 orang dari sobat hitung menurut suatu aturan barisan aritmatika. Jika orang ketiga dapat 15 kelerang dan orang ke-4 dapat 19 kelerang. Berapa jumlah kelereng yang saya punya ... ");
            jsonObjects6.put("semester", "2");
            jsonObjects6.put("bab", "5");
            jsonObjects6.put("jawab_a","75");
            jsonObjects6.put("jawab_b","29");
            jsonObjects6.put("jawab_c","93");
            jsonObjects6.put("jawab_d","98");
            jsonObjects6.put("jawab_benar","75");

            JSONObject jsonObjects7 = new JSONObject();
            jsonObjects7.put("no_soal", "bab5soal7");
            jsonObjects7.put("soal", "Dari sebuah deret hitung diketahui suku ketiga sama dengan 9, sedangkan jumlah suku kelima dan ketujuh sama dengan 36. Jumlah 10 suku pertama adalah ...");
            jsonObjects7.put("semester", "2");
            jsonObjects7.put("bab", "5");
            jsonObjects7.put("jawab_a","75");
            jsonObjects7.put("jawab_b","29");
            jsonObjects7.put("jawab_c","93");
            jsonObjects7.put("jawab_d","98");
            jsonObjects7.put("jawab_benar","75");

            JSONObject jsonObjects8 = new JSONObject();
            jsonObjects8.put("no_soal", "bab5soal8");
            jsonObjects8.put("soal", "Diketahui barisan aritmatika 5, 8, 11, ..., 125, 128, 131. Suku tengahnya adalah ...");
            jsonObjects8.put("semester", "2");
            jsonObjects8.put("bab", "5");
            jsonObjects8.put("jawab_a", "34");
            jsonObjects8.put("jawab_b", "47");
            jsonObjects8.put("jawab_c", "56");
            jsonObjects8.put("jawab_d", "68");
            jsonObjects8.put("jawab_benar", "68");

            JSONObject jsonObjects9 = new JSONObject();
            jsonObjects9.put("no_soal", "bab5soal9");
            jsonObjects9.put("soal", "Suatu barisan dengan pola deret sn = 2n\\(^3\\) – 3n\\(^2\\) . Suku ke-10 adalah ...");
            jsonObjects9.put("semester", "2");
            jsonObjects9.put("bab", "5");
            jsonObjects9.put("jawab_a", "249");
            jsonObjects9.put("jawab_b", "485");
            jsonObjects9.put("jawab_c", "324");
            jsonObjects9.put("jawab_d", "745");
            jsonObjects9.put("jawab_benar", "485");


            JSONObject jsonObjects10 = new JSONObject();
            jsonObjects10.put("no_soal", "bab5soal10");
            jsonObjects10.put("soal", "Diketahui deret aritmetika tingkat satu dengan sn adalah jumlah n suku pertama. Jika sn = (m\\(^3\\) – 1) n\\(^2\\) – (m\\(^2\\) + 2) n + m – 3, maka tentukanlah suku ke-10 pada barisan tersebut ...");
            jsonObjects10.put("semester", "2");
            jsonObjects10.put("bab", "5");
            jsonObjects10.put("jawab_a", "483");
            jsonObjects10.put("jawab_b", "234");
            jsonObjects10.put("jawab_c", "656");
            jsonObjects10.put("jawab_d", "933");
            jsonObjects10.put("jawab_benar", "483");

            // ================================= Soal Bab 6
            JSONObject jsonObject11 = new JSONObject();
            jsonObject11.put("no_soal", "bab6soal1");
            jsonObject11.put("soal", "$${ {sin\\;(a-b)}\\over {tan\\;a-tan\\;b}=\\;...}$$");
            jsonObject11.put("semester", "2");
            jsonObject11.put("bab", "6");
            jsonObject11.put("jawab_a", "cos a cos b");
            jsonObject11.put("jawab_b", "sin a sin b");
            jsonObject11.put("jawab_c", "-cos a cos b");
            jsonObject11.put("jawab_d", "-sin a sin b");
            jsonObject11.put("jawab_benar", "cos a cos b");

            JSONObject jsonObject12 = new JSONObject();
            jsonObject12.put("no_soal", "bab6soal2");
            jsonObject12.put("soal", "sin 3p + sin p = ...");
            jsonObject12.put("semester", "2");
            jsonObject12.put("bab", "6");
            jsonObject12.put("jawab_a", "4 sin p cos\\(^2\\) p");
            jsonObject12.put("jawab_b", "4 sin\\(^2\\) p cos\\(^2\\) p");
            jsonObject12.put("jawab_c", "4 sin\\(^2\\) p cos p");
            jsonObject12.put("jawab_d", "2 sin p cos\\(^2\\) p");
            jsonObject12.put("jawab_benar", "4 sin p cos\\(^2\\) p");

            JSONObject jsonObject13 = new JSONObject();
            jsonObject13.put("no_soal", "bab6soal3");
            jsonObject13.put("soal", "Nilai $${{sin\\;105^0+sin\\;15^2}\\over {cos\\;75^0\\;-cos\\;5^0}}$$ adalah ...");
            jsonObject13.put("semester", "2");
            jsonObject13.put("bab", "6");
            jsonObject13.put("jawab_a", "$${-\\sqrt{3}}$$");
            jsonObject13.put("jawab_b", "$${-1}$$");
            jsonObject13.put("jawab_c", "$${1\\over 2}$$");
            jsonObject13.put("jawab_d", "$${\\sqrt{3}}$$");
            jsonObject13.put("jawab_benar", "$${-1}$$");

            JSONObject jsonObject14 = new JSONObject();
            jsonObject14.put("no_soal", "bab6soal4");
            jsonObject14.put("soal", "Jika $${sin\\;\\alpha\\;=\\;{3\\over\\;5}\\;dan\\;tan\\;\\alpha\\;=\\;{4\\over\\;5}}$$ $${\\alpha\\;dan\\;\\beta\\;adalah\\;sudut\\;lancip,}$$maka nilai $${sin\\;(\\alpha+\\beta)\\;adalah\\;...}$$");
            jsonObject14.put("semester", "2");
            jsonObject14.put("bab", "6");
            jsonObject14.put("jawab_a", "$${9\\over 25}$$");
            jsonObject14.put("jawab_b", "$${27\\over 25}$$");
            jsonObject14.put("jawab_c", "$${18\\over 25}$$");
            jsonObject14.put("jawab_d", "$${1}$$");
            jsonObject14.put("jawab_benar", "$${1}$$");

            JSONObject jsonObject15 = new JSONObject();
            jsonObject15.put("no_soal", "bab6soal5");
            jsonObject15.put("soal", "Jika tan 5\\(^0\\)=x, tentukan nilai tan 50\\(^0\\) ...");
            jsonObject15.put("semester", "2");
            jsonObject15.put("bab", "6");
            jsonObject15.put("jawab_a", "$${1+x\\over 1-x}$$");
            jsonObject15.put("jawab_b", "$${1+x\\over 1+x}$$");
            jsonObject15.put("jawab_c", "$${1-x\\over 1-x}$$");
            jsonObject15.put("jawab_d", "$${1+x^2\\over 1+x}$$");
            jsonObject15.put("jawab_benar", "$${1+x\\over 1-x}$$");

            JSONObject jsonObject16 = new JSONObject();
            jsonObject16.put("no_soal", "bab6soal6");
            jsonObject16.put("soal", "sin 75 + sin 15 = ...");
            jsonObject16.put("semester", "2");
            jsonObject16.put("bab", "6");
            jsonObject16.put("jawab_a", "$${-1}$$");
            jsonObject16.put("jawab_b", "$${0}$$");
            jsonObject16.put("jawab_c", "$${{1\\over 2}\\sqrt{2}}$$");
            jsonObject16.put("jawab_d", "$${{1\\over 2}\\sqrt{6}}$$");
            jsonObject16.put("jawab_benar", "$${{1\\over 2}\\sqrt{6}}$$");

            JSONObject jsonObject17 = new JSONObject();
            jsonObject17.put("no_soal", "bab6soal7");
            jsonObject17.put("soal", "Jika A+B+C = 180, maka $${{sin 1\\over 2} (B+C) = ...}$$");
            jsonObject17.put("semester", "2");
            jsonObject17.put("bab", "6");
            jsonObject17.put("jawab_a", "$${cos{1\\over 2}A}$$");
            jsonObject17.put("jawab_b", "$${sin{1\\over 2}A}$$");
            jsonObject17.put("jawab_c", "$${tg\\;(B+C)}$$");
            jsonObject17.put("jawab_d", "$${cos\\;2A}$$");
            jsonObject17.put("jawab_benar", "$${cos{1\\over 2}A}$$");

            JSONObject jsonObject18 = new JSONObject();
            jsonObject18.put("no_soal", "bab6soal8");
            jsonObject18.put("soal", "Bentuk $${{sin\\;5x+sin\\;3x}\\over {cos\\;5x+cos\\;3x}}$$ ...");
            jsonObject18.put("semester", "2");
            jsonObject18.put("bab", "6");
            jsonObject18.put("jawab_a", "tan 2x");
            jsonObject18.put("jawab_b", "tan 4x");
            jsonObject18.put("jawab_c", "cotan 4x");
            jsonObject18.put("jawab_d", "cotan 8x");
            jsonObject18.put("jawab_benar", "tan 4x");

            JSONObject jsonObject19 = new JSONObject();
            jsonObject19.put("no_soal", "bab6soal9");
            jsonObject19.put("soal", "Bentuk tan\\(^2\\)x - cos\\(^2\\)x identic dengan ...");
            jsonObject19.put("semester", "2");
            jsonObject19.put("bab", "6");
            jsonObject19.put("jawab_a", "sin\\(^2\\)x - cos\\(^2\\)x");
            jsonObject19.put("jawab_b", "sec\\(^2\\)x - cos\\(^2\\)x");
            jsonObject19.put("jawab_c", "sec\\(^2\\)x - cosec\\(^2\\)x");
            jsonObject19.put("jawab_d", "cosec\\(^2\\)x - sec\\(^2\\)x");
            jsonObject19.put("jawab_benar", "sec\\(^2\\)x - cosec\\(^2\\)x");

            JSONObject jsonObject20 = new JSONObject();
            jsonObject20.put("no_soal", "bab6soal10");
            jsonObject20.put("soal", "Untuk 0&lt;x&lt;180\\(^0\\), banyaknya nilai-nilai x yang memenuhi 8 cos\\(^4\\)x - cos\\(^2\\)x = 0 adalah ...");
            jsonObject20.put("semester", "2");
            jsonObject20.put("bab", "6");
            jsonObject20.put("jawab_a", "2");
            jsonObject20.put("jawab_b", "3");
            jsonObject20.put("jawab_c", "4");
            jsonObject20.put("jawab_d", "5");
            jsonObject20.put("jawab_benar", "5");

            //  ========================================= Soal Bab 8
            JSONObject jsonObject21 = new JSONObject();
            jsonObject21.put("no_soal", "bab8soal1");
            jsonObject21.put("soal", "Jika vektor $${\n" +
                    "                a=\\begin{pmatrix}1 \\\\ 2 \\\\ 3 \\end{pmatrix};\n" +
                    "                b=\\begin{pmatrix}5 \\\\ 4 \\\\ 1 \\end{pmatrix};}$$ $${dan\\;\n" +
                    "                c=\\begin{pmatrix}4 \\\\ -1 \\\\ 1 \\end{pmatrix}\n" +
                    "                }$$\n" +
                    "                maka vektor a+2b-3c = ...");
            jsonObject21.put("semester", "2");
            jsonObject21.put("bab", "8");
            jsonObject21.put("jawab_a", "$${\\begin{pmatrix}6 \\\\ 11 \\\\ -8 \\end{pmatrix}}$$");
            jsonObject21.put("jawab_b", "$${\\begin{pmatrix}7 \\\\ 13 \\\\ -8 \\end{pmatrix}}$$");
            jsonObject21.put("jawab_c", "$${\\begin{pmatrix}-1 \\\\ 13 \\\\ -2 \\end{pmatrix}}$$");
            jsonObject21.put("jawab_d", "$${\\begin{pmatrix}-6 \\\\ 12 \\\\ 8 \\end{pmatrix}}$$");
            jsonObject21.put("jawab_benar", "$${\\begin{pmatrix}-1 \\\\ 13 \\\\ -2 \\end{pmatrix}}$$");

            JSONObject jsonObject22 = new JSONObject();
            jsonObject22.put("no_soal", "bab8soal2");
            jsonObject22.put("soal", "Diketahui $${|a|=\\sqrt{3},\\,|b|=1,\\,dan\\;|a-b|=1}$$Panjang vektor a+b=...");
            jsonObject22.put("semester", "2");
            jsonObject22.put("bab", "8");
            jsonObject22.put("jawab_a", "$${\\sqrt{3}}$$");
            jsonObject22.put("jawab_b", "$${\\sqrt{5}}$$");
            jsonObject22.put("jawab_c", "$${\\sqrt{7}}$$");
            jsonObject22.put("jawab_d", "$${\\sqrt{8}}$$");
            jsonObject22.put("jawab_benar", "$${\\sqrt{7}}$$");

            JSONObject jsonObject23 = new JSONObject();
            jsonObject23.put("no_soal", "bab8soal3");
            jsonObject23.put("soal", "Ditentukan titik-titik P(-1,5,2) dan Q(5,-4,17), jika T pada ruas PQ dan PT:QT = 2:1, maka vektor posisi titik T adalah ...");
            jsonObject23.put("semester", "2");
            jsonObject23.put("bab", "8");
            jsonObject23.put("jawab_a", "(3,-1,11)");
            jsonObject23.put("jawab_b", "(2,-1,12)");
            jsonObject23.put("jawab_c", "(3,1,12)");
            jsonObject23.put("jawab_d", "(11,-13,32)");
            jsonObject23.put("jawab_benar", "(11,-13,32)");

            JSONObject jsonObject24 = new JSONObject();
            jsonObject24.put("no_soal", "bab8soal4");
            jsonObject24.put("soal", "Diketahui titik A(3,1,-4), B(3,-4,6) dan C(-1,5,4), titik P membagi AB sehingga AP:PB = 3:2, maka vektor yang diwakili oleh CP adalah ....");
            jsonObject24.put("semester", "2");
            jsonObject24.put("bab", "8");
            jsonObject24.put("jawab_a", "$${\\begin{pmatrix}-4 \\\\ 3 \\\\ -6 \\end{pmatrix}}$$");
            jsonObject24.put("jawab_b", "$${\\begin{pmatrix}4 \\\\ -7 \\\\ -2 \\end{pmatrix}}$$");
            jsonObject24.put("jawab_c", "$${\\begin{pmatrix}-4 \\\\ 3 \\\\ 6 \\end{pmatrix}}$$");
            jsonObject24.put("jawab_d", "$${\\begin{pmatrix}-4 \\\\ 7 \\\\ 2 \\end{pmatrix}}$$");
            jsonObject24.put("jawab_benar", "$${\\begin{pmatrix}4 \\\\ -7 \\\\ -2 \\end{pmatrix}}$$");

            JSONObject jsonObject25 = new JSONObject();
            jsonObject25.put("no_soal", "bab8soal5");
            jsonObject25.put("soal", "Diketahui $${|a|=\\sqrt{6}}$$(a-b).(a+b) = 0 dan a.(a-b) = 3. Besar sudut antara vektor a dan b adalah ...");
            jsonObject25.put("semester", "2");
            jsonObject25.put("bab", "8");
            jsonObject25.put("jawab_a", "$${\\pi\\over 6}$$");
            jsonObject25.put("jawab_b", "$${\\pi\\over 4}$$");
            jsonObject25.put("jawab_c", "$${\\pi\\over 3}$$");
            jsonObject25.put("jawab_d", "$${\\pi\\over 2}$$");
            jsonObject25.put("jawab_benar", "$${\\pi\\over 3}$$");

            JSONObject jsonObject26 = new JSONObject();
            jsonObject26.put("no_soal", "bab8soal6");
            jsonObject26.put("soal", "Titik A(3,2,-1), B(1,-2,1) dan C(7,p-1,-5) segaris untuk nilai p adalah ...");
            jsonObject26.put("semester", "2");
            jsonObject26.put("bab", "8");
            jsonObject26.put("jawab_a", "13");
            jsonObject26.put("jawab_b", "11");
            jsonObject26.put("jawab_c", "5");
            jsonObject26.put("jawab_d", "-11");
            jsonObject26.put("jawab_benar", "11");

            JSONObject jsonObject27 = new JSONObject();
            jsonObject27.put("no_soal", "bab8soal7");
            jsonObject27.put("soal", "Diketahui segitiga PQR dengan koordinasi titik sudut P(1,5,8), Q(-2,1,3) dan R(1,-6,0), PQ wakil dari u dan QR wakil dari v, maka u.v adalah ...");
            jsonObject27.put("semester", "2");
            jsonObject27.put("bab", "8");
            jsonObject27.put("jawab_a", "S");
            jsonObject27.put("jawab_b", "R");
            jsonObject27.put("jawab_c", "Q");
            jsonObject27.put("jawab_d", "P");
            jsonObject27.put("jawab_benar", "R");

            JSONObject jsonObject28 = new JSONObject();
            jsonObject28.put("no_soal", "bab8soal8");
            jsonObject28.put("soal", "Diketahui vektor-vektor a=2i+4j+k, b=-3i+mj+2k dan c=i+2j-k. Vektor a tegak lurus b, maka (b-c) adalah ...");
            jsonObject28.put("semester", "2");
            jsonObject28.put("bab", "8");
            jsonObject28.put("jawab_a", "-4i+j+3k");
            jsonObject28.put("jawab_b", "-4i-j+3k");
            jsonObject28.put("jawab_c", "-4i-4j+3k");
            jsonObject28.put("jawab_d", "4i-j+3k");
            jsonObject28.put("jawab_benar", "-4i-j+3k");

            JSONObject jsonObject29 = new JSONObject();
            jsonObject29.put("no_soal", "bab8soal9");
            jsonObject29.put("soal", "Diketahui segitiga ABC, dengan A(0,0,0), B(2,2,0) dan C(0,2,2). Proyeksi ortogonal AB pada AC adalah ...");
            jsonObject29.put("semester", "2");
            jsonObject29.put("bab", "8");
            jsonObject29.put("jawab_a", "j+k");
            jsonObject29.put("jawab_b", "i+k");
            jsonObject29.put("jawab_c", "-i+k");
            jsonObject29.put("jawab_d", "i+j-k");
            jsonObject29.put("jawab_benar", "j+k");

            JSONObject jsonObject30 = new JSONObject();
            jsonObject30.put("no_soal", "bab8soal10");
            jsonObject30.put("soal", "Diketahui panjang proyeksi vektor $${a=\\begin{pmatrix}-2 \\\\ 8 \\\\ 4 \\end{pmatrix}}$$ pada vektor $${b=\\begin{pmatrix}0 \\\\ p \\\\ 4 \\end{pmatrix}}$$ adalah 8. Nilai p = ...");
            jsonObject30.put("semester", "2");
            jsonObject30.put("bab", "8");
            jsonObject30.put("jawab_a", "-4");
            jsonObject30.put("jawab_b", "-3");
            jsonObject30.put("jawab_c", "3");
            jsonObject30.put("jawab_d", "4");
            jsonObject30.put("jawab_benar", "3");

//  ========================================= Soal Bab 7
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("no_soal", "bab7soal1");
            jsonObject.put("soal", "Diketahui matriks\n" +
                    "                $${\n" +
                    "                A\\,=\\,\\begin{pmatrix}3&amp;y \\\\ 5&amp;-1 \\end{pmatrix},\n" +
                    "                B\\,=\\,\\begin{pmatrix}x&amp;5 \\\\ 3&amp;6 \\end{pmatrix},\n" +
                    "                }$$\n" +
                    "                $${\n" +
                    "                C\\,=\\,\\begin{pmatrix}-3&amp;-1 \\\\ y&amp;9 \\end{pmatrix}.\n" +
                    "                }$$\n" +
                    "                $${\n" +
                    "                Jika\\;A+B-C\\,=\\,\\begin{pmatrix}8&amp;5x \\\\ -x&amp;-4 \\end{pmatrix},\n" +
                    "                }$$\n" +
                    "                maka nilai x+2xy+y adalah ...");
            jsonObject.put("semester", "2");
            jsonObject.put("bab", "7");
            jsonObject.put("jawab_a", "12");
            jsonObject.put("jawab_b", "18");
            jsonObject.put("jawab_c", "20");
            jsonObject.put("jawab_d", "22");
            jsonObject.put("jawab_benar", "22");

            JSONObject jsonObject2 = new JSONObject();
            jsonObject2.put("no_soal", "bab7soal2");
            jsonObject2.put("soal", "Diketahui persamaan matriks\n" +
                    "                $${\n" +
                    "                2\\begin{pmatrix}a&amp;2 \\\\ -3&amp;1 \\end{pmatrix}+\n" +
                    "                \\begin{pmatrix}4&amp;-1 \\\\ 0&amp;b \\end{pmatrix}=\n" +
                    "                }$$\n" +
                    "                $${\n" +
                    "                \\begin{pmatrix}3&amp;2 \\\\ c&amp;4 \\end{pmatrix}\n" +
                    "                \\begin{pmatrix}2&amp;d \\\\ 1&amp;3 \\end{pmatrix}.\n" +
                    "                }$$\n" +
                    "                Nilai dari a+b+c+d = ...");
            jsonObject2.put("semester", "2");
            jsonObject2.put("bab", "7");
            jsonObject2.put("jawab_a", "11");
            jsonObject2.put("jawab_b", "13");
            jsonObject2.put("jawab_c", "17");
            jsonObject2.put("jawab_d", "19");
            jsonObject2.put("jawab_benar", "11");

            JSONObject jsonObject3 = new JSONObject();
            jsonObject3.put("no_soal", "bab7soal3");
            jsonObject3.put("soal", "Diketahui matriks\n" +
                    "                $${\n" +
                    "                A=\\begin{pmatrix}2&amp;3 \\\\ 3&amp;4 \\end{pmatrix}\n" +
                    "                }$$\n" +
                    "                $${\n" +
                    "                dan\\;B=\\begin{pmatrix}-1&amp;0 \\\\ 1&amp;2 \\end{pmatrix}.\n" +
                    "                }$$\n" +
                    "                Jika AC=B, maka determinan matriks C adalah = ...");
            jsonObject3.put("semester", "2");
            jsonObject3.put("bab", "7");
            jsonObject3.put("jawab_a", "5");
            jsonObject3.put("jawab_b", "3");
            jsonObject3.put("jawab_c", "2");
            jsonObject3.put("jawab_d", "-1");
            jsonObject3.put("jawab_benar", "2");

            JSONObject jsonObject4 = new JSONObject();
            jsonObject4.put("no_soal", "bab7soal4");
            jsonObject4.put("soal", "Diketahui matriks\n" +
                    "                $${\n" +
                    "                A=\\begin{pmatrix}2&amp;5 \\\\ -1&amp;-3 \\end{pmatrix}\n" +
                    "                }$$\n" +
                    "                $${\n" +
                    "                dan\\;B=\\begin{pmatrix}3&amp;5 \\\\ -1&amp;-2 \\end{pmatrix}.\n" +
                    "                }$$\n" +
                    "                Hasil dari AB\\(^2\\) = ...");
            jsonObject4.put("semester", "2");
            jsonObject4.put("bab", "7");
            jsonObject4.put("jawab_a", "A\\(^t\\)");
            jsonObject4.put("jawab_b", "B");
            jsonObject4.put("jawab_c", "B\\(^{-1}\\)");
            jsonObject4.put("jawab_d", "A\\(^{-1}\\)");
            jsonObject4.put("jawab_benar", "B");

            JSONObject jsonObject5 = new JSONObject();
            jsonObject5.put("no_soal", "bab7soal5");
            jsonObject5.put("soal", "Diketahui suatu persamaan matriks:\n" +
                    "                $${\n" +
                    "                \\begin{pmatrix}{-q+s}&amp;q \\\\ {-p+r}&amp;p \\end{pmatrix}\n" +
                    "                .A=\\begin{pmatrix}p&amp;q \\\\ r&amp;s \\end{pmatrix}=\n" +
                    "                }$$\n" +
                    "                Determinan matriks A adalah ...");
            jsonObject5.put("semester", "2");
            jsonObject5.put("bab", "7");
            jsonObject5.put("jawab_a", "0");
            jsonObject5.put("jawab_b", "1");
            jsonObject5.put("jawab_c", "3");
            jsonObject5.put("jawab_d", "4");
            jsonObject5.put("jawab_benar", "1");

            JSONObject jsonObject6 = new JSONObject();
            jsonObject6.put("no_soal", "bab7soal6");
            jsonObject6.put("soal", "Diketahui matriks:\n" +
                    "                $${\n" +
                    "                A=\\begin{pmatrix}1&amp;2 \\\\ 3&amp;4 \\end{pmatrix}\n" +
                    "                }$$\n" +
                    "                dan matriks $${\n" +
                    "                B=\\begin{pmatrix}-1&amp;1 \\\\ 2&amp;-2 \\\\ -3&amp;3 \\end{pmatrix}\n" +
                    "                }$$\n" +
                    "                Serta B\\(^T\\) adalah transpos dari matriks B. Hasil dari A\\(^2\\)xB\\(^T\\) = ...");
            jsonObject6.put("semester", "2");
            jsonObject6.put("bab", "7");
            jsonObject6.put("jawab_a", "$${\\begin{pmatrix}3&amp;6&amp;51 \\\\ 37&amp;14&amp;111 \\end{pmatrix}}$$");
            jsonObject6.put("jawab_b", "$${\\begin{pmatrix}-17&amp;-6&amp;-51 \\\\ -37&amp;-14&amp;-111 \\end{pmatrix}}$$");
            jsonObject6.put("jawab_c", "$${\\begin{pmatrix}-3&amp;6&amp;9 \\\\ -7&amp;14&amp;-21 \\end{pmatrix}}$$");
            jsonObject6.put("jawab_d", "$${\\begin{pmatrix}3&amp;-6&amp;9 \\\\ 7&amp;-14&amp;21 \\end{pmatrix}}$$");
            jsonObject6.put("jawab_benar", "$${\\begin{pmatrix}3&amp;-6&amp;9 \\\\ 7&amp;-14&amp;21 \\end{pmatrix}}$$");

            JSONObject jsonObject7 = new JSONObject();
            jsonObject7.put("no_soal", "bab7soal7");
            jsonObject7.put("soal", "Invers dari matriks $${\\begin{bmatrix}4&amp;-5 \\\\ -7&amp;9 \\end{bmatrix}}$$");
            jsonObject7.put("semester", "2");
            jsonObject7.put("bab", "7");
            jsonObject7.put("jawab_a", "$${\\begin{bmatrix}9&amp;5 \\\\ 7&amp;4 \\end{bmatrix}}$$");
            jsonObject7.put("jawab_b", "$${\\begin{bmatrix}9&amp;-5 \\\\ -7&amp;4 \\end{bmatrix}}$$");
            jsonObject7.put("jawab_c", "$${\\begin{bmatrix}4&amp;-7 \\\\ -5&amp;9 \\end{bmatrix}}$$");
            jsonObject7.put("jawab_d", "$${\\begin{bmatrix}-9&amp;-7 \\\\ -5&amp;-4 \\end{bmatrix}}$$");
            jsonObject7.put("jawab_benar", "$${\\begin{bmatrix}9&amp;5 \\\\ 7&amp;4 \\end{bmatrix}}$$");

            JSONObject jsonObject8 = new JSONObject();
            jsonObject8.put("no_soal", "bab7soal8");
            jsonObject8.put("soal", "Diketahui $${A=\\begin{bmatrix}-4&amp;5&amp;2 \\\\ 0&amp;-2&amp;4 \\\\ -1&amp;-6&amp;3 \\end{bmatrix}}$$" +
                    "Nilai det (A) = ...");
            jsonObject8.put("semester", "2");
            jsonObject8.put("bab", "7");
            jsonObject8.put("jawab_a", "-48");
            jsonObject8.put("jawab_b", "-72");
            jsonObject8.put("jawab_c", "-96");
            jsonObject8.put("jawab_d", "24");
            jsonObject8.put("jawab_benar", "-96");

            JSONObject jsonObject9 = new JSONObject();
            jsonObject9.put("no_soal", "bab7soal9");
            jsonObject9.put("soal", "Nilai x-y dari sistem persamaan linear $${\n" +
                    "                  \\begin{cases}\n" +
                    "                    2x-3y=-4\\\\\n" +
                    "                    x+2y=5\n" +
                    "                  \\end{cases}\n" +
                    "                }$$ Adalah ...");
            jsonObject9.put("semester", "2");
            jsonObject9.put("bab", "7");
            jsonObject9.put("jawab_a", "-2");
            jsonObject9.put("jawab_b", "2");
            jsonObject9.put("jawab_c", "0");
            jsonObject9.put("jawab_d", "-1");
            jsonObject9.put("jawab_benar", "2");

            JSONObject jsonObject10 = new JSONObject();
            jsonObject10.put("no_soal", "bab7soal10");
            jsonObject10.put("soal", "Determinan matriks koefisien dari sistem persamaan linear $${\n" +
                    "                  \\begin{cases}\n" +
                    "                    5x+2y=1.250\\\\\n" +
                    "                    x+ky=400\n" +
                    "                  \\end{cases}\n" +
                    "                }$$ Adalah 3, nilai x:y = ...");
            jsonObject10.put("semester", "2");
            jsonObject10.put("bab", "7");
            jsonObject10.put("jawab_a", "2:1");
            jsonObject10.put("jawab_b", "2:5");
            jsonObject10.put("jawab_c", "3:2");
            jsonObject10.put("jawab_d", "3:5");
            jsonObject10.put("jawab_benar", "3:5");


            // ============================================
            DB DB = new DB(activity);
            // BAB 5
            DB.insertSoal(jsonObjects);
            DB.insertSoal(jsonObjects2);
            DB.insertSoal(jsonObjects3);
            DB.insertSoal(jsonObjects4);
            DB.insertSoal(jsonObjects5);
            DB.insertSoal(jsonObjects6);
            DB.insertSoal(jsonObjects7);
            DB.insertSoal(jsonObjects8);
            DB.insertSoal(jsonObjects9);
            DB.insertSoal(jsonObjects10);
            // BAB 6
            DB.insertSoal(jsonObject11);
            DB.insertSoal(jsonObject12);
            DB.insertSoal(jsonObject13);
            DB.insertSoal(jsonObject14);
            DB.insertSoal(jsonObject15);
            DB.insertSoal(jsonObject16);
            DB.insertSoal(jsonObject17);
            DB.insertSoal(jsonObject18);
            DB.insertSoal(jsonObject19);
            DB.insertSoal(jsonObject20);
            // BAB 7
            DB.insertSoal(jsonObject);
            DB.insertSoal(jsonObject2);
            DB.insertSoal(jsonObject3);
            DB.insertSoal(jsonObject4);
            DB.insertSoal(jsonObject5);
            DB.insertSoal(jsonObject6);
            DB.insertSoal(jsonObject7);
            DB.insertSoal(jsonObject8);
            DB.insertSoal(jsonObject9);
            DB.insertSoal(jsonObject10);
            // BAB 8
            DB.insertSoal(jsonObject21);
            DB.insertSoal(jsonObject22);
            DB.insertSoal(jsonObject23);
            DB.insertSoal(jsonObject24);
            DB.insertSoal(jsonObject25);
            DB.insertSoal(jsonObject26);
            DB.insertSoal(jsonObject27);
            DB.insertSoal(jsonObject28);
            DB.insertSoal(jsonObject29);
            DB.insertSoal(jsonObject30);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
