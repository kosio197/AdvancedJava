package bg.softuni.sets_and_maps;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class HandsCards {

    private static Map<String, HashSet<String>> map = new LinkedHashMap<>();

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String input = s.nextLine();

        while (!input.equals("JOKER")) {
            String name = input.split(":")[0];
            String cards[] = input.split(":")[1].trim().split(", ");

            HashSet<String> plearCards;

            if (!map.containsKey(name)) {
                plearCards = new HashSet<>();

            } else {
                plearCards = map.get(name);

            }

            for (String string : cards) {
                plearCards.add(string);
            }
            map.put(name, plearCards);
            input = s.nextLine();
        }

        printPlears();
        s.close();
    }

    private static void printPlears() {

        for (Map.Entry<String, HashSet<String>> e : map.entrySet()) {
            System.out.println(e.getKey() + ": " + calculateCards(e.getValue()));
        }
    }

    private static int calculateCards(HashSet<String> value) {

        int result = 0;
        for (String str : value) {
            result += getPower(str.charAt(0)) * getType(str.charAt(str.length() - 1));
        }

        return result;
    }

    private static int getType(char c) {

        switch (c) {
            case 'S':
                return 4;
            case 'H':
                return 3;
            case 'D':
                return 2;
            case 'C':
                return 1;
            default:
                return 0;
        }
    }

    private static int getPower(char c) {

        switch (c) {
            case '1':
                return 10;
            case '2':
                return 2;
            case '3':
                return 3;
            case '4':
                return 4;
            case '5':
                return 5;
            case '6':
                return 6;
            case '7':
                return 7;
            case '8':
                return 8;
            case '9':
                return 9;
            case 'J':
                return 11;
            case 'Q':
                return 12;
            case 'K':
                return 13;
            case 'A':
                return 14;
            default:
                return 0;
        }
    }
}
