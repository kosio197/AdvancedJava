package bg.softuni.string_processing;

import java.math.BigInteger;
import java.util.Scanner;

public class ConvertFromBaseNToBase10 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        String inp = s.nextLine().trim();
        s.close();

        int step = 0;

        BigInteger temp = new BigInteger(String.valueOf(0));
        for (int i = inp.length() - 1; i >= 0; i--) {

            BigInteger base = new BigInteger(String.valueOf(n));
            base = base.pow(step++);

            BigInteger c = new BigInteger(String.valueOf(inp.charAt(i)));
            c = c.multiply(base);

            temp = temp.add(c);

        }
        System.out.println(temp);
    }
}
