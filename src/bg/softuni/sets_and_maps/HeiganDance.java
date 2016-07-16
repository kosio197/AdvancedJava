package bg.softuni.sets_and_maps;

import java.util.Scanner;

public class HeiganDance {

    private static double hPoints = 3000000;
    private static int pPoints = 18500;
    private static double damage;
    private static int row = 7;
    private static int col = 7;

    private static boolean isCloud = false;
    private static boolean hLive = true;
    private static boolean pLive = true;

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        damage = s.nextDouble();
        s.nextLine();

        while (hLive && pLive) {

            String str = s.nextLine().trim();
            String magic = str.split(" ")[0];
            int magicRow = Integer.valueOf(str.split(" ")[1]);
            int magicCol = Integer.valueOf(str.split(" ")[2]);

            makeTurn(magic, magicRow, magicCol);
        }

        printResult();
        s.close();
    }

    private static void makeTurn(String magic, int magicRow, int magicCol) {

        if (isCloud) {
            pPoints -= 3500;
            if (pPoints <= 0) {
                pLive = false;
            }
        }
        hPoints -= damage;
        if (hPoints <= 0) {
            hLive = false;
        }
        if (!pLive || !hLive)
            return;

        int matrix[][] = new int[15][15];

        if (validate(magicRow, magicCol))
            matrix[magicRow][magicCol] = 1;
        if (validate(magicRow - 1, magicCol - 1))
            matrix[magicRow - 1][magicCol - 1] = 1;
        if (validate(magicRow - 1, magicCol))
            matrix[magicRow - 1][magicCol] = 1;
        if (validate(magicRow - 1, magicCol + 1))
            matrix[magicRow - 1][magicCol + 1] = 1;
        if (validate(magicRow, magicCol - 1))
            matrix[magicRow][magicCol - 1] = 1;
        if (validate(magicRow, magicCol + 1))
            matrix[magicRow][magicCol + 1] = 1;
        if (validate(magicRow + 1, magicCol - 1))
            matrix[magicRow + 1][magicCol - 1] = 1;
        if (validate(magicRow + 1, magicCol))
            matrix[magicRow + 1][magicCol] = 1;
        if (validate(magicRow + 1, magicCol + 1))
            matrix[magicRow + 1][magicCol + 1] = 1;

        isCloud = false;
        if (matrix[row][col] == 1) {
            if (validate(row - 1, col) && matrix[row - 1][col] != 1) {
                row -= 1;
            } else if (validate(row, col + 1) && matrix[row][col + 1] != 1) {
                col += 1;
            } else if (validate(row + 1, col) && matrix[row + 1][col] != 1) {
                row += 1;
            } else if (validate(row, col - 1) && matrix[row][col - 1] != 1) {
                col -= 1;
            } else {
                isCloud = magic.equals("Cloud") ? true : false;
                pPoints -= getDamage(magic);
                if (pPoints <= 0) {
                    pLive = false;
                }
            }
        }

    }

    private static double getDamage(String magic) {
        return magic.equals("Eruption") ? 6000 : 3500;
    }

    private static boolean validate(int Row, int Col) {
        return Row >= 0 && Row < 15 && Col >= 0 && Col < 15;
    }

    private static void printResult() {

        if (hLive) {
            System.out.printf("Heigan: %.2f\n", hPoints);
        } else {
            System.out.printf("Heigan: Defeated!\n");
        }

        if (pLive) {
            System.out.printf("Player: %d\n", pPoints);
        } else {
            if (isCloud) {
                System.out.println("Player: Killed by Plague Cloud");
            } else {
                System.out.println("Player: Killed by Eruption");
            }
        }

        System.out.printf("Final position: %d, %d", row, col);
    }

}
