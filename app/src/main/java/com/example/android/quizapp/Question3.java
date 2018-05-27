package com.example.android.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Question3 extends AppCompatActivity {

    //user answers from previous questions
    String userAnswer1;
    String userAnswer2;
    //variable to store user answer
    String userAnswer3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);
        //gets the previous answers
        userAnswer1 = getIntent().getStringExtra("q1Answer");
        userAnswer2 = getIntent().getStringExtra("q2Answer");
    }

    //gets the users answer and stores it in a variable
    public void userAnswer(View view) {
        RadioGroup selection = findViewById(R.id.radio);
        int answer3 = selection.getCheckedRadioButtonId();
        userAnswer3 = getResources().getResourceEntryName(answer3);
    }

    //Starts the next activity and passes all previous answers forward
    public void questionFour(View view) {
        if (userAnswer3 != null) {
            Intent question4 = new Intent(getApplicationContext(), Question4.class);
            question4.putExtra("q3Answer", userAnswer3);
            question4.putExtra("q2Answer", userAnswer2);
            question4.putExtra("q1Answer", userAnswer1);
            startActivity(question4);
        } else {
            Toast.makeText(this, "Please enter an answer", Toast.LENGTH_SHORT).show();
        }
    }

    /*
    Navigates the user to the previous question and passes all answers before the previous question backwards.
     This is done so it essentially starts the last activity as if navigating to it for the first time
     and allows the variable for the previous screen to be reset to a null value*/
    public void backButton(View view) {
        Intent backButton = new Intent(getApplicationContext(), Question2.class);
        backButton.putExtra("q1Answer", userAnswer1);
        startActivity(backButton);
    }


}