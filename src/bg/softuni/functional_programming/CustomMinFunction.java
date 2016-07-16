package bg.softuni.functional_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Function;

public class CustomMinFunction {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        if (line.length() == 0)
            return;

        String inp[] = line.split("\\s+");
        br.close();

        Integer[] arr = new Integer[inp.length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.valueOf(inp[i]);
        }

        System.out.println(processArray(arr, t -> {
            int min = t[0];

            for (int i = 0; i < t.length; i++) {
                if (t[i] < min)
                    min = t[i];
            }

            return min;
        }));
    }

    private static Integer processArray(Integer[] arr, Function<Integer[], Integer> function) {
        return function.apply(arr);
    }
}
