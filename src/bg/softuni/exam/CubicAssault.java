package bg.softuni.exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class CubicAssault {

    static class Meteor implements Comparable<Meteor> {

        String type;
        long value;

        public Meteor(String type, long value) {
            this.type = type;
            this.value = value;
        }

        @Override
        public int compareTo(Meteor m) {

            if (this.value > m.value) {
                return -1;
            } else if (this.value < m.value) {
                return 1;
            } else {
                return this.type.compareTo(m.type);
            }
        }

    }

    static class Region implements Comparable<Region> {

        String name;
        Meteor[] meteors;

        public Region(String name, Meteor[] meteors) {
            this.name = name;
            this.meteors = meteors;
        }

        @Override
        public int compareTo(Region r) {
            if (this.meteors[2].value > r.meteors[2].value) {
                return -1;
            } else if (this.meteors[2].value < r.meteors[2].value) {
                return 1;
            } else {
                if (this.name.length() > r.name.length()) {
                    return 1;
                } else if (this.name.length() < r.name.length()) {
                    return -1;
                } else {
                    return this.name.compareTo(r.name);
                }
            }
        }

    }

    private static Map<String, Region> map = new HashMap<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inp = br.readLine();

        while (!inp.equals("Count em all")) {

            String[] data = inp.split(" -> ");
            String regionName = data[0];
            String meteorType = data[1];
            String meteorValue = data[2];

            processdata(regionName, meteorType, meteorValue);
            inp = br.readLine();
        }

        printResult();
    }

    private static void printResult() {

        Set<Region> set = new TreeSet<>();
        for (Map.Entry<String, Region> r : map.entrySet()) {
            set.add(r.getValue());
        }

        for (Region region : set) {
            System.out.println(region.name);
            List<Meteor> ml = Arrays.asList(map.get(region.name).meteors);
            Collections.sort(ml);
            for (Meteor m : ml) {

                System.out.printf("-> %s : %s\n", m.type, m.value);

            }
        }
    }

    private static void processdata(String name, String type, String value) {

        Region next = map.get(name);
        if (next == null) {
            next = new Region(name, new Meteor[3]);
            next.meteors[0] = new Meteor("Green", 0);
            next.meteors[1] = new Meteor("Red", 0);
            next.meteors[2] = new Meteor("Black", 0);
        }

        int index = getIndex(type);
        if (index >= 0 && next.meteors[index].value == 0) {
            next.meteors[index] = new Meteor(type, Integer.valueOf(value));
        } else {
            next.meteors[index].value = next.meteors[index].value + Long.valueOf(value);

        }
        map.put(name, next);
        calculateMeteors(name);
    }

    private static void calculateMeteors(String name) {

        Meteor[] m = map.get(name).meteors;
        if (m[0].value >= 1000000) {
            m[1].value += m[0].value / 1000000;
            m[0].value = m[0].value % 1000000;
        }
        if (m[1].value >= 1000000) {
            m[2].value += m[1].value / 1000000;
            m[1].value = m[1].value % 1000000;
        }
    }

    private static int getIndex(String type) {

        switch (type) {
            case "Green":
                return 0;
            case "Red":
                return 1;

            case "Black":
                return 2;
        }
        return -1;
    }

}
