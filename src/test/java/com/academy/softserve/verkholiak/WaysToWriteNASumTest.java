package com.academy.softserve.verkholiak;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class WaysToWriteNASumTest {
    private static WaysToWriteNAsSum waysToWriteNAsSum;
    @BeforeClass
    public static void createWaysToWriteNAsSumObject() {
        waysToWriteNAsSum = new WaysToWriteNAsSum();
    }

    @Test
    public void givenIntNumbersWhenCountWaysCalledThenRightNumberIsReturned() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method m=waysToWriteNAsSum.getClass().getDeclaredMethod("countWays", int.class);
        m.setAccessible(true);
        Assert.assertEquals(21L,m.invoke(waysToWriteNAsSum,8));
    }
    @Test
    public void givenIntNumbersWhenCountWaysCalledThenRightNumberLongIsReturned() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method m=waysToWriteNAsSum.getClass().getDeclaredMethod("countWays", int.class);
        m.setAccessible(true);
        Assert.assertEquals(29L,m.invoke(waysToWriteNAsSum,9));
    }



}
