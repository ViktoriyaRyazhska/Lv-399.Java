package com.academy.softserve.nastyastr;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class PaintFenceTest {

    private static PaintFence  paintFence;
    @BeforeClass
    public  static void setUp() throws Exception {
        paintFence = new PaintFence();

    }

    @Test
    public void calcTest() {
        long result = 16;
        assertEquals(result, paintFence.calc(2,4));
    }
    @Test
    public void calcOneTest() {
        long result = 10;
        assertEquals(result, paintFence.calc(4,2));
    }

}