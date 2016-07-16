package bg.softuni.sets_and_maps;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class ParkingSystem {

    private static int row;
    private static int col;
    private static List<HashSet<Integer>> free = new ArrayList<>();

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        row = s.nextInt();
        col = s.nextInt();
        s.nextLine();

        for (int i = 0; i < row; i++) {
            free.add(i, new HashSet<Integer>());
        }
        String str = s.nextLine();

        while (!str.equals("stop")) {

            int inRow = Integer.valueOf(str.split(" ")[0]);
            int spotRow = Integer.valueOf(str.split(" ")[1]);
            int spotCol = Integer.valueOf(str.split(" ")[2]);

            parkingCar(inRow, spotRow, spotCol);

            str = s.nextLine();
        }

        s.close();
    }

    private static void parkingCar(int inRow, int spotRow, int spotCol) {

        int stepCount = 1;
        stepCount += inRow - spotRow >= 0 ? inRow - spotRow : spotRow - inRow;

        HashSet<Integer> set = free.get(spotRow);

        if (set.size() == col - 1) {
            System.out.printf("Row %d full\n", spotRow);
            return;
        }

        if (!set.contains(spotCol)) {
            set.add(spotCol);
            System.out.println(stepCount + spotCol);

        } else {

            for (int i = 1; i <= (spotCol >= col - spotCol - 1 ? spotCol : col - spotCol - 1); i++) {
                if (spotCol - i > 0 && !set.contains(spotCol - i)) {

                    set.add(spotCol - i);
                    System.out.println(stepCount + spotCol - i);
                    break;

                } else if (spotCol + i < col && !set.contains(spotCol + i)) {

                    set.add(spotCol + i);
                    System.out.println(stepCount + spotCol + i);
                    break;
                }
            }
        }
    }
}
