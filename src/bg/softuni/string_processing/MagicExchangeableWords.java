package bg.softuni.string_processing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MagicExchangeableWords {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String str[] = s.nextLine().split("\\s+");
        String fStr = str[0];
        String sStr = str[1];
        s.close();

        boolean exchangeable = true;
        Map<Character, Character> map = new HashMap<>();

        if (fStr.length() == sStr.length()) {
            for (int i = 0; i < sStr.length(); i++) {
                if (!map.containsKey(fStr.charAt(i))) {

                    map.put(fStr.charAt(i), sStr.charAt(i));

                } else {
                    if (map.get(fStr.charAt(i)) != sStr.charAt(i)) {
                        exchangeable = false;
                        break;
                    }
                }
            }
        } else {

            Set<Character> fSet = new HashSet<>();
            for (Character c : fStr.toCharArray()) {
                fSet.add(c);
            }

            Set<Character> sSet = new HashSet<>();
            for (Character c : sStr.toCharArray()) {
                sSet.add(c);
            }

            if (fSet.size() != sSet.size()) {
                exchangeable = false;
            }

        }



        System.out.println(exchangeable);
    }
}
