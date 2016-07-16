package bg.softuni.regexp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UseYourChainsBuddy {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String data = br.readLine();
        br.close();

        StringBuilder sb = new StringBuilder();

        String regex = "(\\<p\\>.*?\\<\\/p\\>)?";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(data);

        while (m.find()) {
            String str = m.group(0);
            if (str.length() > 7) {
                str = str.substring(3, str.length() - 4);
            }
            sb.append(str);
        }

        data = sb.toString();
        data = data.replaceAll("([A-Z]|\\W)", " ");
        data = data.replaceAll("\\s+", " ");


        processData(data);

    }

    private static void processData(String data) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.length(); i++) {

            char next = data.charAt(i);
            if (next > 96 && next < 123) {
                if (next < 110) {
                    next += 13;
                } else {
                    next -= 13;
                }
            }
            sb.append(next);
        }

        System.out.println(sb);
    }
}
