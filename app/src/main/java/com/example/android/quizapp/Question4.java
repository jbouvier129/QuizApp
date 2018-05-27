package com.example.android.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Question4 extends AppCompatActivity {

    //previous answers
    String userAnswer1;
    String userAnswer2;
    String userAnswer3;
    //variable to store the users answer
    String userAnswer4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question4);
        //Gets previous user answers
        userAnswer1 = getIntent().getStringExtra("q1Answer");
        userAnswer2 = getIntent().getStringExtra("q2Answer");
        userAnswer3 = getIntent().getStringExtra("q3Answer");
    }

    //Gets the user input and stores it in a variable
    public void userAnswer(View view) {
        RadioGroup selection = findViewById(R.id.radio);
        int answer4 = selection.getCheckedRadioButtonId();
        userAnswer4 = getResources().getResourceEntryName(answer4);
    }

    //navigates to the next question and passes all answers forward
    public void questionFive(View view) {
        if (userAnswer4 != null) {
            Intent question5 = new Intent(getApplicationContext(), Question5.class);
            question5.putExtra("q4Answer", userAnswer4);
            question5.putExtra("q3Answer", userAnswer3);
            question5.putExtra("q2Answer", userAnswer2);
            question5.putExtra("q1Answer", userAnswer1);
            startActivity(question5);
        } else {
            Toast.makeText(this, "Please enter an answer", Toast.LENGTH_SHORT).show();
        }
    }

    /*
    Navigates the user to the previous question and passes all answers before the previous question backwards.
     This is done so it essentially starts the last activity as if navigating to it for the first time
     and allows the variable for the previous screen to be reset to a null value*/
    public void backButton(View view) {
        Intent backButton = new Intent(getApplicationContext(), Question3.class);
        backButton.putExtra("q2Answer", userAnswer2);
        backButton.putExtra("q1Answer", userAnswer1);
        startActivity(backButton);
    }


}
