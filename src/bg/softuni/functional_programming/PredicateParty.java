package bg.softuni.functional_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateParty {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<String> list = new ArrayList<>();
        String str[] = br.readLine().split("\\s+");
        for (String string : str) {
            list.add(string);
        }

        String line = br.readLine();

        while (!line.equals("Party!")) {
            String command[] = line.split("\\s+");
            Predicate<String> p = null;
            switch (command[1]) {
                case "StartsWith":
                    p = s -> s.startsWith(command[2]);
                    break;
                case "EndsWith":
                    p = s -> s.endsWith(command[2]);
                    break;
                case "Length":
                    p = s -> s.length() == Integer.valueOf(command[2]);
                    break;

            }
            List<String> temp = processList(list, p, command[0].equalsIgnoreCase("Double"));
            list = temp;
            line = br.readLine();
        }

        if (list.size() == 0) {
            System.out.println("Nobody is going to the party!");
        } else {
            for (int i = 0; i < list.size() - 1; i++) {
                System.out.print(list.get(i) + ", ");
            }
            System.out.print(list.get(list.size() - 1) + " are going to the party!");
        }
    }


    private static List<String> processList(List<String> list, Predicate<String> p, boolean add) {

        List<String> temp = new ArrayList<>();

        for (String s : list) {
            if(p.test(s)){
                if(add){
                    temp.add(s);
                    temp.add(s);
                }
            } else {
                temp.add(s);
            }
        }

        return temp;
    }
}
