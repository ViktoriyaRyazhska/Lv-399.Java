package chenchak;


import main.java.main.Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * This class for task "Inserting row".
 */
public class InsertingRow implements Algorithm {

    @Override
    public void start(BufferedReader bufferedReader) {
        try {
            System.out.println("Please, input sequence of integer number:");
            String seqOfNumber = bufferedReader.readLine();
            int[] array = convertStringToArrayOfIntegers(seqOfNumber);
            System.out.println("Plese, input number:");
            int num = Integer.parseInt(bufferedReader.readLine());
            if (num >=0) {
                findRow(num, array);
            } else {
                System.out.println("Number must be > 0");
                start(bufferedReader);
            }

        } catch (IOException | NumberFormatException e) {
            start(bufferedReader);

        }
    }

    public void findRow(int number, int[] inputArray) {
        boolean check = false;
        for (int i = 0; i < inputArray.length; i++) {
            if (number == inputArray[i]) {
                System.out.println("Your number index: " + i);
                check = true;
                break;
            }
        }

        if (!check) {
            System.out.println("Not found this index!");
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

    /**
     * @return class name.
     */
    @Override
    public String toString() {
        return "InsertingRow";
    }
}
