package com.academy.softserve.chenchak;

import com.academy.softserve.chenchak.MergeSort;
import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;

public class MergeSortTest {

    private static Method convertStringToArrayOfIntegers;

    @BeforeClass
    public static void init() throws NoSuchMethodException {
        convertStringToArrayOfIntegers = MergeSort.class.
                getDeclaredMethod("convertStringToArrayOfIntegers", String.class);
        convertStringToArrayOfIntegers.setAccessible(true);
    }

    @Test
    public void convertStringToArrayOfIntegersTest() throws InvocationTargetException, IllegalAccessException {
        MergeSort mergeSort = new MergeSort();
        String inputString = "20 5 2 15 9";
        int[] rightResult = {20, 5, 2, 15, 9};
        int[] result = (int[]) convertStringToArrayOfIntegers.invoke(mergeSort, inputString);
        assertArrayEquals(result, rightResult);
    }

    @Test
    public void convertStringToArrayOfIntegersTestFail() throws InvocationTargetException, IllegalAccessException {
        MergeSort mergeSort = new MergeSort();
        String inputString = "20 5 2 15 9";
        int[] rightResult = {20, 5, 2, 15, 5};
        int[] result = (int[]) convertStringToArrayOfIntegers.invoke(mergeSort, inputString);
        assertFalse(Arrays.equals(result, rightResult));
    }
}