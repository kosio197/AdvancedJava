package bg.softuni.regexp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QueryMess {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inp = br.readLine();

        while (!inp.equals("END")) {

            inp = inp.replaceAll("\\+|%20|\\s+", " ");
            inp = inp.replaceAll("\\s+", " ");

            String input[] = inp.split("\\?");

            for (String str : input) {
                checkInput(str);
            }

            for (Map.Entry<String, List<String>> map : map.entrySet()) {

                System.out.print(map.getKey() + "=[");
                for (int i = 0; i < map.getValue().size() - 1; i++) {
                    System.out.print(map.getValue().get(i) + ", ");
                }
                System.out.print(map.getValue().get(map.getValue().size() - 1) + "]");
            }
            if (!map.isEmpty()) {
                System.out.println();
                map.clear();
            }

            inp = br.readLine();
        }
        br.close();
    }

    private static Map<String, List<String>> map = new LinkedHashMap<>();

    private static void checkInput(String inp) {

        Pattern p = Pattern.compile("^.*?=.*?$"); // login=student
                                                  // (\\s*\\w+\\s?)
        // &
        // password=student
        String[] data = inp.split("&");

        for (String str : data) {

            Matcher m = p.matcher(str);
            if (m.find()) {
                String k = m.group(0).split("=")[0].trim();
                String v = m.group(0).split("=")[1].trim();

                List<String> list = map.get(k);
                if (list == null) {
                    list = new ArrayList<>();
                    map.put(k, list);
                }
                map.get(k).add(v);
            }
        }
    }
}
