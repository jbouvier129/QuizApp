package com.example.android.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //starts the quiz app
    public void startQuiz(View view) {

        Intent question1 = new Intent(getApplicationContext(), Question1.class);
        startActivity(question1);

    }
}
