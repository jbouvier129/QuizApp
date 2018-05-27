package com.example.android.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Question8 extends AppCompatActivity {

    //previous user answers
    String userAnswer1;
    String userAnswer2;
    String userAnswer3;
    String userAnswer4;
    String userAnswer5;
    String userAnswer6;
    String userAnswer7;
    //variable to store the user answer
    String userAnswer8;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question8);
        //gets all previous user answers
        userAnswer1 = getIntent().getStringExtra("q1Answer");
        userAnswer2 = getIntent().getStringExtra("q2Answer");
        userAnswer3 = getIntent().getStringExtra("q3Answer");
        userAnswer4 = getIntent().getStringExtra("q4Answer");
        userAnswer5 = getIntent().getStringExtra("q5Answer");
        userAnswer6 = getIntent().getStringExtra("q6Answer");
        userAnswer7 = getIntent().getStringExtra("q7Answer");
    }

    //Gets the user input and stores it in a variable
    public void userAnswer(View view) {
        RadioGroup selection = findViewById(R.id.radio);
        int answer8 = selection.getCheckedRadioButtonId();
        userAnswer8 = getResources().getResourceEntryName(answer8);
    }

    //Starts the next activity and passes all user answers forward
    public void questionNine(View view) {
        if (userAnswer8 != null) {
            Intent question9 = new Intent(getApplicationContext(), Question9.class);
            question9.putExtra("q8Answer", userAnswer8);
            question9.putExtra("q7Answer", userAnswer7);
            question9.putExtra("q6Answer", userAnswer6);
            question9.putExtra("q5Answer", userAnswer5);
            question9.putExtra("q4Answer", userAnswer4);
            question9.putExtra("q3Answer", userAnswer3);
            question9.putExtra("q2Answer", userAnswer2);
            question9.putExtra("q1Answer", userAnswer1);
            startActivity(question9);
        } else {
            Toast.makeText(this, "Please enter an answer", Toast.LENGTH_SHORT).show();
        }
    }

    /*
    Navigates the user to the previous question and passes all answers before the previous question backwards.
     This is done so it essentially starts the last activity as if navigating to it for the first time
     and allows the variable for the previous screen to be reset to a null value*/
    public void backButton(View view) {
        Intent backButton = new Intent(getApplicationContext(), Question7.class);
        backButton.putExtra("q6Answer", userAnswer6);
        backButton.putExtra("q5Answer", userAnswer5);
        backButton.putExtra("q4Answer", userAnswer4);
        backButton.putExtra("q3Answer", userAnswer3);
        backButton.putExtra("q2Answer", userAnswer2);
        backButton.putExtra("q1Answer", userAnswer1);
        startActivity(backButton);
    }


}
