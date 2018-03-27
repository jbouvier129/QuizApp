package com.example.android.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;

public class Question6 extends AppCompatActivity {

    float score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question6);
        score = getIntent().getFloatExtra("points", score);
    }

    public void userAnswer(View view) {
        CheckBox box2Checked = findViewById(R.id.box2);
        CheckBox box4Checked = findViewById(R.id.box4);

        if (box2Checked.isChecked() && box4Checked.isChecked()) {
            score = score + 1f;
        }
    }

    public void resultsPage(View view) {
        Intent resultsPage = new Intent(getApplicationContext(), Results.class);
        resultsPage.putExtra("points", score);
        startActivity(resultsPage);
    }

    public void backButton(View view) {
        Intent backButton = new Intent(getApplicationContext(), Question5.class);
        backButton.putExtra("points", score);
        startActivity(backButton);
    }
}
