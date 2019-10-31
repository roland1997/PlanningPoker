package com.example.planningpoker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class VoteActivity extends AppCompatActivity {

    TextView textViewQuestion;

    Button buttonVote1,buttonVote2,buttonVote3,buttonVote4,buttonVote5;

    String code;

    private FirebaseAuth mAuth;
    private DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote);

        initialize();

        questionFromFirebase();

        onClickListener();
    }

    private void questionFromFirebase(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Session").child(code).child("Question");


        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String question = dataSnapshot.getValue().toString();
                textViewQuestion.setText(question);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void openSessionActivity(){
        Intent intent = new Intent(this,SessionActivity.class);
        startActivity(intent);
    }

    private void onClickListener() {


        databaseReference = FirebaseDatabase.getInstance().getReference("Session").child(code);

        buttonVote1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String vote = "1";
                VoteNumber voteNumber = new VoteNumber(vote);
                FirebaseUser user = mAuth.getCurrentUser();
                String stringVoteNumber = voteNumber.getVote();
                databaseReference.child(stringVoteNumber).child(user.getUid()).setValue(user.getEmail());

                openSessionActivity();
            }
        });

        buttonVote2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String vote = "2";
                VoteNumber voteNumber = new VoteNumber(vote);
                FirebaseUser user = mAuth.getCurrentUser();
                String stringVoteNumber = voteNumber.getVote();
                databaseReference.child(stringVoteNumber).child(user.getUid()).setValue(user.getEmail());
                openSessionActivity();

            }
        });

        buttonVote3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String vote = "3";
                VoteNumber voteNumber = new VoteNumber(vote);
                FirebaseUser user = mAuth.getCurrentUser();
                String stringVoteNumber = voteNumber.getVote();
                databaseReference.child(stringVoteNumber).child(user.getUid()).setValue(user.getEmail());

                openSessionActivity();
            }
        });
        buttonVote4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String vote = "4";
                VoteNumber voteNumber = new VoteNumber(vote);
                FirebaseUser user = mAuth.getCurrentUser();
                String stringVoteNumber = voteNumber.getVote();
                databaseReference.child(stringVoteNumber).child(user.getUid()).setValue(user.getEmail());

                openSessionActivity();
            }
        });

        buttonVote5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String vote = "5";
                VoteNumber voteNumber = new VoteNumber(vote);
                FirebaseUser user = mAuth.getCurrentUser();
                String stringVoteNumber = voteNumber.getVote();
                databaseReference.child(stringVoteNumber).child(user.getUid()).setValue(user.getEmail());

                openSessionActivity();
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

        code = getIntent().getStringExtra("codeString");

        mAuth = FirebaseAuth.getInstance();

        Toast.makeText(getApplicationContext(), " Szavasat az egyik gombra kattintva adhatja le.", Toast.LENGTH_LONG).show();
    }



}
