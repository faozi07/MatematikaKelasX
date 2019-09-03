package com.android.unsmk;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.json.JSONException;
import org.json.JSONObject;

public class SplashScreen extends AppCompatActivity {

    DB DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
    }

    @Override
    protected void onResume() {
        super.onResume();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences spLoadData = getSharedPreferences(StaticVars.SP_LOGIN, MODE_PRIVATE);
                if (spLoadData.getString("isLoadData","").equals("true")) {
                    startActivity(new Intent(SplashScreen.this, MenuUtama.class));
                } else {
                    SharedPreferences.Editor loadEdit = spLoadData.edit();
                    loadEdit.putString("isLoadData", "true");
                    loadEdit.apply();
                    try {
                        //  ========================================= Soal Bab 1
                        JSONObject jsonObjects = new JSONObject();
                        jsonObjects.put("no_soal", "bab1soal1");
                        jsonObjects.put("soal", "Bentuk sederhana dari \\((4a)^2\\) x \\((2a)\\) = ...");
                        jsonObjects.put("semester", "1");
                        jsonObjects.put("bab", "1");
                        jsonObjects.put("jawab_a", "$${-2a}$$");
                        jsonObjects.put("jawab_b", "$${1\\over 8a}$$");
                        jsonObjects.put("jawab_c", "$${1\\over 2a}$$");
                        jsonObjects.put("jawab_d", "$${1\\over 4a}$$");
                        jsonObjects.put("jawab_benar", "$${1\\over 8a}$$");


                        JSONObject jsonObjects2 = new JSONObject();
                        jsonObjects2.put("no_soal","bab1soal2");
                        jsonObjects2.put("soal","Hasil dari $$4^2 \\times 32\\frac{3}{5} = ...$$");
                        jsonObjects2.put("semester","1");
                        jsonObjects2.put("bab","1");
                        jsonObjects2.put("jawab_a","\\(2^2\\)");
                        jsonObjects2.put("jawab_b","\\(2^{-2}\\)");
                        jsonObjects2.put("jawab_c","\\(2^3\\)");
                        jsonObjects2.put("jawab_d","\\(2^4\\)");
                        jsonObjects2.put("jawab_benar","\\(2^4\\)");


                        JSONObject jsonObjects3 = new JSONObject();
                        jsonObjects3.put("no_soal","bab1soal3");
                        jsonObjects3.put("soal","Jika a=27 dan b=32, maka nilai dari $$3(a\\frac{-1}{3}) \\times 4b\\frac{2}{5}$$adalah ...");
                        jsonObjects3.put("semester","1");
                        jsonObjects3.put("bab","1");
                        jsonObjects3.put("jawab_a","-25");
                        jsonObjects3.put("jawab_b","-16");
                        jsonObjects3.put("jawab_c","0");
                        jsonObjects3.put("jawab_d","16");
                        jsonObjects3.put("jawab_benar","16");

                        JSONObject jsonObjects4 = new JSONObject();
                        jsonObjects4.put("no_soal", "bab1soal4");
                        jsonObjects4.put("soal", "Bentuk paling sederhana dari $${{x\\over y^{-3}} + {y\\over x^{-2}}}$$dalam pangkat positif adalah ...");
                        jsonObjects4.put("semester", "1");
                        jsonObjects4.put("bab", "1");
                        jsonObjects4.put("jawab_a", "xy(\\(y^{2}\\)+x)");
                        jsonObjects4.put("jawab_b", "x(\\(xy^{3}\\)+y)");
                        jsonObjects4.put("jawab_c", "(x\\(y^{2}\\)+\\(x^{2}\\)y)");
                        jsonObjects4.put("jawab_d", "xy(\\(2x^{2}\\)+y)");
                        jsonObjects4.put("jawab_benar", "xy(\\(y^{2}\\)+x)");

                        JSONObject jsonObjects5 = new JSONObject();
                        jsonObjects5.put("no_soal", "bab1soal5");
                        jsonObjects5.put("soal", "Bentuk sederhana dari $${(a^{-1}b^2)^3 \\over a^{-9}b^3}$$ adalah ...");
                        jsonObjects5.put("semester", "1");
                        jsonObjects5.put("bab", "1");
                        jsonObjects5.put("jawab_a", "\\(a^5\\)\\(b^3\\)");
                        jsonObjects5.put("jawab_b", "\\(a^6\\)\\(b^3\\)");
                        jsonObjects5.put("jawab_c", "\\(a^8\\)\\(b^8\\)");
                        jsonObjects5.put("jawab_d", "\\(a^7\\)\\(b^6\\)");
                        jsonObjects5.put("jawab_benar", "\\(a^6\\)\\(b^3\\)");

                        JSONObject jsonObjects6 = new JSONObject();
                        jsonObjects6.put("no_soal", "bab1soal6");
                        jsonObjects6.put("soal", "$${{({2\\over3} p^2q^3)^4}\\over{(3^{-2}(pq)^4)^2}} =$$");
                        jsonObjects6.put("semester", "1");
                        jsonObjects6.put("bab", "1");
                        jsonObjects6.put("jawab_a", "$${8q}{4\\over3}$$");
                        jsonObjects6.put("jawab_b", "$${1\\over4}pq$$");
                        jsonObjects6.put("jawab_c", "$$16q^4$$");
                        jsonObjects6.put("jawab_d", "$${q}{4\\over16}$$");
                        jsonObjects6.put("jawab_benar", "$$16q^4$$");

                        JSONObject jsonObjects7 = new JSONObject();
                        jsonObjects7.put("no_soal", "bab1soal7");
                        jsonObjects7.put("soal", "Jika diketahui log x=a dan log y=b, maka $$log {{10x^3}\\over{y^2}} = ...$$");
                        jsonObjects7.put("semester", "1");
                        jsonObjects7.put("bab", "1");
                        jsonObjects7.put("jawab_a", "$$10(3a-2b)$$");
                        jsonObjects7.put("jawab_b", "$$1 + 3a - 2b$$");
                        jsonObjects7.put("jawab_c", "$${10a^3\\over{b^2}}$$");
                        jsonObjects7.put("jawab_d", "$${30a\\over2b}$$");
                        jsonObjects7.put("jawab_benar", "$$10(3a-2b)$$");

                        JSONObject jsonObjects8 = new JSONObject();
                        jsonObjects8.put("no_soal", "bab1soal8");
                        jsonObjects8.put("soal", "Nilai dari \\(^3\\) log 6 + 2. \\(^3\\) log 2 adalah ...");
                        jsonObjects8.put("semester", "1");
                        jsonObjects8.put("bab", "1");
                        jsonObjects8.put("jawab_a", "0");
                        jsonObjects8.put("jawab_b", "1");
                        jsonObjects8.put("jawab_c", "2");
                        jsonObjects8.put("jawab_d", "3");
                        jsonObjects8.put("jawab_benar", "3");

                        JSONObject jsonObjects9 = new JSONObject();
                        jsonObjects9.put("no_soal", "bab1soal9");
                        jsonObjects9.put("soal", "Jika \\(^3\\) log 5 = 1,465 dan \\(^3\\) log 7 = 1,771, maka \\(^3\\) log 105 adalah ...");
                        jsonObjects9.put("semester", "1");
                        jsonObjects9.put("bab", "1");
                        jsonObjects9.put("jawab_a", "2,336");
                        jsonObjects9.put("jawab_b", "3,227");
                        jsonObjects9.put("jawab_c", "4,326");
                        jsonObjects9.put("jawab_d", "5,629");
                        jsonObjects9.put("jawab_benar", "4,326");


                        JSONObject jsonObjects10 = new JSONObject();
                        jsonObjects10.put("no_soal", "bab1soal10");
                        jsonObjects10.put("soal", "Jika diketahui \\(^2\\)log 3 = x dan \\(^2\\)log 5 = y, maka $$^2log\\;45\\sqrt{15}$$ adalah ...");
                        jsonObjects10.put("semester", "1");
                        jsonObjects10.put("bab", "1");
                        jsonObjects10.put("jawab_a", "$${1\\over2}(5x-3y)$$");
                        jsonObjects10.put("jawab_b", "$${1\\over2}(5x+3y)$$");
                        jsonObjects10.put("jawab_c", "$${1\\over2}(3x+5y)$$");
                        jsonObjects10.put("jawab_d", "$${1\\over2}x^2{\\sqrt{x}}+y{\\sqrt{y}}$$");
                        jsonObjects10.put("jawab_benar", "$${1\\over2}(5x+3y)$$");
//  ========================================= Soal Bab 2
                        JSONObject jsonObject = new JSONObject();
                        jsonObject.put("no_soal", "bab2soal1");
                        jsonObject.put("soal", "Tentukan himpunan penyelesaian dari |2x - 7| = 3");
                        jsonObject.put("semester", "1");
                        jsonObject.put("bab", "2");
                        jsonObject.put("jawab_a", "{2,5}");
                        jsonObject.put("jawab_b", "{4,6}");
                        jsonObject.put("jawab_c", "{9,7}");
                        jsonObject.put("jawab_d", "{8,5}");
                        jsonObject.put("jawab_benar", "{2,5}");

                        JSONObject jsonObject2 = new JSONObject();
                        jsonObject2.put("no_soal", "bab2soal2");
                        jsonObject2.put("soal", "Tentukan himpunan penyelesaian dari |2x - 1| < 7 ...");
                        jsonObject2.put("semester", "1");
                        jsonObject2.put("bab", "2");
                        jsonObject2.put("jawab_a", "{7 < x < 5}");
                        jsonObject2.put("jawab_b", "{-3 > x > 4}\n");
                        jsonObject2.put("jawab_c", "{-4 > x > -3}");
                        jsonObject2.put("jawab_d", "{-3 < x < 4}");
                        jsonObject2.put("jawab_benar", "{-3 < x < 4}");

                        JSONObject jsonObject3 = new JSONObject();
                        jsonObject3.put("no_soal", "bab2soal3");
                        jsonObject3.put("soal", "Tentukan penyelesaian dari |3x - 2| &ge; |2x + 7| ...");
                        jsonObject3.put("semester", "1");
                        jsonObject3.put("bab", "2");
                        jsonObject3.put("jawab_a", "{x &ge; -1  atau  x &le; 9}");
                        jsonObject3.put("jawab_b", "{x &le; -1  atau  x &ge; 9}");
                        jsonObject3.put("jawab_c", "{x &le; -5  atau  x &ge; 3}");
                        jsonObject3.put("jawab_d", "{x &ge; 2  atau  x &le; -6}");
                        jsonObject3.put("jawab_benar", "{x &le; -1  atau  x &ge; 9}");

                        JSONObject jsonObject4 = new JSONObject();
                        jsonObject4.put("no_soal", "bab2soal4");
                        jsonObject4.put("soal", "Tentukan nilai-nilai x yang memenuhi persamaan |x + 1| + |2x - 4| = 9 ...");
                        jsonObject4.put("semester", "1");
                        jsonObject4.put("bab", "2");
                        jsonObject4.put("jawab_a", "x = 2  atau  x = -4");
                        jsonObject4.put("jawab_b", "x = -3  atau  x = -2");
                        jsonObject4.put("jawab_c", "x = -2  atau  x = 4");
                        jsonObject4.put("jawab_d", "x = 8  atau  x = -8");
                        jsonObject4.put("jawab_benar", "x = -2  atau  x = 4");

                        JSONObject jsonObject5 = new JSONObject();
                        jsonObject5.put("no_soal", "bab2soal5");
                        jsonObject5.put("soal", "Tentukanlah himpunan dari |3x – 1| = |x + 4| ...");
                        jsonObject5.put("semester", "1");
                        jsonObject5.put("bab", "2");
                        jsonObject5.put("jawab_a", "{-3, 6} ");
                        jsonObject5.put("jawab_b", "{1, 5}");
                        jsonObject5.put("jawab_c", "{7, 1}");
                        jsonObject5.put("jawab_d", "{-1, 5}");
                        jsonObject5.put("jawab_benar", "{-1, 5}");

                        JSONObject jsonObject6 = new JSONObject();
                        jsonObject6.put("no_soal", "bab2soal6");
                        jsonObject6.put("soal", "Tentukanlah  himpunan penyelesaian |4x + 2| &ge; 6 ...");
                        jsonObject6.put("semester", "1");
                        jsonObject6.put("bab", "2");
                        jsonObject6.put("jawab_a", "(x &le; -2 atau x &ge; 1)");
                        jsonObject6.put("jawab_b", "(x &le; 2 atau x &ge; -1)");
                        jsonObject6.put("jawab_c", "(x &ge; -6 atau x &le; -2)");
                        jsonObject6.put("jawab_d", "(x &ge; 4 atau x &le; -3)");
                        jsonObject6.put("jawab_benar", "(x &le; -2 atau x &ge; 1)");

                        JSONObject jsonObject7 = new JSONObject();
                        jsonObject7.put("no_soal", "bab2soal7");
                        jsonObject7.put("soal", "Selesaikan persamaan nilai mutlak dari –5|x – 7| + 2 = –13 ...");
                        jsonObject7.put("semester", "1");
                        jsonObject7.put("bab", "2");
                        jsonObject7.put("jawab_a", "{3, 7}");
                        jsonObject7.put("jawab_b", "{-10, 8}");
                        jsonObject7.put("jawab_c", "{4, 10}");
                        jsonObject7.put("jawab_d", "{-4, 12}");
                        jsonObject7.put("jawab_benar", "{4, 10}");

                        JSONObject jsonObject8 = new JSONObject();
                        jsonObject8.put("no_soal", "bab2soal8");
                        jsonObject8.put("soal", "Tentukan hasil persamaan dari |5x+10| = -|x2+2x| ...");
                        jsonObject8.put("semester", "1");
                        jsonObject8.put("bab", "2");
                        jsonObject8.put("jawab_a", "{-5}");
                        jsonObject8.put("jawab_b", "{-2}");
                        jsonObject8.put("jawab_c", "{9}");
                        jsonObject8.put("jawab_d", "{6}");
                        jsonObject8.put("jawab_benar", "{-2}");

                        JSONObject jsonObject9 = new JSONObject();
                        jsonObject9.put("no_soal", "bab2soal9");
                        jsonObject9.put("soal", "Tentukan himpunan penyelesaian dari persamaan nilai mutlak |3x + 4| = x – 8 ...");
                        jsonObject9.put("semester", "1");
                        jsonObject9.put("bab", "2");
                        jsonObject9.put("jawab_a", "{-4}");
                        jsonObject9.put("jawab_b", "{5}");
                        jsonObject9.put("jawab_c", "{-9}");
                        jsonObject9.put("jawab_d", "{2}");
                        jsonObject9.put("jawab_benar", "{2}");

                        JSONObject jsonObject10 = new JSONObject();
                        jsonObject10.put("no_soal", "bab2soal10");
                        jsonObject10.put("soal", "Tentukan himpunan penyelesaian dari persamaan nilai mutlak |–2x| + 5 = 13 ...");
                        jsonObject10.put("semester", "1");
                        jsonObject10.put("bab", "2");
                        jsonObject10.put("jawab_a", "x = –4 atau x = 4");
                        jsonObject10.put("jawab_b", "x = 4 atau x = -3");
                        jsonObject10.put("jawab_c", "x = –5 atau x = -4");
                        jsonObject10.put("jawab_d", "x = 3 atau x = 5");
                        jsonObject10.put("jawab_benar", "x = –4 atau x = 4");

//  ========================================= Soal Bab 3
                        JSONObject jsonObject11 = new JSONObject();
                        jsonObject11.put("no_soal", "bab3soal1");
                        jsonObject11.put("soal", "Diberikan dua buah persamaan sebagai berikut:\n(i) x − y = 5\n(ii) \\(x^2\\) - 6yx + \\(9y^2\\) − 9 = 0\nTentukan himpunan penyelesaian dari persamaan-persamaan di atas ...");
                        jsonObject11.put("semester", "1");
                        jsonObject11.put("bab", "3");
                        jsonObject11.put("jawab_a", "{(9, 4), (5, 1)}");
                        jsonObject11.put("jawab_b", "{(6, 1), (9, 4)}");
                        jsonObject11.put("jawab_c", "{(6, 9), (1, 4)}");
                        jsonObject11.put("jawab_d", "{(3,5 ), (4, 2)}");
                        jsonObject11.put("jawab_benar", "{(6, 1), (9, 4)}");

                        JSONObject jsonObject12 = new JSONObject();
                        jsonObject12.put("no_soal", "bab3soal2");
                        jsonObject12.put("soal", "Tentukan penyelesaian dari SPLDV berikut dengan metode eliminasi:\n2x – y = 7\nx + 2y = 1\n" +
                                "Maka nilai x dan y berturut-turut adalah ...");
                        jsonObject12.put("semester", "1");
                        jsonObject12.put("bab", "3");
                        jsonObject12.put("jawab_a", "(3, 4)");
                        jsonObject12.put("jawab_b", "(4, 5)");
                        jsonObject12.put("jawab_c", "(3, -1)");
                        jsonObject12.put("jawab_d", "(6, 8)");
                        jsonObject12.put("jawab_benar", "(3, -1)");

                        JSONObject jsonObject13 = new JSONObject();
                        jsonObject13.put("no_soal", "bab3soal3");
                        jsonObject13.put("soal", "Tentukan penyelesaian dari SPLDV berikut ini dengan metode substitusi:\nx + y = 8\n2x + 3y = 19\nMaka nilai x dan y berturut-turut adalah ...");
                        jsonObject13.put("semester", "1");
                        jsonObject13.put("bab", "3");
                        jsonObject13.put("jawab_a", "(5, 3)");
                        jsonObject13.put("jawab_b", "(-3, -5)");
                        jsonObject13.put("jawab_c", "(4, -2)");
                        jsonObject13.put("jawab_d", "(11, 7)");
                        jsonObject13.put("jawab_benar", "(5, 3)");

                        JSONObject jsonObject14 = new JSONObject();
                        jsonObject14.put("no_soal", "bab3soal4");
                        jsonObject14.put("soal", "Tentukan penyelesaian dari SPLDV berikut dengan metode campuran:\nx + y = -5\nx – 2y = 5\nMaka nilai x dan y berturut-turut adalah ...");
                        jsonObject14.put("semester", "1");
                        jsonObject14.put("bab", "3");
                        jsonObject14.put("jawab_a", "(5, 3)");
                        jsonObject14.put("jawab_b", "(-2, 4)");
                        jsonObject14.put("jawab_c", "(-2, 3)");
                        jsonObject14.put("jawab_d", "(1, 7)");
                        jsonObject14.put("jawab_benar", "(-2, 3)");

                        JSONObject jsonObject15 = new JSONObject();
                        jsonObject15.put("no_soal", "bab3soal5");
                        jsonObject15.put("soal", "Umur Melly 7 tahun lebih muda dari umur Ayu. Jumlah umur mereka adalah 43 tahun. Umur Ayu adalah ...");
                        jsonObject15.put("semester", "1");
                        jsonObject15.put("bab", "3");
                        jsonObject15.put("jawab_a", "25 Tahun");
                        jsonObject15.put("jawab_b", "18 Tahun");
                        jsonObject15.put("jawab_c", "19 Tahun");
                        jsonObject15.put("jawab_d", "22 Tahun");
                        jsonObject15.put("jawab_benar", "25 Tahun");

                        JSONObject jsonObject16 = new JSONObject();
                        jsonObject16.put("no_soal", "bab3soal6");
                        jsonObject16.put("soal", "Sebuah taman memiliki ukuran panjang 8 meter lebih panjang dari lebarnya. Keliling taman tersebut adalah 44 m. Luas taman tersebut adalah ...");
                        jsonObject16.put("semester", "1");
                        jsonObject16.put("bab", "3");
                        jsonObject16.put("jawab_a", "112 \\(m^2\\)");
                        jsonObject16.put("jawab_b", "198 \\(m^2\\)");
                        jsonObject16.put("jawab_c", "123 \\(m^2\\)");
                        jsonObject16.put("jawab_d", "105 \\(m^2\\)");
                        jsonObject16.put("jawab_benar", "105 \\(m^2\\)");

                        JSONObject jsonObject17 = new JSONObject();
                        jsonObject17.put("no_soal", "bab3soal7");
                        jsonObject17.put("soal", "Di dalam kandang terdapat kambing dan ayam sebanyak 13 ekor. Jika jumlah kaki hewan tersebut 32 2kor, maka jumlah kambing dan ayam masing-masing adalah ...");
                        jsonObject17.put("semester", "1");
                        jsonObject17.put("bab", "3");
                        jsonObject17.put("jawab_a", "3 dan 10");
                        jsonObject17.put("jawab_b", "4 dan 9");
                        jsonObject17.put("jawab_c", "5 dan 8");
                        jsonObject17.put("jawab_d", "10 dan 3");
                        jsonObject17.put("jawab_benar", "3 dan 10");

                        JSONObject jsonObject18 = new JSONObject();
                        jsonObject18.put("no_soal", "bab3soal8");
                        jsonObject18.put("soal", "Harga 7 kg gula dan 2 kg telur Rp105.000,00. Sedangkan harga 5 kg gula dan 2 kg telur Rp83.000,00. Harga 3 kg telur dan 1 kg gula adalah ...");
                        jsonObject18.put("semester", "1");
                        jsonObject18.put("bab", "3");
                        jsonObject18.put("jawab_a", "Rp39.000,00");
                        jsonObject18.put("jawab_b", "Rp53.000,00");
                        jsonObject18.put("jawab_c", "Rp55.000,00");
                        jsonObject18.put("jawab_d", "Rp55.000,00");
                        jsonObject18.put("jawab_benar", "Rp53.000,00");

                        JSONObject jsonObject19 = new JSONObject();
                        jsonObject19.put("no_soal", "bab3soal9");
                        jsonObject19.put("soal", "Seorang tukang parkir mendapat uang sebesar Rp17.000,00 dari 3 buah mobil dan 5 buah motor, sedangkan dari 4 buah mobil dan 2 buah motor ia mendapat uang Rp18.000,00. Jika terdapat 20 mobil dan 30 motor, banyak uang parkir yang diperoleh adalah ...");
                        jsonObject19.put("semester", "1");
                        jsonObject19.put("bab", "3");
                        jsonObject19.put("jawab_a", "Rp135.000,00");
                        jsonObject19.put("jawab_b", "Rp115.000,00");
                        jsonObject19.put("jawab_c", "Rp110.000,00");
                        jsonObject19.put("jawab_d", "Rp100.000,00");
                        jsonObject19.put("jawab_benar", "Rp110.000,00");

                        JSONObject jsonObject20 = new JSONObject();
                        jsonObject20.put("no_soal", "bab3soal10");
                        jsonObject20.put("soal", "Nunik membeli 1 kg daging sapi dan 2 kg ayam potong dengan harga Rp94.000,00. Nanik membeli 3 kg ayam potong dan 2 kg daging sapi dengan harga Rp167.000,00. Jika harga 1 kg daging sapi dinyatakan dengan x dan 1 kg ayam dinyatakan dengan y, sistem persamaan linear dua variabel yang berkaitan dengan pernyataan di atas adalah ...");
                        jsonObject20.put("semester", "1");
                        jsonObject20.put("bab", "3");
                        jsonObject20.put("jawab_a", "x + 2y = 94.000 dan 3x + 2y = 167.000");
                        jsonObject20.put("jawab_b", "x + 2y = 94.000 dan 2x + 3y = 167.000");
                        jsonObject20.put("jawab_c", "2x + y = 94.000 dan 3x + 2y = 167.000");
                        jsonObject20.put("jawab_d", "2x + y = 94.000 dan 2x + 3y = 167.000");
                        jsonObject20.put("jawab_benar", "x + 2y = 94.000 dan 2x + 3y = 167.000");

//  ========================================= Soal Bab 4
                        JSONObject jsonObject21 = new JSONObject();
                        jsonObject21.put("no_soal", "bab4soal1");
                        jsonObject21.put("soal", "Untuk membuat 1 liter minuman jenis A diperlukan 2 kaleng soda dan 1 kaleng susu, sedangkan untuk membuat 1 liter minuman jenis B diperlukan 2 kaleng soda dan 3 kaleng susu. Tersedia 40 kaleng soda dan 30 kaleng susu. Jika 1 liter minuman jenis A dijual seharga Rp30.000,00 dan satu liter minuman jenis B dijual seharga Rp50.000,00, pendapatan maksimum dari hasil penjualan kedua jenis minuman tersebut adalah ...");
                        jsonObject21.put("semester", "1");
                        jsonObject21.put("bab", "4");
                        jsonObject21.put("jawab_a", "Rp500.000,00");
                        jsonObject21.put("jawab_b", "Rp540.000,00");
                        jsonObject21.put("jawab_c", "Rp600.000,00");
                        jsonObject21.put("jawab_d", "Rp700.000,00");
                        jsonObject21.put("jawab_benar", "Rp700.000,00");

                        JSONObject jsonObject22 = new JSONObject();
                        jsonObject22.put("no_soal", "bab4soal2");
                        jsonObject22.put("soal", "Seorang pedagang menjual buah mangga dan pisang dengan menggunakan gerobak. Pedagang tersebut membeli mangga dengan harga Rp. 8.000,00/kg dan pisang Rp. 6.000,00/kg. Modal yang tersedia Rp. 1200.000,00 dan gerobaknya hanya dapat memuat mangga dan pisang sebanyak 180 kg. Jika harga jual mangga Rp.9200,00/kg dan pisang Rp.7000,00/kg, maka laba maksimum yang diperoleh adalah ...");
                        jsonObject22.put("semester", "1");
                        jsonObject22.put("bab", "4");
                        jsonObject22.put("jawab_a", "Rp.150.000,00");
                        jsonObject22.put("jawab_b", "Rp.192.000,00");
                        jsonObject22.put("jawab_c", "Rp.204.000,00");
                        jsonObject22.put("jawab_d", "Rp.216.000,00");
                        jsonObject22.put("jawab_benar", "Rp.192.000,00");

                        JSONObject jsonObject23 = new JSONObject();
                        jsonObject23.put("no_soal", "bab4soal3");
                        jsonObject23.put("soal", "Nilai maksimum f(x, y) = 5x + 4y yang memenuhi pertidaksamaan x + y &le; 8, x + 2y &le; 12, x &ge; 0, dan y &ge; 0 adalah ...");
                        jsonObject23.put("semester", "1");
                        jsonObject23.put("bab", "4");
                        jsonObject23.put("jawab_a", "24");
                        jsonObject23.put("jawab_b", "32");
                        jsonObject23.put("jawab_c", "36");
                        jsonObject23.put("jawab_d", "40");
                        jsonObject23.put("jawab_benar", "40");

                        // ======================== Butuh Gambar
                        JSONObject jsonObject24 = new JSONObject();
                        jsonObject24.put("no_soal", "bab4soal4");
                        jsonObject24.put("soal", "Daerah yang merupakan himpunan penyelesaian dari pertidaksamaan 2x + 3y &le; 12, 4x + y &ge; 10, x &ge; 0,y &ge; 0 adalah ...");
                        jsonObject24.put("semester", "1");
                        jsonObject24.put("bab", "4");
                        jsonObject24.put("jawab_a", "II");
                        jsonObject24.put("jawab_b", "III");
                        jsonObject24.put("jawab_c", "IV");
                        jsonObject24.put("jawab_d", "I &amp; III");
                        jsonObject24.put("jawab_benar", "III");
                        // ========================================

                        // ======================== Butuh Gambar
                        JSONObject jsonObject25 = new JSONObject();
                        jsonObject25.put("no_soal", "bab4soal5");
                        jsonObject25.put("soal", "Nilai minimum fungsi obyektif  f(x, y) = 3x + 2y dari daerah yang diarsir pada gambar adalah ...");
                        jsonObject25.put("semester", "1");
                        jsonObject25.put("bab", "4");
                        jsonObject25.put("jawab_a", "4");
                        jsonObject25.put("jawab_b", "5");
                        jsonObject25.put("jawab_c", "7");
                        jsonObject25.put("jawab_d", "12");
                        jsonObject25.put("jawab_benar", "7");
                        // ==========================================

                        JSONObject jsonObject26 = new JSONObject();
                        jsonObject26.put("no_soal", "bab4soal6");
                        jsonObject26.put("soal", "Nilai minimum fungsi obyektif  f(x, y) = 3x + 2y dari daerah yang diarsir pada gambar adalah ...");
                        jsonObject26.put("semester", "1");
                        jsonObject26.put("bab", "4");
                        jsonObject26.put("jawab_a", "8 dan 6");
                        jsonObject26.put("jawab_b", "6 dan 4");
                        jsonObject26.put("jawab_c", "5 dan 9");
                        jsonObject26.put("jawab_d", "4 dan 8");
                        jsonObject26.put("jawab_benar", "4 dan 8");

                        // ======================== Butuh Gambar
                        JSONObject jsonObject27 = new JSONObject();
                        jsonObject27.put("no_soal", "bab4soal7");
                        jsonObject27.put("soal", "Dalam sistem pertidaksamaan: 2y &ge; x : y &le; 2x; 2y + x &le; 20; x + y &ge; 9. Nilai maksimum untuk 3y – x dicapai di titik ...");
                        jsonObject27.put("semester", "1");
                        jsonObject27.put("bab", "4");
                        jsonObject27.put("jawab_a", "S");
                        jsonObject27.put("jawab_b", "R");
                        jsonObject27.put("jawab_c", "Q");
                        jsonObject27.put("jawab_d", "P");
                        jsonObject27.put("jawab_benar", "R");
                        // ========================================

                        JSONObject jsonObject28 = new JSONObject();
                        jsonObject28.put("no_soal", "bab4soal8");
                        jsonObject28.put("soal", "Disebuah kantin, Ani dan kawan-kawan membayar tidak lebih dari Rp35.000,- untuk 4 mangkok bakso dan 6 gelas es yang dipesannya, sedang Adi dan kawan-kawan membayar tidak lebih dari Rp50.000,- untuk 8 mangkok bakso dan 4 gelas es. Jika kita memesan 5 mangkok bakso dan 3 gelas es maka maksimum yang harus kita bayar ...");
                        jsonObject28.put("semester", "1");
                        jsonObject28.put("bab", "4");
                        jsonObject28.put("jawab_a", "Rp32.500,-");
                        jsonObject28.put("jawab_b", "Rp35.000,-");
                        jsonObject28.put("jawab_c", "Rp40.500,-");
                        jsonObject28.put("jawab_d", "Rp42.000,-");
                        jsonObject28.put("jawab_benar", "Rp32.500,-");

                        // ======================== Butuh Gambar
                        JSONObject jsonObject29 = new JSONObject();
                        jsonObject29.put("no_soal", "bab4soal9");
                        jsonObject29.put("soal", "Daerah yang diarsir pada gambar merupakan himpunan penyelesaian suatu sistem pertidaksamaan linear. Nilai maksimum dari f(x, y) = 7x + 6y adalah ...");
                        jsonObject29.put("semester", "1");
                        jsonObject29.put("bab", "4");
                        jsonObject29.put("jawab_a", "102");
                        jsonObject29.put("jawab_b", "88");
                        jsonObject29.put("jawab_c", "94");
                        jsonObject29.put("jawab_d", "196");
                        jsonObject29.put("jawab_benar", "102");
                        // =========================================

                        JSONObject jsonObject30 = new JSONObject();
                        jsonObject30.put("no_soal", "bab4soal10");
                        jsonObject30.put("soal", "Nilai minimum dari z = 2x + 3y dengan syarat x + y &ge; 4, 5y – x &le; 20, y &ge; x, y &ge; 0, x &ge; 0 adalah ...");
                        jsonObject30.put("semester", "1");
                        jsonObject30.put("bab", "4");
                        jsonObject30.put("jawab_a", "5");
                        jsonObject30.put("jawab_b", "10");
                        jsonObject30.put("jawab_c", "0");
                        jsonObject30.put("jawab_d", "1");
                        jsonObject30.put("jawab_benar", "10");

                        DB = new DB(SplashScreen.this);
                        // BAB 1
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
                        // BAB 2
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
                        // BAB 3
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
                        // BAB 4
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


                        startActivity(new Intent(SplashScreen.this, MenuUtama.class));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, 2000);
    }
}
