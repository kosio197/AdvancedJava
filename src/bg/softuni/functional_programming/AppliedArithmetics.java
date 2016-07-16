package bg.softuni.functional_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;
import java.util.function.Function;

public class AppliedArithmetics {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        if (input.length() == 0)
            return;
        String inputNum[] = input.split("\\s+");

        Integer[] set = new Integer[inputNum.length];

        for (int i = 0; i < inputNum.length; i++) {
            set[i] = Integer.valueOf(inputNum[i]);
        }

        String command = br.readLine().trim().toLowerCase();

        while (!command.equals("end")) {
            switch (command) {
                case "add":
                    funcSet(set, i -> i + 1);
                    break;
                case "subtract":
                    funcSet(set, i -> i - 1);
                    break;
                case "multiply":
                    funcSet(set, i -> i * 2);
                    break;
                case "print":
                    consumerSet(set, i -> System.out.print(i + " "));
                    return;
                default:
                    break;
            }


            command = br.readLine().trim().toLowerCase();
        }
        br.close();
    }

    private static void funcSet(Integer[] arr, Function<Integer, Integer> func) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = func.apply(arr[i]);
        }
    }

    private static void consumerSet(Integer[] arr, Consumer<Integer> consumer) {
        for (int i = 0; i < arr.length; i++) {
            consumer.accept(arr[i]);
        }
    }
}
