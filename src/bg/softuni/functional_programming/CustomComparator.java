package bg.softuni.functional_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CustomComparator {

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

        Arrays.sort(data, (s, t) -> {
            if (s % 2 == 0 && t % 2 != 0) {
                return -1;
            } else if (s % 2 != 0 && t % 2 == 0) {
                return 1;
            }
            return s - t;
        });

        for (Integer integer : data) {
            System.out.print(integer + " ");
        }
    }

}
