package com.android.unsmk;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Random;

public class InputBrgMasuk extends AppCompatActivity {

    Calendar myCalendar;
    EditText editKodeBrgMsk, editTglBrgMasuk, editKodeBrg, editNamaBrg, editHrgSatuan, editJml, editTotal;
    Spinner spinSupplier, spinJenisBrg;
    Button btnSimpan;

    String tgl = "";
    public static boolean berhasilAdd = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_brg_masuk);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Barang Masuk");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        initial();
        action();
        myCalendar = Calendar.getInstance();
    }

    private void initial() {
        editKodeBrgMsk = findViewById(R.id.editKodeBrgMasuk);
        editTglBrgMasuk = findViewById(R.id.editTglBrgMasuk);
        editKodeBrg = findViewById(R.id.editKodeBarang);
        editNamaBrg = findViewById(R.id.editNamaBarang);
        editHrgSatuan = findViewById(R.id.editHargaSatuan);
        editJml = findViewById(R.id.editJumlah);
        editTotal = findViewById(R.id.editTotal);
        spinJenisBrg = findViewById(R.id.spinJenisBrg);
        spinSupplier = findViewById(R.id.spinSupplier);
        btnSimpan = findViewById(R.id.btnSimpan);
    }

    private boolean isCompleted () {
        return !editKodeBrgMsk.getText().toString().equals("") && !editTglBrgMasuk.getText().toString().equals("") &&
                !editKodeBrg.getText().toString().equals("") && !editNamaBrg.getText().toString().equals("") &&
                !editHrgSatuan.getText().toString().equals("") && !editJml.getText().toString().equals("") &&
                !editTotal.getText().toString().equals("") && !spinJenisBrg.getSelectedItem().toString().contains("Pilih") &&
                !spinSupplier.getSelectedItem().toString().contains("Pilih");
    }

    private void action() {
        Random numberRandom = new Random();
        editKodeBrgMsk.setText("BM-"+ numberRandom.nextInt());
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {

                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                String myFormat = "dd-MM-yyyy";
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
                tgl = sdf.format(myCalendar.getTime());
                editTglBrgMasuk.setText(tgl);
            }
        };

        editTglBrgMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideKeyboard();
                // TODO Auto-generated method stub
                DatePickerDialog mDate = new DatePickerDialog(InputBrgMasuk.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH));
                mDate.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
                mDate.show();
            }
        });

        editHrgSatuan.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() > 0 && editJml.getText().length() > 0) {
                    int hrgSatuan = Integer.parseInt(s.toString());
                    int jml = Integer.parseInt(editJml.getText().toString());
                    double total = jml*hrgSatuan;
                    Locale localeID = new Locale("in", "ID");
                    NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
                    String totalRupiah = formatRupiah.format(total);
                    editTotal.setText(String.valueOf(totalRupiah));
                }
                else {
                    editTotal.setText("");
                }
            }
        });

        editJml.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() > 0 && editHrgSatuan.getText().length() > 0) {
                    int jumlah = Integer.parseInt(s.toString());
                    int hrgSatuan = Integer.parseInt(editHrgSatuan.getText().toString());
                    double total = jumlah*hrgSatuan;
                    Locale localeID = new Locale("in", "ID");
                    NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
                    String totalRupiah = formatRupiah.format(total);
                    editTotal.setText(String.valueOf(totalRupiah));
                }
                else {
                    editTotal.setText("");
                }
            }
        });

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SoundBtn.soundBtn(InputBrgMasuk.this);
                if (isCompleted()) {
                    final ProgressDialog progressDialog = new ProgressDialog(InputBrgMasuk.this);
                    progressDialog.setMessage("Input Barang Masuk");
                    progressDialog.setCancelable(false);
                    progressDialog.show();
                    Locale localeID = new Locale("in", "ID");
                    NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);

                    int hargaSatuan = Integer.parseInt(editHrgSatuan.getText().toString());

                    DB db = new DB(InputBrgMasuk.this);
                    db.insertBrgMasuk(editKodeBrgMsk.getText().toString(), editTglBrgMasuk.getText().toString(),
                            spinSupplier.getSelectedItem().toString(), editKodeBrg.getText().toString(), editNamaBrg.getText().toString(),
                            spinJenisBrg.getSelectedItem().toString(), formatRupiah.format(hargaSatuan), editJml.getText().toString(),
                            editTotal.getText().toString());
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            progressDialog.dismiss();
                            if (berhasilAdd) {
                                finish();
                                Toast.makeText(InputBrgMasuk.this, "Berhasil input data", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(InputBrgMasuk.this, "Gagal input data, silakan coba kembali", Toast.LENGTH_LONG).show();
                            }
                        }
                    },2000);
                } else {
                    Toast.makeText(InputBrgMasuk.this, "Anda belum melengkapi form", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void hideKeyboard() {
        View view = getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) {
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {
        SoundBtn.soundBtn(InputBrgMasuk.this);
        finish();
    }
}
