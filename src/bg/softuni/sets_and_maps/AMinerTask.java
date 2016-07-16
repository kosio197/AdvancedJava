package bg.softuni.sets_and_maps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {

    private static Map<String, Integer> map = new LinkedHashMap<>();

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String str= s.nextLine();

        while (!str.equals("stop")) {

            int i=s.nextInt();
            s.nextLine();

            if(!map.containsKey(str)){
                map.put(str, i);

            }else{
                map.put(str, map.get(str) + i);
            }
            str = s.nextLine();
        }

        for (Map.Entry<String, Integer> e : map.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }

        s.close();
    }
}
