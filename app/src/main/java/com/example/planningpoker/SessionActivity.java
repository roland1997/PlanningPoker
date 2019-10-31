package com.example.planningpoker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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

import static com.google.android.gms.common.internal.safeparcel.SafeParcelable.NULL;
import static java.lang.Thread.sleep;

public class SessionActivity extends AppCompatActivity {
    Button buttonCreateSession,buttonJoinSession;
    EditText textQuestion,numberQCode;
    EditText getNumberQCodeJoin;

    Button newButton;

    String code;
    String question;

    String jCode="";
    String jCodeCheck="";

    FirebaseDatabase database;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session);

        initialize();

        buttonCreateSession.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                question = textQuestion.getText().toString().trim();
                code = numberQCode.getText().toString().trim();
                clear();
                database = FirebaseDatabase.getInstance();
                myRef = database.getReference("Session").child(code);
                Log.d("question", question);



                if(!question.isEmpty()){
                    myRef.child("Question").setValue("                    "+question);
                }
                //database();
                openActivityQuestionRoom(code);
            }
        });
        buttonJoinSession.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jCode = getNumberQCodeJoin.getText().toString();

                Log.d("globalis2", jCode);

                database(jCode);


            }
        });

        newButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clear();
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
        //Log.d("hulye",codeString);
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

    newButton = findViewById(R.id.newButton);

    }

    public void database(final String szoba){
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference().child("Session").child(szoba);

        Log.d("globalis1",szoba);

            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    jCodeCheck="";
                    jCodeCheck = dataSnapshot.getKey();

                    Log.d("globalis", jCodeCheck);

                    if(dataSnapshot.getValue()!=null){

                        openActivityVote(szoba);
                        Log.d("drt","a");
                        jCodeCheck="";
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


}
