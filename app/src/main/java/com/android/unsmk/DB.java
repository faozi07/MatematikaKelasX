package com.android.unsmk;

/*
 * Created by faozi on 14/03/18.
 */

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.Html;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import io.github.kexanie.library.MathView;

public class DB extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "user.db";
    private static final int DATABASE_VERSION = 1;

    // ================================================ USER ======================================
    private static final String TABLE_NAME_USER = "karyawanUser";
    private static final String NO_TELP = "NO_TELP";
    private static final String NIK = "NIK";
    private static final String NAMA_KARYAWAN = "NAMA_KARYAWAN";
    private static final String ALAMAT = "ALAMAT";
    private static final String PASSWORD = "PASSWORD";

    // ================================================ INVENTORY ======================================
    private static final String TABLE_NAME_INVENTORY = "inventory";
    private static final String KODE_BRG_MSK = "KODE_BRG_MSK";
    private static final String TGL_BRG_MSK = "TGL_BRG_MSK";
    private static final String SUPPLIER = "SUPPLIER";
    private static final String KODE_BARANG = "KODE_BARANG";
    private static final String NAMA_BARANG = "NAMA_BARANG";
    private static final String JENIS = "JENIS";
    private static final String HARGA_SATUAN = "HARGA_SATUAN";
    private static final String JUMLAH = "JUMLAH";
    private static final String TOTAL = "TOTAL";

    // ================================================ INVENTORY ======================================
    private static final String TABLE_NAME_PENJUALAN = "penjualan";
    private static final String NO_PENJUALAN = "NO_PENJUALAN";
    private static final String TGL_PENJUALAN = "TGL_PENJUALAN";
    private static final String NAMA_KONSUMEN = "NAMA_KONSUMEN";
    private static final String NO_TELP_KONSUMEN = "NO_TELP_KONSUMEN";
    private static final String ALAMAT_KONSUMEN = "ALAMAT_KONSUMEN";
    private static final String HARGA_JUAL = "HARGA_JUAL";


    // ================================================ SOAL ======================================
    private static final String TABLE_SOAL = "TABLE_SOAL";
    private static final String NO_SOAL = "NO_SOAL";
    private static final String SOAL = "SOAL";
    private static final String SEMESTER = "SEMESTER";
    private static final String BAB = "BAB";
    private static final String JAWAB_A = "JAWAB_A";
    private static final String JAWAB_B = "JAWAB_B";
    private static final String JAWAB_C = "JAWAB_C";
    private static final String JAWAB_D = "JAWAB_D";
    private static final String JAWAB_BENAR = "JAWAB_BENAR";

    public DB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_SOAL + " (" +
                    NO_SOAL + " TEXT null, " +
                    SOAL + " TEXT null, " +
                    SEMESTER + " TEXT null, " +
                    BAB + " TEXT null, " +
                    JAWAB_A + " TEXT null, " +
                    JAWAB_B + " TEXT null, " +
                    JAWAB_C + " TEXT null, " +
                    JAWAB_D + " TEXT null, " +
                    JAWAB_BENAR + " TEXT null);";
            Log.d("DataUser ", "onCreate: " + sql);
            db.execSQL(sql);
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_USER);
        onCreate(db);
    }

    public void dropTable() {
        try {
            SQLiteDatabase database = getWritableDatabase();
            String updateQuery = "DROP TABLE IF EXISTS " + TABLE_NAME_USER;
            database.execSQL(updateQuery);
            database.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertSoal(final JSONObject objectSoal) {
        try {
            String noSoal = objectSoal.getString("no_soal");
            String soal = objectSoal.getString("soal");
            String semester = objectSoal.getString("semester");
            String bab = objectSoal.getString("bab");
            String jawabA = objectSoal.getString("jawab_a");
            String jawabB = objectSoal.getString("jawab_b");
            String jawabC = objectSoal.getString("jawab_c");
            String jawabD = objectSoal.getString("jawab_d");
            String jawabBenar = objectSoal.getString("jawab_benar");
            SQLiteDatabase db = getWritableDatabase();
            String sql = "INSERT INTO " + TABLE_SOAL + " (" +
                    NO_SOAL + ", " +
                    SOAL + ", "+
                    SEMESTER + ", "+
                    BAB + ", "+
                    JAWAB_A + ", "+
                    JAWAB_B + ", "+
                    JAWAB_C + ", "+
                    JAWAB_D + ", "+
                    JAWAB_BENAR+") VALUES ('" +
                    noSoal + "','" +
                    soal + "','" +
                    semester + "','" +
                    bab + "','" +
                    jawabA + "','" +
                    jawabB + "','" +
                    jawabC + "','" +
                    jawabD + "','" +
                    jawabBenar + "');";
            db.execSQL(sql);
            Soal.registerSukses = true;
        } catch (JSONException exp) {
            exp.printStackTrace();
            Soal.registerSukses = false;
        } catch (Exception exp) {
            exp.printStackTrace();
            Soal.registerSukses = false;
        }
    }

    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    public void loadSoal() {
        SQLiteDatabase db = getWritableDatabase();
        @SuppressLint("Recycle")
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_SOAL + "", null);
        if (cursor.moveToFirst()) {
            do {
                Log.i("0111",cursor.getString(0)); // no soal
                Log.i("0111",cursor.getString(1)); // soal
                Log.i("0111",cursor.getString(2)); // semester
                Log.i("0111",cursor.getString(3)); // bab
                Log.i("0111",cursor.getString(4)); // jawab a
                Log.i("0111",cursor.getString(5)); // jawab b
                Log.i("0111",cursor.getString(6)); // jawab c
                Log.i("0111",cursor.getString(7)); // jawab d
                Log.i("0111",cursor.getString(8)); // jawab benar
            } while (cursor.moveToNext());
        }
        db.close();
    }

    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    public void loadSoalByNoSoal(String noSoal) {
        SQLiteDatabase db = getWritableDatabase();
        @SuppressLint("Recycle")
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_SOAL + " WHERE "+ NO_SOAL +"='"+ noSoal +"';", null);
        if (cursor.moveToFirst()) {
            do {
                Soal.soal = cursor.getString(1);
                Soal.jawabA = cursor.getString(4);
                Soal.jawabB = cursor.getString(5);
                Soal.jawabC = cursor.getString(6);
                Soal.jawabD = cursor.getString(7);
                Soal.jawabanBenar = cursor.getString(8);
                Soal.setTextSoal(cursor.getString(1), cursor.getString(4), cursor.getString(5),
                        cursor.getString(6), cursor.getString(7));
                Log.i("0111",cursor.getString(0)); // no soal
                Log.i("0111",cursor.getString(1)); // soal
                Log.i("0111",cursor.getString(2)); // semester
                Log.i("0111",cursor.getString(3)); // bab
                Log.i("0111",cursor.getString(4)); // jawab a
                Log.i("0111",cursor.getString(5)); // jawab b
                Log.i("0111",cursor.getString(6)); // jawab c
                Log.i("0111",cursor.getString(7)); // jawab d
                Log.i("0111",cursor.getString(8)); // jawab benar
            } while (cursor.moveToNext());
        }
        db.close();
    }

    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    public void cekUserAll() {
        SQLiteDatabase db = getWritableDatabase();
        @SuppressLint("Recycle")
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME_USER + "", null);
        if (cursor.moveToFirst()) {
            do {
                Log.i("01",cursor.getString(0));
                Log.i("01",cursor.getString(1));
                Log.i("01",cursor.getString(2));
                Log.i("01",cursor.getString(3));
                Log.i("01",cursor.getString(4));
            } while (cursor.moveToNext());
        }
        db.close();
    }

    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    public void login(String nik, String password) {
        SQLiteDatabase db = getWritableDatabase();
        @SuppressLint("Recycle")
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME_USER +
                " WHERE " + NIK + "='" + nik + "' AND "+PASSWORD+" = '"+password+"'", null);
        if (cursor.moveToFirst()) {
            do {
                StaticVars.isTerdaftar = cursor.getString(0) != null && nik.equals(cursor.getString(0));
                StaticVars.nik = cursor.getString(0);
                StaticVars.nama = cursor.getString(2);
            } while (cursor.moveToNext());
        }
        db.close();
    }

    // ============================================== Barang Masuk ==============================================
    public void insertBrgMasuk(String kodeBrgMsk, String tglBrgMsk, String supplier, String kodeBrg, String namaBrg, String jenis, String hrgSatuan,
                               String jml, String total) {
        try {
            SQLiteDatabase db = getWritableDatabase();
            String sql = "INSERT INTO " + TABLE_NAME_INVENTORY + " (" +
                    KODE_BRG_MSK + "," +
                    TGL_BRG_MSK + ", "+
                    SUPPLIER + ", "+
                    KODE_BARANG + ", "+
                    NAMA_BARANG + ", "+
                    JENIS + ", "+
                    HARGA_SATUAN + ", "+
                    JUMLAH + ", "+
                    TOTAL +") VALUES ('" +
                    kodeBrgMsk + "', '" +
                    tglBrgMsk + "', '" +
                    supplier + "', '" +
                    kodeBrg + "', '" +
                    namaBrg + "', '" +
                    jenis + "', '" +
                    hrgSatuan + "', '" +
                    jml + "', '" +
                    total + "');";
            db.execSQL(sql);
            InputBrgMasuk.berhasilAdd = true;
        } catch (Exception exp) {
            exp.printStackTrace();
            InputBrgMasuk.berhasilAdd = false;
        }
    }

}

