package moskalyuk;


import main.java.main.Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

public class BucketSort implements Algorithm {
    private static final String ENTER_MSG = "Enter a line:";
    private static final String ERROR_MSG = "Reading error";
    private static final String FORMAT_EXAMPLE = "Example: 5, 3, 0, 2, 4, 1";

    public void start(BufferedReader reader) {
        System.out.println(ENTER_MSG);
        System.out.println(FORMAT_EXAMPLE);
        try {
            String inputString = reader.readLine();
            int[] integers = convertStringToArrayOfIntegers(inputString);
            sort(integers);
            printArray(integers);
        } catch (IOException ex) {
            System.out.println(ERROR_MSG);
            start(reader);
        }
    }

    private int[] convertStringToArrayOfIntegers(String inputString) {
        String[] arrayOfString = inputString.split(", ");
        int[] arrayOfIntegers = new int[arrayOfString.length];
        for (int i = 0; i < arrayOfIntegers.length; i++) {
            arrayOfIntegers[i] = Integer.parseInt(arrayOfString[i]);
        }
        return arrayOfIntegers;
    }

    private void sort(int[] inputArray) {
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

    private void printArray(int[] integers) {
        Arrays.stream(integers).forEach(value -> System.out.print(value + " "));
        System.out.println();
    }

}
