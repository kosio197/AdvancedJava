package bg.softuni.regexp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inp = br.readLine();

        checkInput(inp);

        br.close();
    }

    private static void checkInput(String inp) {

        String regex = "\\s(([0-9A-Za-z][\\.-0-9a-zA-Z]*[A-Za-z0-9])|([a-zA-z0-9]))@(([A-Za-z][-a-zA-Z]*[A-Za-z])|([A-Za-z]))(\\.(([A-Za-z][-a-zA-Z]*[A-Za-z])|([A-Za-z])))+";

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(inp);

        while (m.find()) {
            System.out.println(m.group(0).trim());
        }

    }
}
