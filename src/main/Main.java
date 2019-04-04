package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private final static List<Algorithm> TASKS = new ArrayList<>();
    private final static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {

        TASKS.add(new CountingSort());
        TASKS.add(new PathsWithoutCrossing());

        boolean onStatus = true;
        int chose = TASKS.size();

        while (onStatus) {
            System.out.println("Enter number of task or: \n");
            for (int i = 0; i < TASKS.size(); i++) {
                System.out.println(i + " " + TASKS.get(i));
            }
            System.out.println(TASKS.size() + " Exit");

            try {
                chose = Integer.parseInt(bufferedReader.readLine());
            } catch (Exception e) {
                System.out.println("Try to write one more time");
            }

            if (chose == TASKS.size()) {
                break;
            }
            if (chose < TASKS.size()) {
                TASKS.get(chose).start(bufferedReader);

            }
            if (chose > TASKS.size()) {
                System.out.println("Try to write one more time");
            }
            System.out.println("\n-----------------------------------------------");
        }
    }
}
