package bg.softuni.stacks_and_queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BasicQueueOperations {

    private static Queue<Integer> Q = new LinkedList<>();

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int S = s.nextInt();
        int X = s.nextInt();

        for (int i = 0; i < N; i++) {
            Q.add(s.nextInt());
        }
        for (int i = 0; i < S; i++) {
            Q.poll();
        }

        if (Q.contains(X)) {
            System.out.println("true");
        } else {
            System.out.println(findMin());
        }
        s.close();
    }

    private static int findMin() {

        int result = Integer.MAX_VALUE;

        if (Q.isEmpty()) {
            result = 0;
        } else {
            while (!Q.isEmpty()) {
                int i = Q.poll();
                if (result > i) {
                    result = i;
                }
            }
        }

        return result;
    }
}
