package bg.softuni.streamapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class OfficeStuff {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.valueOf(br.readLine());
        for (int i = 0; i < count; i++) {

            String inp = br.readLine();
            processData(inp.replace('|', ' '));
        }

        printResult();
    }

    private static void printResult() {

        for (Map.Entry<String, Map<String, Integer>> e : map.entrySet()) {

            System.out.print(e.getKey() + ": ");
            List<String> list = new ArrayList<>();
            for (Map.Entry<String, Integer> l : e.getValue().entrySet()) {
                list.add(l.getKey());
            }
            for (int i = 0; i < list.size() - 1; i++) {
                System.out.print(list.get(i) + "-" + e.getValue().get(list.get(i)) + ", ");
            }
            System.out.print(list.get(list.size() - 1) + "-" + e.getValue().get(list.get(list.size() - 1)) + "\n");
        }
    }

    private static Map<String, Map<String, Integer>> map = new TreeMap<>();
    private static void processData(String data) {

        String[] str = data.split("-");
        String company = str[0].trim();
        String produkt = str[2].trim();
        int amount = Integer.valueOf(str[1].trim());

        Map<String, Integer> productMap = map.get(company);
        if (productMap == null) {
            productMap = new LinkedHashMap<>();
        }

        if (!productMap.containsKey(produkt)) {
            productMap.put(produkt, amount);
        } else {
            productMap.put(produkt, productMap.get(produkt) + amount);
        }
        map.put(company, productMap);
    }
}
