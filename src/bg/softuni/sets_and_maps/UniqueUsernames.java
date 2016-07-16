package bg.softuni.sets_and_maps;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames {



    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        s.nextLine();

        Set<String> S = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String str = s.nextLine().trim();
            if (!S.contains(str)) {
                S.add(str);
                System.out.println(str);
            }
        }

        s.close();
    }

}
