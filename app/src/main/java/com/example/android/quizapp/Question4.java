package com.example.android.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;

public class Question4 extends AppCompatActivity {

    String userAnswer1;
    String userAnswer2;
    String userAnswer3;
    String userAnswer4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question4);
        userAnswer1 = getIntent().getStringExtra("q1Answer");
        userAnswer2 = getIntent().getStringExtra("q2Answer");
        userAnswer3 = getIntent().getStringExtra("q3Answer");
    }

    public void userAnswer(View view) {
        RadioGroup selection = findViewById(R.id.radio);
        int answer4 = selection.getCheckedRadioButtonId();
        userAnswer4 = getResources().getResourceEntryName(answer4);
    }

    public void questionFive(View view) {
        Intent question5 = new Intent(getApplicationContext(), Question5.class);
        question5.putExtra("q4Answer", userAnswer4);
        question5.putExtra("q3Answer", userAnswer3);
        question5.putExtra("q2Answer", userAnswer2);
        question5.putExtra("q1Answer", userAnswer1);
        startActivity(question5);
    }

    public void backButton(View view) {
        Intent backButton = new Intent(getApplicationContext(), Question3.class);
        backButton.putExtra("q2Answer", userAnswer2);
        backButton.putExtra("q1Answer", userAnswer1);
        startActivity(backButton);
    }


}
