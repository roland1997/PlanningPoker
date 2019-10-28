package com.example.planningpoker;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SessionActivity extends AppCompatActivity {
    Button buttonCreateSession,buttonJoinSession;
    EditText textQuestion,numberQCode;
    EditText getNumberQCodeJoin;

    Button newButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session);

        initialize();

        buttonCreateSession.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String question = textQuestion.getText().toString().trim();

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("Kod");



                if(!question.isEmpty()){
                    myRef.child("Question").setValue("                    "+question);
                }
                openActivityQuestionRoom();
            }
        });
        buttonJoinSession.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityVote();
            }
        });

        newButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clear();
            }
        });
    }

    private void openActivityQuestionRoom(){
        Intent intent = new Intent(this, QuestionDetails.class);
        startActivity(intent);
    }
    private void openActivityVote(){
        Intent intent = new Intent(this, VoteActivity.class);
        startActivity(intent);
    }

    private void clear(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Kod");
        myRef.child("1").setValue("");
        myRef.child("2").setValue("");
        myRef.child("3").setValue("");
        myRef.child("4").setValue("");
        myRef.child("5").setValue("");
        myRef.child("Question").setValue("");
    }

    private void initialize() {
    textQuestion = findViewById(R.id.sQuestionLabel);
    numberQCode = findViewById(R.id.sQuestionCode);
    buttonCreateSession = findViewById(R.id.sCreateButton);
    getNumberQCodeJoin = findViewById(R.id.sQuestionCodeJoin);
    buttonJoinSession = findViewById(R.id.sJoinSession);

    newButton = findViewById(R.id.newButton);

    }


}
