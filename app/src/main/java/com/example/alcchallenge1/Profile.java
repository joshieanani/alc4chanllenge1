package com.example.alcchallenge1;


import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.alcchallenge1.ALC4ChallengeDatabaseContract.*;


public class Profile extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {
    private Cursor mProfileCursor;
    private int mProfileImagePos;
    private int mNamePos;
    private int mTrackPos;
    private int mCountryPos;
    private int mEmailPos;
    private int mPhonePos;
    public static final int LOADER_PROFILE = 0;
    private ImageView mProfileImage;
    private TextView mName;
    private TextView mTrack;
    private TextView mCountry;
    private TextView mEmail;
    private TextView mPhone;
    private ALC4ChallengeOpenHelper mDbOpenHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
//
//        mDbOpenHelper = new ALC4ChallengeOpenHelper(this);
//        SQLiteDatabase db = mDbOpenHelper.getReadableDatabase();


        mProfileImage = findViewById(R.id.profile_image_view);
        mName = findViewById(R.id.name_text_view);
        mTrack = findViewById(R.id.track_text_view);
        mCountry = findViewById(R.id.country_text_view);
        mEmail = findViewById(R.id.email_text_view);
        mPhone = findViewById(R.id.phone_text_view);


        getLoaderManager().initLoader(LOADER_PROFILE, null, this);
    }


    private CursorLoader createLoaderProfile() {
        String profileColumns[] = {

                ALC4ChallengeProviderContract.Profile.COLUMN_NAME,
                ALC4ChallengeProviderContract.Profile.COLUMN_TRACK,
                ALC4ChallengeProviderContract.Profile.COLUMN_COUNTRY,
                ALC4ChallengeProviderContract.Profile.COLUMN_EMAIL,
                ALC4ChallengeProviderContract.Profile.COLUMN_PHONE,
                ALC4ChallengeProviderContract.Profile._ID
        };
        Uri uri = ALC4ChallengeProviderContract.Profile.CONTENT_URI;
//        Uri uri = ContentUris.withAppendedId(ALC4ChallengeProviderContract.Profile.CONTENT_URI, 0);
        return new CursorLoader(this, uri, profileColumns, null, null, null);
    }


    private void loadProfile(Cursor data) {
        mProfileCursor = data;


        mNamePos = mProfileCursor.getColumnIndex(ProfileInfoEntry.COLUMN_NAME);
        mTrackPos = mProfileCursor.getColumnIndex(ProfileInfoEntry.COLUMN_TRACK);
        mCountryPos = mProfileCursor.getColumnIndex(ProfileInfoEntry.COLUMN_COUNTRY);
        mEmailPos = mProfileCursor.getColumnIndex(ProfileInfoEntry.COLUMN_EMAIL);
        mPhonePos = mProfileCursor.getColumnIndex(ProfileInfoEntry.COLUMN_PHONE);

        mProfileCursor.moveToFirst();

        displayProfileDetails();
    }





    private void displayProfileDetails() {


        if (mProfileCursor != null && mProfileCursor.getCount() > 0) {
            String name = mProfileCursor.getString(mNamePos);
            String track = mProfileCursor.getString(mTrackPos);
            String country = mProfileCursor.getString(mCountryPos);
            String email = mProfileCursor.getString(mEmailPos);
            String phone = mProfileCursor.getString(mPhonePos);


            mProfileImage.setImageResource(R.drawable.profile);

            mName.setText(name);
            mTrack.setText(track);
            mCountry.setText(country);
            mEmail.setText(email);
            mPhone.setText(phone);
        }
    }


    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle bundle) {
        CursorLoader loader = null;


        if (id == LOADER_PROFILE) {
            loader = createLoaderProfile();
        }
        return loader;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        if (loader.getId() == LOADER_PROFILE) {
            loadProfile(data);
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        if (loader.getId() == LOADER_PROFILE) {
            mProfileCursor.close();
        }
    }
}
