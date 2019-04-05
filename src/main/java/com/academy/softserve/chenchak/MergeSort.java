package com.academy.softserve.chenchak;


import com.academy.softserve.main.java.main.Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * This class for task "Merge Sort".
 */
public class MergeSort implements Algorithm {

    /**
     * This is for input numbers from keyboard.
     */
    private int[] numSequence;

    /**
     * @param arr array
     * @param l   length
     * @param m   middle index in array.
     * @param r   r
     */
    void merge(final int[] arr, final int l, final int m, final int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int[] l1 = new int[n1];
        int[] r1 = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i) {
            l1[i] = arr[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            r1[j] = arr[m + 1 + j];
        }


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (l1[i] <= r1[j]) {
                arr[k] = l1[i];
                i++;
            } else {
                arr[k] = r1[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = l1[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = r1[j];
            j++;
            k++;
        }
    }

    /**
     * @param arr It`s array.
     * @param l   It`s array length.
     * @param r   r
     */
    void sort(final int[] arr, final int l, final int r) {
        if (l < r) {
            // Find the middle point
            int m = (l + r) / 2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    /**
     * @param newNumSequence This method for input number.
     */
    public void setNumSequence(final String newNumSequence) {
        String[] integerStrings = newNumSequence.split(" ");
        this.numSequence = new int[integerStrings.length];
        for (int i = 0; i < this.numSequence.length; i++) {
            this.numSequence[i] = Integer.parseInt(integerStrings[i]);
        }
    }

    /**
     * Read number from keyboard, and save.
     */
    public void input() {
        System.out.println("Please, input sequence of integer number:");
        String seqOfNumber = "";
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        try {
            seqOfNumber = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        setNumSequence(seqOfNumber);

    }

    /**
     * This method uses merge sort. Prints your given array, then sorts.
     *
     * @param bufferedReader This value can read and save users array in
     *                       another value.
     */
    @Override
    public void start(final BufferedReader bufferedReader) {
        input();
        System.out.println("Given Array");
        Arrays.stream(numSequence).
                forEach(value -> System.out.print(value + " "));

        sort(numSequence, 0, numSequence.length - 1);

        System.out.println("\nSorted array");
        Arrays.stream(numSequence).
                forEach(value -> System.out.print(value + " "));
    }

    /**
     * @return class name.
     */
    @Override
    public String toString() {
        return "MergeSort";
    }
}
