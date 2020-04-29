package com.example.demoapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int answer = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Random rand = new Random();
        answer = rand.nextInt(20) + 1;
    }

    public void guessSubmitted (View view) {

        EditText guessEditText = findViewById(R.id.guessEditText);

        int guess = Integer.parseInt(guessEditText.getText().toString());

        if (guess > answer) {
                createToast("Lower");
            }
        else if (guess < answer) {
                createToast("Higher");
        }
        else {
            createToast("Thats the one! Go again");
            Random rand = new Random();
            answer = rand.nextInt(20) +1;
        }
    }

    public void createToast(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}