package com.academy.softserve.moskalyuk;

import com.academy.softserve.main.Algorithm;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * This class contains methods that return longest palindrome subsequence.
 */
public class PalindromicSubSequence implements Algorithm {
    /**
     * Message for users.
     */
    private static final String ENTER_MSG = "Enter a line:";
    /**
     * Message for users.
     */
    private static final String ERROR_MSG = "You must enter string!!!";
    /**
     * Format for output message.
     */
    private static final String FORMAT_OUTPUT_MSG = "Length of palindrome is %d";

    /**
     * Method print to console size of palindrome.
     *
     * @param reader BufferRider object is the source of input data
     */
    public void start(final BufferedReader reader) {
        System.out.println(ENTER_MSG);
        try {
            String inputString = reader.readLine();
            int length = getSizeOfPalindromeSubSequence(inputString);
            System.out.println(String.format(FORMAT_OUTPUT_MSG, length));
        } catch (IOException | ArrayIndexOutOfBoundsException e) {
            System.out.println(ERROR_MSG);
            start(reader);
        }
    }

    @Override
    public String toString() {
        return "PalindromicSubSequence";
    }

    /**
     * Method return size of palindrome subsequence.
     *
     * @param inputString string from user
     * @return size of palindrome
     */
    private int getSizeOfPalindromeSubSequence(final String inputString) {
        int size = inputString.length();
        int[][] dp = new int[size][size];
        for (int i = size - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < size; j++) {
                if (inputString.charAt(i) == inputString.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][size - 1];

    }
}
