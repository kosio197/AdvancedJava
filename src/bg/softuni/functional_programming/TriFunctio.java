package bg.softuni.functional_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

public class TriFunctio {
    @FunctionalInterface
    public interface TriFunction<P, S, R, U> {
        public U apply(P p, S s, R r);
    }

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer number = Integer.valueOf(br.readLine());
        List<String> list = Arrays.asList(br.readLine().split("\\s+"));
        br.close();


        BiFunction<String, Integer, Boolean> biFunction = (s, i) -> {

            int sum = 0;
            for (char ch : s.toCharArray()) {
                sum += ch;
                if (sum >= i) {
                    return true;
                }
            }
            return false;
        };
        TriFunction<Integer, BiFunction<String, Integer, Boolean>, List<String>, String> triFunction = (num, biFunc,
                collection) -> {
                    for (String s : list) {
                        if (biFunc.apply(s, num)) {
                            return s;
                        }
                    }

                    return "";
                };

        System.out.println(triFunction.apply(number, biFunction, list));
    }
}

