package com.example.planningpoker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class QuestionDetails extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private DatabaseReference myRef;
    private String userID;
    private FirebaseDatabase mFirebaseDatabase;


    TextView textViewQuestion;
    TextView textViewEmail;
    TextView textViewVote1, textViewVote2, textViewVote3, textViewVote4, textViewVote5;
    Button update;

    String code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_details);

        initialization();
        mAuth = FirebaseAuth.getInstance();
        mFirebaseDatabase = FirebaseDatabase.getInstance();

        code = getIntent().getStringExtra("codeString");
        Log.d("keremazidt",code);

        FirebaseUser user = mAuth.getCurrentUser();
        userID = user.getUid();

        myRef = mFirebaseDatabase.getReference("Session").child(code);

        myRef.child("1").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String user = dataSnapshot.getValue().toString().replace("{"," ");
                String user1 = user.replace(",","\n");
                String user2 = user1.replace("}"," ");
                String user3 = user2.replace("=",": ");

                //Log.d("felhasznalo",user3);
                textViewVote1.setText("                    "+"1:"+"\n"+user3);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError){}
        });

        myRef.child("2").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String user = dataSnapshot.getValue().toString().replace("{"," ");
                String user1 = user.replace(",","\n");
                String user2 = user1.replace("}"," ");
                String user3 = user2.replace("=",": ");

                Log.d("felhasznalo",user3);
                textViewVote2.setText("                    "+"2:"+"\n"+user3);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) { }
        });

        myRef.child("3").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String user = dataSnapshot.getValue().toString().replace("{"," ");
                String user1 = user.replace(",","\n");
                String user2 = user1.replace("}"," ");
                String user3 = user2.replace("=",": ");

                Log.d("felhasznalo",user3);
                textViewVote3.setText("                    "+"3:"+"\n"+user3);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) { }
        });

        myRef.child("4").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String user = dataSnapshot.getValue().toString().replace("{"," ");
                String user1 = user.replace(",","\n");
                String user2 = user1.replace("}"," ");
                String user3 = user2.replace("=",": ");

                Log.d("felhasznalo",user3);
                textViewVote4.setText("                    "+"4:"+"\n"+user3);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) { }
        });

        myRef.child("5").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String user = dataSnapshot.getValue().toString().replace("{"," ");
                String user1 = user.replace(",","\n");
                String user2 = user1.replace("}"," ");
                String user3 = user2.replace("=",": ");

                Log.d("felhasznalo1",user3);
                textViewVote5.setText("                    "+"5:"+"\n"+user3);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) { }
        });

        myRef.child("Question").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String question = dataSnapshot.getValue().toString();
                textViewQuestion.setText(question);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityQuestionVote();
            }
        });
    }

    private void openActivityQuestionVote(){
        Intent intent = new Intent(this, QuestionDetails.class);
        startActivity(intent);
    }
    private void initialization() {
        update = findViewById(R.id.buttonUpdateRecyclerView);
        textViewEmail = findViewById(R.id.textViewEmail);
        textViewQuestion = findViewById(R.id.textViewQuestion);
        textViewVote1 = findViewById(R.id.textViewVote1);
        textViewVote2 = findViewById(R.id.textViewVote2);
        textViewVote3 = findViewById(R.id.textViewVote3);
        textViewVote4 = findViewById(R.id.textViewVote4);
        textViewVote5 = findViewById(R.id.textViewVote5);

    }
}
