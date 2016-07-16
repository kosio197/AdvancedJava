package bg.softuni.exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CubicRube {

    private static int matrix[][][];
    private static int r;
    private static int c;
    private static int h;
    private static int change;
    private static int size;
    private static long valueCange = 0;

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 4
        // 2 2 2 2
        // Analyze

        size = Integer.valueOf(br.readLine());
        matrix = new int[size][size][size];
        change = size * size * size;

        String input = br.readLine();
        while (!input.equals("Analyze")) {
            String[] inp = input.split("\\s+");
            r = Integer.valueOf(inp[0]);
            c = Integer.valueOf(inp[1]);
            h = Integer.valueOf(inp[2]);

            String indexInteger = "";

            for (int i = 3; i < inp.length; i++) {
                indexInteger += inp[i];
            }

            processMatrix(Integer.valueOf(indexInteger));

            input = br.readLine();
        }
        System.out.println(valueCange + "\n" + change);

    }

    private static void processMatrix(Integer i) {
        if (validate()) {
            if (matrix[r][c][h] == 0 && matrix[r][c][h] != i) {
                change--;
                valueCange += i;
            }
            matrix[r][c][h] = i;
        }
    }

    private static boolean validate() {

        return (r >= 0 && r < size && c >= 0 && c < size && h >= 0 && h < size);
    }
}
