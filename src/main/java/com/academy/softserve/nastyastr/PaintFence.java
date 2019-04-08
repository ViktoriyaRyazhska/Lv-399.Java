package com.academy.softserve.nastyastr;

import com.academy.softserve.main.Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * class to sum an array of numbers to a given number.
 */
public class PaintFence implements Algorithm {

    /**
     * @param mod variable - maximum value
     */
    private final int mod = 1000000007;
    /**
     * @param k number of colours
     */
    private int k;
    /**
     * @param n number of posts
     */
    private int n;

    /**
     * @param bufferedReader for reading user input
     */
    @Override
    public void start(final BufferedReader bufferedReader) {
        System.out.println("Enter numbers of posts: ");
        try {
            n = Integer.parseInt(bufferedReader.readLine());
            System.out.println("Enter numbers of colors: ");
            k = Integer.parseInt(bufferedReader.readLine());
        } catch (NumberFormatException e) {
            System.out.println("Error in entering!!!");
        } catch (IOException io) {
            io.printStackTrace();
        }
        long[] dp = new long[n + 1];
        Arrays.fill(dp, 0);
        dp[1] = k;
        int same = 0;
        int diff = k;
        for (int i = 2; i <= n; i++) {
            same = diff;
            diff = (int) (dp[i - 1] * (k - 1));
            diff = diff % mod;
            dp[i] = (same + diff) % mod;
        }
        System.out.println(n
                + " posts can be painted in "
                + k + " colours in " + dp[n] + " ways");
    }

    /**
     * @return naming of class .
     */
    @Override
    public String toString() {
        return "This is paint fence algorithm:"
                + "\nFirst - you have to enter number of posts"
                + " then -  number of colors!";
    }
}
