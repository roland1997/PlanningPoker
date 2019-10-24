package com.example.planningpoker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText lName, lPassword;
    Button lLogin, lRegiszter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lName = (EditText)findViewById(R.id.lNameLabel);
        lPassword = (EditText)findViewById(R.id.lPasswordLabel);
        lLogin = (Button)findViewById(R.id.lLoginButton);
        lRegiszter = (Button)findViewById(R.id.lRegisterButton);

        lRegiszter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityRegister();
            }
        });
        lLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivitySession();
            }
        });

    }
    public void openActivityRegister(){
        Intent intent = new Intent(this,RegisterActivity.class);
        startActivity(intent);
    }
    public void openActivitySession(){
        Intent intent = new Intent(this,SessionActivity.class);
        startActivity(intent);
    }
}
