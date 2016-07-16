package bg.softuni.regexp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReplaceTag {
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

        inp = inp.replace("<a", "[URL");
        inp = inp.replace("</a>", "[/URL]");

        System.out.print(inp);
    }
}
