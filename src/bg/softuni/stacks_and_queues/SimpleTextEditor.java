package bg.softuni.stacks_and_queues;

import java.util.Scanner;
import java.util.Stack;

public class SimpleTextEditor {

    private static Stack<Character> text = new Stack<>();
    private static Stack<Character> undo = new Stack<>();
    private static Stack<Integer> countUndo = new Stack<>();

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        s.nextLine();
        for (int i = 0; i < n; i++) {
            String comand[] = s.nextLine().split(" ");

            switch (Integer.valueOf(comand[0])) {
                case 1:
                    append(comand[1]);
                    break;
                case 2:
                    erases(Integer.valueOf(comand[1]));
                    break;
                case 3:
                    returns(Integer.valueOf(comand[1]));
                    break;
                case 4:
                    undoes();
                    break;
                default:
                    break;
            }

        }

        s.close();
    }

    private static void undoes() {

        int count = countUndo.pop();
        if (count > 0) {
            for (int i = 0; i < count; i++) {
                text.pop();
            }
        } else {
            for (int i = 0; i < count * (-1); i++) {
                text.push(undo.pop());
            }
        }

    }

    private static void returns(Integer index) {

        System.out.println(text.get(index - 1));
    }

    private static void erases(Integer count) {

        for (int i = 0; i < count; i++) {
            undo.push(text.pop());
        }
        countUndo.push(count * (-1));

    }

    private static void append(String str) {

        int count = str.length();
        for (int i = 0; i < count; i++) {
            text.push(str.charAt(i));
        }
        countUndo.push(count);
    }
}
