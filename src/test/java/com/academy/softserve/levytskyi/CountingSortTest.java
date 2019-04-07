package com.academy.softserve.levytskyi;


import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.assertArrayEquals;

public class CountingSortTest {
    private static Method sort;
    private static Method setNumSequence;

    @BeforeClass
    public static void init() throws NoSuchMethodException {
        sort = CountingSort.class.getDeclaredMethod("sort", int[].class);
        sort.setAccessible(true);

        setNumSequence = CountingSort.class.getDeclaredMethod("setNumSequence", String.class);
        setNumSequence.setAccessible(true);
    }

    @Test
    public void testSort() throws InvocationTargetException, IllegalAccessException {
        CountingSort countingSort = new CountingSort();

        int[] array = {4, 1, 6, 7, 83, 101, 54};
        int[] template = {1, 4, 6, 7, 54, 83, 101};

        sort.invoke(countingSort, (Object) array);
        assertArrayEquals(array, template);
    }

/*    @Test
    public void testSetNumSequence() throws InvocationTargetException, IllegalAccessException {
        String arrayInString = "1 8 -3 2 6 8 3";
        int[] template = {1, 8, -3, 2, 6, 8, 3};
        CountingSort countingSort = new CountingSort();



        int [] array = setNumSequence.invoke(countingSort,arrayInString);

        assertArrayEquals(array,template);


        //Зробити, щоб повертало масив
    }*/

    @Test(expected = Exception.class)
    public void testSetNumSequenceException() throws InvocationTargetException, IllegalAccessException {
        CountingSort countingSort = new CountingSort();
        setNumSequence.invoke(countingSort, "1 5 6 f s df");
    }
}