package bg.softuni.string_processing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseString {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        br.close();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {

            sb.append(str.charAt(str.length() - 1 - i));
        }
        System.out.println(sb.toString());
    }
}
