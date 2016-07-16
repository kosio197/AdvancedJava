package bg.softuni.string_processing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class MelrahShake {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String text = br.readLine();
        String pattern = br.readLine();
        br.close();

        while(true){

            if(text.indexOf(pattern) >=0){

                if (text.indexOf(pattern) == text.lastIndexOf(pattern)) {
                    break;
                }

                text = text.replaceFirst(Pattern.quote(pattern), "");
                int index = text.lastIndexOf(pattern);

                if (index >= 0) {

                    text = text.substring(0, index) + text.substring(index + pattern.length());
                }

                System.out.println("Shaked it.");

                if (pattern.length() > 1) {
                    pattern = pattern.substring(0, pattern.length() / 2)
                            + pattern.substring((pattern.length() / 2) + 1);
                } else {
                    break;
                }
            } else {

                break;
            }
        }

        System.out.println("No shake.");
        System.out.println(text);
    }
}
