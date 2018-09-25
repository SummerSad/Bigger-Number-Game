package com.example.yoshie.biggernumbergame;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // init 2 buttons number and set Points to 0
        randomButtonNumber();
        TextView textViewPoints = findViewById(R.id.idPoints);
        textViewPoints.setText("0");
    }

    // Set 2 random number for user to choose
    private void randomButtonNumber() {
        Random rand_gen = new Random();
        int MAX = 10000;

        Button buttonLeft = findViewById(R.id.idButtonLeft);
        buttonLeft.setText(String.valueOf(rand_gen.nextInt(MAX)));

        Button buttonRight = findViewById(R.id.idButtonRight);
        buttonRight.setText(String.valueOf(rand_gen.nextInt(MAX)));

    }

    // return bigger number of 2 buttons
    private int biggerNumberButton() {
        Button buttonLeft = findViewById(R.id.idButtonLeft);
        int num_left = Integer.valueOf(buttonLeft.getText().toString());

        Button buttonRight = findViewById(R.id.idButtonRight);
        int num_right = Integer.valueOf(buttonRight.getText().toString());

        return num_left > num_right ? num_left : num_right;
    }

    // check if clicked button is bugger
    private boolean isBiggerNumber(View view) {
        Button button = findViewById(view.getId());
        int num = Integer.valueOf(button.getText().toString());

        return num == biggerNumberButton();
    }

    // add points of player
    private void addPoints(int n) {
        TextView textViewPoints = findViewById(R.id.idPoints);
        int num_points = Integer.valueOf(textViewPoints.getText().toString());
        textViewPoints.setText(String.valueOf(num_points + n));
    }

    // when player choose correctly, show good toast
    // otherwise bad toast
    private void showToast(boolean isGood) {
        Context context = getApplicationContext();
        CharSequence text = isGood ? "Good boy :)" : "Bad Boy :(";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public void clickCheckButton(View view) {
        // random 2 buttons number again and add or minus points
        if (isBiggerNumber(view) == true) {
            randomButtonNumber();
            addPoints(1);
            showToast(true);
        } else {
            randomButtonNumber();
            addPoints(-1);
            showToast(false);
        }
    }
}
