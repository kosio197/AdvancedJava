package bg.softuni.sets_and_maps;

import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class PeriodicTable {

    private static SortedSet<String> S = new TreeSet<>();

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        s.nextLine();

        for (int i = 0; i < n; i++) {
            String str[] = s.nextLine().split(" ");
            for (int j = 0; j < str.length; j++) {
                String x = str[j];

                if (!S.contains(x)) {
                    S.add(x);
                }
            }
        }

        for (String str : S) {
            System.out.print(str + " ");
        }
        s.close();
    }
}
