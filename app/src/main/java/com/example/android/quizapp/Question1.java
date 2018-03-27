package com.example.android.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;

public class Question1 extends AppCompatActivity {

    float score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);
    }

    public void userAnswer(View view) {
        RadioGroup selection = findViewById(R.id.radio);
        int answer = selection.getCheckedRadioButtonId();
        String userAnswer = getResources().getResourceEntryName(answer);
        if (userAnswer.equals("b")) {
            score = score + 1f;
        }
    }

    public void questionTwo(View view) {
        Intent question2 = new Intent(getApplicationContext(), Question2.class);
        question2.putExtra("points", score);
        startActivity(question2);
    }

}
