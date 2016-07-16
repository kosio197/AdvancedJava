package bg.softuni.stacks_and_queues;

import java.util.Scanner;
import java.util.Stack;

public class BalancedParentheses {

    private static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String str = s.nextLine().trim();
        boolean isbalanced = true;

        for (int i = 0; i < str.length(); i++) {

            int x = str.charAt(i);

            if (x == 40 || x == 91 || x == 123) {
                stack.push(x);
            } else if (!stack.isEmpty()) {
                int y = stack.pop();
                if ((x == 41 && y == 40) || (x == 93 && y == 91) || (x == 125 && y == 123)) {
                    continue;
                } else {
                    isbalanced = false;
                    break;
                }
            } else {
                isbalanced = false;
                break;
            }
        }

        System.out.printf("%s", isbalanced ? "YES" : "NO");
        s.close();
    }
}
