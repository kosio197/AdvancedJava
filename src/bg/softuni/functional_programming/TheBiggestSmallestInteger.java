package bg.softuni.functional_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

public class TheBiggestSmallestInteger {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<String> list = Arrays.asList(br.readLine().split("\\s+"));
        if (list.size() == 0)
            return;
        Integer inp[] = new Integer[list.size()];

        for (int i = 0; i < inp.length; i++) {
            inp[i] = Integer.valueOf(list.get(i));
        }
        String command = br.readLine();
        if (command.length() < 6)
            return;
        br.close();

        boolean oddEven = command.contains("Even");
        boolean minMax = command.contains("min");

        BiFunction<List<Integer>, Boolean, Integer> smallBig = (arr, b) -> {

            int i = arr.get(0);
            for (int j = 0; j < arr.size(); j++) {
                if (!b) {
                    if (i <= arr.get(j)) {
                        i = arr.get(j);
                    }
                } else {
                    if (i >= arr.get(j)) {
                        i = arr.get(j);
                    }
                }
            }
            return i;
        };



        BiFunction<BiFunction<List<Integer>, Boolean, Integer>, Boolean, Integer> result = (bifunc, h) -> {

            List<Integer> tempO = new ArrayList<>();
            List<Integer> tempE = new ArrayList<>();
            for (Integer i : inp) {
                if (h && i % 2 == 0) {
                    tempE.add(i);
                } else if (!h && i % 2 != 0) {
                    tempO.add(i);
                }
            }
            if (h && tempE.size() > 0) {
                return bifunc.apply(tempE, minMax);
            } else if (tempO.size() > 0) {
                return bifunc.apply(tempO, minMax);
            } else {
                return null;
            }
        };

        System.out.println(result.apply(smallBig, oddEven) != null ? result.apply(smallBig, oddEven) : "");
    }

}
