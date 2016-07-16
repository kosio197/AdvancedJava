package bg.softuni.string_processing;

import java.util.Scanner;

public class SumBigNumbers {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        String fNum = s.nextLine().toLowerCase();

        int index = 0;
        while (Integer.valueOf(fNum.charAt(index)) - 48 == 0) {
            fNum = fNum.substring(1);
        }

        String sNum = s.nextLine().toLowerCase();
        index = 0;
        while (Integer.valueOf(sNum.charAt(index)) - 48 == 0) {
            sNum = sNum.substring(1);
        }

        s.close();

        StringBuilder sb = new StringBuilder();

        int indexF = fNum.length() - 1;
        int indexS = sNum.length() - 1;
        int temp = 0;

        while (indexF >= 0 || indexS >= 0) {

            int f = 0;
            int sec = 0;

            if (indexF >= 0) {
                f = Integer.valueOf(fNum.charAt(indexF--)) - 48;
            }

            if (indexS >= 0) {
                sec = Integer.valueOf(sNum.charAt(indexS--)) - 48;
            }

            temp += f + sec;
            if (temp > 9) {
                int result = temp - 10;
                temp = 1;
                sb.append(result);
            } else {
                sb.append(temp);
                temp = 0;
            }
        }

        if (temp != 0) {
            sb.append(temp);
        }
        String bigNum = sb.reverse().toString();
        System.out.println(bigNum);
    }
}
