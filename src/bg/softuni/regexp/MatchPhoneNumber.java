package bg.softuni.regexp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchPhoneNumber {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inp = br.readLine();

        while (!inp.equals("end")) {

            checkInput(inp);
            inp = br.readLine();
        }
        br.close();
    }

    private static void checkInput(String inp) {

        String regex = "(^|\\s*)\\+359(\\s+|-)2\\2\\d{3}\\2\\d{4}$";

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(inp);

        if (m.find()) {
            System.out.println(m.group(0));
        }

    }
}
