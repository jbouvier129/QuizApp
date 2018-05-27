package com.example.android.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Question7 extends AppCompatActivity {

    //previous user answers
    String userAnswer1;
    String userAnswer2;
    String userAnswer3;
    String userAnswer4;
    String userAnswer5;
    String userAnswer6;

    String userAnswer7;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question7);
        //gets all previous user answers
        userAnswer1 = getIntent().getStringExtra("q1Answer");
        userAnswer2 = getIntent().getStringExtra("q2Answer");
        userAnswer3 = getIntent().getStringExtra("q3Answer");
        userAnswer4 = getIntent().getStringExtra("q4Answer");
        userAnswer5 = getIntent().getStringExtra("q5Answer");
        userAnswer6 = getIntent().getStringExtra("q6Answer");
    }

    //Gets the user input and stores it as a variable
    public void userAnswer(View view) {
        RadioGroup selection = findViewById(R.id.radio);
        int answer7 = selection.getCheckedRadioButtonId();
        userAnswer7 = getResources().getResourceEntryName(answer7);
    }

    //Starts the next activity and passes all previous user answers forward
    public void questionEight(View view) {
        if (userAnswer7 != null) {
            Intent question8 = new Intent(getApplicationContext(), Question8.class);
            question8.putExtra("q7Answer", userAnswer7);
            question8.putExtra("q6Answer", userAnswer6);
            question8.putExtra("q5Answer", userAnswer5);
            question8.putExtra("q4Answer", userAnswer4);
            question8.putExtra("q3Answer", userAnswer3);
            question8.putExtra("q2Answer", userAnswer2);
            question8.putExtra("q1Answer", userAnswer1);
            startActivity(question8);
        } else {
            Toast.makeText(this, "Please enter an answer", Toast.LENGTH_SHORT).show();
        }
    }

    /*
    Navigates the user to the previous question and passes all answers before the previous question backwards.
     This is done so it essentially starts the last activity as if navigating to it for the first time
     and allows the variable for the previous screen to be reset to a null value*/
    public void backButton(View view) {
        Intent backButton = new Intent(getApplicationContext(), Question5.class);
        backButton.putExtra("q5Answer", userAnswer5);
        backButton.putExtra("q4Answer", userAnswer4);
        backButton.putExtra("q3Answer", userAnswer3);
        backButton.putExtra("q2Answer", userAnswer2);
        backButton.putExtra("q1Answer", userAnswer1);
        startActivity(backButton);
    }


}
