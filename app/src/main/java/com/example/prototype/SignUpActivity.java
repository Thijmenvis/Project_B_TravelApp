package com.example.prototype;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    private EditText Uname, Email, Password;
    private Button SignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        setupUIViews();

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate()){

                }
            }
        });
    }

    private void setupUIViews(){
        Uname = (EditText)findViewById(R.id.editText_Name);
        Password = (EditText)findViewById(R.id.editText_Password);
        Email = (EditText)findViewById(R.id.editText_Email);
        SignUp = (Button)findViewById(R.id.button_SignUp);
    }

    private Boolean validate(){
        Boolean result = false;

        String name = Uname.getText().toString();
        String password = Password.getText().toString();
        String email = Email.getText().toString();

        if(name.isEmpty() && password.isEmpty() && email.isEmpty()) {
            Toast.makeText(this, "Please fill in", Toast.LENGTH_SHORT).show();
        }else{
            result = true;
        }

        return result;
    }

    public void goToMain (View view){
        Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);
    }
}
