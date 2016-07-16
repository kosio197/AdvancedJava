package bg.softuni.functional_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FindEvensOdds {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inputNum[] = br.readLine().split("\\s+");
        String oddEven = br.readLine().trim();
        boolean odd = oddEven.equalsIgnoreCase("Odd");

        br.close();

        int startNum = Integer.valueOf(inputNum[0]);
        int endNum = Integer.valueOf(inputNum[1]);

        List<Integer> set = new ArrayList<>();
        for (int i = startNum; i <= endNum; i++) {
            set.add(i);
        }
        consumeStrings(set, s -> System.out.print(s + " "), i -> odd ? i % 2 != 0 : i % 2 == 0);
        //
        // consumeStrings(set, new Consumer<Integer>() {
        //
        // @Override
        // public void accept(Integer s) {
        // System.out.println("Sir " + s);
        //
        // }
        //
        // }, new Predicate<Integer>() {
        //
        // @Override
        // public boolean test(Integer i) {
        //
        // return odd ? i % 2 == 0 : i % 2 != 0;
        // }
        // });
    }

    private static void consumeStrings(List<Integer> arr, Consumer<Integer> con, Predicate<Integer> tester) {
        for (Integer i : arr) {
            if (tester.test(i)) {
                con.accept(i);
            }
        }
    }
}
