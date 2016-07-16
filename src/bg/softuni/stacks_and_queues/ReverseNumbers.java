package bg.softuni.stacks_and_queues;

import java.util.Scanner;
import java.util.Stack;

public class ReverseNumbers {

    private static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String str[] = s.nextLine().split(" ");

        for (int i = 0; i < str.length; i++) {
            stack.push(Integer.parseInt(str[i]));
        }

        printStack();
        s.close();
    }

    private static void printStack() {

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");

        }
    }
}
