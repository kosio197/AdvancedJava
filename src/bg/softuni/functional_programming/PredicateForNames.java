package bg.softuni.functional_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateForNames {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.valueOf(br.readLine());
        String inp = br.readLine();
        if (inp.length() == 0)
            return;

        String str[] = inp.split("\\s+");


        processSet(str, s -> s.length() <= size, z -> System.out.println(z));

    }

    private static void processSet(String[] str, Predicate<String> p, Consumer<String> cons) {

        for (String s : str) {
            if (p.test(s)) {
                cons.accept(s);
            }
        }

    }
}
