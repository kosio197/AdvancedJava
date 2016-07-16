package bg.softuni.stacks_and_queues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SequenceWithQueue {

    private static ArrayDeque<Double> Q = new ArrayDeque<>();

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int index = 0;
        Q.add(s.nextDouble());

        while (index < 50) {

            Double x = Q.poll();
            Q.add(x + 1);
            Q.add((2 * x) + 1);
            Q.add(x + 2);

            index++;
            System.out.printf("%.0f ", x);
        }
        s.close();
    }
}
