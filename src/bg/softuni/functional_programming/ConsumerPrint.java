package bg.softuni.functional_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;

public class ConsumerPrint {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String arr[] = br.readLine().split("\\s+");
        br.close();

        consumeStrings(arr, s -> System.out.println(s));
    }

    private static void consumeStrings(String[] arr, Consumer<String> con) {

        for (String str : arr) {
            con.accept(str);
        }
    }


}
