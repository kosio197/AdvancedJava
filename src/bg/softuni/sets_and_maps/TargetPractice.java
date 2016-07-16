package bg.softuni.sets_and_maps;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TargetPractice {

    private static Character[][] matrix;
    private static int row;
    private static int col;
    private static int buletRow;
    private static int buletCol;
    private static int buletDamage;

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        row = s.nextInt();
        col = s.nextInt();
        s.nextLine();

        matrix = new Character[row][col];
        String str = s.nextLine().trim();
        while (str.length() < row * col) {
            str += str;
        }
        int index = 0;
        boolean left = true;
        for (int i = row - 1; i >= 0; i--) {
            for (int j = 0; j < col; j++) {
                if (left) {
                    matrix[i][(col - 1) - j] = str.charAt(index++);
                } else {
                    matrix[i][j] = str.charAt(index++);
                }
            }
            left = !left;
        }


        buletRow = s.nextInt();
        buletCol = s.nextInt();
        buletDamage = s.nextInt();

        processCommand();
        printMatrix();
        s.close();
    }

    private static void processCommand() {

        List<Integer> killed = new LinkedList<>();
        for (int i = buletCol - buletDamage - 1 > 0 ? buletCol - buletDamage - 1 : 0; i < col; i++) {
            for (int j = buletRow - buletDamage - 1 > 0 ? buletRow - buletDamage - 1 : 0; j < row; j++) {
                boolean isInside = checkAndWriteIfNeeded(i, j);
                if (isInside)
                    killed.add(j);
            }
            replaceCharacter(killed, i);
            killed.clear();
        }
    }

    private static void replaceCharacter(List<Integer> killed, int currentCol) {

        for (Integer i : killed) {
            for (int j = i; j > 0; j--) {

                matrix[j][currentCol] = matrix[j - 1][currentCol];
                matrix[j - 1][currentCol] = ' ';
            }
        }
    }

    private static boolean checkAndWriteIfNeeded(int currentCol, int currentRol) {

        if ((buletRow - currentRol) * (buletRow - currentRol)
                + (buletCol - currentCol) * (buletCol - currentCol) <= buletDamage
                * buletDamage) {

            matrix[currentRol][currentCol] = ' ';
            return true;
        }
        return false;
    }

    private static void printMatrix() {

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }

    }
}
