package com.academy.softserve.silich;

import com.academy.softserve.main.Algorithm;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author Oleksandr
 */
public class WaysToCover implements Algorithm {
    /**
     * INITIAL is array which contain unique values.
     */
    private static final int[] INITIAL = {1, 2, 4};
    /**
     * LIMITATION is value which point to limit.
     */
    private static final int LIMITATION = 4;
    /**
     * THREE is value which point to 3.
     */
    private static final int THREE = 3;


    /**
     * @param n input param
     * @return return integer value
     */
    private Integer coverWays(final Integer n) {

        if (n < LIMITATION) {
            return INITIAL[n - 1];
        } else {
            return coverWays(n - 1) + coverWays(n - 2) + coverWays(n - THREE);
        }
    }

    /**
     * @param reader has type of BufferedReader
     */
    @Override
    public void start(final BufferedReader reader) {
        Integer number = parseToInt(reader);
        System.out.println("Ways to cover: ");
        System.out.println(coverWays(number));
    }

    /**
     * @param reader has type of BufferedReader
     * @return Integer value
     */
    private Integer parseToInt(final BufferedReader reader) {
        Integer number = 0;
        String inputString = "";
        try {
            System.out.println("Input number which you want to decompose:");
            inputString = reader.readLine();
            number = Integer.parseInt(inputString);
        } catch (IOException e) {
            System.out.println("IO Exception!!!");
            number = parseToInt(reader);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException!!!");
            number = parseToInt(reader);
        }
        return number;
    }

    /**
     * This function describe algorithm.
     */
    private void menu() {
        System.out.println("Algorithm: ways to cover in 3 steps");
        System.out.println("This function count ways to "
                + "decompose any number 1, 2 or 3");
    }

    /**
     * @return name of function
     */
    @Override
    public String toString() {
        return "Ways to cover";
    }
}
