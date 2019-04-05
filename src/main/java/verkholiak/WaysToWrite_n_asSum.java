package verkholiak;

import main.java.main.Algorithm;

import java.io.BufferedReader;
import java.util.Arrays;

class WaysToWrite_n_asSum implements Algorithm {

    private static long countWays(int n) {

        long table[] = new long[n + 1];

        Arrays.fill(table, 0);

        table[0] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = i; j <= n; j++) {
                table[j] += table[j - i];
            }
        }
        return table[n];
    }

    @Override
    public void start(BufferedReader bufferedReader) {
        System.out.println("To find in how many ways is possible to calculate n with positive integers.");
        System.out.println("Enter n ");
        int n = 0;
        try {
            n = Integer.parseInt(bufferedReader.readLine());
            if (n > 0) {
                System.out.print("There are " + countWays(n) + " ways");
            } else {
                System.out.println("Number must be bigger than zero");
                start(bufferedReader);
            }
        } catch (Exception e) {
            System.out.println("Invalid data type \n Try to write one more time \n");
            start(bufferedReader);
        }
    }

    @Override
    public String toString() {
        return "Ways to write n as sum of two or more positive integers";
    }
}