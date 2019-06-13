package com.example.prototype;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    Button button;
    ImageView imageView;
    private static final int PICK_IMAGE = 100;
    Uri imageURI;

    TextView textView;
    TextView textView2;
    AlertDialog dialog;
    AlertDialog dialog2;
    EditText editText;
    EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        textView = (TextView)findViewById(R.id.text_Bio_Text);
        dialog = new AlertDialog.Builder(this).create();
        editText = new EditText(this);

        dialog.setTitle("Edit bio");
        dialog.setView(editText);

        dialog.setButton(DialogInterface.BUTTON_POSITIVE, "Save Changes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                textView.setText(editText.getText());

            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(textView.getText());
                dialog.show();

            }
        });

        textView2 = (TextView)findViewById(R.id.tx_JohnDoe);
        dialog2 = new AlertDialog.Builder(this).create();
        editText2 = new EditText(this);

        dialog2.setTitle("Change name");
        dialog2.setView(editText2);

        dialog2.setButton(DialogInterface.BUTTON_POSITIVE, "Save Changes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                textView2.setText(editText2.getText());

            }
        });


        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText2.setText(textView2.getText());
                dialog2.show();

            }

        });


        imageView = (ImageView)findViewById(R.id.image_Avatar);
        button = (Button)findViewById(R.id.btn_ChangePic);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();

            }
        });

        ImageButton btn = (ImageButton)findViewById(R.id.imageButton2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, GalleryActivity.class);
                startActivity(intent);
            }
        });

        ImageButton button = (ImageButton)findViewById(R.id.imageButton5);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });

    }

    private void openGallery(){
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);

    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && requestCode == PICK_IMAGE){
            imageURI = data.getData();
            imageView.setImageURI(imageURI);


        }
    }

    public void goToMap (View view){
        Intent intent = new Intent (this, MapActivity.class);
        startActivity(intent);
    }

    public void goToMemories (View view){
        Intent intent = new Intent (this, MemoriesActivity.class);
        startActivity(intent);
    }
}
