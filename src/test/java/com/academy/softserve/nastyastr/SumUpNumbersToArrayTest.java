package com.academy.softserve.nastyastr;

import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.String;
import static org.junit.Assert.*;

public class SumUpNumbersToArrayTest {

    private static SumUpNumbersToArray  sumUpNumbersToArray;

    @BeforeClass
    public static void  init() throws NoSuchMethodException {
        sumUpNumbersToArray = new SumUpNumbersToArray();
    }

    @Test
    public void setNumSequenceTest() {
        int[] a = new int[]{1,2,3,5,7,9};
        String b = "1 2 3 5 7 9";
        sumUpNumbersToArray.setNumSequence(b);
        assertArrayEquals(a, sumUpNumbersToArray.getNumSequence());
    }

    @Test
    public void countWaysTest() {
        int [] a = new int[] {1,2,3};
        assertEquals(24, sumUpNumbersToArray.countWays(6,a ));
    }

    @Test(expected = Exception.class)
    public void countWaysExpectedExceptinTest() {
        int [] a = new int[] {1,2,3};
        sumUpNumbersToArray.countWays(-1,a );
    }
}