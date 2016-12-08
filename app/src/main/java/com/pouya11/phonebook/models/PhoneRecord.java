package com.pouya11.phonebook.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.pouya11.phonebook.DatabaseHelper;

import java.util.ArrayList;

/**
 * this is a model class will contain phone records
 * Created by Mohammad on 01/12/2016.
 */
public class PhoneRecord {
    private long id;
    private String name;
    private String family;
    private String phone;
    private String email;

    public PhoneRecord(){ // default constructor

    }
    public PhoneRecord(String name, String family, String phone, String email){
        this.setName(name);
        this.setFamily(family);
        this.setPhone(phone);
        this.setEmail(email);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean save(Context context){
        DatabaseHelper dbh = new DatabaseHelper(context);

        SQLiteDatabase db = dbh.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(PhoneRecord.NAME, this.getName());
        contentValues.put(PhoneRecord.FAMILY, this.getFamily());
        contentValues.put(PhoneRecord.PHONE, this.getPhone());
        contentValues.put(PhoneRecord.EMAIL, this.getEmail());

        this.setId(db.insert(PhoneRecord.TABLE,null, contentValues));

        return this.getId() > 0;
    }

    public static ArrayList<PhoneRecord> select(Context context, String selection, String orderBy, String limit){
        DatabaseHelper dbh = new DatabaseHelper(context);

        SQLiteDatabase db = dbh.getWritableDatabase();

        Cursor cursor = db.query(PhoneRecord.TABLE,null,selection, null, null, null, orderBy, limit);

        ArrayList<PhoneRecord> result = new ArrayList<>();

        if(cursor.moveToFirst()) {
            do {
                PhoneRecord phoneRecord = new PhoneRecord();
                phoneRecord.setId( cursor.getLong( cursor.getColumnIndex(PhoneRecord.ID) ) );
                phoneRecord.setName( cursor.getString( cursor.getColumnIndex(PhoneRecord.NAME) ) );
                phoneRecord.setFamily( cursor.getString( cursor.getColumnIndex(PhoneRecord.FAMILY) ) );
                phoneRecord.setPhone( cursor.getString( cursor.getColumnIndex(PhoneRecord.PHONE) ) );
                phoneRecord.setEmail( cursor.getString( cursor.getColumnIndex(PhoneRecord.EMAIL) ) );

                result.add(phoneRecord);
            } while (cursor.moveToNext());
        }

        cursor.close();

        return result;
    }

    public static final String TABLE = "phonebook";

    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String FAMILY = "family";
    public static final String PHONE = "phone";
    public static final String EMAIL = "email";
}
