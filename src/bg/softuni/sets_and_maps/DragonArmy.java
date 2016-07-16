package bg.softuni.sets_and_maps;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class DragonArmy {

    static class Dragon {// {damage} {health} {armor}

        String name;
        int damage;
        int health;
        int armor;

        public Dragon(String name, int damage, int healt, int armor) {
            this.name = name;
            this.damage = damage;
            this.health = healt;
            this.armor = armor;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getDamage() {
            return damage;
        }

        public void setDamage(int damage) {
            this.damage = damage;
        }

        public int getHealt() {
            return health;
        }

        public void setHealth(int health) {
            this.health = health;
        }

        public int getArmor() {
            return armor;
        }

        public void setArmor(int armor) {
            this.armor = armor;
        }

    }

    private static Map<String, Map<String, Dragon>> map = new LinkedHashMap<>();
    private static Map<String, Long[]> average = new HashMap<>();

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        s.nextLine();
        for (int i = 0; i < n; i++) {
            String inp = s.nextLine();
            addData(inp);
        }

        printResult();
        s.close();
    }

    private static void printResult() {

        for (Map.Entry<String, Map<String, Dragon>> e : map.entrySet()) {

            double size = e.getValue().size();
            Long[] arr = average.get(e.getKey());

            System.out.printf("%s::(%.2f/%.2f/%.2f)\n", e.getKey(), arr[0] / size, arr[1] / size, arr[2] / size);

            for (Map.Entry<String, Dragon> d: map.get(e.getKey()).entrySet()) {

                System.out.printf("-%s -> damage: %s, health: %s, armor: %s\n", d.getValue().getName(),
                        d.getValue().getDamage(), d.getValue().getHealt(), d.getValue().getArmor());
            }
        }
    }

    private static void addData(String inp) {
        // {type} {name} {damage} {health} {armor} health 250, damage 45, and
        // armor 10.
        String data[] = inp.split(" ");

        String type = data[0];
        String name = data[1];
        int damage = data[2].equals("null") ? 45 : Integer.valueOf(data[2]);
        int health = data[3].equals("null") ? 250 : Integer.valueOf(data[3]);
        int armor = data[4].equals("null") ? 10 : Integer.valueOf(data[4]);
        Long[] arr;

        Map<String, Dragon> inmap = map.get(type);

        if (inmap == null) {
            inmap = new TreeMap<>();
            map.put(type, inmap);
        }

        Dragon d = inmap.get(name);

        if (d == null) {
            inmap.put(name, new Dragon(name, damage, health, armor));

        } else {
            arr = average.get(type);

            arr[0] -= d.getDamage();
            arr[1] -= d.getHealt();
            arr[2] -= d.getArmor();

            average.put(type, arr);

            d.setArmor(armor);
            d.setDamage(damage);
            d.setHealth(health);
        }



        arr = average.get(type);

        if (arr == null) {
            arr = new Long[3];

            arr[0] = (long) damage;
            arr[1] = (long) health;
            arr[2] = (long) armor;

            average.put(type, arr);
        } else {
            arr[0] += damage;
            arr[1] += health;
            arr[2] += armor;

            average.put(type, arr);
        }

    }

}
