package com.example.android.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;


public class Results extends AppCompatActivity {

    //score variable
    float score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        //Gets user score that was calculated when the results page button was pressed
        score = getIntent().getFloatExtra("points", score);
        //Inserts the score and runs the userScore function to generate the results text
        userScore(score);
    }

    //allows the user to restart the quiz from scratch
    public void restartQuiz(View view) {
        Intent restartQuiz = new Intent(getApplicationContext(), Question1.class);
        startActivity(restartQuiz);
    }

    //exits the user to the main menu
    public void exitToMain(View view) {
        Intent exitToMain = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(exitToMain);
    }

    //Figures out the user score
    public float displayScore(float score) {
        score = Math.round(score / 10f * 100f);
        return score;
    }

    //Displays a message based on the user score
    public void userScore(float score) {
        String message;
        //Finds the appropriate text views in order to set text later
        TextView userScore = findViewById(R.id.yourScore);
        TextView userMessage = findViewById(R.id.messageView);
        //Final score variable derived from displayScore
        int finalScore = (Math.round(displayScore(score)));
        //if statements to determine message to be displayed based on finalScore
        if (finalScore == 100) {
            message = "Wow!! \nAre you Stan Lee?";
        } else if (finalScore == 90) {
            message = "You're amazing!!";
        } else if (finalScore == 80) {
            message = "Impressive!!";
        } else if (finalScore == 70) {
            message = "You're a regular \ncomic book junkie!";
        } else if (finalScore == 60) {
            message = "Still a majority!!";
        } else if (finalScore == 50) {
            message = "Solid for the \ncasual reader";
        } else if (finalScore == 40) {
            message = "Just a fan of \nthe movies?";
        } else if (finalScore == 30) {
            message = "DC Universe?";
        } else if (finalScore == 20) {
            message = "A couple good guesses?";
        } else if (finalScore == 10) {
            message = "Did you even try?";
        } else if (finalScore == 0) {
            message = "Have you heard of Marvel?";
        } else {
            message = "What did you do?";
        }
        //sets the text for the views
        userScore.setText((finalScore) + "%");
        userMessage.setText(message);
    }

}
