package bg.softuni.sets_and_maps;

import java.util.HashMap;
import java.util.Scanner;

public class Phonebook {

    private static HashMap<String, String> map = new HashMap<>();

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String str = s.nextLine();

        while (!str.equals("search")) {
            String x[] = str.split("-");
            map.put(x[0], x[1]);

            str = s.nextLine();
        }

        str = s.nextLine();

        while (!str.equals("stop")) {

            if (map.containsKey(str)) {
                System.out.println(str + " -> " + map.get(str));
            } else {
                System.out.println("Contact " + str + " does not exist.");
            }

            str = s.nextLine();

        }
        s.close();
    }

}
