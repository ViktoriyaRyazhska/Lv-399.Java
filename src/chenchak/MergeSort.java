package chenchak;

import main.Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MergeSort implements Algorithm {

    public int[] numSequence;


    void merge(int arr[], int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // main.Main function that sorts arr[l..r] using
    // merge()
    void sort(int arr[], int l, int r) {
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

    public void setNumSequence(String numSequence) {

        String[] integerStrings = numSequence.split(" ");
        this.numSequence = new int[integerStrings.length];
        for (int i = 0; i < this.numSequence.length; i++) {
            this.numSequence[i] = Integer.parseInt(integerStrings[i]);
        }
    }


    public void input() {
        System.out.println("Please, input sequence of integer number:");
        String seqOfNumber = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            seqOfNumber = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        setNumSequence(seqOfNumber);

    }

    @Override
    public void start(BufferedReader bufferedReader) {
        input();
        System.out.println("Given Array");
        Arrays.stream(numSequence).
                forEach(value -> System.out.print(value + " "));

        sort(numSequence, 0, numSequence.length - 1);

        System.out.println("\nSorted array");
        Arrays.stream(numSequence).
                forEach(value -> System.out.print(value + " "));
    }

    @Override
    public String toString() {
        return "MergeSort{}";
    }
}
