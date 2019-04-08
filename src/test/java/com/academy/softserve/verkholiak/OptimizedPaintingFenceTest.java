package com.academy.softserve.verkholiak;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OptimizedPaintingFenceTest {
    private static OptimizedPaintingFence optimizedPaintingFence;

    @BeforeClass
    public static void createPaintFenceObject() {
        optimizedPaintingFence = new OptimizedPaintingFence();
    }
    @Test
    public void givenIntNumbersWhenCountWaysCalledThenLongIsReturned() {
        optimizedPaintingFence.setK(1);
        optimizedPaintingFence.setN(1);
        assertEquals(1, optimizedPaintingFence.countWays());
    }

    @Test
    public void givenLessThanOneNumbersWhenCountWaysCalledThenNegativeValueReturned() {
        optimizedPaintingFence.setK(-1);
        optimizedPaintingFence.setN(-1);
        assertEquals(-1, optimizedPaintingFence.countWays());
    }
    @Test(expected = Exception.class)
    public void givenInproperValuesWhenCountWaysCalledThenExceptionIsThrown() throws Exception {
        optimizedPaintingFence.input("u","r");
    }

    @Test
    public void givenIntNumbersWhenCountWaysCalledThenRightValuesReturned() {
        optimizedPaintingFence.setK(4);
        optimizedPaintingFence.setN(2);
        assertEquals(16, optimizedPaintingFence.countWays());
        optimizedPaintingFence.setK(2);
        optimizedPaintingFence.setN(3);
        assertEquals(6, optimizedPaintingFence.countWays());
    }


}
