package bg.softuni.string_processing;

import java.util.Scanner;

public class CountSubstringOccurrences {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        String text = s.nextLine().toLowerCase();
        String str = s.nextLine().toLowerCase();
        s.close();

        int result = 0;
        int index = 0;

        while (true) {

            index = text.indexOf(str);
            if (index == -1) {
                break;
            }
            result++;
            text = text.substring(++index);
        }

        System.out.println(result);
    }
}
