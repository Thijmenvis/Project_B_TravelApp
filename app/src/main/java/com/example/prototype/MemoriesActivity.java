package com.example.prototype;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MemoriesActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    Button button;
    Button button2;
    Button button3;
    ImageView imageView;
    ImageView imageView2;
    ImageView imageView3;
    private static final int PICK_IMAGE = 100;
    Uri imageURI;

    TextView textView;
    TextView textView2;
    TextView textView3;
    AlertDialog dialog;
    AlertDialog dialog2;
    AlertDialog dialog3;
    EditText editText;
    EditText editText2;
    EditText editText3;
    int whichPhoto;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_memories);

            sharedPreferences = getSharedPreferences("app",MODE_PRIVATE);
            editor = sharedPreferences.edit();
            whichPhoto = sharedPreferences.getInt("WP", 1);
            editor.apply();

            imageView = (ImageView) findViewById(R.id.image_Placeholder1);
            button = (Button) findViewById(R.id.btn_choosphoto);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    editor.putInt("WP", whichPhoto = 1);
                    editor.apply();
                    openGallery();

                }
            });
            ImageView imageView = (ImageView) findViewById(R.id.image_Placeholder1);


            imageView2 = (ImageView) findViewById(R.id.image_Placeholder2);
            button2 = (Button) findViewById(R.id.btn_choosphoto2);

            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    editor.putInt("WP", whichPhoto = 2);
                    editor.apply();
                    openGallery();

                }
            });
            ImageView imageView2 = (ImageView) findViewById(R.id.image_Placeholder2);


            imageView3 = (ImageView) findViewById(R.id.image_Placeholder3);
            button3 = (Button) findViewById(R.id.btn_choosphoto3);

            button3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    editor.putInt("WP", whichPhoto = 3);
                    editor.apply();
                    openGallery();

                }
            });
            ImageView imageView3 = (ImageView) findViewById(R.id.image_Placeholder3);


            textView = (TextView)findViewById(R.id.text_Placeholder1);
            dialog = new AlertDialog.Builder(this).create();
            editText = new EditText(this);

            dialog.setTitle("Add text");
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


            textView2 = (TextView)findViewById(R.id.text_Placeholder2);
            dialog2 = new AlertDialog.Builder(this).create();
            editText2 = new EditText(this);

            dialog2.setTitle("Add text");
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


            textView3 = (TextView)findViewById(R.id.text_Placeholder3);
            dialog3 = new AlertDialog.Builder(this).create();
            editText3 = new EditText(this);

            dialog3.setTitle("Add text");
            dialog3.setView(editText3);

            dialog3.setButton(DialogInterface.BUTTON_POSITIVE, "Save Changes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    textView3.setText(editText3.getText());

                }
            });

            textView3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    editText3.setText(textView3.getText());
                    dialog3.show();
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
        if(resultCode == RESULT_OK && requestCode == PICK_IMAGE && whichPhoto == 1) {
            imageURI = data.getData();
            imageView.setImageURI(imageURI);
        }
        else if(resultCode == RESULT_OK && requestCode == PICK_IMAGE && whichPhoto == 2){
            imageView2.setImageURI(imageURI);
        }
        else if(resultCode == RESULT_OK && requestCode == PICK_IMAGE && whichPhoto == 3){
            imageView3.setImageURI(imageURI);
        }
    }
}

