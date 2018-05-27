package com.example.android.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Question9 extends AppCompatActivity {

    //previous user answers
    String userAnswer1;
    String userAnswer2;
    String userAnswer3;
    String userAnswer4;
    String userAnswer5;
    String userAnswer6;
    String userAnswer7;
    String userAnswer8;
    //variable to store the user input
    String userAnswer9;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question9);
        //Gets all previous user answers
        userAnswer1 = getIntent().getStringExtra("q1Answer");
        userAnswer2 = getIntent().getStringExtra("q2Answer");
        userAnswer3 = getIntent().getStringExtra("q3Answer");
        userAnswer4 = getIntent().getStringExtra("q4Answer");
        userAnswer5 = getIntent().getStringExtra("q5Answer");
        userAnswer6 = getIntent().getStringExtra("q6Answer");
        userAnswer7 = getIntent().getStringExtra("q7Answer");
        userAnswer8 = getIntent().getStringExtra("q8Answer");
    }

    //Gets the user input and stores it in a variable
    public void userAnswer(View view) {
        RadioGroup selection = findViewById(R.id.radio);
        int answer9 = selection.getCheckedRadioButtonId();
        userAnswer9 = getResources().getResourceEntryName(answer9);
    }

    //Starts the next activity and passes all user answers forward
    public void questionTen(View view) {
        if (userAnswer9 != null) {
            Intent question10 = new Intent(getApplicationContext(), Question10.class);
            question10.putExtra("q9Answer", userAnswer9);
            question10.putExtra("q8Answer", userAnswer8);
            question10.putExtra("q7Answer", userAnswer7);
            question10.putExtra("q6Answer", userAnswer6);
            question10.putExtra("q5Answer", userAnswer5);
            question10.putExtra("q4Answer", userAnswer4);
            question10.putExtra("q3Answer", userAnswer3);
            question10.putExtra("q2Answer", userAnswer2);
            question10.putExtra("q1Answer", userAnswer1);
            startActivity(question10);
        } else {
            Toast.makeText(this, "Please enter an answer", Toast.LENGTH_SHORT).show();
        }
    }

    /*
    Navigates the user to the previous question and passes all answers before the previous question backwards.
     This is done so it essentially starts the last activity as if navigating to it for the first time
     and allows the variable for the previous screen to be reset to a null value*/
    public void backButton(View view) {
        Intent backButton = new Intent(getApplicationContext(), Question8.class);
        backButton.putExtra("q7Answer", userAnswer7);
        backButton.putExtra("q6Answer", userAnswer6);
        backButton.putExtra("q5Answer", userAnswer5);
        backButton.putExtra("q4Answer", userAnswer4);
        backButton.putExtra("q3Answer", userAnswer3);
        backButton.putExtra("q2Answer", userAnswer2);
        backButton.putExtra("q1Answer", userAnswer1);
        startActivity(backButton);
    }


}
