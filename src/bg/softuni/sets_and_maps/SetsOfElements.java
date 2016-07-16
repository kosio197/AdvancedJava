package bg.softuni.sets_and_maps;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {

    private static Set<Integer> S1 = new HashSet<>();
    private static Set<Integer> S2 = new HashSet<>();

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        s.nextLine();

        for (int i = 0; i < n; i++) {
            S1.add(s.nextInt());
        }
        for (int i = 0; i < m; i++) {
            int x = s.nextInt();
            S2.add(x);
            if (S1.contains(x)) {
                System.out.print(x + " ");
            }
        }
        s.close();
    }

}
