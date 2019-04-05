package com.academy.softserve.hanuliak;


import com.academy.softserve.main.java.main.Algorithm;

import java.io.BufferedReader;

/**
 * This class use to find how many numbers we have with difference
 * one in the maximum sub sequence.
 */
public class FindMaxSubSequenceLength implements Algorithm {
    /**
     * Sequence of integer number.
     */
    public int[] numSequence;

    /**
     * Class constructor.
     */
    public FindMaxSubSequenceLength() {
    }

    /**
     * @return Sequence of integer number in array.
     */
    public int[] getNumSequence() {
        return numSequence;
    }

    /**
     * @param reader Read sequence of number from cmd.
     */
    public void setNumSequence(final BufferedReader reader) {
        String msgInvalidData = "Invalid data, please try again";
        String msgBeforeInput = "Please, input number sequence "
                + "(split by space):";
        String numSequenceStr = "";
        String[] integerStrings;
        System.out.println(msgBeforeInput);
        try {
            numSequenceStr = reader.readLine();
            integerStrings = numSequenceStr.split(" ");
            this.numSequence = new int[integerStrings.length];
            for (int i = 0; i < this.numSequence.length; i++) {
                this.numSequence[i] = Integer.parseInt(integerStrings[i]);
            }
        } catch (Exception e) {

            System.out.println(msgInvalidData);
            setNumSequence(reader);
        }
    }

    /**
     * Calculate how many numbers we have with difference
     * one in the maximum sub sequence.
     *
     * @return maximum sub sequence length.
     */
    public int calculate() {
        int currentSubSequenceLength = 1;
        int maxSubSequenceLength = 1;
        int difference;

        for (int i = 1; i < numSequence.length; i++) {
            difference = numSequence[i] - numSequence[i - 1];
            if (difference == 1) {
                currentSubSequenceLength++;
                if (currentSubSequenceLength > maxSubSequenceLength) {
                    maxSubSequenceLength = currentSubSequenceLength;
                }
            } else {
                currentSubSequenceLength = 1;
            }
        }

        return maxSubSequenceLength;
    }

    /**
     * Print info about task goal.
     */
    public void getGoalInfo() {
        String msgGoal = "The goal: To find how many numbers we have with "
                + "difference one in \nthe maximum sub sequence";
        System.out.println(msgGoal);
    }

    /**
     * @return Task name for menu item.
     */
    @Override
    public String toString() {
        String msgTaskName = "Find Max SubSequence Length";
        return msgTaskName;
    }

    /**
     * @param bufferedReader Read number sequence from console.
     */
    @Override
    public void start(final BufferedReader bufferedReader) {
        String msgSeqOutput = "Max sub sequence length = ";
        getGoalInfo();
        setNumSequence(bufferedReader);
        System.out.println(msgSeqOutput + calculate());
    }
}
