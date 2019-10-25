package com.example.planningpoker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    EditText rName,rEmail, rPassword;
    Button rRegiszter;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

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
        String email,password;
        email = rEmail.getText().toString().trim();
        password = rPassword.getText().toString().trim();

        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Log.d("regiszt","sikeres regisztracio");
                    Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
                    finish();
                    startActivity(intent);
                }
                else {
                    Log.d("regiszt","Sikertelen regisztracio");
                }
            }
        });
    }
}
