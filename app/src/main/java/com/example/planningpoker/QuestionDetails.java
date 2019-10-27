package com.example.planningpoker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ScrollView;
import android.widget.TextView;

public class QuestionDetails extends AppCompatActivity {
    ScrollView scrollView;
    TextView textViewQuestion;
    TextView textViewEmail;
    TextView textViewVote;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_details);
    }
    private void initialization() {
        scrollView = findViewById(R.id.scrollView);
        textViewEmail = findViewById(R.id.textViewEmail);
        textViewQuestion = findViewById(R.id.textViewQuestion);
        textViewVote = findViewById(R.id.textViewVote);


    }
}
