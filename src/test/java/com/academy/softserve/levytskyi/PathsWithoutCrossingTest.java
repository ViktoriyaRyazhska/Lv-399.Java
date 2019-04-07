package com.academy.softserve.levytskyi;

import org.junit.Test;

import static org.junit.Assert.*;

public class PathsWithoutCrossingTest {


    @Test
    public void testCalculateCountWays() {
        PathsWithoutCrossing pathsWithoutCrossing = new PathsWithoutCrossing();
        int template = 16796;
        int result = pathsWithoutCrossing.calculateCountWays(10);

        assertEquals(template,result);
    }

    @Test(expected = NegativeArraySizeException.class)
    public void testCalculateCountWaysNegativeArraySizeException() {
        PathsWithoutCrossing pathsWithoutCrossing = new PathsWithoutCrossing();
        int result = pathsWithoutCrossing.calculateCountWays(-5);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testCalculateCountWaysArrayIndexOutOfBoundsException() {
        PathsWithoutCrossing pathsWithoutCrossing = new PathsWithoutCrossing();
        int result = pathsWithoutCrossing.calculateCountWays(0);
    }


    @Test
    public void countWays() {
        PathsWithoutCrossing pathsWithoutCrossing = new PathsWithoutCrossing();

        int template = 42;
        int result1 = pathsWithoutCrossing.countWays(10);
        int result2 = pathsWithoutCrossing.countWays(-10);

        assertEquals(template,result1);
        assertEquals(0,result2);

    }
}