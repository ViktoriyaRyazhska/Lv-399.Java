package com.academy.softserve.chenchak;


import com.academy.softserve.main.java.main.Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * This class for task "Inserting row".
 */
public class InsertingRow implements Algorithm {

    /**
     * This is for input numbers from keyboard.
     */
    private int[] numSequence;

    /**
     * @param newNumSequence This method for input number.
     */
    public void setNumSequence(final String newNumSequence) {
        String[] integerStrings = newNumSequence.split(" ");
        this.numSequence = new int[integerStrings.length];
        for (int i = 0; i < this.numSequence.length; i++) {
            this.numSequence[i] = Integer.parseInt(integerStrings[i]);
        }
    }

    /**
     * Read number from keyboard, and save.
     */
    public void input() {
        System.out.println("Please, input sequence of integer number:");
        String seqOfNumber = "";
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        try {
            seqOfNumber = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        setNumSequence(seqOfNumber);

    }

    /**
     * @param number this is number which user enter.
     * @return index.
     */
    public Integer findRow(final int number) {
        for (int i = 0; i < numSequence.length; i++) {
            if (number == numSequence[i]) {
                return i;
            }
        }

        return -1;
    }

    /**
     * This method find row uses value.
     *
     * @param bufferedReader This value can read and save users array in
     *                       another value.
     */
    @Override
    public void start(final BufferedReader bufferedReader) {
        input();

        System.out.println("Given Array");
        Arrays.stream(numSequence).
                forEach(value -> System.out.print(value + " "));
        System.out.println();

        System.out.println("Enter your number:");
        int in = 0;
        try {
            in = Integer.parseInt(bufferedReader.readLine());
            int result = findRow(in);
            if (in == -1) {
                System.out.println("Not found this element in array");
            } else {
                System.out.println("Index of this number: " + result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * @return class name.
     */
    @Override
    public String toString() {
        return "InsertingRow";
    }
}

