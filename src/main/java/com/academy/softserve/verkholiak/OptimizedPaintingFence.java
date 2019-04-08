package com.academy.softserve.verkholiak;

import com.academy.softserve.main.java.main.Algorithm;
import java.io.BufferedReader;

/**
 * Class which calculate combination of painting fence.
 */
public class OptimizedPaintingFence implements Algorithm {

    /**
     * @param n Integer quantity of posts
     * @param k Integer quantity of colors
     * @return Returns count of ways to color k posts using k colors
     */
    private static long countWays(final int n, final int k) {

        long total = k;
        long diff = k;
        long same;

        for (int i = 2; i <= n; i++) {

            same = diff;

            diff = total * (k - 1);

            total = same + diff;
        }

        return total;
    }

    /**
     * @param bufferedReader Reads text from a character-input stream
     */
    @Override
    public void start(final BufferedReader bufferedReader) {
        System.out.println("Given a fence with n posts and k colors,\n"
                + "find out the number of ways of painting the fence "
                + "such that at most 2 adjacent posts have the same color. ");
        System.out.println("Enter n ");

        int n;
        int k;

        try {
            n = Integer.parseInt(bufferedReader.readLine());
            System.out.println("Enter k ");
            k = Integer.parseInt(bufferedReader.readLine());
            if ((n > 1) && (k > 1)) {
                System.out.println("There are " + countWays(n, k)
                        + " ways of painting the fence");
            } else {
                System.out.println("Numbers must be bigger than one");
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
        return "Optimized painting fence: use one variable instead of a table";
    }
}
