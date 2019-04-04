package dynamicProgramming;

// Program to find the number of ways,
// n can be written as sum of two or
// more positive integers.

import java.util.Arrays;

class WaysToWrite_n_asSumOriginal {

    // Returns number of ways to write
    // n as sum of two or more positive
    // integers
    static long countWays(int n) {

        // table[i] will be storing the
        // number of solutions for value
        // i. We need n+1 rows as the
        // table is consturcted in bottom
        // up manner using the base case
        // (n = 0)
        long table[] = new long[n + 1];

        // Initialize all table values as 0
        Arrays.fill(table, 0);

        // Base case (If given value is 0)
        table[0] = 1;

        // Pick all integer one by one and
        // update the table[] values after
        // the index greater than or equal
        // to n
        for (int i = 1; i < n; i++)
            for (int j = i; j <= n; j++)
                table[j] += table[j - i];

        return table[n];
    }

    //driver code
    public static void main(String[] args) {
        int n = 200;

        System.out.print(countWays(n));
    }
}

// This code is contributed by Anant Agarwal.

