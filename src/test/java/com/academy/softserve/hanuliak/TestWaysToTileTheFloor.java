package com.academy.softserve.hanuliak;

import com.academy.softserve.hanuliak.WaysToTileTheFloor;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * Created by Illia Chenchak
 */
public class TestWaysToTileTheFloor {

    @Test
    public void calcCountWayTestWithSameValue() {
        int n = 7;
        int m = 7;
        WaysToTileTheFloor waysToTileTheFloor = new WaysToTileTheFloor();
        assertEquals(2,waysToTileTheFloor.calculate(n,m));
    }

    @Test
    public void calcCountWayTestWhereNIsSmaller() {
        int n = 6;
        int m = 7;
        WaysToTileTheFloor waysToTileTheFloor = new WaysToTileTheFloor();
        assertEquals(1,waysToTileTheFloor.calculate(n,m));
    }

    @Test
    public void calcCountWayTestWhereNIsBigger() {
        int n = 8;
        int m = 7;
        WaysToTileTheFloor waysToTileTheFloor = new WaysToTileTheFloor();
        assertEquals(3,waysToTileTheFloor.calculate(n,m));
    }


}
