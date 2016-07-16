package bg.softuni.string_processing;

import java.util.Scanner;

public class TextFilter {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        String ban[] = s.nextLine().split(", ");
        String text = s.nextLine();
        s.close();

        for (String word : ban) {
            String ast = "";
            for (int i = 0; i < word.length(); i++) {
                ast = '*' + ast;
            }
            text = text.replaceAll(word, ast);
        }
        System.out.println(text);
    }
}
