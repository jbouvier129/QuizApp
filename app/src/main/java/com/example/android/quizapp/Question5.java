package com.example.android.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Question5 extends AppCompatActivity {

    //previous answers
    String userAnswer1;
    String userAnswer2;
    String userAnswer3;
    String userAnswer4;
    //variable to store the user answer
    String userAnswer5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question5);
        //Gets all previous user answers
        userAnswer1 = getIntent().getStringExtra("q1Answer");
        userAnswer2 = getIntent().getStringExtra("q2Answer");
        userAnswer3 = getIntent().getStringExtra("q3Answer");
        userAnswer4 = getIntent().getStringExtra("q4Answer");
    }

    //Gets the user input and stores it in a variable
    public String userAnswer() {
        EditText answer5 = findViewById(R.id.userText);
        userAnswer5 = answer5.getText().toString().trim();
        return userAnswer5;

    }

    //Starts the next activity and passes all previous answers forward
    public void questionSix(View view) {
        userAnswer();
        if (userAnswer5.isEmpty()) {
            Toast.makeText(this, "Please enter an answer", Toast.LENGTH_SHORT).show();
        } else {
            Intent question6 = new Intent(getApplicationContext(), Question6.class);
            question6.putExtra("q5Answer", userAnswer5);
            question6.putExtra("q4Answer", userAnswer4);
            question6.putExtra("q3Answer", userAnswer3);
            question6.putExtra("q2Answer", userAnswer2);
            question6.putExtra("q1Answer", userAnswer1);
            startActivity(question6);
        }
    }

    /*
    Navigates the user to the previous question and passes all answers before the previous question backwards.
     This is done so it essentially starts the last activity as if navigating to it for the first time
     and allows the variable for the previous screen to be reset to a null value*/
    public void backButton(View view) {
        Intent backButton = new Intent(getApplicationContext(), Question4.class);
        backButton.putExtra("q3Answer", userAnswer3);
        backButton.putExtra("q2Answer", userAnswer2);
        backButton.putExtra("q1Answer", userAnswer1);
        startActivity(backButton);
    }
}
