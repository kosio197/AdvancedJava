package bg.softuni.string_processing;

import java.util.Scanner;

public class FormattingNumbers {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        String inp[] = s.nextLine().split("\\s+");
        int a = Integer.valueOf(inp[0]);
        double b = Double.valueOf(inp[1]);
        double c = Double.valueOf(inp[2]);

        s.close();
        String bit = Integer.toString(a, 2);
        String zero = "";

        if (bit.length() <= 10) {
            for (int i = 0; i < 10 - bit.length(); i++) {
                zero += '0';
            }
            zero += bit;
        } else
            zero = bit.substring(0, 10);

        String bs = String.format("%.2f", b);
        if (bs.length() > 10) {
            bs = bs.substring(0, 10);
        }

        String cs = String.format("%.3f", c);
        if (cs.length() > 10) {
            cs = cs.substring(0, 10);
        }

        System.out.printf("|%-10s|%10s|%10s|%-10s|", Integer.toString(a, 16).toUpperCase(), zero, bs, cs);
    }
}
