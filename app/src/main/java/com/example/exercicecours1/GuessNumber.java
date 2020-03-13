package com.example.exercicecours1;

import java.util.Random;

public class GuessNumber {
    private int currentNumber;
    private int maxNumber;
    public  enum guessState{BIGGER, EQUAL, SMALLER};


    public GuessNumber(int maxNumber)
    {
        this.maxNumber = maxNumber;
        generateNewNumber();
    }

    public  guessState testNumber(int numbeToTest, int numbertoCompare)
    {
        guessState numberState;

        if ( numbeToTest < numbertoCompare ) {
            numberState = guessState.SMALLER;
        }
        else if (numbeToTest > numbertoCompare){
                numberState = guessState.BIGGER;
        }else  {
            numberState = guessState.EQUAL;
        }
        return  numberState;
    }

    public  void generateNewNumber()
    {
        currentNumber = new Random().nextInt( maxNumber +1);
    }
}
