package com.example.android.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Question1 extends AppCompatActivity {

    String userAnswer1; //stores user answer to be passed to next activity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);
    }

    //retrieves user answer and stores it as a variable
    public void userAnswer(View view) {
        RadioGroup selection = findViewById(R.id.radio);
        int answer1 = selection.getCheckedRadioButtonId();
        userAnswer1 = getResources().getResourceEntryName(answer1);
    }

    //Starts the next activity and passes the answer to it
    public void questionTwo(View view) {
        if (userAnswer1 != null) {
            Intent question2 = new Intent(getApplicationContext(), Question2.class);
            question2.putExtra("q1Answer", userAnswer1);
            startActivity(question2);
        } else {
            Toast.makeText(this, "Please enter an answer", Toast.LENGTH_SHORT).show();
        }
    }

}
