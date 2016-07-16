package bg.softuni.stacks_and_queues;

import java.util.Scanner;
import java.util.Stack;

public class StackFibonacci {

    private static Stack<Long> stack = new Stack<>();

    public static void main(String[] args) {

        stack.push(1L);
        stack.push(1L);
        Scanner s = new Scanner(System.in);
        int fibNumber = s.nextInt();
        for (int i = 0; i < fibNumber - 1; i++) {
            long n1 = stack.pop();
            long n2 = stack.peek() + n1;
            stack.push(n1);
            stack.push(n2);
        }

        System.out.println(stack.pop());
        s.close();
    }
}
