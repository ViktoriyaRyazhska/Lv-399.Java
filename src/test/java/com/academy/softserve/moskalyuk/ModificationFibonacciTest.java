<<<<<<< HEAD
package com.academy.softserve.moskalyuk;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.*;

public class ModificationFibonacciTest {
    public static Method getIndexOfElement;

    @BeforeClass
    public static void setUp() throws NoSuchMethodException {
        getIndexOfElement
                = ModificationFibonacci.class.getDeclaredMethod("getIndexOfElement", int.class);
        getIndexOfElement.setAccessible(true); //make method accessible locally
    }

    @Test
    public void getIndexOfElementTest() throws InvocationTargetException, IllegalAccessException {
        ModificationFibonacci modificationFibonacci = new ModificationFibonacci();
        int result = (int) getIndexOfElement.invoke(modificationFibonacci, 2);
        assertTrue(result == 1);
        result = (int) getIndexOfElement.invoke(modificationFibonacci, 20);
        ;
        assertTrue(result == 872);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void getIndexOfElementTest2() throws Throwable {
        ModificationFibonacci modificationFibonacci = new ModificationFibonacci();
        try {
            int result = (int) getIndexOfElement.invoke(modificationFibonacci, -1);
        } catch (InvocationTargetException e) {
            if (e.getCause().getClass() == ArrayIndexOutOfBoundsException.class) {
                throw e.getCause();
            }
        }


    }
=======
package com.academy.softserve.moskalyuk;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.*;

public class ModificationFibonacciTest {
    public static Method getIndexOfElement;

    @BeforeClass
    public static void setUp() throws NoSuchMethodException {
        getIndexOfElement
                = ModificationFibonacci.class.getDeclaredMethod("getIndexOfElement", int.class);
        getIndexOfElement.setAccessible(true); //make method accessible locally
    }

    @Test
    public void getIndexOfElementTest() throws InvocationTargetException, IllegalAccessException {
        ModificationFibonacci modificationFibonacci = new ModificationFibonacci();
        int result = (int) getIndexOfElement.invoke(modificationFibonacci, 2);
        assertTrue(result == 1);
        result = (int) getIndexOfElement.invoke(modificationFibonacci, 20);
        ;
        assertTrue(result == 872);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void getIndexOfElementTest2() throws Throwable {
        ModificationFibonacci modificationFibonacci = new ModificationFibonacci();
        try {
            int result = (int) getIndexOfElement.invoke(modificationFibonacci, -1);
        } catch (InvocationTargetException e) {
            if (e.getCause().getClass() == ArrayIndexOutOfBoundsException.class) {
                throw e.getCause();
            }
        }


    }
>>>>>>> dev
}