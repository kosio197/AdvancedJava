package bg.softuni.exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CubicMessages {

    private static int lenth = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inp = br.readLine();
        // 1234test4321
        // 4
        // 0000oooo0000
        // 4
        // Over!

        while (!inp.equals("Over!")) {

            lenth = Integer.valueOf(br.readLine());
            processData(inp);
            inp = br.readLine();
        }
    }

    private static void processData(String inp) {

        if (inp.charAt(0) < 48 || inp.charAt(0) > 57)
            return;
        String regex = "(^[0-9]*)([a-zA-Z]{" + lenth + "})([0-9]*)(.*?[a-zA-Z].*)$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(inp);


        if (m.find()) {

            String start = m.group(1) == null ? "" : m.group(1);
            String message = m.group(2) == null ? "" : m.group(2);

            String end = m.group(3) == null ? "-1" : m.group(3);
            String chec = m.group(4) == null ? "-1" : m.group(4);
            if (start.equals("") || !chec.equals("-1") || end.equals("-1")) {
                return;
            }
            printMessage(start, message, end);
        }
    }

    private static void printMessage(String start, String message, String end) {

        StringBuilder sb = new StringBuilder();
        sb.append(message + " == ");

        for (int i = 0; i < start.length(); i++) {
            int index = Integer.valueOf(start.charAt(i)) - 48;

            if (index >= 0 && index < message.length()) {
                sb.append(message.charAt(index));
            } else {
                sb.append(" ");
            }
        }

        for (int i = 0; i < end.length(); i++) {
            int index = Integer.valueOf(end.charAt(i)) - 48;
            if (index >= 0 && index < message.length()) {
                sb.append(message.charAt(index));
            } else if (index >= message.length()) {
                sb.append(" ");
            }
        }
        System.out.println(sb);
    }
}
