/**
 * @author Illia Chenchak
 * @version 1.0
 * @since 1.0
 */
package chenchak;

import main.Algorithm;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * This class search FriendPairs.
 */
public class FriendPairs implements Algorithm {
    /**
     * @param n This is count of friend.
     * @return countFriendsPairings.
     */
    static int countFriendsPairings(final int n) {
        int[] dp = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            if (i <= 2) {
                dp[i] = i;
            } else {
                dp[i] = dp[i - 1] + (i - 1) * dp[i - 2];
            }
        }

        return dp[n];
    }

    /**
     * This method find and print your friend pairs.
     *
     * @param bufferedReader This value can read and save users array in
     *                       another value.
     */
    @Override
    public void start(final BufferedReader bufferedReader) {
        System.out.println("Enter number of friends:");
        int n = 0;
        try {
            n = Integer.parseInt(bufferedReader.readLine());
            System.out.println(FriendPairs.countFriendsPairings(n));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return name of this methods.
     */
    @Override
    public String toString() {
        return "Friend pairs";
    }
}
