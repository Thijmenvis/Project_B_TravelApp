package com.example.prototype;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText Email;
    EditText Password;
    Button Login;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new DatabaseHelper(this);

        Email = (EditText) findViewById(R.id.editText_Password);
        Password = (EditText) findViewById(R.id.editText_Password2);
        Login = (Button) findViewById(R.id.button_Login);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = Email.getText().toString();
                String password = Password.getText().toString();
                Boolean Chkemailpass = db.emailpassword(email,password);

                if(Chkemailpass==true){
                    Toast.makeText(getApplicationContext(),"Signed in", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, ProfileActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(),"Wrong email or password", Toast.LENGTH_SHORT).show();
                }


            }


        });

}
    public void goToPasswordForget(View view) {
        Intent intent = new Intent(this, PasswordForgetActivity.class);
        startActivity(intent);
    }

    public void goToMap(View view){
    }
}

