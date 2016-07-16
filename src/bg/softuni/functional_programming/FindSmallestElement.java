package bg.softuni.functional_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Function;

public class FindSmallestElement {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inp = br.readLine();
        br.close();

        if (inp.length() == 0)
            return;
        String str[] = inp.split("\\s+");

        Integer data[] = new Integer[str.length];
        for (int i = 0; i < str.length; i++) {
            data[i] = Integer.valueOf(str[i]);
        }

        System.out.println(minValue.apply(data));
    }

    private static Function<Integer[], Integer> minValue = new Function<Integer[], Integer>() {

        @Override
        public Integer apply(Integer[] data) {
            int min = data[0];
            int index = 0;
            for (int i = 1; i < data.length; i++) {
                if (data[i] <= min) {
                    min = data[i];
                    index = i;
                }
            }

            return index;
        }
    };
}
