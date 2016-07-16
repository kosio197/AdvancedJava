package bg.softuni.functional_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ReverseAndExclude {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        if (input.length() == 0)
            return;
        String inputNum[] = input.split("\\s+");

        Integer[] set = new Integer[inputNum.length];

        for (int i = 0; i < inputNum.length; i++) {
            set[i] = Integer.valueOf(inputNum[i]);
        }

        int del = Integer.valueOf(br.readLine());

        br.close();

        processSet(set, i -> System.out.print(i + " "), p -> p % del != 0);

    }

    private static void processSet(Integer[] set, Consumer<Integer> cons, Predicate<Integer> p) {

        for (int i = set.length - 1; i >= 0; i--) {
            if (p.test(set[i])) {
                cons.accept(set[i]);

            }

        }
    }

}
