package com.pouya11.phonebook;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.pouya11.phonebook.models.PhoneRecord;

/**
 * Created by Mohammad on 08/12/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, "phonebook_db", null, DatabaseHelper.VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE %s(" +
                "%s INT PRIMARY KEY AUTOINCREMENT," +
                "%s VARCHAR(255) NOT NULL," +
                "%s VARCHAR(255) NULL," +
                "%s VARCHAR(255) NULL," +
                "%s VARCHAR(255) NULL" +
                ")";
        sql = String.format(sql, PhoneRecord.TABLE,
                PhoneRecord.ID,
                PhoneRecord.NAME,
                PhoneRecord.FAMILY,
                PhoneRecord.PHONE,
                PhoneRecord.EMAIL);

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
