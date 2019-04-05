package com.academy.softserve.hanuliak;


import com.academy.softserve.main.java.main.Algorithm;

import java.io.BufferedReader;

/**
 * This class  calculate the number of ways to tile the given
 * floor using 1 x m tiles if tile can either be placed
 * horizontally or vertically.
 */
public class WaysToTileTheFloor implements Algorithm {

    /**
     * Floor width.
     */
    private int width;
    /**
     * Floor length.
     */
    private int length;

    /**
     * Class constructor.
     */
    public WaysToTileTheFloor() {
    }

    /**
     * @return floor length.
     */
    public int getLength() {
        return length;
    }

    /**
     * @return floor width.
     */
    public int getWidth() {
        return width;
    }

    /**
     * @param reader Read floor length from console.
     */
    public void setLength(final BufferedReader reader) {
        String msgInvalidData = "Invalid data, please try again";
        String msgBeforeInput = "Please, input length(m) (integer number):";
        System.out.println(msgBeforeInput);
        try {
            this.length = Integer.parseInt(reader.readLine());
        } catch (Exception e) {
            System.out.println(msgInvalidData);
            setLength(reader);
        }
    }

    /**
     * @param reader Read floor width from console.
     */
    public void setWidth(final BufferedReader reader) {
        String msgInvalidData = "Invalid data, please try again";
        String msgBeforeInput = "Please, input width(n) (integer number):";
        System.out.println(msgBeforeInput);
        try {
            this.width = Integer.parseInt(reader.readLine());
        } catch (Exception e) {
            System.out.println(msgInvalidData);
            setWidth(reader);
        }
    }

    /**
     * @param n floor width
     * @param m floor length
     * @return number of ways to tile
     */

    public int calculate(final int n, final int m) {
        if (n < m) {
            return 1;
        }
        if (n == m) {
            return 2;
        }
        return calculate(n - 1, m) + calculate(n - m, m);
    }

    /**
     * This method print task goal.
     */
    public void getGoalInfo() {
        String msgGoalInfo =
                "Goal: Given a floor of size n x m and tiles of "
                        + "size 1 x m. The problem \n"
                        + "is to count the number of ways to "
                        + "tile the given floor using 1 x m tiles. \n"
                        + "A tile can either be"
                        + "  placed horizontally or vertically.";
        System.out.println(msgGoalInfo);
    }

    /**
     * @return Task name for menu item.
     */
    @Override
    public String toString() {
        return "Ways To Tile The Floor";
    }

    /**
     * @param bufferedReader read data from console
     */
    @Override
    public void start(final BufferedReader bufferedReader) {
        String msgOutput = "Count ways to tile the floor: ";
        int countWay;
        getGoalInfo();
        setWidth(bufferedReader);
        setLength(bufferedReader);
        countWay = calculate(width, length);
        System.out.println(msgOutput + countWay);
    }
}