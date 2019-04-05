package com.academy.softserve.moskalyuk;


import com.academy.softserve.main.java.main.Algorithm;

import java.io.BufferedReader;
import java.io.IOException;

public class ModificationFibonacci implements Algorithm {

    private static final int THRESHOLD = 5;
    private static final Integer[] INITIAL = {1, 1, 1, 2};
    private static final String MSG = "Enter number of element:";
    private static final String ERROR_MSG = "Enter number, not letter!!!";

    @Override
    public void start(BufferedReader reader) {
        System.out.println(MSG);
        try {
            int elementNumber = Integer.parseInt(reader.readLine());
            System.out.println(fibonacci(elementNumber));
        } catch (IOException | NumberFormatException e) {
            System.out.println(ERROR_MSG);
            start(reader);
        }
    }

    private int fibonacci(int number) {
        if (number < THRESHOLD) {
            return INITIAL[number - 1];
        } else {
            return fibonacci(number - 2) + fibonacci(number - 3) + fibonacci(number - 4);
        }
    }
}
