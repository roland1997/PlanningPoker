package com.example.planningpoker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

public class QuestionDetails extends AppCompatActivity {

    RecyclerView recyclerView;
    TextView textViewQuestion;
    TextView textViewEmail;
    TextView textViewVote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_detalies);

        initialization();

    }


    private void initialization() {
        recyclerView = findViewById(R.id.recyclerView);
        textViewEmail = findViewById(R.id.textViewEmail);
        textViewQuestion = findViewById(R.id.textViewQuestion);
        textViewVote = findViewById(R.id.textViewVote);

    }
}
