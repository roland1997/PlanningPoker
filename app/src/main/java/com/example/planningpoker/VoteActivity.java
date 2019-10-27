package com.example.planningpoker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;

public class VoteActivity extends AppCompatActivity {
/*
    TextView textViewQuestion;
    Button buttonVote1;
    Button buttonVote2;
    Button buttonVote3;
    Button buttonVote4;
    Button buttonVote5;

    private FirebaseAuth mAuth;
    com.google.firebase.database.DatabaseReference reff;

*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote);
/*
        mAuth = FirebaseAuth.getInstance();
        initialize();

        Toast.makeText(getApplicationContext(),
                " Szavasat az egyik gombra kattintva adhatja le.",
                Toast.LENGTH_SHORT).show();

        onClickListener();*/
    }
/*
    private void onClickListener() {

        final VoteNumber vote = new VoteNumber();

         final com.google.firebase.database.DatabaseReference reff = FirebaseDatabase.getInstance().getReference("vote");

        buttonVote1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                vote.setVote("1");
                reff.push().setValue(vote);
                startActivity(new Intent(VoteActivity.this, SessionActivity.class));
            }
        });

        buttonVote2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vote.setVote("2");
                reff.push().setValue(vote);
                startActivity(new Intent(VoteActivity.this, SessionActivity.class));
            }
        });

        buttonVote3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vote.setVote("3");
                reff.push().setValue(vote);
                startActivity(new Intent(VoteActivity.this, SessionActivity.class));
            }
        });
        buttonVote4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vote.setVote("4");
                reff.push().setValue(vote);
                startActivity(new Intent(VoteActivity.this, SessionActivity.class));
            }
        });

        buttonVote5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                vote.setVote("5");
                reff.push().setValue(vote);
                startActivity(new Intent(VoteActivity.this, SessionActivity.class));
            }
        });
    }


    private void initialize() {

        textViewQuestion = findViewById(R.id.textViewQuestion);
        buttonVote1 = findViewById(R.id.buttonVote1);
        buttonVote2 = findViewById(R.id.buttonVote2);
        buttonVote3 = findViewById(R.id.buttonVote3);
        buttonVote4 = findViewById(R.id.buttonVote4);
        buttonVote5 = findViewById(R.id.buttonVote5);
    }

*/

}
