package com.academy.softserve.levytskyi;


import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class CountingSortTest {


    @Test
    public void testSort() {
        int[] array = {4, 1, 6, 7, -10, 83, 101, 54};
        int[] template = {-10, 1, 4, 6, 7, 54, 83, 101};

        CountingSort countingSort = new CountingSort();
        countingSort.sort(array);
        assertArrayEquals(array, template);
        // Пофіксити від'ємні
    }

    @Test
    public void testSetNumSequence() {
        String arrayInString = "1 8 -3 2 6 8 3";
        int[] template = {1, 8, -3, 2, 6, 8, 3};
        CountingSort countingSort = new CountingSort();
        int [] array = countingSort.setNumSequence(arrayInString);

        assertArrayEquals(array,template);
    }

    @Test(expected = NumberFormatException.class)
    public void testSetNumSequenceException() {
        String arrayInString = "1 5 6 f s df";
        CountingSort countingSort = new CountingSort();
        int [] array = countingSort.setNumSequence(arrayInString);
    }
}