package levytskyi;

import main.Algorithm;

import java.io.BufferedReader;
import java.io.IOException;


/**
 *
 */
public class PathsWithoutCrossing implements Algorithm {
    private static int number;

    /**
     * @param number lol
     * @return lol
     */
    private int calculateCountWays(int number) {
        int[] arr = new int[number + 1];
        arr[0] = arr[1] = 1;
        for (int i = 2; i <= number; i++) {
            arr[i] = 0;
            for (int j = 0; j < i; j++) {
                arr[i] += arr[j] * arr[i - j - 1];
            }// C4 = C0C3 + C1C2 + C2C1 + C3C0 = 1*5 + 1*2 + 2*1 + 5*1 = 14
        }
        return arr[number];
    }

    /**
     * @param number lll
     * @return
     */
    private int countWays(int number) {
        if ((number < 1) || (number % 2 != 0)) {
            return 0;
        }
        return calculateCountWays(number / 2);
    }

    /**
     * @param bufferedReader lol
     */
    @Override
    public void start(BufferedReader bufferedReader) {
        try {
            System.out.println("Enter number: ");
            try {
                number = Integer.parseInt(bufferedReader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Ways to connect: " + countWays(number));
        } catch (Exception e) {
            System.out.println("Invalid data type \n Try to write one more time \n");
            start(bufferedReader);
        }
    }

    /**
     * @return
     */
    @Override
    public String toString(){
        return "Paths Without Crossing";
    }
}