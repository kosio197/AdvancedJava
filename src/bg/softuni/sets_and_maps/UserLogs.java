package bg.softuni.sets_and_maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class UserLogs {

    static class User implements Comparable<User> {

        private String username;
        private Map<String, Integer> ipMap;

        public User(String username, Map<String, Integer> ipMap) {
            this.username = username;
            this.ipMap = ipMap;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public Map<String, Integer> getIpMap() {
            return ipMap;
        }

        public void setIpMap(Map<String, Integer> ipMap) {
            this.ipMap = ipMap;
        }

        @Override
        public int compareTo(User o) {
            return username.compareTo(o.username);
        }
    }

    private static SortedSet<User> users = new TreeSet<>();
    private static Map<String, User> usersList = new HashMap<>();

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String inp = s.nextLine();

        while (!inp.equals("end")) {
            String str[] = inp.split(" ");
            String ip = str[0].split("=")[1];
            String username = str[2].split("=")[1];

            Map<String, Integer> map;
            if (!usersList.containsKey(username)) {
                map = new LinkedHashMap<String, Integer>();
                map.put(ip, 1);
                User next = new User(username, map);
                users.add(next);
                usersList.put(username, next);
            } else {
                map = usersList.get(username).getIpMap();
                if (!map.containsKey(ip)) {
                    map.put(ip, 1);
                } else {
                    map.put(ip, map.get(ip) + 1);
                }
            }

            inp = s.nextLine();
        }

        printUsers();
        s.close();
    }

    private static void printUsers() {

        for (User user : users) {
            System.out.print(user.username + ":\n");
            List<String> l = new ArrayList<>();
            for (Map.Entry<String, Integer> e : user.ipMap.entrySet()) {
                l.add(e.getKey() + " => " + e.getValue());
            }

            for (int i = 0; i < l.size() - 1; i++) {
                System.out.print(l.get(i) + ", ");
            }
            System.out.print(l.get(l.size() - 1) + ".\n");
        }

    }
}
