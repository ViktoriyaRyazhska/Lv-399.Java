package levytskyi;

import main.Algorithm;

import java.io.BufferedReader;
import java.io.IOException;


/**
 * This class is count number of ways to connect n (where n is even)
 * points on a circle such that no two connecting lines cross each
 * other and every point is connected with one other point.
 */
public class PathsWithoutCrossing implements Algorithm {
    /**
     * @param number is a number of points
     */
    private static int number;

    /**
     * @param numberOfPoints amount of points.
     * @return amount of ways to do lines without crossing.
     */
    private int calculateCountWays(final int numberOfPoints) {
        int[] arr = new int[numberOfPoints + 1];
        arr[0] = 1;
        arr[0] = arr[1];
        for (int i = 2; i <= numberOfPoints; i++) {
            arr[i] = 0;
            for (int j = 0; j < i; j++) {
                arr[i] += arr[j] * arr[i - j - 1];
            }
        }
        return arr[numberOfPoints];
    }

    /**
     * @param amountOfPoints amount of points
     * @return amount of ways
     */
    private int countWays(final int amountOfPoints) {
        if ((amountOfPoints < 1) || (amountOfPoints % 2 != 0)) {
            return 0;
        }
        return calculateCountWays(amountOfPoints / 2);
    }

    /**
     * @param bufferedReader input number of points
     */
    @Override
    public void start(final BufferedReader bufferedReader) {
        try {
            System.out.println("Enter the even number: ");
            try {
                number = Integer.parseInt(bufferedReader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Ways to connect: " + countWays(number));
        } catch (Exception e) {
            System.out.println("Invalid data type \n "
                    + "Try to write one more time \n");
            start(bufferedReader);
        }
    }

    /**
     * @return class name
     */
    @Override
    public String toString() {
        return "Paths Without Crossing";
    }
}
