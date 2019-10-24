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
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    EditText lName, lPassword;
    Button lLogin, lRegiszter;
    String email,password;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

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




        FirebaseUser user = mAuth.getCurrentUser();
        try{
            Log.d("beji",user.getUid());
        }
        catch (NullPointerException e){

        }

    }
    public void openActivityRegister(){
        Intent intent = new Intent(this,RegisterActivity.class);
        startActivity(intent);

    }
    public void openActivitySession(){
        email = lName.getText().toString().trim();
        password = lPassword.getText().toString().trim();
        login(email,password);

        Intent intent = new Intent(MainActivity.this,SessionActivity.class);
        startActivity(intent);
    }
    public void login(String email, String password){
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isComplete()){

                }else{

                }
            }
        });
    }
}
