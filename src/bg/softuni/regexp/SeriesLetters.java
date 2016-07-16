package bg.softuni.regexp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SeriesLetters {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inp = br.readLine();

        Pattern p = Pattern.compile("(.)\\1*");
        Matcher m = p.matcher(inp);
        StringBuilder sb = new StringBuilder();

        while (m.find()) {
            sb.append(m.group(1));
        }

        System.out.println(sb);

        br.close();
    }
}
