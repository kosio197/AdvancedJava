package bg.softuni.regexp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SemanticHTML {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inp = br.readLine();

        while (!inp.equals("END")) {

            checkInput(inp);
            inp = br.readLine();
        }
        br.close();
    }

    private static void checkInput(String inp) {

        String regex = "(.*?)<div(.*?)\\s+(id|class)\\s*=\\s*\"(main|header|nav|article|section|aside|footer)\"(.*?)>(.*?)$";

        String regex1 = "(.*?)<\\/div>\\s*<\\!--\\s*(main|header|nav|article|section|aside|footer)\\s*-->";

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(inp);

        Pattern p1 = Pattern.compile(regex1);
        Matcher m1 = p1.matcher(inp);

        if (m.find()) {
            System.out.println(((m.group(1) + "<" + m.group(4) + m.group(2) + m.group(5)).trim() + ">" + m.group(6))
                    .replaceAll("\\s+", " "));
        } else if (m1.find()) {

            System.out.println((m1.group(1) + "</" + m1.group(2) + ">").replaceAll("\\s+", " "));
        } else {
            System.out.println(inp);
        }
    }
}
