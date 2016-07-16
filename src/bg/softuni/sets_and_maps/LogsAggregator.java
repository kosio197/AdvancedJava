package bg.softuni.sets_and_maps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LogsAggregator {

    private static Map<String, TreeMap<String, Integer>> userMap = new TreeMap<>();

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        s.nextLine();

        for (int i = 0; i < n; i++) {
            receiveLogs(s.nextLine().trim());
        }

        printUserLogs();
        s.close();
    }

    private static void printUserLogs() {

        for (Map.Entry<String, TreeMap<String, Integer>> users : userMap.entrySet()) {
            List<String> ipList = new ArrayList<>();
            int allDuration = 0;
            for (Map.Entry<String, Integer> ips : users.getValue().entrySet()) {
                ipList.add(ips.getKey());
                allDuration += ips.getValue();
            }
            System.out.printf("%s: %s [%s]\n", users.getKey(), allDuration, String.join(", ", ipList));
        }

    }

    private static void receiveLogs(String input) {

        String getData[] = input.split(" ");

        String ip = getData[0];
        String user = getData[1];
        int duration = Integer.valueOf(getData[2]);

        TreeMap<String, Integer> ipMap;
        if (!userMap.containsKey(user)) {

            ipMap = new TreeMap<>();
            ipMap.put(ip, duration);
            userMap.put(user, ipMap);
        } else {

            ipMap = userMap.get(user);
            if (!ipMap.containsKey(ip)) {
                ipMap.put(ip, duration);
            } else {
                ipMap.put(ip, ipMap.get(ip) + duration);
            }
        }
    }

}
