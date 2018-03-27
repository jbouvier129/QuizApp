package com.example.android.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;


public class Results extends AppCompatActivity {

    float score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        score = getIntent().getFloatExtra("points", score);
        userScore(score);
    }

    public void restartQuiz(View view) {
        Intent restartQuiz = new Intent(getApplicationContext(), Question1.class);
        startActivity(restartQuiz);
    }

    public void exitToMain(View view) {
        Intent exitToMain = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(exitToMain);
    }

    public float displayScore(float score) {
        score = Math.round(score / 6f * 100f);
        return score;
    }

    public void userScore(float score) {
        String message;
        TextView userScore = findViewById(R.id.yourScore);
        TextView userMessage = findViewById(R.id.messageView);
        int finalScore = (Math.round(displayScore(score)));
        if (finalScore == 100) {
            message = "GREAT JOB!!";
        } else if (finalScore == 83) {
            message = "ALMOST!";
        } else if (finalScore == 67) {
            message = "COME ON NOW. \n YOU CAN DO BETTER!";
        } else if (finalScore == 50) {
            message = "HALF WAY THERE!!";
        } else if (finalScore == 33) {
            message = "REALLY??";
        } else if (finalScore == 17) {
            message = "DID YOU EVEN TRY??";
        } else if (finalScore == 0) {
            message = "NOT EVEN ONE?!?!";
        } else {
            message = "WHAT DID YOU DO??";
        }
        userScore.setText((finalScore) + "%");
        userMessage.setText(message);


    }

}
