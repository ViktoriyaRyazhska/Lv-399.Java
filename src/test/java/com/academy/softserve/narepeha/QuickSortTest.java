package com.academy.softserve.narepeha;

import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;


public class QuickSortTest {
    public static Method partitionTest;

    @BeforeClass
    public static void init() throws NoSuchMethodException {
        partitionTest = QuickSort.class.getDeclaredMethod("partition", int[].class,int.class,int.class);
        partitionTest.setAccessible(true);
    }

    @Test
    public void partitionTest () throws InvocationTargetException, IllegalAccessException {
        QuickSort quickSort = new QuickSort();
        int[] template = {4, 2, 3};
        int invoke = (int) partitionTest.invoke(quickSort, template, 0, template.length - 1);
        assertEquals(1,invoke);
    }

    @Test
    public void partitionTest2 () throws InvocationTargetException, IllegalAccessException {
        QuickSort quickSort = new QuickSort();
        int[] template = {8, 25, -3, 4 ,4, 2};
        int invoke = (int) partitionTest.invoke(quickSort, template, 0, template.length - 1);
        assertEquals(1,invoke);
    }
}
