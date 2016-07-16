package bg.softuni.string_processing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractHyperlinks {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        String inp = br.readLine();

        while (!inp.equals("END")) {
            sb.append(inp + " ");
            inp = br.readLine();
        }
        br.close();
        String data = sb.toString();

        String regex = "<a.*?>";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(data);

        while (m.find()) {


            String regex1 = "<a.*?href\\s*=\\s*(.*?)(\\s+\\w+\\s*=|>).*?";
            Pattern p1 = Pattern.compile(regex1);
            Matcher m1 = p1.matcher(m.group(0));

            if (m1.find()) {
                String path = m1.group(1);
                path = clear(path.trim());
                System.out.println(path);
            }
        }

    }

    private static String clear(String path) {

        if (path.charAt(0) == '"' || path.charAt(0) == '\'') {
            path = path.substring(1, path.length() - 1);
        }

        return path;
    }

}
