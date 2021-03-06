package com.academy.softserve.chenchak;

import com.academy.softserve.main.Algorithm;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * This class for task "Inserting row".
 */
public class InsertingRow implements Algorithm {

    /**
     * This method find index uses your number and print number.
     *
     * @param bufferedReader This value can read and save users array in
     *                       another value.
     */
    @Override
    public void start(final BufferedReader bufferedReader) {
        try {
            System.out.println("Please, input sequence of integer number:");
            String seqOfNumber = bufferedReader.readLine();
            String result;
            int[] array = convertStringToArrayOfIntegers(seqOfNumber);
            System.out.println("Plese, input number:");
            int num = Integer.parseInt(bufferedReader.readLine());
            if (num >= 0) {
                result = findRow(num, array);
            } else {
                System.out.println("Number must be > 0");
                start(bufferedReader);
            }

        } catch (IOException | NumberFormatException e) {
            start(bufferedReader);

        }
    }


    /**
     * This method find index uses your number.
     *
     * @param number     This is your number.
     * @param inputArray this is array when we search number.
     * @return result this is your finded index.
     */
    public String findRow(final int number, final int[] inputArray) {
        boolean check = false;
        String result = "Your number index: ";
        for (int i = 0; i < inputArray.length; i++) {
            if (number == inputArray[i]) {
                result += i + " ";
                check = true;
                break;
            }
        }
        if (!check) {
            result += "Not found this index!";
        }
        return result;
    }

    /**
     * Method convert input string to array of integers.
     *
     * @param inputString input string from user
     * @return array of integers
     */
    private int[] convertStringToArrayOfIntegers(final String inputString) {
        String[] arrayOfString = inputString.split(" ");
        int[] arrayOfIntegers = new int[arrayOfString.length];
        for (int i = 0; i < arrayOfIntegers.length; i++) {
            arrayOfIntegers[i] = Integer.parseInt(arrayOfString[i]);
        }
        return arrayOfIntegers;
    }

    /**
     * @return class name.
     */
    @Override
    public String toString() {
        return "InsertingRow";
    }
}
