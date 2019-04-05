package hanuliak;

import main.Algorithm;

import java.io.BufferedReader;
import java.io.IOException;


/**
 *
 */
public class FindMaxSubSequenceLength implements Algorithm {


    /**
     * num.
     */
    private int[] numSequence;
    /**
     * max.
     */
    private int maxSubSequenceLength;


    /**
     * constructor.
     */
    public FindMaxSubSequenceLength() {
    }

    /**
     * @return num.
     */
    public int[] getNumSequence() {
        return numSequence;
    }

    /**
     * @param numSequence sequence number
     */
    public void setNumSequence( String numSequence) {

        String[] integerStrings = numSequence.split(" ");
        this.numSequence = new int[integerStrings.length];
        for (int i = 0; i < this.numSequence.length; i++) {
            this.numSequence[i] = Integer.parseInt(integerStrings[i]);
        }
    }


    public void input(BufferedReader reader) {
        System.out.println("Please, input sequence of integer number (separate by space) :");
        String seqOfNumber = "";

        try {
            seqOfNumber = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            setNumSequence(seqOfNumber);
        } catch (Exception e) {
            System.out.println("Invalid data, please try again");
            input(reader);
        }

    }


    public void output() {
        System.out.println("MaxSubSequenceLength = " + maxSubSequenceLength);
    }


    public void calculate() {
        int currentSubSequenceLength = 1;

        maxSubSequenceLength = 1;
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
    }

    public void infoAboutTask() {
        System.out.println("The goal: To find how many numbers we have with difference one in  ");
        System.out.println("the maximum sub sequence");

    }

    @Override
    public void start(BufferedReader bufferedReader) {
        infoAboutTask();
        input(bufferedReader);
        calculate();
        output();
    }


    @Override
    public String toString() {
        return "Find max sub sequence length";

    }

}
