package com.example.prototype;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText Email;
    EditText Password;
    Button Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Email = (EditText) findViewById(R.id.editText_Email);
        Password = (EditText) findViewById(R.id.editText_Password);
        Login = (Button) findViewById(R.id.button_Login);

}
    public void goToPasswordForget(View view) {
        Intent intent = new Intent(this, PasswordForgetActivity.class);
        startActivity(intent);
    }

    public void goToMap(View view) {
        String email = Email.getText().toString();
        String password = Password.getText().toString();

        if(email.equals("Emir") && password.equals("123")){
            Toast.makeText(this, "You signed in", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, ProfileActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
        }

    }}

