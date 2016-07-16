package bg.softuni.regexp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidUsernames {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String data[] = br.readLine().split("\\s|\\/|\\\\|\\(|\\)");

        checkInp(data);

        br.close();
    }

    private static String oldUser = "";
    private static int maxLength = 0;
    private static String users[] = { "", "" };

    private static void checkInp(String[] data) {

        Pattern p = Pattern.compile("^[a-zA-z]\\w{2,24}$");

        for (int i = 0; i < data.length; i++) {

            Matcher m = p.matcher(data[i].trim());

            if (m.find()) {
                String next = m.group(0);
                if (next.length() + oldUser.length() > maxLength) {
                    maxLength = next.length() + oldUser.length();
                    users[1] = next;
                    users[0] = oldUser;
                }
                oldUser = next;
            }
        }
        System.out.printf("%s\n%s", users[0], users[1]);
    }
}
