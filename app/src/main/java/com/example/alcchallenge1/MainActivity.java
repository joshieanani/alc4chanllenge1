package com.example.alcchallenge1;



import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;



public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void goToAbout(View view) {
        Intent intent = new Intent(this, AboutALC.class);
        this.startActivity(intent);
    }

    public void goToProfile(View view) {
        Intent intent = new Intent(this, Profile.class);
        this.startActivity(intent);
    }


}
