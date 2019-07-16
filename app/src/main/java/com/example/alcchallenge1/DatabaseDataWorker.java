package com.example.alcchallenge1;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.example.alcchallenge1.ALC4ChallengeDatabaseContract.ProfileInfoEntry;

public class DatabaseDataWorker {

    private SQLiteDatabase mDb;


    public DatabaseDataWorker(SQLiteDatabase db) {
        mDb = db;
    }


    public void insertProfiles() {


        insertProfile("Joshua Anani", "Android", "Ghana", "joshuaanani8@gmail.com", "0246036105");

    }


    private void insertProfile(String name, String track, String country, String email, String phoneNumber) {

       ContentValues values = new ContentValues();

        values.put(ProfileInfoEntry.COLUMN_NAME, name);
        values.put(ProfileInfoEntry.COLUMN_TRACK, track);
        values.put(ProfileInfoEntry.COLUMN_COUNTRY, country);
        values.put(ProfileInfoEntry.COLUMN_EMAIL, email);
        values.put(ProfileInfoEntry.COLUMN_PHONE, phoneNumber);

        long newRowId = mDb.insert(ProfileInfoEntry.TABLE_NAME, null, values);

    }


}
