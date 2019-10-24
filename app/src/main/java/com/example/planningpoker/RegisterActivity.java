package com.example.planningpoker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    EditText name,email,password;
    Button regiszter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = (EditText)findViewById(R.id.nameLabel);
        email = (EditText)findViewById(R.id.emailLabel);
        password = (EditText)findViewById(R.id.passwordLabel);
        regiszter = (Button)findViewById(R.id.registerButton);
    }
}
