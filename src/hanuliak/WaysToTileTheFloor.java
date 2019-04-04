package hanuliak;

import main.Algorithm;

import java.io.BufferedReader;
import java.io.IOException;

public class WaysToTileTheFloor implements Algorithm {

    private int width;
    private int length;
    private int countWay;

    public WaysToTileTheFloor() {
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public void setLength(String length) {
        this.length = Integer.parseInt(length);
    }

    public void setWidth(String width) {
        this.width = Integer.parseInt(width);
    }


    public void input(BufferedReader reader) {
        String width;
        String length;
        System.out.println("Please, input floor width (integer number): ");

        try {
            try {
                width = reader.readLine();
                setWidth(width);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Please, input floor length (integer number): ");
            try {
                length = reader.readLine();
                setLength(length);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.out.println("Invalid data, please try again");
            input(reader);
        }
    }


    public void output() {
        System.out.println("Count ways to tile the floor: " + countWay);
    }

    public void calculate() {
        countWay = calcCountWay(width, length);
    }

    /**
     * @param n
     * @param m
     * @return
     */
    private int calcCountWay(int n, int m) {
        if (n < m) {
            return 1;
        }
        if (n == m) {
            return 2;
        }
        return calcCountWay(n - 1, m) + calcCountWay(n - m, m);
    }

    /**
     *
     */
    public  void infoAboutTask(){
        System.out.println("Goal: Given a floor of size n x m and tiles of size 1 x m. The problem");
        System.out.println("is to count the number of ways to tile the given floor using 1 x m tiles.");
        System.out.println("A tile can either be  placed horizontally or vertically.");

    }

    @Override
    public void start(BufferedReader bufferedReader) {
        infoAboutTask();
        input(bufferedReader);
        calculate();
        output();
    }



    @Override
    public String toString() {
        return "Ways To Tile The Floor";
    }
}