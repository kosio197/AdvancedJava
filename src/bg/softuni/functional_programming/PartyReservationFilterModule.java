package bg.softuni.functional_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PartyReservationFilterModule {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<String> list = new ArrayList<>();
        String str[] = br.readLine().split("\\s+");
        for (String string : str) {
            list.add(string);
        }

        List<String> temp = new ArrayList<String>();
        temp = list;
        String line = br.readLine();

        while (!line.equals("Print")) {
            String command[] = line.split(";");
            Predicate<String> p = null;
            switch (command[1]) {
                case "Starts with":
                    p = s -> s.startsWith(command[2]);
                    break;
                case "Ends with":
                    p = s -> s.endsWith(command[2]);
                    break;
                case "Length":
                    p = s -> s.length() == Integer.valueOf(command[2]);
                    break;
                case "Contains":
                    p = s -> s.indexOf(command[2]) >= 0;
                    break;

            }

            if (command[0].equalsIgnoreCase("Add filter")) {
                temp = processList(temp, p, command[0].equalsIgnoreCase("Add filter"));
            } else {
                temp.addAll(0, processList1(list, p, command[0].equalsIgnoreCase("Remove filter")));
            }

            line = br.readLine();
        }

        for (int i = 0; i < list.size(); i++) {
            if (temp.contains(list.get(i))) {
                System.out.print(list.get(i) + " ");
            }
        }


    }

    private static List<String> processList1(List<String> list, Predicate<String> p, boolean remove) {

        List<String> temp = new ArrayList<>();

        for (String s : list) {
            if (p.test(s)) {
                temp.add(s);
            }
        }

        return temp;
    }

    private static List<String> processList(List<String> list, Predicate<String> p, boolean add) {

        List<String> temp = new ArrayList<>();

        for (String s : list) {
            if (!p.test(s)) {
                temp.add(s);
            }
        }

        return temp;
    }
}
