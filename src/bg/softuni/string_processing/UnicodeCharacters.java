package bg.softuni.string_processing;

import java.util.Scanner;

public class UnicodeCharacters {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        s.close();

        for (char c : str.toCharArray()) {
            System.out.print(String.format("\\u%04x", (int) c));
        }
    }
}
