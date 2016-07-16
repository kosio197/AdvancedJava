package bg.softuni.sets_and_maps;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RadioactiveMutantVampireBunnies {

    static class Cell {
        private int row;
        private int col;

        public Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public int getRow() {
            return row;
        }

        public void setRow(int row) {
            this.row = row;
        }

        public int getCol() {
            return col;
        }

        public void setCol(int col) {
            this.col = col;
        }

    }
    private static char matrix[][];
    private static int row;
    private static int col;
    private static int rowP;
    private static int colP;
    private static int dedR = -1;
    private static int dedC = -1;
    private static boolean isLive = true;
    private static boolean isDed = true;

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        row = s.nextInt();
        col = s.nextInt();
        s.nextLine();

        matrix = new char[row][col];

        for (int i = 0; i < row; i++) {
            String inp = s.nextLine().trim();
            for (int j = 0; j < col; j++) {
                matrix[i][j] = inp.charAt(j);
                if (inp.charAt(j) == 'P') {
                    rowP = i;
                    colP = j;
                }
            }
        }


        String command = s.nextLine().trim();
        s.close();

        processMatrix(command);

    }

    private static void processMatrix(String command) {


        for (int i = 0; i < command.length(); i++) {

            char c = command.charAt(i);
            switch (c) {
                case 'U':
                    moveUp();
                    break;
                case 'D':
                    moveDown();
                    break;
                case 'L':
                    moveLeft();
                    break;
                case 'R':
                    moveRight();
                    break;
            }


            if (!isLive) {
                break;
            }

            spreadBunnies();
            if (!isDed) {
                printResult("dead");
                break;
            }
        }

    }

    private static boolean moveRight() {

        if (inMatrix(rowP, colP + 1)) {
            matrix[rowP][colP] = '.';
            if (validate(rowP, colP + 1)) {

                matrix[rowP][++colP] = 'P';
                return true;
            } else {
                dedR = rowP;
                dedC = colP + 1;
                printResult("dead");
            }

        } else {
            matrix[rowP][colP] = '.';
            dedR = rowP;
            dedC = colP;
            printResult("won");
        }

        return false;
    }

    private static boolean moveLeft() {

        if (inMatrix(rowP, colP - 1)) {
            matrix[rowP][colP] = '.';
            if (validate(rowP, colP - 1)) {

                matrix[rowP][--colP] = 'P';
                return true;
            } else {
                dedR = rowP;
                dedC = colP - 1;
                printResult("dead");
            }
        } else {
            matrix[rowP][colP] = '.';
            dedR = rowP;
            dedC = colP;
            printResult("won");
        }
        return false;
    }

    private static boolean moveDown() {
        if (inMatrix(rowP + 1, colP)) {
            matrix[rowP][colP] = '.';
            if (validate(rowP + 1, colP)) {

                matrix[++rowP][colP] = 'P';
                return true;
            } else {
                dedR = rowP + 1;
                dedC = colP;
                printResult("dead");
            }
        } else {
            matrix[rowP][colP] = '.';
            dedR = rowP;
            dedC = colP;
            printResult("won");
        }
        return false;
    }

    private static boolean moveUp() {


        if (inMatrix(rowP - 1, colP)) {

            matrix[rowP][colP] = '.';
            if (validate(rowP - 1, colP)) {

                matrix[--rowP][colP] = 'P';
                return true;
            } else {
                dedR = rowP - 1;
                dedC = colP;
                printResult("dead");
            }
        } else {
            matrix[rowP][colP] = '.';
            dedR = rowP;
            dedC = colP;
            printResult("won");
        }
        return false;
    }

    private static void spreadBunnies() {

        List<Cell> bunnys = new ArrayList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                if (matrix[i][j] == 'B') {
                    bunnys.add(new Cell(i, j));
                }
            }
        }

        for (Cell cell : bunnys) {

            int i = cell.getRow();
            int j = cell.getCol();

            if (inMatrix(i + 1, j)) {

                willDie(i + 1, j);
                matrix[i + 1][j] = 'B';
            }

            if (inMatrix(i - 1, j)) {
                willDie(i - 1, j);
                matrix[i - 1][j] = 'B';
            }

            if (inMatrix(i, j + 1)) {
                willDie(i, j + 1);
                matrix[i][j + 1] = 'B';
            }
            if (inMatrix(i, j - 1)) {
                willDie(i, j - 1);
                matrix[i][j - 1] = 'B';
            }
        }
    }

    private static boolean inMatrix(int r, int c) {
        return (r < row && r >= 0 && c < col && c >= 0);
    }

    private static void willDie(int r, int c) {

        if (matrix[r][c] == 'P') {
            matrix[r][c] = '.';
            isDed = false;
            dedR = rowP;
            dedC = colP;
            isLive = false;
        }
    }

    private static boolean validate(int r, int c) {

        if (matrix[r][c] == 'B') {

            isLive = false;
            return false;
        }
        return true;
    }


    private static void printResult(String str) {

        isLive = false;
        if (isDed) {
            spreadBunnies();
        }

        printMatrix();
        System.out.printf("%s: %d %d", str, dedR, dedC);
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
