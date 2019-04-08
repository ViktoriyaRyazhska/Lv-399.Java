package com.academy.softserve.nastyastr;




import com.academy.softserve.main.Algorithm;

import java.io.BufferedReader;
import java.io.IOException;

/**class to sum an array of numbers to a given number.*/
public class SumUpNumbersToArray implements Algorithm {
    /**sequence of numbers.*/
    private int[] numSequence;
    /**ways to sum up numbers.*/
    private int ways;
    /**method for parsing numbers from a given array.
     * @param sequence an array of integer numbers .*/
    public void setNumSequence(final String sequence) {
        String[] integerStrings = sequence.split(" ");
        this.numSequence = new int[integerStrings.length];
        try {
            for (int i = 0; i < this.numSequence.length; i++) {
                this.numSequence[i] = Integer.parseInt(integerStrings[i]);
            }
        } catch (NumberFormatException nb) {
            System.out.println("Error in entering!!!");
        }
    }

    /**
     * @param bufferedReader for reading user input.
     */
    public void start(final BufferedReader bufferedReader) {
        System.out.println("Please, input sequence of integer numbers:");
        String seqOfNumber = "";
        int k = 0;
        try {
            seqOfNumber = bufferedReader.readLine();
        setNumSequence(seqOfNumber);
        System.out.println("Please, input  number:");
        k = Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
            System.out.println("Error in entering!!!");
        }
        ways = countWays(k, numSequence);
        System.out.println("WAYS to sum to a number"
                + " using array elements: " + ways);

    }


    /**
     * @return naming of class .
     */
    @Override
    public String toString() {
        return "This is sum up numbers in array task"
                + "\nFirst - you have to enter an array, then - one number";
    }

    /**
     * @param n integer number to sum up to .
     * @param arr an array of integers .
     * @return number of ways.
     */
   public  int countWays(final int n, final int[] arr) {
        int[] count = new int[n + 1];
        count[0] = 1;
        // count ways for all values up to 'N' and store the result
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < arr.length; j++) {

                if (i >= arr[j]) {
                    count[i] += count[i - arr[j]];
                }
            }
        }
        return count[n];
    }
}
