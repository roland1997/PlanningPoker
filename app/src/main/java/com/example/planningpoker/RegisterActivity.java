package com.example.planningpoker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    EditText rName,rEmail, rPassword;
    Button rRegiszter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        rName = (EditText)findViewById(R.id.rNameLabel);
        rEmail = (EditText)findViewById(R.id.rEmailLabel);
        rPassword = (EditText)findViewById(R.id.rPasswordLabel);
        rRegiszter = (Button)findViewById(R.id.rRegisterButton);

        rRegiszter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            openActivityMain();
            }
        });
    }

    public void openActivityMain(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
