package com.example.android.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;

public class Question3 extends AppCompatActivity {

    float score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);
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

    public void questionFour(View view) {
        Intent question4 = new Intent(getApplicationContext(), Question4.class);
        question4.putExtra("points", score);
        startActivity(question4);
    }

    public void backButton(View view) {
        Intent backButton = new Intent(getApplicationContext(), Question2.class);
        backButton.putExtra("points", score);
        startActivity(backButton);
    }


}