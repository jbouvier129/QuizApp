package com.example.android.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;

public class Question4 extends AppCompatActivity {

    float score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question4);
        score = getIntent().getFloatExtra("points", score);
    }

    public void userAnswer(View view) {
        RadioGroup selection = findViewById(R.id.radio);
        int answer = selection.getCheckedRadioButtonId();
        String userAnswer = getResources().getResourceEntryName(answer);
        if (userAnswer.equals("c")) {
            score = score + 1f;
        }
    }

    public void questionFive(View view) {
        Intent question5 = new Intent(getApplicationContext(), Question5.class);
        question5.putExtra("points", score);
        startActivity(question5);
    }

    public void backButton(View view) {
        Intent backButton = new Intent(getApplicationContext(), Question3.class);
        backButton.putExtra("points", score);
        startActivity(backButton);
    }


}
