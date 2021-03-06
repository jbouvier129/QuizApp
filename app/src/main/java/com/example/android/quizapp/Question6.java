package com.example.android.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Question6 extends AppCompatActivity {

    //previous user answers
    String userAnswer1;
    String userAnswer2;
    String userAnswer3;
    String userAnswer4;
    String userAnswer5;
    //variable to store user answer
    String userAnswer6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question6);
        //Gets all previous user answers
        userAnswer1 = getIntent().getStringExtra("q1Answer");
        userAnswer2 = getIntent().getStringExtra("q2Answer");
        userAnswer3 = getIntent().getStringExtra("q3Answer");
        userAnswer4 = getIntent().getStringExtra("q4Answer");
        userAnswer5 = getIntent().getStringExtra("q5Answer");
    }

    //gets the user answer and stores it in a variable
    public void userAnswer(View view) {
        RadioGroup selection = findViewById(R.id.radio);
        int answer6 = selection.getCheckedRadioButtonId();
        userAnswer6 = getResources().getResourceEntryName(answer6);
    }

    //Starts the next activity and passes all user answers forward
    public void questionSeven(View view) {
        if (userAnswer6 != null) {
            Intent question7 = new Intent(getApplicationContext(), Question7.class);
            question7.putExtra("q6Answer", userAnswer6);
            question7.putExtra("q5Answer", userAnswer5);
            question7.putExtra("q4Answer", userAnswer4);
            question7.putExtra("q3Answer", userAnswer3);
            question7.putExtra("q2Answer", userAnswer2);
            question7.putExtra("q1Answer", userAnswer1);
            startActivity(question7);
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
        backButton.putExtra("q4Answer", userAnswer4);
        backButton.putExtra("q3Answer", userAnswer3);
        backButton.putExtra("q2Answer", userAnswer2);
        backButton.putExtra("q1Answer", userAnswer1);
        startActivity(backButton);
    }


}
