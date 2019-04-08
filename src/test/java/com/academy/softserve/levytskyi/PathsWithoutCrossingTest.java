package com.academy.softserve.levytskyi;

<<<<<<< HEAD
=======

>>>>>>> 17f203c26c59bbc0385f3cd42a7963cc6f96c33c
import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
<<<<<<< HEAD
import java.lang.reflect.Parameter;

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
=======

import static org.junit.Assert.assertTrue;

public class PathsWithoutCrossingTest {
    public static Method calculateCountWays;
    public static Method countWays;

    @BeforeClass
    public static void setUp() throws NoSuchMethodException {
        calculateCountWays
                = PathsWithoutCrossing.class.getDeclaredMethod("calculateCountWays", int.class);
        calculateCountWays.setAccessible(true); //make method accessible locally
        countWays
                = PathsWithoutCrossing.class.getDeclaredMethod("countWays", int.class);
        countWays.setAccessible(true); //make method accessible locally
    }

    @Test
    public void calculateCountWaysTest() throws InvocationTargetException, IllegalAccessException {
        PathsWithoutCrossing pathsWithoutCrossing = new PathsWithoutCrossing(); //get instance
        int result = (int) calculateCountWays.invoke(pathsWithoutCrossing, 3);
        assertTrue(result == 5);
        result = (int) calculateCountWays.invoke(pathsWithoutCrossing, 9999);
        assertTrue(result < 0);
    }


    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void calculateCountWaysTest2() throws IllegalAccessException {
        PathsWithoutCrossing pathsWithoutCrossing = new PathsWithoutCrossing(); //get instance
        try {
            calculateCountWays.invoke(pathsWithoutCrossing, 0);
        } catch (InvocationTargetException e) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Test
    public void countWaysTest() throws IllegalAccessException, InvocationTargetException {
        PathsWithoutCrossing pathsWithoutCrossing = new PathsWithoutCrossing();//get instance
        int result = (int) countWays.invoke(pathsWithoutCrossing, -10);
        assertTrue(result == 0);
        result = (int) countWays.invoke(pathsWithoutCrossing, 0);
        assertTrue(result == 0);
        result = (int) countWays.invoke(pathsWithoutCrossing, 100);
        assertTrue(result == 992169208);
    }
}
>>>>>>> 17f203c26c59bbc0385f3cd42a7963cc6f96c33c
