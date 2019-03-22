package com.example.prototype;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }

    public void goToMap (View view){
        Intent intent = new Intent (this, MapActivity.class);
        startActivity(intent);
    }

    public void goToGallery (View view){
        Intent intent = new Intent (this, GalleryActivity.class);
        startActivity(intent);
    }

    public void goToSettings (View view){
        Intent intent = new Intent (this, SettingsActivity.class);
        startActivity(intent);
    }
}
