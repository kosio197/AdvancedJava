package bg.softuni.string_processing;

import java.math.BigInteger;
import java.util.Scanner;

public class ConvertFromBaseXtoBaseN {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        String inp = s.nextLine().trim();

        BigInteger big;
        long number = Long.MIN_VALUE;
        try {
            number = Long.valueOf(inp);
        } catch (Exception e) {

        }

        s.close();

        String result = "";
        if (number != Long.MIN_VALUE) {

            while (number > 0) {
                result = number % n + result;
                number /= n;
            }
        } else {
            big = new BigInteger(inp);
            BigInteger d = new BigInteger(String.format("%d", n));

            while (big.compareTo(BigInteger.ZERO) > 0) {

                result = big.mod(d) + result;
                big = big.divide(d);
            }
        }

        System.out.println(result);
    }
}
