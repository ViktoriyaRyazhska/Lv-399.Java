
package com.academy.softserve.silich;


import com.academy.softserve.main.java.main.Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Oleksandr
 */
public class InsertionSorting implements Algorithm {

    /**
     * @param reader incoming array
     */
    public void start(final BufferedReader reader) {

        List<Integer> array = stringToInteger(reader);
        for (int i = 1; i < array.size(); i++) {
            int key = array.get(i);
            int j = i - 1;
            while ((j >= 0) && (array.get(j) > key)) {
                array.set(j + 1, array.get(j));
                j = j - 1;
            }
            array.set(j + 1, key);
        }

        System.out.println("Sorted array:");
        System.out.println(array);
    }

    private void menu() {
        System.out.println("This function sorting arrays");
    }

    /**
     * @param reader has type of BufferedReader
     * @return array of Integer. Type ArrayList
     */
    private List<Integer> stringToInteger(final BufferedReader reader) {
        String inputString;
        List<Integer> array;

        try {
            System.out.println("Input array to sorting:");
            inputString = reader.readLine();
            array = convertToInteger(inputString);
        } catch (IOException e) {
            System.out.println("IOException!!!");
            array = stringToInteger(reader);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException!!!");
            array = stringToInteger(reader);
        }

        return array;
    }


    /**
     * @param inputString is array from numbers
     * @return array in Integer format
     */
    private static List<Integer> convertToInteger(final String inputString) {
        String[] numbers = inputString.split(" ");
        List<Integer> array = new ArrayList<>();
        for (String number : numbers) {
            array.add(Integer.parseInt(number));
        }

        return array;
    }

    /**
     * @return name of function
     */
    @Override
    public String toString() {
        return "InsertionSorting";
    }

}
