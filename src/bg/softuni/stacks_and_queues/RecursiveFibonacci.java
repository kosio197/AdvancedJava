package bg.softuni.stacks_and_queues;

import java.util.Scanner;

public class RecursiveFibonacci {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        System.out.println(getFibonacci(s.nextInt()));

        s.close();
    }

    private static long[] arr = new long[50];

    private static long getFibonacci(int n) {

        if (n == 1 || n == 0) {
            return 1;
        }
        if (arr[n] == 0) {
            arr[n] = getFibonacci(n - 1) + getFibonacci(n - 2);
        }

        return arr[n];
    }
}
