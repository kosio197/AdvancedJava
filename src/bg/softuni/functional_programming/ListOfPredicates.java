package bg.softuni.functional_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ListOfPredicates {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer num = Integer.valueOf(br.readLine());
        String inp = br.readLine();

        br.close();

        if (inp.length() == 0)
            return;
        String str[] = inp.split("\\s+");

        List<Predicate<Integer>> list = new ArrayList<>();
        for (int i = 0; i < str.length; i++) {
            int d = Integer.valueOf(str[i]);
            list.add(s -> s % d == 0);
        }

        process(num, list, s -> System.out.print(s + " "));
    }

    private static void process(Integer num, List<Predicate<Integer>> list, Consumer<Integer> cons) {

        a: for (int i = 1; i <= num; i++) {
            for (Predicate<Integer> p : list) {
                if (!p.test(i)) {
                    continue a;
                }
            }
            cons.accept(i);
        }
    }
}
