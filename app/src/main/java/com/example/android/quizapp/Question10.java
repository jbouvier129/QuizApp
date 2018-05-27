package com.example.android.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class Question10 extends AppCompatActivity {

    //Previous user answers
    String userAnswer1;
    String userAnswer2;
    String userAnswer3;
    String userAnswer4;
    String userAnswer5;
    String userAnswer6;
    String userAnswer7;
    String userAnswer8;
    String userAnswer9;
    //Variables to determine user input
    boolean userSelection1;
    boolean userSelection2;
    boolean userSelection3;
    boolean userSelection4;
    //Variable to determine user score
    float score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question10);
        //Gets all previous answers
        userAnswer1 = getIntent().getStringExtra("q1Answer");
        userAnswer2 = getIntent().getStringExtra("q2Answer");
        userAnswer3 = getIntent().getStringExtra("q3Answer");
        userAnswer4 = getIntent().getStringExtra("q4Answer");
        userAnswer5 = getIntent().getStringExtra("q5Answer");
        userAnswer6 = getIntent().getStringExtra("q6Answer");
        userAnswer7 = getIntent().getStringExtra("q7Answer");
        userAnswer8 = getIntent().getStringExtra("q8Answer");
        userAnswer9 = getIntent().getStringExtra("q9Answer");
    }

    //Determines user selections and stores them in a variable if checked
    public void userAnswer(View view) {
        CheckBox box1Checked = findViewById(R.id.box1);
        CheckBox box2Checked = findViewById(R.id.box2);
        CheckBox box3Checked = findViewById(R.id.box3);
        CheckBox box4Checked = findViewById(R.id.box4);
        userSelection1 = box1Checked.isChecked();
        userSelection2 = box2Checked.isChecked();
        userSelection3 = box3Checked.isChecked();
        userSelection4 = box4Checked.isChecked();
    }

    //Determines user score
    public void userScore() {
        //variables used to calculate score. Value determined based on correct user input for each question
        float q1Score;
        float q2Score;
        float q3Score;
        float q4Score;
        float q5Score;
        float q6Score;
        float q7Score;
        float q8Score;
        float q9Score;
        float q10Score;

        //If statements to determine whether the user answered the questions correctly.
        if (userAnswer1.equalsIgnoreCase("d")) {
            q1Score = 1;
        } else {
            q1Score = 0;
        }
        if (userAnswer2.equalsIgnoreCase("a")) {
            q2Score = 1;
        } else {
            q2Score = 0;
        }
        if (userAnswer3.equalsIgnoreCase("a")) {
            q3Score = 1;
        } else {
            q3Score = 0;
        }
        if (userAnswer4.equalsIgnoreCase("d")) {
            q4Score = 1;
        } else {
            q4Score = 0;
        }
        if (userAnswer5.equalsIgnoreCase("json") || userAnswer5.equalsIgnoreCase("j-son") || userAnswer5.equalsIgnoreCase("j'son")) {
            q5Score = 1;
        } else {
            q5Score = 0;
        }
        if (userAnswer6.equalsIgnoreCase("c")) {
            q6Score = 1;
        } else {
            q6Score = 0;
        }
        if (userAnswer7.equalsIgnoreCase("a")) {
            q7Score = 1;
        } else {
            q7Score = 0;
        }
        if (userAnswer8.equalsIgnoreCase("b")) {
            q8Score = 1;
        } else {
            q8Score = 0;
        }
        if (userAnswer9.equalsIgnoreCase("b")) {
            q9Score = 1;
        } else {
            q9Score = 0;
        }
        if (!userSelection1 && userSelection2 && !userSelection3 && userSelection4) {
            q10Score = 1;
        } else {
            q10Score = 0;
        }
        //uses the score from each question to calculate the total score
        score = q1Score + q2Score + q3Score + q4Score + q5Score + q6Score + q7Score + q8Score + q9Score + q10Score;
    }

    //navigates the user to the results page, passing forward the score and generating a toast message
    public void resultsPage(View view) {
        if (!userSelection1 && !userSelection2 && !userSelection3 && !userSelection4) {
            Toast.makeText(this, "Please enter an answer", Toast.LENGTH_SHORT).show();
        } else {
            userScore();
            Intent resultsPage = new Intent(getApplicationContext(), Results.class);
            resultsPage.putExtra("points", score);
            Toast.makeText(this, "You scored a " + (score * 10) + "%", Toast.LENGTH_SHORT).show();
            startActivity(resultsPage);
        }
    }


    /*
    Navigates the user to the previous question and passes all answers before the previous question backwards.
     This is done so it essentially starts the last activity as if navigating to it for the first time
     and allows the variable for the previous screen to be reset to a null value*/
    public void backButton(View view) {
        Intent backButton = new Intent(getApplicationContext(), Question9.class);
        backButton.putExtra("q8Answer", userAnswer8);
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
