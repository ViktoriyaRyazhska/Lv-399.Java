package main.java.main;


import levytskyi.PathsWithoutCrossing;


import main.java.chenchak.FriendPairs;
import main.java.chenchak.InsertingRow;
import main.java.chenchak.MergeSort;
import main.java.hanuliak.FindMaxSubSequenceLength;
import main.java.hanuliak.WaysToTileTheFloor;
import main.java.levytskyi.CountingSort;
import main.java.narepeha.Fibonacci;
import main.java.narepeha.LowAndHighEffort;
import main.java.narepeha.QuickSort;
import main.java.silich.InsertionSorting;
import main.java.silich.WaysToCover;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * the main class with static method.
 */
public final class Main {
    /**
     * variable that contains all tasks
     * implemented by the team.
     */
    private static final List<Algorithm> TASKS = new ArrayList<>();
    /**
     * the reader
     * to be used for getting information from the user
     * never close it inside your class!
     */
    private static final BufferedReader BUFFERED_READER;

    static {
        BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));
    }

    /**
     * private constructor
     * to make this class impossible to instantiate.
     */
    private Main() {
    }

    /**
     * @param args default parameters from the console
     */
    public static void main(final String[] args) {

        TASKS.add(new FindMaxSubSequenceLength());
        TASKS.add(new WaysToTileTheFloor());
        TASKS.add(new CountingSort());
        TASKS.add(new PathsWithoutCrossing());
        TASKS.add(new Fibonacci());
        TASKS.add(new QuickSort());
        TASKS.add(new WaysToCover());
        TASKS.add(new InsertionSorting());
        TASKS.add(new LowAndHighEffort());
        TASKS.add(new FriendPairs());
        TASKS.add(new InsertingRow());
        TASKS.add(new MergeSort());

        boolean onStatus = true;
        int chose = TASKS.size();

        while (onStatus) {
            System.out.println("Enter number of task or: \n");
            for (int i = 0; i < TASKS.size(); i++) {
                System.out.println(i + " " + TASKS.get(i));
            }
            System.out.println(TASKS.size() + " Exit");

            try {
                chose = Integer.parseInt(BUFFERED_READER.readLine());
            } catch (Exception e) {
                System.out.println("Try to write one more time");
            }
            if (chose == TASKS.size()) {
                onStatus = false; //exit
            }
            if (chose < TASKS.size()) {
                TASKS.get(chose).start(BUFFERED_READER);

            }
            if (chose > TASKS.size()) {
                System.out.println("Try to write one more time");
            }
            System.out.println("\n-----------------------------------------------");
        }
    }
}
