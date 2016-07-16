package bg.softuni.sets_and_maps;

import java.util.Scanner;

public class LegoBlocks {

    private static int matrix[][];
    private static int matrix1[][];

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        s.nextLine();

        matrix = new int[n][];
        matrix1 = new int[n][];

        boolean isOk = true;
        int cellsCount = 0;

        for (int i = 0; i < n; i++) {
            String str[] = s.nextLine().trim().split("\\s+");

            matrix[i] = new int[str.length];

            for (int j = 0; j < str.length; j++) {
                matrix[i][j] = Integer.valueOf(str[j]);
            }

        }

        for (int i = 0; i < n; i++) {

            int size = matrix[i].length;

            String str[] = s.nextLine().trim().split("\\s+");

            if (isOk) {

                matrix1[i] = new int[size + str.length];

                for (int j = 0; j < size; j++) {
                    matrix1[i][j] = matrix[i][j];
                }

                int index = 1;
                for (int j = size; j < matrix1[i].length; j++) {
                    matrix1[i][j] = Integer.valueOf(str[str.length - index++]);
                }

                cellsCount += matrix1[i].length;

                if (i > 0 && matrix1[i].length != matrix1[i - 1].length)
                    isOk = false;
            } else {
                cellsCount += size + str.length;
            }
        }

        s.close();

        if (isOk) {
            printMatrix();
        } else {
            System.out.printf("The total number of cells is: %s", cellsCount);
        }
    }

    private static void printMatrix() {

        for (int i = 0; i < matrix1.length; i++) {
            System.out.print("[");
            for (int j = 0; j < matrix1[i].length - 1; j++) {
                System.out.print(matrix1[i][j] + ", ");
            }
            System.out.print(matrix1[i][matrix1[i].length - 1] + "]\n");
        }
    }

}
