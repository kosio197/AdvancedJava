package bg.softuni.regexp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceExtractor {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String key = br.readLine();
        String text = br.readLine();

        checkInput(key, text);

        br.close();
    }

    private static void checkInput(String key, String text) {

        String regex = "(^|\\s)(\\s*\\w+\\s)*" + key + "(\\s\\w+\\s*)*(\\.|\\?|\\!)";

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(text);

        while (m.find()) {
            System.out.println(m.group(0).trim());
        }
    }
}
