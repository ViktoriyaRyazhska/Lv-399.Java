package com.academy.softserve.silich;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

import static org.junit.Assert.*;

public class InsertionSortingTest {
    public static Method convertToInteger;

    @BeforeClass
    public static void setUp() throws Exception {
        convertToInteger = InsertionSorting.class.getDeclaredMethod("convertToInteger", String.class);
        convertToInteger.setAccessible(true);
    }

    @Test
    public void convertToIntegerTest() throws InvocationTargetException, IllegalAccessException {
        InsertionSorting insertionSorting = new InsertionSorting();
        List<Integer> testList = Arrays.asList(5, 8, 6, 1, 2);
        List<Integer> arrayTemplate = (List<Integer>) convertToInteger.invoke(insertionSorting, "5 8 6 1 2");
        assertArrayEquals(arrayTemplate.toArray(),testList.toArray());
    }

    @After
    public void tearDown() throws Exception {
    }
}