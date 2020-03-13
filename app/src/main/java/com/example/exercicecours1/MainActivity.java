package com.example.exercicecours1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final int Max = 10;
    private GuessNumber guessNumber;

    private EditText inputNumber;
    private EditText inputNumber2;
    private Button buttonTry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputNumber =  findViewById(R.id.editText_guessedNumber);
        inputNumber2 =  findViewById(R.id.editText_guessedNumber2);
        buttonTry = findViewById(R.id.button_trynumber);

        guessNumber = new GuessNumber(Max);
        setListenner();
    }

    private void setListenner() {
        buttonTry.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                guess();
            }
        });
    }

    private void guess()
    {
        int numberToGuess = Integer.parseInt(inputNumber.getText().toString());
        int numberToGuess2 = Integer.parseInt(inputNumber2.getText().toString());
        GuessNumber.guessState result = guessNumber.testNumber(numberToGuess,numberToGuess2);

        if (result == GuessNumber.guessState.BIGGER){
            inputNumber.setBackgroundColor(Color.RED);
            inputNumber2.setBackgroundColor(Color.TRANSPARENT);
        }else if (result == GuessNumber.guessState.SMALLER) {
            inputNumber.setBackgroundColor(Color.TRANSPARENT);
            inputNumber2.setBackgroundColor(Color.RED);
        } else  {
            inputNumber.back
           // inputNumber.setBackgroundColor(Color.TRANSPARENT);
            inputNumber2.setBackgroundColor(Color.TRANSPARENT);
        }
    }

    private  void showHint(String hint)
    {
        Toast.makeText(this, hint, Toast.LENGTH_SHORT).show();
    }

}
