package com.example.prototype;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {
    DatabaseHelper db;
    EditText editText_Email, editText_Password, editText_Password2;
    Button button_SignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        db = new DatabaseHelper(this);
        editText_Email=(EditText)findViewById(R.id.editText_Email);
        editText_Password=(EditText)findViewById(R.id.editText_Password);
        editText_Password2=(EditText)findViewById(R.id.editText_Password2);
        button_SignUp=(Button)findViewById(R.id.button_SignUp);
        button_SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = editText_Email.getText().toString();
                String s2 = editText_Password.getText().toString();
                String s3 = editText_Password2.getText().toString();
                if(s1.equals("")||s2.equals("")||s3.equals("")){
                    Toast.makeText(getApplicationContext(), "Please fill in", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(s2.equals(s3)){
                        Boolean chkemail = db.chkemail(s1);
                        if(chkemail==true){
                            Boolean insert = db.insert(s1,s2);
                            if(insert==true){
                                Toast.makeText(getApplicationContext(),"Registration completed!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                                startActivity(intent);

                            }
                        }
                        else{
                            Toast.makeText(getApplicationContext(), "Email already exists", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Passwords do not match", Toast.LENGTH_SHORT).show();

                    }

                }

            }
        });
    }



    public void goToMain (View view){
        Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);
    }
}
