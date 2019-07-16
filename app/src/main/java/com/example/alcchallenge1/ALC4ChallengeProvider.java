package com.example.alcchallenge1;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import static com.example.alcchallenge1.ALC4ChallengeDatabaseContract.*;
import static com.example.alcchallenge1.ALC4ChallengeProviderContract.*;
import static com.example.alcchallenge1.ALC4ChallengeProviderContract.Profile.*;

public class ALC4ChallengeProvider extends ContentProvider {

    private ALC4ChallengeOpenHelper mDbOpenHelper;
    private static UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);


    public static final int PROFILE = 0;

    static {

        sUriMatcher.addURI(AUTHORITY, PATH, PROFILE);
    }

    public ALC4ChallengeProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        // TODO: Implement this to handle requests to insert a new row.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public boolean onCreate() {
        mDbOpenHelper = new ALC4ChallengeOpenHelper(getContext());
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
//        long rowId = -1;
//        String rowSelection = null;
//        String[] rowSelectionArgs = null;
        Cursor cursor = null;
        SQLiteDatabase db = mDbOpenHelper.getReadableDatabase();

        int uriMatch = sUriMatcher.match(uri);

        switch (uriMatch) {
            case PROFILE:
                cursor = db.query(ProfileInfoEntry.TABLE_NAME, projection,selection, selectionArgs, null, null, sortOrder);
                break;
        }
        return cursor;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
