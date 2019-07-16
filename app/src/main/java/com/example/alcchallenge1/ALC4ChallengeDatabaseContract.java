package com.example.alcchallenge1;

import android.provider.BaseColumns;

public class ALC4ChallengeDatabaseContract {

    private ALC4ChallengeDatabaseContract() {
    }

    public static final class ProfileInfoEntry implements BaseColumns {
        public static final String TABLE_NAME = "profile_info";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_TRACK = "track";
        public static final String COLUMN_COUNTRY = "country";
        public static final String COLUMN_EMAIL = "email";
        public static final String COLUMN_PHONE = "phone";

//CREATE INDEX

        // CREATE TABLE profile_info
        public static final String SQL_CREATE_TABLE =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        _ID + " INTEGER PRIMARY KEY, " +
                        COLUMN_NAME + " TEXT NOT NULL, " +
                        COLUMN_TRACK + " TEXT NOT NULL, " +
                        COLUMN_COUNTRY + " TEXT NOT NULL, " +
                        COLUMN_EMAIL + " TEXT NOT NULL, " +
                        COLUMN_PHONE + " TEXT NOT NULL)";

//        public static final String SQL_CREATE_TABLE = "CREATE TABLE (_ID INTEGER PRIMARY KEY, profile_image BLOB NOT NULL, name TEXT NOT NULL, " +
//                "track TEXT NOT NULL, country TEXT NOT NULL, email TEXT NOT NULL, phone TEXT NOT NULL)";

    }

}
