package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


class Main {
    private static final List<Algorithm> tasks = new ArrayList<>();
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {

        int chose = 0;
/*        while (true) {
            System.out.println("Enter number of task or: \n");
            for (int i = 0; i < tasks.size(); i++) {

                System.out.println(i + " " + tasks.get(i));
            }
            System.out.println(tasks.size() + " Exit");
            try {
                chose = Integer.parseInt(bufferedReader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (chose == tasks.size()) {
                break;
            }
            tasks.get(chose).start(bufferedReader);
            System.out.println("\n-----------------------------------------------");
        }*/
    }
}