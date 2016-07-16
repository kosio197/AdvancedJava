package bg.softuni.sets_and_maps;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Crossfire {

    private static int row;
    private static int col;
    private static List<LinkedList<Integer>> matrix;

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        row = s.nextInt();
        col = s.nextInt();
        s.nextLine();
        matrix = new ArrayList<LinkedList<Integer>>();

        int index = 1;
        for (int i = 0; i < row; i++) {
            matrix.add(i, new LinkedList<Integer>());
            for (int j = 0; j < col; j++) {
                matrix.get(i).add(index++);
            }
        }

        String inp = s.nextLine();

        while (!inp.equals("Nuke it from orbit")) {

            int atacRow = Integer.valueOf(inp.split(" ")[0]);
            int atacCol = Integer.valueOf(inp.split(" ")[1]);
            int atacSize = Integer.valueOf(inp.split(" ")[2]);

            processMatrix(atacRow, atacCol, atacSize);
            inp = s.nextLine();
        }

        s.close();

        printResult();
    }

    private static void printResult() {

        for (LinkedList<Integer> ll : matrix) {
            for (int i = 0; i < ll.size() - 1; i++) {
                System.out.print(ll.get(i) + " ");
            }
            System.out.print(ll.get(ll.size() - 1) + "\n");
        }
    }

    private static void processMatrix(int atacRow, int atacCol, int atacSize) {

        for (int i = (atacRow) - (atacSize); i <= atacRow + atacSize && atacCol >= 0; i++) {
            if (i != atacRow && validateRol(i, atacCol)) {
                matrix.get(i).remove(atacCol);
            }
        }


        int index = atacCol - atacSize > 0 ? atacCol - atacSize : 0;
        if (atacRow < matrix.size() && atacRow >= 0) {

            for (int i = index; i <= atacCol + atacSize; i++) {

                if (matrix.get(atacRow).size() > index && i >= 0) {
                    matrix.get(atacRow).remove(index);
                }
            }
        }

        if (atacRow >= 0 && atacRow < matrix.size() && matrix.get(atacRow).size() == 0) {
            matrix.remove(atacRow);
        }

    }

    private static boolean validateRol(int i, int atacCol) {

        return (i >= 0 && i < matrix.size() && matrix.get(i).size() > atacCol);
    }

}
