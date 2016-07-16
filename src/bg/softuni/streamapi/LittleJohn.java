package bg.softuni.streamapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LittleJohn {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 4; i++) {

            String input = br.readLine();
            processData(input);
        }
        br.close();

        Integer countArrow = Integer.valueOf(String.valueOf(small) + String.valueOf(medium) + String.valueOf(large));

        System.out.println(processArrow(Integer.toString(countArrow, 2)));
    }

    private static long processArrow(String bin) {

        int size = bin.length();
        for (int i = size - 1; i >= 0; i--) {
            bin += bin.charAt(i);
        }

        return Long.parseLong(bin, 2);
    }

    private static int small, medium, large = 0;

    private static void processData(String inp) {

        String smallA = ">----->";
        String mediumA = ">>----->";
        String largeA = ">>>----->>";

        while (inp.indexOf(largeA) >= 0) {
            large++;
            int index = inp.indexOf(largeA);
            inp = inp.substring(0, index) + " " + inp.substring(index + largeA.length());
        }
        while (inp.indexOf(mediumA) >= 0) {
            medium++;
            int index = inp.indexOf(mediumA);
            inp = inp.substring(0, index) + " " + inp.substring(index + mediumA.length());
        }
        while (inp.indexOf(smallA) >= 0) {
            small++;
            int index = inp.indexOf(smallA);
            inp = inp.substring(0, index) + " " + inp.substring(index + smallA.length());
        }
    }
}
