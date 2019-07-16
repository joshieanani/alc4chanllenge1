package com.example.alcchallenge1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.example.alcchallenge1.ALC4ChallengeDatabaseContract.*;

public class ALC4ChallengeOpenHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "alc.db";
    public static final int DATABASE_VERSION = 1;



    public ALC4ChallengeOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {



        db.execSQL(ProfileInfoEntry.SQL_CREATE_TABLE);

        DatabaseDataWorker worker = new DatabaseDataWorker(db);
        worker.insertProfiles();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }
}
