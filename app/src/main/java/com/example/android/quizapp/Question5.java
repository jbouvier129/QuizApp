package com.example.android.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class Question5 extends AppCompatActivity {

    float score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question5);
        score = getIntent().getFloatExtra("points", score);
    }

    public float userAnswer() {
        EditText answer = findViewById(R.id.userText);
        String userInput = answer.getText().toString();
        if (userInput.equalsIgnoreCase("ostrich")) {
            score = score + 1f;
        }
        return score;

    }

    public void questionSix(View view) {
        userAnswer();
        Intent question6 = new Intent(getApplicationContext(), Question6.class);
        question6.putExtra("points", score);
        startActivity(question6);
    }

    public void backButton(View view) {
        Intent backButton = new Intent(getApplicationContext(), Question4.class);
        backButton.putExtra("points", score);
        startActivity(backButton);
    }
}
