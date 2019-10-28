package com.example.planningpoker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    EditText lEmail, lPassword;
    Button lLogin, lRegiszter;

    private FirebaseAuth mAuth;

    SharedPreferences sharedpreferences;
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Email = "emailKey";
    public static final String Password = "passwordKey";

    String savedEmail,savedPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        lEmail = (EditText) findViewById(R.id.lEmailLabel);
        lPassword = (EditText) findViewById(R.id.lPasswordLabel);
        lLogin = (Button) findViewById(R.id.lLoginButton);
        lRegiszter = (Button) findViewById(R.id.lRegisterButton);


        lRegiszter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityRegister();
            }
        });

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        lLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor;
                editor = sharedpreferences.edit();
                editor.putString(Email, lEmail.getText().toString());
                editor.putString(Password, lPassword.getText().toString());
                editor.apply();

                openActivitySession();
            }
        });

        savedEmail = sharedpreferences.getString(Email,"");
        savedPassword = sharedpreferences.getString(Password,"");

        lEmail.setText(savedEmail);
        lPassword.setText(savedPassword);

    }

    public void openActivityRegister() {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    public void openActivitySession() {

        String email, password;
        email = lEmail.getText().toString().trim();
        password = lPassword.getText().toString().trim();

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    FirebaseUser user = mAuth.getCurrentUser();
                    Log.d("alma", user.getUid());

                    Intent intent = new Intent(MainActivity.this, SessionActivity.class);
                    finish();

                    startActivity(intent);
                }else{
                    Log.d("alma","semmi");
                    Toast.makeText(getApplicationContext(),"Sikertelen bejelentkezes", Toast.LENGTH_SHORT).show();
                }

            }
        });



    }
}
