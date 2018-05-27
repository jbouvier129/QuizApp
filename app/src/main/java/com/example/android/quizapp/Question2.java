package com.example.android.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Question2 extends AppCompatActivity {

    String userAnswer1; //user answer from question one
    String userAnswer2; //user answer to be passed to next activity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);

        //gets the answer from the first activity
        userAnswer1 = getIntent().getStringExtra("q1Answer");
    }

    //gets the user answer and stores it in a variable
    public void userAnswer(View view) {
        RadioGroup selection = findViewById(R.id.radio);
        int answer2 = selection.getCheckedRadioButtonId();
        userAnswer2 = getResources().getResourceEntryName(answer2);
    }


    //Starts the next activity and passes the previous user answers to it
    public void questionThree(View view) {
        if (userAnswer2 != null) {
            Intent question3 = new Intent(getApplicationContext(), Question3.class);
            question3.putExtra("q2Answer", userAnswer2);
            question3.putExtra("q1Answer", userAnswer1);
            startActivity(question3);
        } else {
            Toast.makeText(this, "Please enter an answer", Toast.LENGTH_SHORT).show();
        }
    }

    //navigates the user to the previous question. In this case no old user answers are passed backwards as it is question one
    public void backButton(View view) {
        Intent backButton = new Intent(getApplicationContext(), Question1.class);
        startActivity(backButton);
    }


}