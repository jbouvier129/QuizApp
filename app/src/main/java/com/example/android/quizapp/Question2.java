package com.example.android.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;

public class Question2 extends AppCompatActivity {

    float score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);

        score = getIntent().getFloatExtra("points", score);
    }

    public void userAnswer(View view) {
        RadioGroup selection = findViewById(R.id.radio);
        int answer = selection.getCheckedRadioButtonId();
        String userAnswer = getResources().getResourceEntryName(answer);
        if (userAnswer.equals("a")) {
            score = score + 1f;
        }
    }

    public void questionThree(View view) {
        Intent question3 = new Intent(getApplicationContext(), Question3.class);
        question3.putExtra("points", score);
        startActivity(question3);
    }

    public void backButton(View view) {
        Intent backButton = new Intent(getApplicationContext(), Question1.class);
        backButton.putExtra("points", score);
        startActivity(backButton);
    }


}