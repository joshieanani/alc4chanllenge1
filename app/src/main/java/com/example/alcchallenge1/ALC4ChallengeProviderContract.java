package com.example.alcchallenge1;

import android.net.Uri;
import android.provider.BaseColumns;

public final class ALC4ChallengeProviderContract {
    private ALC4ChallengeProviderContract(){}

    public static final String AUTHORITY = "com.example.alcchallenge1.provider";
    public static final Uri AUTHORITY_URI = Uri.parse("content://" + AUTHORITY);

    protected interface ProfileColumns{
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_TRACK = "track";
        public static final String COLUMN_COUNTRY = "country";
        public static final String COLUMN_EMAIL = "email";
        public static final String COLUMN_PHONE = "phone";


    }

    public static final class Profile implements BaseColumns, ProfileColumns {
       public static final String PATH = "profile";
       public static final Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, PATH);
    }
}
