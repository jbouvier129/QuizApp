package com.example.android.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;

public class Question2 extends AppCompatActivity {

    String userAnswer1;
    String userAnswer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);

        userAnswer1 = getIntent().getStringExtra("q1Answer");
    }

    public void userAnswer(View view) {
        RadioGroup selection = findViewById(R.id.radio);
        int answer2 = selection.getCheckedRadioButtonId();
        userAnswer2 = getResources().getResourceEntryName(answer2);
    }


    public void questionThree(View view) {
        Intent question3 = new Intent(getApplicationContext(), Question3.class);
        question3.putExtra("q2Answer", userAnswer2);
        question3.putExtra("q1Answer", userAnswer1);
        startActivity(question3);
    }

    public void backButton(View view) {
        Intent backButton = new Intent(getApplicationContext(), Question1.class);
        ;
        startActivity(backButton);
    }


}