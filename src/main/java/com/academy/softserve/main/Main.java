package com.academy.softserve.main;

import com.academy.softserve.chenchak.FriendPairs;
import com.academy.softserve.chenchak.InsertingRow;
import com.academy.softserve.chenchak.MergeSort;
import com.academy.softserve.hanuliak.FindMaxSubSequenceLength;
import com.academy.softserve.hanuliak.WaysToTileTheFloor;
import com.academy.softserve.levytskyi.CountingSort;
import com.academy.softserve.levytskyi.PathsWithoutCrossing;
import com.academy.softserve.narepeha.Fibonacci;
import com.academy.softserve.narepeha.LowAndHighEffort;
import com.academy.softserve.narepeha.QuickSort;
import com.academy.softserve.silich.InsertionSorting;
import com.academy.softserve.silich.WaysToCover;
import com.academy.softserve.verkholiak.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * the com.academy.softserve.main class with static method.
 */
public final class Main {
    /**
     * variable that contains all tasks
     * implemented by the team.
     */
    private static final List<Algorithm> TASKS;
    /**
     * the reader
     * to be used for getting information from the user
     * never close it inside your class!
     */
    private static final BufferedReader BUFFERED_READER;

    static {
        BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));
        TASKS = new ArrayList<>();
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
        TASKS.add(new OptimizedPaintingFence());
        TASKS.add(new WaysToWriteNAsSum());

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
                System.out.println("You can use numbers only");
                continue;
            }

            if (chose == TASKS.size()) {
                isRunning = false;
            } else if ((chose < TASKS.size()) && (chose >= 0)) {
                TASKS.get(chose).start(BUFFERED_READER);
            } else {
                System.out.println("Try to write one more time");
            }

            System.out.println("\n------------------------------------------------------");
        }
    }
}
