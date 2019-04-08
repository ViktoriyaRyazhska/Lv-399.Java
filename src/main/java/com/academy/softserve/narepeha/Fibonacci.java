/*
  Open source project
  2019
 */
package com.academy.softserve.narepeha;

import com.academy.softserve.main.Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * The class represents Fibonacci sequence
 * You can launch it by calling the method start().
 *
 * @author Dima Narepeha
 */
public class Fibonacci implements Algorithm {
    /**
     * The value is used for Fibonacci sequence storage.
     */
    private final List<BigInteger> sequence = new ArrayList<>();

    /**
     * default constructor
     * adds two initial elements
     * into sequence.
     */
    public Fibonacci() {
        sequence.add(BigInteger.valueOf(1)); //initial elements
        sequence.add(BigInteger.valueOf(1));
    }

    /**
     * default menu to be shown to the user while starting.
     */
    private void printMenu() {
        System.out.println("Enter Fibonacci number id to be printed");
    }

    /**
     * returns input from user.
     *
     * @param bufferedReader reader the input to be read from
     * @return Integer. Or null if failed.
     */
    private Integer getInput(final BufferedReader bufferedReader) {
        try {
            return Integer.valueOf(bufferedReader.readLine());
        } catch (IOException ignored) {

        } catch (NumberFormatException e) {
            System.out.println("Invalid input");
        }
        return null;
    }

    /**
     * prints an element in sequence.
     *
     * @param index of element
     */
    private void printOutputFor(final Integer index) {
        if (index > 0) {
            System.out.println("Output: " + sequence.get(index - 1));
        }
    }

    /**
     * generate Fibonacci sequence
     * to element on the lastPosition inclusive.
     * if it is already cached, this method returns quickly.
     *
     * @param lastPosition position that sequence should be generated to
     */
    private void genSeqTo(final int lastPosition) {
        int initialSeqSize = sequence.size();
        for (int i = 0; i <= lastPosition - initialSeqSize; i++) {
            int currentSize = sequence.size();
            BigInteger newElement = sequence.get(currentSize - 1)
                    .add(sequence.get(currentSize - 2));
            sequence.add(newElement);
        }
    }

    /**
     * @return String that represents the class info
     */
    @Override
    public String toString() {
        return "Fibonacci sequence";
    }

    /**
     * Starts the class and interacts with the user.
     *
     * @param bufferedReader input is read through this reader
     */
    @Override
    public void start(final BufferedReader bufferedReader) {
        printMenu();
        Integer index = getInput(bufferedReader);
        if (index != null) {
            genSeqTo(index);
            printOutputFor(index);
        }
    }

}
