package bg.softuni.string_processing;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Palindromes {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String str = s.nextLine().trim();
        s.close();

        String word[] = str.split("[, |\\. |\\? |\\! ]\\s*|[, |\\. |\\? |\\! ]");
        List<String> set = new LinkedList<String>();

        for (String w : word) {
            boolean palendrom = true;
            for (int i = 0; i < w.length() / 2; i++) {
                if (w.charAt(i) != w.charAt(w.length() - 1 - i)) {
                    palendrom = false;
                }
            }
            if (palendrom && !set.contains(w)) {
                set.add(w);
            }
        }
        Collections.sort(set, String.CASE_INSENSITIVE_ORDER);

        System.out.println("[" + String.join(", ", set) + "]");
    }
}
