package com.example.prototype;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void goToPasswordForget (View view){
        Intent intent = new Intent (this, PasswordForgetActivity.class);
        startActivity(intent);
    }
    public void goToMap (View view){
        Intent intent = new Intent (this, MapActivity.class);
        startActivity(intent);
    }
}
