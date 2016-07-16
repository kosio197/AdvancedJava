package bg.softuni.sets_and_maps;

import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class CountSymbols {

    private static SortedMap<Character, Integer> map = new TreeMap<>();

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String str = s.nextLine();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                int x = map.get(c);
                map.put(c, ++x);
            }
        }

        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            System.out.printf("%s: %d time/s\n", e.getKey(), e.getValue());
        }
        s.close();
    }

}
