/*
  Open source project
  2019
 */

package narepeha;


import main.java.main.Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * The class represents QuickSort algorithm
 * You can launch it by calling the method start().
 *
 * @author Dima Narepeha
 */
public class QuickSort implements Algorithm {
    /**
     * default menu to be shown to the user while starting.
     */
    private void printMenu() {
        System.out.println("Enter an Array separated by space "
                + "to be sorted and press enter: ");
    }

    /**
     * returns input from user.
     *
     * @param bufferedReader reader the input to be read from
     * @return int[] result
     */
    private int[] getInput(final BufferedReader bufferedReader) {
        int[] result;
        try {
            String[] input;
            input = bufferedReader.readLine().split("\\s"); //separate by space
            result = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                result[i] = Integer.parseInt(input[i]);
            }
        } catch (IOException | NumberFormatException e) {
            result = new int[1];
            System.out.println("Invalid input");
        }
        return result;
    }

    /**
     * prints the sorted array.
     *
     * @param index of element
     */
    private void printOutputFor(final int[] index) {
        System.out.println("Sorted array: " + Arrays.toString(index));
    }

    /**
     * Sorts an array by using quick sort algorithm.
     *
     * @param arr   array to be sorted
     * @param start first index of current range
     * @param end   last index of current range
     */
    private static void quickSort(final int[] arr,
                                  final int start,
                                  final int end) {

        int partition = partition(arr, start, end);

        if (partition - 1 > start) {
            quickSort(arr, start, partition - 1);
        }
        if (partition + 1 < end) {
            quickSort(arr, partition + 1, end);
        }
    }

    /**
     * Founds a pivot in the presented array.
     *
     * @param arr   array to be sorted
     * @param start first index of current rangert
     * @param end   last index of current range
     * @return int pivot
     */
    private static int partition(final int[] arr,
                                 final int start,
                                 final int end) {
        int pivot = arr[end];
        int localStart = start;
        for (int i = localStart; i < end; i++) {
            if (arr[i] < pivot) {
                int temp = arr[localStart];
                arr[localStart] = arr[i];
                arr[i] = temp;
                localStart++;
            }
        }

        int temp = arr[localStart];
        arr[localStart] = pivot;
        arr[end] = temp;

        return localStart;
    }

    /**
     * @return String that represents the class info
     */
    @Override
    public String toString() {
        return "QuickSort algorithm";
    }

    /**
     * Starts the class and interacts with the user.
     *
     * @param bufferedReader input is read through this reader
     */
    @Override
    public void start(final BufferedReader bufferedReader) {
        printMenu();
        int[] index = getInput(bufferedReader);
        quickSort(index, 0, index.length - 1);
        printOutputFor(index);
    }
}
