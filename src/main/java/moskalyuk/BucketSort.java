package moskalyuk;


import main.java.main.Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * This class contains methods which sort input array by bucket sort method.
 */
public class BucketSort implements Algorithm {
    /**
     * Message for users.
     */
    private static final String ENTER_MSG = "Enter a line:";
    /**
     * Message for users.
     */
    private static final String ERROR_MSG = "Reading error";
    /**
     * Message for users.
     */
    private static final String FORMAT_EXAMPLE = "Example: 5, 3, 0, 2, 4, 1";
    /**
     * Format for output message.
     */
    private static final String FORMAT_OUTPUT_MSG = "Sorted array: ";

    /**
     * Method start receive data from console and invoke other method for
     * sorting it.
     *
     * @param reader BufferRider object is the source of input data
     */
    public void start(final BufferedReader reader) {
        System.out.println(ENTER_MSG);
        System.out.println(FORMAT_EXAMPLE);
        try {
            String inputString = reader.readLine();
            int[] integers = convertStringToArrayOfIntegers(inputString);
            sort(integers);
            System.out.print(FORMAT_OUTPUT_MSG);
            printArray(integers);
        } catch (IOException ex) {
            System.out.println(ERROR_MSG);
            start(reader);
        }
    }

    /**
     * Method convert input string to array of integers.
     *
     * @param inputString input string from user
     * @return array of integers
     */
    private int[] convertStringToArrayOfIntegers(final String inputString) {
        String[] arrayOfString = inputString.split(", ");
        int[] arrayOfIntegers = new int[arrayOfString.length];
        for (int i = 0; i < arrayOfIntegers.length; i++) {
            arrayOfIntegers[i] = Integer.parseInt(arrayOfString[i]);
        }
        return arrayOfIntegers;
    }

    /**
     * Method sort input array by bucket sort method.
     *
     * @param inputArray unsorted array of integers
     */
    private void sort(final int[] inputArray) {
        int[] bucket = new int[inputArray.length + 1];

        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = 0;
        }

        for (int value : inputArray) {
            bucket[value]++;
        }

        int outPos = 0;
        for (int i = 0; i < bucket.length; i++) {
            for (int j = 0; j < bucket[i]; j++) {
                inputArray[outPos++] = i;
            }
        }
    }

    /**
     * Method print input array to console.
     *
     * @param integers input array
     */
    private void printArray(final int[] integers) {
        Arrays.stream(integers).forEach(value -> System.out.print(value + " "));
        System.out.println();
    }
}
