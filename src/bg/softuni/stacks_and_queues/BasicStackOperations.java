package bg.softuni.stacks_and_queues;

import java.util.Scanner;
import java.util.Stack;

public class BasicStackOperations {

    private static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int S = s.nextInt();
        int X = s.nextInt();

        for (int i = 0; i < N; i++) {
            stack.push(s.nextInt());
        }
        for (int i = 0; i < S; i++) {
            stack.pop();
        }

        if (stack.contains(X)) {
            System.out.println("true");
        } else {
            System.out.println(findMin());
        }
        s.close();
    }

    private static int findMin() {

        int result = Integer.MAX_VALUE;

        if (stack.isEmpty()) {
            result = 0;
        } else {
            while (!stack.isEmpty()) {
                int i = stack.pop();
                if (result > i) {
                    result = i;
                }
            }
        }

        return result;
    }
}
