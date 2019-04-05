package com.academy.softserve.verkholiak;

import com.academy.softserve.main.java.main.Algorithm;
import java.io.BufferedReader;
import java.util.Arrays;

/**
 * Calculate how many ways to write n
 * as sum of two or more positive integers.
 */
public class WaysToWriteNAsSum implements Algorithm {

    /**
     * @param n The positive variable type integer
     * @return The variable type long
     */
    private static long countWays(final int n) {

        long[] table = new long[n + 1];

        Arrays.fill(table, 0);

        table[0] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = i; j <= n; j++) {
                table[j] += table[j - i];
            }
        }

        return table[n];
    }

    /**
     * @param bufferedReader Reads text from a character-input stream
     */
    @Override
    public void start(final BufferedReader bufferedReader) {
        System.out.println("To find in how many ways is possible "
                + "to calculate n with positive integers.");
        System.out.println("Enter n ");
        int n;
        try {
            n = Integer.parseInt(bufferedReader.readLine());
            if (n > 0) {
                System.out.print("There are " + countWays(n) + " ways");
            } else {
                System.out.println("Number must be bigger than zero");
                start(bufferedReader);
            }
        } catch (Exception e) {
            System.out.println("Invalid data type \n"
                    + "Try to write one more time \n");
            start(bufferedReader);
        }
    }

    /**
     * @return The string of information
     */
    @Override
    public String toString() {
        return "Ways to write n as sum of two or more positive integers";
    }
}
