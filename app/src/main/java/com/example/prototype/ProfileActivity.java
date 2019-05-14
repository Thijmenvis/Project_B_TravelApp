package com.example.prototype;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class ProfileActivity extends AppCompatActivity {

    Button button;
    private static final int PICK_IMAGE = 100;
    private static final int request_code = 121232;
    Uri imageURI;

    TextView textView;
    TextView textView2;
    AlertDialog dialog;
    AlertDialog dialog2;
    EditText editText;
    EditText editText2;
    Metadata metadata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            // start runtime permission
            Boolean hasPermission =( ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED);
            if (!hasPermission){

                ActivityCompat.requestPermissions( this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, request_code);
            }else {

                //showFileChooser();

            }
        }else {
            //readfile();
            //showFileChooser();
        }
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

        button = (Button)findViewById(R.id.btn_ChangePic);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();

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
        }

        if(resultCode == RESULT_OK && requestCode == 0){
            Bitmap bitmap = (Bitmap)data.getExtras().get("data");
            Uri tempUri = getImageUri(getApplicationContext(), bitmap);
            String path_2 = getRealPathFromURI(tempUri);
            File imagefile = new File(path_2);
            imagefile.setReadable(true);
            imagefile.setExecutable(true);


            Log.d("path_2", path_2);
            try {
                metadata = ImageMetadataReader.readMetadata(imagefile);
                for (Directory directory : metadata.getDirectories()) {


                    for (Tag data_of_meta : directory.getTags()) {

                        Log.d("tags ", data_of_meta.toString());// this line shows wat variable tag is bound to in logcat
                    }
                }
            } catch (ImageProcessingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
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

    public void goToMemories (View view){
        Intent intent = new Intent (this, MemoriesActivity.class);
        startActivity(intent);
    }

    public Uri getImageUri(Context inContext, Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "Title", null);
        return Uri.parse(path);
    }

    public String getRealPathFromURI(Uri uri) {
        String path = "";
        if (getContentResolver() != null) {
            Cursor cursor = getContentResolver().query(uri, null, null, null, null);
            if (cursor != null) {
                cursor.moveToFirst();
                int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
                path = cursor.getString(idx);
                cursor.close();
            }
        }
        return path;
    }


}
