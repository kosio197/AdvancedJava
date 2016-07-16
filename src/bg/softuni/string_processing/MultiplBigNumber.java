package bg.softuni.string_processing;

import java.util.Scanner;

public class MultiplBigNumber {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        String bigNum = s.nextLine().toLowerCase();
        while (Integer.valueOf(bigNum.charAt(0)) - 48 == 0) {
            bigNum = bigNum.substring(1);
        }

        int m = s.nextInt();
        s.close();

        StringBuilder sb = new StringBuilder();
        int temp = 0;

        for (int i = bigNum.length() - 1; i >= 0; i--) {

            int current = Integer.valueOf(bigNum.charAt(i)) - 48;
            temp += current * m;

            if (temp > 9) {
                sb.append(temp % 10);
                temp /= 10;
            } else {
                sb.append(temp);
                temp = 0;
            }
        }
        if (temp != 0) {
            sb.append(temp);
        }

        String result = sb.reverse().toString();
        if (Integer.valueOf(result.charAt(0)) - 48 == 0) {
            System.out.println(0);
        } else {

            System.out.println(result);
        }

    }
}
