package com.example.planningpoker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static java.lang.Thread.sleep;

public class SessionActivity extends AppCompatActivity {
    Button buttonCreateSession,buttonJoinSession, viewQuestionButton, voteButton;
    EditText textQuestion,numberQCode;
    EditText getNumberQCodeJoin;

    String code,question,jCode="";

    FirebaseDatabase database;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session);

        initialize();

        createSession();

        joinSession();

        viewQuestion();

        simpleFragment();
    }

    private void simpleFragment() {
        voteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new SimpleFragment());
            }
        });
    }


    private void viewQuestion() {
        Log.d("question", "alma");

        viewQuestionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                code = numberQCode.getText().toString().trim();

                if(!code.isEmpty()) {
                    openActivityQuestionRoom(code);
                }
                else
                Toast.makeText(getApplicationContext(),"Kérem irja be a szoba kodot!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void createSession(){

        buttonCreateSession.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                question = textQuestion.getText().toString().trim();
                code = numberQCode.getText().toString().trim();
                if(!code.isEmpty()||!question.isEmpty()) {
                    clear();
                    database = FirebaseDatabase.getInstance();
                    myRef = database.getReference("Session").child(code);
                    Log.d("question", question);


                    if (!question.isEmpty()) {
                        myRef.child("Question").setValue("                    " + question);
                    }

                    openActivityQuestionRoom(code);
                }
                else
                    Toast.makeText(getApplicationContext(),"Kérem irja be a kérdést és a szoba kodot!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void joinSession(){
        buttonJoinSession.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jCode = getNumberQCodeJoin.getText().toString();

                Log.d("globalis2", jCode);

                database(jCode);


            }
        });
    }


    private void openActivityQuestionRoom(String codeString){
        Intent intent = new Intent(this, QuestionDetails.class);
        intent.putExtra("codeString",codeString);
        startActivity(intent);
    }

    private void openActivityVote(String codeString){
        Intent intent = new Intent(this, VoteActivity.class);

        intent.putExtra("codeString",codeString);
        startActivity(intent);
    }

    private void clear(){
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Session").child(code);

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
    viewQuestionButton = findViewById(R.id.viewButton);
    voteButton = findViewById(R.id.fragment);


    }

    public void database(final String szoba){
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference().child("Session").child(szoba);

        Log.d("globalis1",szoba);

            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    if(dataSnapshot.getValue()!=null){

                        openActivityVote(szoba);
                        Log.d("drt","a");

                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Nem jo a kod", Toast.LENGTH_SHORT).show();
                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

    }
    public void setFragment(Fragment fragment){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        fragmentTransaction.replace(R.id.frameL, fragment);
        fragmentTransaction.commit();
    }




}
