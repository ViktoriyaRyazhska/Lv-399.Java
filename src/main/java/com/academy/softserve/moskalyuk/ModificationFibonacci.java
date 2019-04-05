package com.academy.softserve.moskalyuk;

import com.academy.softserve.main.java.main.Algorithm;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * This class contains methods which print to console index of required element.
 */
public class ModificationFibonacci implements Algorithm {
    /**
     * Message for users.
     */
    private static final String MSG = "Enter number of element:";
    /**
     * Message for users.
     */
    private static final String ERROR_MSG = "Enter number, not letter!!!";
    /**
     * Threshold for method getIndexOfElement.
     */
    private static final int THRESHOLD = 5;
    /**
     * Array of four first number of sequence.
     */
    private static final int[] INITIAL = {1, 1, 1, 2};
    /**
     * Additional number for method getIndexOfElement.
     */
    private static final int ADDITIONAL_NUMBER_ONE = 1;
    /**
     * Additional number for method getIndexOfElement.
     */
    private static final int ADDITIONAL_NUMBER_TWO = 2;
    /**
     * Additional number for method getIndexOfElement.
     */
    private static final int ADDITIONAL_NUMBER_THREE = 3;
    /**
     * Additional number for method getIndexOfElement.
     */
    private static final int ADDITIONAL_NUMBER_FOUR = 4;
    /**
     * Format for output message.
     */
    private static final String OUTPUT_MSG_FORMAT = "Index of element %d is %d";

    /**
     * Method print index of required element.
     * @param reader BufferRider object is the source of input data
     */
    @Override
    public void start(final BufferedReader reader) {
        System.out.println(MSG);
        try {
            int elementNumber = Integer.parseInt(reader.readLine());
            int indexOfElement = getIndexOfElement(elementNumber);
            System.out.println(String.
                    format(OUTPUT_MSG_FORMAT, elementNumber, indexOfElement));
        } catch (IOException | NumberFormatException e) {
            System.out.println(ERROR_MSG);
            start(reader);
        }
    }

    /**
     * Method return index of required element.
     * @param number required element from sequence
     * @return index of element
     */
    private int getIndexOfElement(final int number) {
        if (number < THRESHOLD) {
            return INITIAL[number - ADDITIONAL_NUMBER_ONE];
        } else {
            return getIndexOfElement(number - ADDITIONAL_NUMBER_TWO)
                    + getIndexOfElement(number - ADDITIONAL_NUMBER_THREE)
                    + getIndexOfElement(number - ADDITIONAL_NUMBER_FOUR);
        }
    }
}
