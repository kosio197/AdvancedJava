package bg.softuni.string_processing;

import java.util.Scanner;

public class LettersChangeNumbers {

    private static double result = 0;
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String data[] = s.nextLine().trim().split("\\s+");
        s.close();

        for (int i = 0; i < data.length; i++) {
            calculate(data[i]);
        }

        printResult();
    }

    private static void calculate(String data) {

        char first = data.charAt(0);
        char last = data.charAt(data.length() - 1);
        double num = Integer.valueOf(data.substring(1, data.length() - 1));

        int fPosition = getPosition(first);
        int lPosition = getPosition(last);

        double temp = 0;

        if (first < 91) {
            temp = num / fPosition;
        } else {
            temp = num * fPosition;
        }

        if (last < 91) {
            temp -= lPosition;
        } else {
            temp += lPosition;
        }
        result += temp;
    }

    private static int getPosition(char currentChar) {

        if (currentChar > 64 && currentChar < 91) {
            return currentChar - 64;

        } else if (currentChar > 96 && currentChar < 123) {

            return currentChar - 96;
        }
        return 0;
    }

    private static void printResult() {

        System.out.printf("%.2f", result);
    }
}
