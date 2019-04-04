package chenchak;

import main.Algorithm;

import java.io.BufferedReader;
import java.io.IOException;

public class FriendPairs implements Algorithm {
    static int countFriendsPairings(int n) {
        int dp[] = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            if (i <= 2)
                dp[i] = i;
            else
                dp[i] = dp[i - 1] + (i - 1) * dp[i - 2];
        }

        return dp[n];
    }

    @Override
    public void start(BufferedReader bufferedReader) {
        System.out.println("Enter number of friends:");
        int n = 0;
        try {
            n = Integer.parseInt(bufferedReader.readLine());
            System.out.println(FriendPairs.countFriendsPairings(n));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Friend pairs";
    }
}
