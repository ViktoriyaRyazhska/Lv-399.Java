package com.academy.softserve.moskalyuk;

import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.*;

public class PalindromicSubSequenceTest {
    public static Method getSizeOfPalindromeSubSequence;

    @BeforeClass
    public static void setUp() throws NoSuchMethodException {
        getSizeOfPalindromeSubSequence
                = PalindromicSubSequence.class.getDeclaredMethod("getSizeOfPalindromeSubSequence", String.class);
        getSizeOfPalindromeSubSequence.setAccessible(true); //make method accessible locally
    }

    @Test
    public void getIndexOfElementTest() throws InvocationTargetException, IllegalAccessException {
        PalindromicSubSequence palindromicSubSequence = new PalindromicSubSequence();
        int result = (int) getSizeOfPalindromeSubSequence.invoke(palindromicSubSequence, "abba");
        assertTrue(result == 4);
        result = (int)getSizeOfPalindromeSubSequence.invoke(palindromicSubSequence, ".....");
        assertTrue(result == 5);
    }

//    @Test(expected = ArrayIndexOutOfBoundsException.class)
//    public void getIndexOfElementTest2() throws Throwable {
//        PalindromicSubSequence palindromicSubSequence = new PalindromicSubSequence();
//        try {
//            int result = (int) getSizeOfPalindromeSubSequence.invoke(palindromicSubSequence, -1);
//        } catch (InvocationTargetException e) {
//            if (e.getCause().getClass() == ArrayIndexOutOfBoundsException.class) {
//                throw e.getCause();
//            }
//        }
//
//
//    }

}