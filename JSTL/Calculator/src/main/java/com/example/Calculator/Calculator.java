package com.example.Calculator;

public class Calculator {
    public static float calculate(float input1, float input2, char operate) {
        switch (operate) {
            case '+':
                return input1 + input2;
            case '-':
                return input1 - input2;
            case '*':
                return input1*input2;
            case '/':
                if (input2 != 0) {
                    return input1/input2;
                } else
                    throw new RuntimeException("Can't divide by zero");
            default:
                throw new RuntimeException("Invalid operation");
                }

        }

    }

