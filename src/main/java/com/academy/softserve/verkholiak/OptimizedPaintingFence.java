package com.academy.softserve.verkholiak;

import com.academy.softserve.main.Algorithm;

import java.io.BufferedReader;

/**
 * Class which calculate combination of painting fence.
 */
public class OptimizedPaintingFence implements Algorithm {
    /**
     *n - number of posts.
     */
    private int n;
    /**
     * k - number of colours.
     */
    private int k;

    /**
     * @return long - ways to paint the fence
     */
    public long countWays() {
        if ((n < 1) || (k < 1)) {
            return -1;
        }
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
        System.out.println("Enter posts ");

      /*  int n;
        int k;*/

        try {
            String posts = bufferedReader.readLine();
            System.out.println("Enter colours ");
            String colours = bufferedReader.readLine();
            input(posts, colours);
            long ways = countWays();
            if (ways != -1) {
                System.out.println("There are " + countWays()
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
     * @param posts posts to colour
     * @param colours number of colours for colouring posts
     * @throws Exception throws exception in case of wrong input
     */
    public void input(final String posts,
                      final String colours) throws Exception {
        try {
            n = Integer.parseInt(posts);
            k = Integer.parseInt(colours);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * @param posts set number of posts
     */
    public void setN(final int posts) {
        this.n = posts;
    }

    /**
     * @param colours set number of colours
     */
    public void setK(final int colours) {
        this.k = colours;
    }

    /**
     * @return The string of information
     */
    @Override
    public String toString() {
        return "Optimized painting fence";
    }
}

