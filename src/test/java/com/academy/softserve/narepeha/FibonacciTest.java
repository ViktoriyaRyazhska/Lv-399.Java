package com.academy.softserve.narepeha;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class FibonacciTest {
    public static Method genSeqToTest;

    @BeforeClass
    public static void init() throws NoSuchMethodException {
        genSeqToTest = Fibonacci.class.getDeclaredMethod("genSeqTo", int.class);
        genSeqToTest.setAccessible(true);
    }

    @Test
    public void genSeqToTest() throws InvocationTargetException, IllegalAccessException {
        List<BigInteger> template = new ArrayList<>();
        template.add(new BigInteger("1"));
        template.add(new BigInteger("1"));
        template.add(new BigInteger("2"));
        template.add(new BigInteger("3"));
        template.add(new BigInteger("5"));
        template.add(new BigInteger("8"));
        template.add(new BigInteger("13"));

        Fibonacci fibonacci = new Fibonacci();
        int position = 6;
        List<BigInteger> invoke = (List<BigInteger>) genSeqToTest.invoke(fibonacci, position);

        System.out.println(invoke);
        assertArrayEquals(template.toArray(), invoke.toArray());

    }

    @Test
    public void genSeqToTest2() throws InvocationTargetException, IllegalAccessException {
        List<BigInteger> template = new ArrayList<>();
        template.add(new BigInteger("1"));
        template.add(new BigInteger("1"));
        Fibonacci fibonacci = new Fibonacci();
        int position = -1;
        List<BigInteger> invoke = (List<BigInteger>) genSeqToTest.invoke(fibonacci, position);
        System.out.println(invoke);
        assertArrayEquals(template.toArray(), invoke.toArray());

    }
}
