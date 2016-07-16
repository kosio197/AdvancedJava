package bg.softuni.string_processing;

import java.util.Scanner;

public class CharacterMultiplier {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String str[] = s.nextLine().split("\\s+");
        String fNum = str[0];
        String sNum = str[1];

        s.close();

        Long result = new Long(0);

        int indexF = 0;
        int indexS = 0;

        while (indexF < fNum.length() || indexS < sNum.length()) {

            int f = 1;
            int sec = 1;

            if (indexF < fNum.length()) {
                f = Integer.valueOf(fNum.charAt(indexF++));
            }

            if (indexS < sNum.length()) {
                sec = Integer.valueOf(sNum.charAt(indexS++));
            }

            result += f * sec;
        }

        System.out.println(result);
    }
}
