package com.academy.softserve.silich;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;

public class WaysToCoverTest {

    public Method coverWays;

    @Test
    public void coverWaysTest() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        coverWays = WaysToCover.class.getDeclaredMethod("coverWays", Integer.class);
        coverWays.setAccessible(true);
        WaysToCover waysToCover = new WaysToCover();
        Integer a = (Integer) coverWays.invoke(waysToCover, 5);
        Integer b = 13;
        assertEquals(a, b);
    }

    @Test
    public void coverWaysTest2() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        coverWays = WaysToCover.class.getDeclaredMethod("coverWays", Integer.class);
        coverWays.setAccessible(true);
        WaysToCover waysToCover = new WaysToCover();
        Integer a = (Integer) coverWays.invoke(waysToCover, 10);
        Integer b = 274;
        assertEquals(a, b);
    }
}