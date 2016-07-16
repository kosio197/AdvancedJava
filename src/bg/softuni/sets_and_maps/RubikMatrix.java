package bg.softuni.sets_and_maps;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RubikMatrix {

    static class Pair {

        private int row;
        private int col;

        public Pair(int row, int col) {
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

        @Override
        public boolean equals(Object obj) {

            Pair p = (Pair) obj;
            return row == p.row && col == p.col;
        }
    }

    private static Map<Integer, Pair> inMap = new HashMap<>();
    private static Map<Integer, Pair> outMap = new HashMap<>();

    private static Integer[][] matrix;
    private static int r = 0;
    private static int c = 0;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        r = s.nextInt();
        c = s.nextInt();
        int n = s.nextInt();
        s.nextLine();

        matrix = new Integer[r][c];
        int index = 1;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                matrix[i][j] = index;
                inMap.put(index, new Pair(i, j));
                outMap.put(index++, new Pair(i, j));
            }
        }
        // printMatrix(r, c);

        for (int i = 0; i < n; i++) {

            String comand[] = s.nextLine().trim().split(" "); // {row/col}
            // {direction}
            // {moves}
            try {
                int rc = Integer.valueOf(comand[0]);
                String direction = comand[1];
                int move = Integer.valueOf(comand[2]);

                processCommand(rc, direction, move);
                // printMatrix(r, c);
            } catch (Exception e) {
                System.out.println("ERROR: " + comand.toString());
            }
        }

        rearrangingMatrix();

        s.close();
    }

    private static void rearrangingMatrix() {

        for (int i = 1; i <= inMap.size(); i++) {
            Pair in = inMap.get(i);
            Pair out = outMap.get(i);
            if (in.equals(out)) {
                System.out.println("No swap required");
            } else {

                System.out.printf("Swap (%d, %d) with (%d, %d)\n", in.getRow(), in.getCol(), out.getRow(),
                        out.getCol());

                matrix[out.getRow()][out.getCol()] = matrix[in.getRow()][in.getCol()];
                outMap.put(matrix[in.getRow()][in.getCol()], new Pair(out.getRow(), out.getCol()));

            }
        }

    }

    private static void processCommand(int rc, String direction, int move) {

        switch (direction) {
            case "up":
                moveUp(rc, move);
                break;
            case "down":
                moveDown(rc, move);
                break;
            case "left":
                moveLeft(rc, move);
                break;
            case "right":
                moveRight(rc, move);
                break;

            default:
                System.out.println("Error: switch " + direction);
                break;
        }

    }

    private static void moveRight(int row, int move) {

        move = move % c;
        if (row < 0 || row >= r) {
            System.out.println("ERROR right" + row);
            return;
        }

        for (int i = 0; i < move; i++) {
            int temp = matrix[row][c - 1];
            for (int j = c - 1; j > 0; j--) {
                matrix[row][j] = matrix[row][j - 1];
                outMap.put(matrix[row][j], new Pair(row, j));
            }
            matrix[row][0] = temp;
            outMap.put(matrix[row][0], new Pair(row, 0));
        }
    }

    private static void moveLeft(int row, int move) {

        move = move % c;
        if (row < 0 || row >= r) {
            System.out.println("ERROR left" + row);
            return;
        }

        for (int i = 0; i < move; i++) {
            int temp = matrix[row][0];
            for (int j = 0; j < c - 1; j++) {
                matrix[row][j] = matrix[row][j + 1];
                outMap.put(matrix[row][j], new Pair(row, j));
            }
            matrix[row][c - 1] = temp;
            outMap.put(matrix[row][c - 1], new Pair(row, c - 1));
        }

    }

    private static void moveDown(int col, int move) {
        move = move % r;
        if (col < 0 || col >= c) {
            System.out.println("ERROR down" + col);
            return;
        }

        for (int i = 0; i < move; i++) {
            int temp = matrix[r - 1][col];
            for (int j = r - 1; j > 0; j--) {
                matrix[j][col] = matrix[j - 1][col];
                outMap.put(matrix[j][col], new Pair(j, col));
            }
            matrix[0][col] = temp;
            outMap.put(matrix[0][col], new Pair(0, col));

        }

    }

    private static void moveUp(int col, int move) {

        move = move % r;
        if (col < 0 || col >= c) {
            System.out.println("ERROR up" + col);
            return;
        }

        for (int i = 0; i < move; i++) {
            int temp = matrix[0][col];
            for (int j = 0; j < r - 1; j++) {
                matrix[j][col] = matrix[j + 1][col];
                outMap.put(matrix[j][col], new Pair(j, col));

            }
            matrix[r - 1][col] = temp;
            outMap.put(matrix[r - 1][col], new Pair(r - 1, col));

        }

    }
}
