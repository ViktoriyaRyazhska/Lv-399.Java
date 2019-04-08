package com.academy.softserve.chenchak;

import com.academy.softserve.chenchak.FriendPairs;
import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.*;

public class FriendPairsTest {

    private static Method countFriendsPairings;

    @BeforeClass
    public static void init() throws NoSuchMethodException {
        countFriendsPairings = FriendPairs.class.getDeclaredMethod("countFriendsPairings", int.class);
        countFriendsPairings.setAccessible(true);
    }

    @Test
    public void countFriendsPairings() throws InvocationTargetException, IllegalAccessException {
        FriendPairs friendPairs = new FriendPairs();
        int value = 3;
        int result = (int) countFriendsPairings.invoke(friendPairs, value);
        assertEquals(result, 4);
    }

    @Test(expected = Exception.class)
    public void countFriendsPairingsFail() throws InvocationTargetException, IllegalAccessException {
        FriendPairs friendPairs = new FriendPairs();
        int value = -10;
        int result = (int) countFriendsPairings.invoke(friendPairs, value);
        assertEquals(result, 4);
    }
}