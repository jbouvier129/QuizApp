package com.example.android.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;

public class Question1 extends AppCompatActivity {

    String userAnswer1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);
    }

    public void userAnswer(View view) {
        RadioGroup selection = findViewById(R.id.radio);
        int answer1 = selection.getCheckedRadioButtonId();
        userAnswer1 = getResources().getResourceEntryName(answer1);
    }

    public void questionTwo(View view) {
        Intent question2 = new Intent(getApplicationContext(), Question2.class);
        question2.putExtra("q1Answer", userAnswer1);
        startActivity(question2);
    }

}
