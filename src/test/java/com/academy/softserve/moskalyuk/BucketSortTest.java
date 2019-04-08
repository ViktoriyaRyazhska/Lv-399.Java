<<<<<<< HEAD
package com.academy.softserve.moskalyuk;

import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import static org.junit.Assert.*;

public class BucketSortTest {
    public static Method convertStringToArrayOfIntegers;

    @BeforeClass
    public static void setUp() throws NoSuchMethodException {
        convertStringToArrayOfIntegers
                = BucketSort.class.getDeclaredMethod("convertStringToArrayOfIntegers", String.class);
        convertStringToArrayOfIntegers.setAccessible(true); //make method accessible locally
    }

    @Test
    public void convertStringToArrayOfIntegersTest() throws InvocationTargetException, IllegalAccessException {
        BucketSort bucketSort = new BucketSort();
        int[] result = (int[]) convertStringToArrayOfIntegers.invoke(bucketSort, "1, 2, 3");
        assertTrue(Arrays.equals(result, new int[]{1, 2, 3}));
        result = (int[]) convertStringToArrayOfIntegers.invoke(bucketSort, "0, -5, 5");
        assertTrue(Arrays.equals(result, new int[]{0, -5, 5}));

    }

    @Test(expected = NumberFormatException.class)
    public void convertStringToArrayOfIntegersTest2() throws Throwable {
        BucketSort bucketSort = new BucketSort();
        try {
            int[] result = (int[]) convertStringToArrayOfIntegers.invoke(bucketSort, "abc");
        } catch (InvocationTargetException e) {
            if (e.getCause().getClass() == NumberFormatException.class) {
                throw e.getCause();
            }
        }
    }
=======
package com.academy.softserve.moskalyuk;

import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import static org.junit.Assert.*;

public class BucketSortTest {
    public static Method convertStringToArrayOfIntegers;

    @BeforeClass
    public static void setUp() throws NoSuchMethodException {
        convertStringToArrayOfIntegers
                = BucketSort.class.getDeclaredMethod("convertStringToArrayOfIntegers", String.class);
        convertStringToArrayOfIntegers.setAccessible(true); //make method accessible locally
    }

    @Test
    public void convertStringToArrayOfIntegersTest() throws InvocationTargetException, IllegalAccessException {
        BucketSort bucketSort = new BucketSort();
        int[] result = (int[]) convertStringToArrayOfIntegers.invoke(bucketSort, "1, 2, 3");
        assertTrue(Arrays.equals(result, new int[]{1, 2, 3}));
        result = (int[]) convertStringToArrayOfIntegers.invoke(bucketSort, "0, -5, 5");
        assertTrue(Arrays.equals(result, new int[]{0, -5, 5}));

    }

    @Test(expected = NumberFormatException.class)
    public void convertStringToArrayOfIntegersTest2() throws Throwable {
        BucketSort bucketSort = new BucketSort();
        try {
            int[] result = (int[]) convertStringToArrayOfIntegers.invoke(bucketSort, "abc");
        } catch (InvocationTargetException e) {
            if (e.getCause().getClass() == NumberFormatException.class) {
                throw e.getCause();
            }
        }
    }
>>>>>>> dev
}