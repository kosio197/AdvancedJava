package bg.softuni.sets_and_maps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {

    private static Map<String, String> map = new LinkedHashMap<>();

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String str = s.nextLine();

        while (!str.equals("stop")) {

            String x = s.nextLine();

            if (!x.toLowerCase().endsWith("uk") && !x.toLowerCase().endsWith("us")) {
                map.put(str, x);
            }
            str = s.nextLine();
        }

        for (Map.Entry<String, String> e : map.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }

        s.close();
    }
}
