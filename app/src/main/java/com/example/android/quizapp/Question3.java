package com.example.android.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;

public class Question3 extends AppCompatActivity {

    String userAnswer1;
    String userAnswer2;
    String userAnswer3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);
        userAnswer1 = getIntent().getStringExtra("q1Answer");
        userAnswer2 = getIntent().getStringExtra("q2Answer");
    }

    public void userAnswer(View view) {
        RadioGroup selection = findViewById(R.id.radio);
        int answer3 = selection.getCheckedRadioButtonId();
        userAnswer3 = getResources().getResourceEntryName(answer3);
    }

    public void questionFour(View view) {
        Intent question4 = new Intent(getApplicationContext(), Question4.class);
        question4.putExtra("q3Answer", userAnswer3);
        question4.putExtra("q2Answer", userAnswer2);
        question4.putExtra("q1Answer", userAnswer1);
        startActivity(question4);
    }

    public void backButton(View view) {
        Intent backButton = new Intent(getApplicationContext(), Question2.class);
        backButton.putExtra("q1Answer", userAnswer1);
        startActivity(backButton);
    }


}