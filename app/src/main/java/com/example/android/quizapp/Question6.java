package com.example.android.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;

public class Question6 extends AppCompatActivity {

    String userAnswer1;
    String userAnswer2;
    String userAnswer3;
    String userAnswer4;
    String userAnswer5;
    boolean userSelection1;
    boolean userSelection2;
    boolean userSelection3;
    boolean userSelection4;
    float score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question6);
        userAnswer1 = getIntent().getStringExtra("q1Answer");
        userAnswer2 = getIntent().getStringExtra("q2Answer");
        userAnswer3 = getIntent().getStringExtra("q3Answer");
        userAnswer4 = getIntent().getStringExtra("q4Answer");
        userAnswer5 = getIntent().getStringExtra("q5Answer");
    }

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

    public float userScore() {
        float q1Score;
        float q2Score;
        float q3Score;
        float q4Score;
        float q5Score;
        float q6Score;

        if (userAnswer1.equalsIgnoreCase("b")) {
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
        if (userAnswer4.equalsIgnoreCase("c")) {
            q4Score = 1;
        } else {
            q4Score = 0;
        }
        if (userAnswer5.equalsIgnoreCase("ostrich")) {
            q5Score = 1;
        } else {
            q5Score = 0;
        }
        if (userSelection2 && userSelection4) {
            q6Score = 1;
        } else {
            q6Score = 0;
        }
        score = q1Score + q2Score + q3Score + q4Score + q5Score + q6Score;
        return score;
    }

    public void resultsPage(View view) {
        userScore();
        Intent resultsPage = new Intent(getApplicationContext(), Results.class);
        resultsPage.putExtra("points", score);
        startActivity(resultsPage);
    }

    public void backButton(View view) {
        Intent backButton = new Intent(getApplicationContext(), Question5.class);
        backButton.putExtra("q4Answer", userAnswer4);
        backButton.putExtra("q3Answer", userAnswer3);
        backButton.putExtra("q2Answer", userAnswer2);
        backButton.putExtra("q1Answer", userAnswer1);
        startActivity(backButton);
    }
}
