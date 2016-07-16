package bg.softuni.sets_and_maps;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LegendaryFarming {

    private static Map<String, Integer> map = new TreeMap<>();
    public static void main(String[] args) {

        map.put("shards", 0);
        map.put("fragments", 0);
        map.put("motes", 0);

        Scanner s = new Scanner(System.in);
        boolean isfinish = true;
        while (isfinish) {
            String input[] = s.nextLine().split(" ");
            for (int i = 0; i < input.length - 1; i += 2) {
                int quantity = Integer.valueOf(input[i]);
                String material = input[i + 1].toLowerCase();
                isfinish = addMaterial(quantity, material);
                if (!isfinish) {
                    s.close();
                    break;
                }
            }
        }
    }

    private static void printResult(String material) {
        String str = "";
        if (material.equals("shards")) {
            str = "Shadowmourne";
        } else if (material.equals("fragments")) {
            str = "Valanyr";
        } else {
            str = "Dragonwrath";
        }
        System.out.printf("%s obtained!\n", str);

        map.put(material, map.get(material) - 250);

        Map<String, Integer> junk = new TreeMap<>();

        junk.put("shards", map.get("shards"));
        map.remove("shards");
        junk.put("fragments", map.get("fragments"));
        map.remove("fragments");
        junk.put("motes", map.get("motes"));
        map.remove("motes");

        junk = sortByValue(junk);

        for (Map.Entry<String, Integer> e : junk.entrySet()) {
            System.out.println(e.getKey() + ": " + e.getValue());
        }
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            System.out.println(e.getKey() + ": " + e.getValue());
        }

    }

    private static boolean addMaterial(int quantity, String material) {

        if (!map.containsKey(material)) {
            map.put(material, quantity);
        } else {
            map.put(material, map.get(material) + quantity);
        }

        if (!material.equals("shards") && !material.equals("fragments") && !material.equals("motes")) {
            return true;
        }
        return checkValue(material);
    }

    private static boolean checkValue(String material) {

        int value = map.get(material);
        if (value >= 250) {
            printResult(material);
            return false;
        }
        return true;
    }

    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new LinkedList<Map.Entry<K, V>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
            @Override
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        Map<K, V> result = new LinkedHashMap<K, V>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
}
