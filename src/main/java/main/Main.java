package main;


import chenchak.FriendPairs;
import chenchak.InsertingRow;
import chenchak.MergeSort;
import hanuliak.FindMaxSubSequenceLength;
import hanuliak.WaysToTileTheFloor;
import levytskyi.CountingSort;
import levytskyi.PathsWithoutCrossing;
import narepeha.Fibonacci;
import narepeha.LowAndHighEffort;
import narepeha.QuickSort;
import silich.InsertionSorting;
import silich.WaysToCover;


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
    private static final List<main.java.main.Algorithm> TASKS = new ArrayList<>();
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

        boolean isRunning = true;
        int chose = TASKS.size();

        while (isRunning) {
            System.out.println("Enter number of task: \n");
            for (int i = 0; i < TASKS.size(); i++) {
                System.out.println(i + " " + TASKS.get(i));
            }
            System.out.println(TASKS.size() + " Exit");
            try {
                chose = Integer.parseInt(BUFFERED_READER.readLine());
            } catch (Exception e) {
                System.out.println("You can use letters only");
            }

            if (chose == TASKS.size()) {
                isRunning=false;
            } else if ((chose < TASKS.size()) && (chose >= 0)) {
                TASKS.get(chose).start(BUFFERED_READER);
            } else {
                System.out.println("Try to write one more time");
            }

            System.out.println("\n------------------------------------------------------");
        }
    }
}
