/*
  Open source project
  2019
 */
package com.academy.softserve.narepeha;

import com.academy.softserve.main.Algorithm;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * The class represents a high and low effort task
 * You can launch it by calling the method start().
 *
 * @author Dima Narepeha
 */
public class LowAndHighEffort implements Algorithm {
    /**
     * default menu to be shown to the user while starting.
     */
    private void printMenu() {
        System.out.println("1.Enter an amount of days and hit enter\n"
                + "2.Enter low effort work and "
                + "high effort work for each day respectively"
                + " separated by space and after each pair hit enter\n");
    }

    /**
     * returns input from user.
     *
     * @param bufferedReader reader the input to be read from
     * @return int[][] result
     */
    private int[][] getInput(final BufferedReader bufferedReader) {
        int[][] result;
        try {
            int sizeOfInput = Integer.parseInt(bufferedReader.readLine());
            String[] input;
            if (sizeOfInput < 0) {
                throw new NumberFormatException();
            }
            result = new int[2][sizeOfInput+1]; //+1 because thus we don`t get IndexOutOfBound in Future
            for (int i = 0; i < sizeOfInput; i++) {
                input = bufferedReader
                        .readLine().split("\\s"); //separate by space
                result[0][i] = Integer.parseInt(input[0]); //lowEffortWork
                result[1][i] = Integer.parseInt(input[1]); //highEffortWork
            }

        } catch (IOException | NumberFormatException e) {
            System.out.println("Invalid input");
            result = new int[2][1];
        }
        return result;
    }

    /**
     * Compute result by adding efforts together by an algorithm.
     *
     * @param input the array that represents high and
     *              low effort pairs for each day
     * @return int the total sum of effort
     */
    private int computeResult(final int[][] input) {
        int result = 0;
        result += input[1][0]; //add first high effort element
        for (int i = 1;
             i < input[0].length;
             i++) { //and all others low effort elements
            result += input[0][i];
        }
        return result;
    }

    /**
     * prints the total sum of effort.
     *
     * @param result total sum
     */
    private void printOutputFor(final int result) {
        System.out.println("Total effort: " + result);
    }

    /**
     * @return String that represents the class info
     */
    @Override
    public String toString() {
        return "Low and high effort";
    }

    /**
     * Starts the class and interacts with the user.
     *
     * @param bufferedReader input is read through this reader
     */
    @Override
    public void start(final BufferedReader bufferedReader) {
        printMenu();
        int[][] input = getInput(bufferedReader);
        int result = computeResult(input);
        printOutputFor(result);
    }
}
