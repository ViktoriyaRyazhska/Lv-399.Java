package com.academy.softserve.levytskyi;



import com.academy.softserve.main.Algorithm;

import java.io.BufferedReader;
import java.util.Arrays;

/**
 * This class sort`s array of numbers using counting sort.
 */
public class CountingSort implements Algorithm {
    /**
     * max integer value.
     */
    private static final int MAX_VALUE = 256;
    /**
     * array of numbers.
     */
    private static int[] numSequence;

    /**
     * @param newNumSequence is not sorted array.
     */
    private void sort(final int[] newNumSequence) {
        int n = newNumSequence.length;
        int[] output = new int[newNumSequence.length];
        int[] count = new int[MAX_VALUE];
        for (int i = 0; i < MAX_VALUE; ++i) {
            count[i] = 0;
        }
        for (int i1 : newNumSequence) {
            ++count[i1];
        }
        for (int i = 1; i <= MAX_VALUE - 1; ++i) {
            count[i] += count[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            output[count[newNumSequence[i]] - 1] = newNumSequence[i];
            --count[newNumSequence[i]];
        }
        System.arraycopy(output, 0, newNumSequence, 0, n);
    }

    /**
     * @param bufferedReader input array.
     */
    @Override
    public void start(final BufferedReader bufferedReader) {
        try {
            System.out.println("To finish tap the Enter\n"
                    + "Enter positive elements dividing them by spaces: ");
            setNumSequence(bufferedReader.readLine());
            sort(numSequence);
            Arrays.stream(numSequence).forEach(value ->
                    System.out.print(value + " "));
        } catch (Exception e) {
            System.out.println("Invalid data type "
                    + "\n Try to write one more time \n");
            start(bufferedReader);
        }
    }

    /**
     * @param newNumSequence array of numbers
     */
    private int[] setNumSequence(final String newNumSequence) {
        String[] integerStrings = newNumSequence.split(" ");
        CountingSort.numSequence = new int[integerStrings.length];
        for (int i = 0; i < CountingSort.numSequence.length; i++) {
            CountingSort.numSequence[i] = Integer.parseInt(integerStrings[i]);
        }
        return numSequence;
    }

    /**
     * @return class name
     */
    @Override
    public String toString() {
        return "CountingSort";
    }
}