package bg.softuni.sets_and_maps;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SrubskoUnleashed {

    static class Singer implements Comparable<Singer> {
        private String name;
        private int comein;
        private int amount;

        public Singer(String name, int comein, int amount) {

            this.name = name;
            this.comein = comein;
            this.amount = amount;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getComein() {
            return comein;
        }

        public void setComein(int comein) {
            this.comein = comein;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        @Override
        public int compareTo(Singer o) {

            return amount == o.amount ? o.comein - comein : amount - o.amount;
        }

    }

    private static Map<String, Map<String, Singer>> cities = new LinkedHashMap<>();
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String inp = s.nextLine();
        while (!inp.equals("End")) {

            validateAndAdd(inp);
            inp = s.nextLine();

        }

        printResult();
        s.close();
    }

    private static void printResult() {

        for (Map.Entry<String, Map<String, Singer>> e : cities.entrySet()) {
            System.out.printf("%s\n", e.getKey());
            Map<String, Singer> orderMap = sortByValue(e.getValue());
            for (Map.Entry<String, Singer> s : orderMap.entrySet()) {
                System.out.printf("#  %s -> %s\n", s.getKey(), s.getValue().getAmount());
            }
        }

    }

    private static void validateAndAdd(String inp) {

        String name[] = inp.split(" @");
        if (name.length != 2)
            return;
        String data[] = name[1].split(" ");
        if (data.length < 3)
            return;
        String singer = name[0];
        int amount;
        try {
            amount = Integer.valueOf(data[data.length - 1]) * Integer.valueOf(data[data.length - 2]);
        } catch (Exception e) {
            return;
        }
        String city = "";
        for (int i = 0; i < data.length - 2; i++) {
            city += data[i] + " ";
        }
        city.trim();

        addData(city, singer, amount);
    }

    static int index = 0;
    private static void addData(String city, String singer, int amount) {

        Map<String, Singer> singerMap = cities.get(city);

        if (singerMap == null) {
            singerMap = new HashMap<>();
            cities.put(city, singerMap);
        }

        Singer s = singerMap.get(singer);
        if (s == null) {
            singerMap.put(singer, new Singer(singer, index++, amount));
        } else {
            s.setAmount(s.getAmount() + amount);
        }
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
