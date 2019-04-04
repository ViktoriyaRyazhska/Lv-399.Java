
package nastyastr;

import main.Algorithm;

import java.io.BufferedReader;
import java.io.IOException;


/**
 * class to sum an array of numbers to a given number.
 */
public class PaintFence implements Algorithm {

    /**
     * @param mod
     */
    private final int mod = 1000000007;
    /**
     * @param k
     */
    private int k;
    /**
     * @param n
     */
    private int n;

    /**
     * @param bufferedReader
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
        // There are k ways to color first post
        long total = k;
        // int mod = 1000000007;
        int same = 0, diff = k;
        // Fill for 2 posts onwards
        for (int i = 2; i <= n; i++) {
            // Current same is same as previous diff
            same = diff;

            // We always have k-1 choices for next post
            diff = (int) total * (k - 1);
            diff = diff % mod;

            // Total choices till i.
            total = (same + diff) % mod;
        }
        System.out.println(n
                + " posts can be painted in "
                + k + " colours in " + total + " ways");
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
