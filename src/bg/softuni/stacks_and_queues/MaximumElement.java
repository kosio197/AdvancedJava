package bg.softuni.stacks_and_queues;

import java.util.Scanner;
import java.util.Stack;

public class MaximumElement {

    private static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int maxinp[] = new int[n + 1];
        int index = 1;

        for (int i = 0; i < n; i++) {
            int query = s.nextInt();

            switch (query) {
                case 1:
                    int next = s.nextInt();

                    stack.push(next);

                    if (next >= maxinp[index - 1]) {
                        maxinp[index] = next;
                    } else {
                        maxinp[index] = maxinp[index - 1];
                    }

                    index++;

                    break;
                case 2:
                    stack.pop();
                    index--;
                    break;
                case 3:
                    // printMax();
                    System.out.println(maxinp[index - 1]);
                    break;
            }
        }

        s.close();
    }
}
