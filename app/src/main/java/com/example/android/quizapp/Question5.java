package com.example.android.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class Question5 extends AppCompatActivity {

    String userAnswer1;
    String userAnswer2;
    String userAnswer3;
    String userAnswer4;
    String userAnswer5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question5);
        userAnswer1 = getIntent().getStringExtra("q1Answer");
        userAnswer2 = getIntent().getStringExtra("q2Answer");
        userAnswer3 = getIntent().getStringExtra("q3Answer");
        userAnswer4 = getIntent().getStringExtra("q4Answer");
    }

    public String userAnswer() {
        EditText answer5 = findViewById(R.id.userText);
        userAnswer5 = answer5.getText().toString();
        return userAnswer5;

    }

    public void questionSix(View view) {
        userAnswer();
        Intent question6 = new Intent(getApplicationContext(), Question6.class);
        question6.putExtra("q5Answer", userAnswer5);
        question6.putExtra("q4Answer", userAnswer4);
        question6.putExtra("q3Answer", userAnswer3);
        question6.putExtra("q2Answer", userAnswer2);
        question6.putExtra("q1Answer", userAnswer1);
        startActivity(question6);
    }

    public void backButton(View view) {
        Intent backButton = new Intent(getApplicationContext(), Question4.class);
        backButton.putExtra("q3Answer", userAnswer3);
        backButton.putExtra("q2Answer", userAnswer2);
        backButton.putExtra("q1Answer", userAnswer1);
        startActivity(backButton);
    }
}
