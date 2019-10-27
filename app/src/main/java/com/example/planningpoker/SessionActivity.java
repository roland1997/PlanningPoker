package com.example.planningpoker;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SessionActivity extends AppCompatActivity {
    Button buttonCreateSession,buttonJoinSession;
    EditText textQuestion,numberQCode,getNumberQCodeJoin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session);
        initialize();
        buttonCreateSession.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityVote();
            }
        });
    }

    private void openActivityQuestionRoom(){
        Intent intent = new Intent(this, VoteActivity.class);
        startActivity(intent);
    }
    private void openActivityVote(){
        Intent intent = new Intent(this, VoteActivity.class);
        startActivity(intent);
    }

    private void initialize() {
    textQuestion = findViewById(R.id.sQuestionLabel);
    numberQCode = findViewById(R.id.sQuestionCode);
    buttonCreateSession = findViewById(R.id.sCreateButton);
    getNumberQCodeJoin = findViewById(R.id.sQuestionCodeJoin);
    buttonJoinSession = findViewById(R.id.sJoinSession);


    }


}
