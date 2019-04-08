package com.academy.softserve.levytskyi;

import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


import static org.junit.Assert.*;

public class PathsWithoutCrossingTest {

    private static Method calculateCountWays;
    private static Method countWays;


    @BeforeClass
    public static void init() throws NoSuchMethodException {
        calculateCountWays = PathsWithoutCrossing.class.getDeclaredMethod("calculateCountWays", int.class);
        calculateCountWays.setAccessible(true);

        countWays = PathsWithoutCrossing.class.getDeclaredMethod("countWays", int.class);
        countWays.setAccessible(true);
    }

    @Test
    public void testCalculateCountWays() throws InvocationTargetException, IllegalAccessException {


        PathsWithoutCrossing pathsWithoutCrossing = new PathsWithoutCrossing();
        int template = 16796;
        int result = (int) calculateCountWays.invoke(pathsWithoutCrossing, 10);

        assertEquals(template, result);
    }

    @Test(expected = Exception.class)
    public void testCalculateCountWaysNegativeArraySizeException() throws InvocationTargetException, IllegalAccessException {
        PathsWithoutCrossing pathsWithoutCrossing = new PathsWithoutCrossing();
        int result = (int) calculateCountWays.invoke(pathsWithoutCrossing, -5);
    }

    @Test(expected = Exception.class)
    public void testCalculateCountWaysArrayIndexOutOfBoundsException() throws InvocationTargetException, IllegalAccessException {
        PathsWithoutCrossing pathsWithoutCrossing = new PathsWithoutCrossing();
        int result = (int) calculateCountWays.invoke(pathsWithoutCrossing, 0);
    }


    @Test
    public void countWays() throws InvocationTargetException, IllegalAccessException {
        PathsWithoutCrossing pathsWithoutCrossing = new PathsWithoutCrossing();

        int template = 42;
        int result1 = (int) countWays.invoke(pathsWithoutCrossing, 10);
        int result2 = (int) countWays.invoke(pathsWithoutCrossing, -10);

        assertEquals(template, result1);
        assertEquals(0, result2);

    }
}
