package bg.softuni.string_processing;

import java.util.Scanner;

public class StringLength {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        String str = s.nextLine();
        for (int i = 0; i < 20; i++) {
            if (i < str.length()) {
                System.out.print(str.charAt(i));
            } else {
                System.out.print('*');
            }
        }
        s.close();
    }
}
