package bg.softuni.exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CubicArtillery {

    static class Bunker {
        Character name;
        int currcapacity;
        List<Integer> weapons;

        public Bunker(char j) {
            this.name = j;
            this.weapons = new ArrayList<Integer>();
            this.currcapacity = capacity;
        }
    }

    private static int startIndex = 0;
    private static int capacity = 0;
    private static List<Bunker> bunkers = new ArrayList<>();

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        capacity = Integer.valueOf(br.readLine());
        String input = br.readLine();

        while (!input.equals("Bunker Revision")) {
            String[] inp = input.split("\\s+");
            processData(inp);
            input = br.readLine();
        }
        br.close();
    }

    private static void processData(String[] inp) {

        for (int i = 0; i < inp.length; i++) {
            if (!createBunker(inp[i])) {
                int wep = Integer.valueOf(inp[i]);

                for (int j = startIndex; j < bunkers.size(); j++) {

                    Bunker next = bunkers.get(j);
                    if (next.currcapacity >= wep) {
                        next.weapons.add(wep);
                        next.currcapacity -= wep;
                        break;
                    }
                    if (next.weapons.size() > 0 && next.weapons.get(0) < wep) {
                        setBunker(next, wep);
                    }
                    if (j < bunkers.size() - 1) {
                        printBunker(next);
                        startIndex ++;
                        break;
                    }
                }
            }
        }
    }

    private static boolean createBunker(String str) {
        for (char j = 'a'; j <= 'z'; j++) {
            if (str.indexOf(j) > -1) {
                bunkers.add(new Bunker(j));
                return true;
            }
        }
        for (char j = 'A'; j <= 'Z'; j++) {
            if (str.indexOf(j) > -1) {
                bunkers.add(new Bunker(j));
                return true;
            }
        }
        return false;
    }

    private static boolean setBunker(Bunker next, int wep) {

        List<Integer> temp = new ArrayList<>();
        temp.addAll(next.weapons);
        int tempcap = next.currcapacity;

        for (int i = 0; i < temp.size(); i++) {
            tempcap += temp.get(0);
            temp.remove(0);

            if (tempcap - wep >= 0) {
                temp.add(wep);
                next.weapons.clear();
                next.weapons.addAll(temp);
                return true;
            }
        }
        return false;
    }

    private static void printBunker(Bunker b) {

        int Bsize = b.weapons.size();

        if (Bsize == 0) {
            System.out.println(b.name + " -> Empty");
        } else {
            System.out.print(b.name + " -> ");
            for (int i = 0; i < Bsize - 1; i++) {
                System.out.print(b.weapons.get(i) + ", ");
            }
            System.out.println(b.weapons.get(Bsize - 1));
        }
    }
}
