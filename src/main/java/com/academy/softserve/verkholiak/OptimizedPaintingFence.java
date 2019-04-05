package com.academy.softserve.verkholiak;


import com.academy.softserve.main.java.main.Algorithm;

import java.io.BufferedReader;

class OptimizedPaintingFence implements Algorithm {

    private static long countWays(int n, int k) {

        long total = k;
        int mod = 1000000007;

        int same = 0, diff = k;

        for (int i = 2; i <= n; i++) {

            same = diff;

            diff = (int) total * (k - 1);
            diff = diff % mod;

            total = (same + diff) % mod;
        }
        return total;
    }

    @Override
    public void start(BufferedReader bufferedReader) {
        System.out.println("Given a fence with n posts and k colors,\n" +
                "find out the number of ways of painting the fence such that at most 2 adjacent posts have the same color. ");
        System.out.println("Enter n ");

        int n = 0;
        int k = 0;
        try {
            n = Integer.parseInt(bufferedReader.readLine());
            System.out.println("Enter k ");
            k = Integer.parseInt(bufferedReader.readLine());
            if ((n > 0) && (k > 0)) {
                System.out.println("There are " + countWays(n, k) + " ways of painting the fence");
            } else {
                System.out.println("Numbers must be bigger than zero");
                start(bufferedReader);
            }
        } catch (Exception e) {
            System.out.println("Invalid data type \n Try to write one more time \n");
            start(bufferedReader);
        }
    }

    @Override
    public String toString() {
        return "Optimized painting fence: use one variable instead of a table";
    }
}