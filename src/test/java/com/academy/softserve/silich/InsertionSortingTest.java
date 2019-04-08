package com.academy.softserve.silich;

import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class InsertionSortingTest {

    public static Method convertToInteger;
    public Method sort;


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

    @Test
    public void sortTest() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        InsertionSorting insertionSorting = new InsertionSorting();
        sort = InsertionSorting.class.getDeclaredMethod("sort", List.class);
        sort.setAccessible(true);
        List<Integer> arrayTemplate = (List<Integer>) sort.invoke(insertionSorting, Arrays.asList(5, 8, 6, 1, 2));
        List<Integer> x = Arrays.asList(5, 8, 6, 1, 2);
        x.sort(Integer::compareTo);
        assertArrayEquals(x.toArray(), arrayTemplate.toArray());
    }
}