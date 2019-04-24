package com.example.prototype;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ProfileActivity extends AppCompatActivity {
    public static final int PICK_IMAGE = 100;

    ImageView one;
    ImageView two;
    Uri imageUri;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        one = (ImageView) findViewById(R.id.image_AddProfilePictureIcon);
        two = (ImageView) findViewById(R.id.image_Avatar);

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });

    }
    public void openGallery(){
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && requestCode == PICK_IMAGE) {
            imageUri = data.getData();
            two.setImageURI(imageUri);
        }}


    public void goToMap (View view){
        Intent intent = new Intent (this, MapActivity.class);
        startActivity(intent);
    }


    public void goToSettings (View view){
        Intent intent = new Intent (this, SettingsActivity.class);
        startActivity(intent);
    }

    public void goToMemories (View view){
        Intent intent = new Intent (this, MemoriesActivity.class);
        startActivity(intent);

    }
}

//