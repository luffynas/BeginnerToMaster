package com.technosantra.seminarandroid;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by M. Nashrulloh on 05/04/19.
 * at PT. Ansvia
 * contact us blankcd3@gmail.com or mohammad.nashrulloh@ansvia.com
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    // Logcat tag
    private static final String LOG = "DatabaseHelper";

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "seminar";

    // Table Names
    private static final String TABLE_MHS = "mahasiswa";

    // Common column names
    private static final String KEY_ID = "id";
    private static final String KEY_NIM = "KEY_NIM";
    private static final String KEY_NAMA = "KEY_NAMA";
    private static final String KEY_CREATED_AT = "created_at";

    // Table Create Statements
    // Todo table create statement
    private static final String CREATE_TABLE_MHS = "CREATE TABLE "
            + TABLE_MHS + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NIM
            + " TEXT," + KEY_NAMA + " TEXT," + KEY_CREATED_AT
            + " DATETIME" + ")";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // creating required tables
        db.execSQL(CREATE_TABLE_MHS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MHS);
        onCreate(db);
    }




    // Provider ORM

    public long createMahasiswa(Mahasiswa mhs) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NIM, mhs.getNim());
        values.put(KEY_NAMA, mhs.getNama());
        values.put(KEY_CREATED_AT, getDateTime());

        // insert row
        long todo_id = db.insert(TABLE_MHS, null, values);

        return todo_id;
    }


    /*
     * Mendapatkan Data mahasiswa
     */
    public Mahasiswa getMahasiswa(long todo_id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + TABLE_MHS + " WHERE "
                + KEY_ID + " = " + todo_id;

        Log.e(LOG, selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null)
            c.moveToFirst();

        Mahasiswa td = new Mahasiswa();
        td.setId(c.getInt(c.getColumnIndex(KEY_ID)));
        td.setNim((c.getString(c.getColumnIndex(KEY_NIM))));
        td.setNama((c.getString(c.getColumnIndex(KEY_NAMA))));
        td.setDateTime(c.getString(c.getColumnIndex(KEY_CREATED_AT)));

        return td;
    }

    /*
     * Mendapatkan Semua Data Mahasiswa
     * */
    public List<Mahasiswa> getAllMahasiswa() {
        List<Mahasiswa> mahasiswas = new ArrayList<Mahasiswa>();
        String selectQuery = "SELECT  * FROM " + TABLE_MHS;

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Mahasiswa td = new Mahasiswa();
                td.setId(c.getInt((c.getColumnIndex(KEY_ID))));
                td.setNim((c.getString(c.getColumnIndex(KEY_NIM))));
                td.setNama((c.getString(c.getColumnIndex(KEY_NAMA))));
                td.setDateTime(c.getString(c.getColumnIndex(KEY_CREATED_AT)));

                // adding to todo list
                mahasiswas.add(td);
            } while (c.moveToNext());
        }

        return mahasiswas;
    }

    public int updateMahasiswa(Mahasiswa mhs) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NIM, mhs.getNim());
        values.put(KEY_NAMA, mhs.getNama());

        // updating row
        return db.update(TABLE_MHS, values, KEY_ID + " = ?",
                new String[] { String.valueOf(mhs.getId()) });
    }

    /*
     * Deleting a mahasiswa
     */
    public void deleteMahasiswa(long mhs_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_MHS, KEY_ID + " = ?",
                new String[] { String.valueOf(mhs_id) });
    }

    private String getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }
}