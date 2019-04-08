package com.academy.softserve.narepeha;

import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;


public class LowAndHighEffortTest {

    public static Method computeResultTest;

    @BeforeClass
    public static void init() throws NoSuchMethodException {
        computeResultTest = LowAndHighEffort.class.getDeclaredMethod("computeResult", int[][].class);
        computeResultTest.setAccessible(true);
    }

    @Test
    public void computeResultTest() throws InvocationTargetException, IllegalAccessException {
        LowAndHighEffort lowAndHihtEffort = new LowAndHighEffort();
        int[][] template = {
                {2,2},
                {2,6}
        };
        int invoke = (int) computeResultTest.invoke(lowAndHihtEffort, (Object) template);
        assertEquals(4,invoke);
    }

    @Test
    public void computeResultTest2() throws InvocationTargetException, IllegalAccessException {
        LowAndHighEffort lowAndHihtEffort = new LowAndHighEffort();
        int[][] template = {
                {2,6},
                {2,8},
                {3,1},
                {1,1},
                {8,4}
        };
        int invoke = (int) computeResultTest.invoke(lowAndHihtEffort, (Object) template);
        assertEquals(8,invoke);
    }

}
