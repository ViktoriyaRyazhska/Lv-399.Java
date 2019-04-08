package com.academy.softserve.chenchak;

import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import static org.junit.Assert.*;

public class InsertingRowTest {
    private static Method convertStringToArrayOfIntegers;

    @BeforeClass
    public static void init() throws NoSuchMethodException {
        convertStringToArrayOfIntegers = InsertingRow.class.
                getDeclaredMethod("convertStringToArrayOfIntegers", String.class);
        convertStringToArrayOfIntegers.setAccessible(true);
    }

    @Test
    public void convertStringToArrayOfIntegersTest() throws InvocationTargetException, IllegalAccessException {
        InsertingRow insertingRow = new InsertingRow();
        String inputString = "20 5 2 15 9";
        int[] rightResult = {20, 5, 2, 15, 9};
        int[] result = (int[]) convertStringToArrayOfIntegers.invoke(insertingRow, inputString);
        assertArrayEquals(result, rightResult);
    }

    @Test
    public void convertStringToArrayOfIntegersTestFail() throws InvocationTargetException, IllegalAccessException {
        InsertingRow insertingRow = new InsertingRow();
        String inputString = "20 5 2 15 9";
        int[] rightResult = {20, 5, 2, 15, 5};
        int[] result = (int[]) convertStringToArrayOfIntegers.invoke(insertingRow, inputString);
        assertFalse(Arrays.equals(result, rightResult));
    }
}