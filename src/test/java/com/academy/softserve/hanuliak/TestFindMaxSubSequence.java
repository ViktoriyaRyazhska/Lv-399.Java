package com.academy.softserve.hanuliak;

import com.academy.softserve.hanuliak.FindMaxSubSequenceLength;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.BufferedReader;

import static org.junit.Assert.*;

/**
 * Created by Illia Chenchak
 */
public class TestFindMaxSubSequence {



    @Test
    public void calculateTestWithDifferentValueInArray() {
        FindMaxSubSequenceLength findMaxSubSequenceLength = new FindMaxSubSequenceLength();
        int[] arr = new int[] {1,2,3,4};
        findMaxSubSequenceLength.numSequence = arr;
        assertEquals(4,findMaxSubSequenceLength.calculate());
    }

    @Test
    public void calculateTestWithSameValueInArray() {
        FindMaxSubSequenceLength findMaxSubSequenceLength = new FindMaxSubSequenceLength();
        int[] arr = new int[] {1,2,3,4,4};
        findMaxSubSequenceLength.numSequence = arr;
        assertEquals(4,findMaxSubSequenceLength.calculate());
    }

}