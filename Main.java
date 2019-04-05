package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private final static List<Algorithm> TASKS = new ArrayList<>();
    private final static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {

        TASKS.add(new WaysToWriteNAsSum());
        TASKS.add(new OptimizedPaintingFence());

        boolean isRunning = true;
        int chose = TASKS.size();

        while (isRunning) {
            System.out.println("Enter number of task: \n");
            for (int i = 0; i < TASKS.size(); i++) {
                System.out.println(i + " " + TASKS.get(i));
            }
            System.out.println(TASKS.size() + " Exit");

            try {
                chose = Integer.parseInt(bufferedReader.readLine());
            } catch (Exception e) {
                System.out.println("You can use letters only");
            }

            if (chose == TASKS.size()) {
                break;
            } else if ((chose < TASKS.size()) && (chose >= 0)) {
                TASKS.get(chose).start(bufferedReader);
            } else {
                System.out.println("Try to write one more time");
            }

            System.out.println("\n------------------------------------------------------");
        }
    }
}
