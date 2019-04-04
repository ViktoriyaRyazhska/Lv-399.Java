package levytskyi;

import main.Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

public class CountingSort implements Algorithm {
    private static int[] numSequence;

    /**
     * @param numSequence
     */
    private void sort(int[] numSequence) {
        int n = numSequence.length;
        int[] output = new int[numSequence.length];//може 1 місця не вистачити
        int[] count = new int[256];
        for (int i = 0; i < 256; ++i)
            count[i] = 0;
        for (int i1 : numSequence) ++count[i1];
        for (int i = 1; i <= 255; ++i)
            count[i] += count[i - 1];
        for (int i = n - 1; i >= 0; i--) {
            output[count[numSequence[i]] - 1] = numSequence[i];
            --count[numSequence[i]];
        }
        System.arraycopy(output, 0, numSequence, 0, n);
    }

    /**
     * @param bufferedReader
     */
    @Override
    public void start(BufferedReader bufferedReader) {
        try {
            System.out.println("Enter array: ");
            try {
                setNumSequence(bufferedReader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
            sort(numSequence);
            Arrays.stream(numSequence).forEach(value -> System.out.print(value + " "));
        } catch (Exception e) {
            System.out.println("Invalid data type \n Try to write one more time \n");
            start(bufferedReader);
        }
    }

    /**
     * @param numSequence
     */
    private void setNumSequence(String numSequence) {
        String[] integerStrings = numSequence.split(" ");
        CountingSort.numSequence = new int[integerStrings.length];
        for (int i = 0; i < CountingSort.numSequence.length; i++) {
            CountingSort.numSequence[i] = Integer.parseInt(integerStrings[i]);
        }
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return "levytskyi.CountingSort";
    }
}