package bg.softuni.functional_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class InfernoIII {

    static class Game {
        int val;
        int index;
        boolean mark;

        public Game(int val, int index) {
            this.val = val;
            this.index = index;
            mark = false;
        }

        @Override
        public String toString() {
            return val + " " + index + " " + mark;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inp[] = br.readLine().split("\\s+");
        List<Game> list =new  ArrayList<InfernoIII.Game>();
        list.add(new Game(0, 0));
        int i = 1;
        for (String s : inp) {
            list.add(new Game(Integer.valueOf(s), i++));
        }
        list.add(new Game(0, inp.length + 1));

        String line= br.readLine();
        while(!line.equals("Forge")){

            String command[] = line.split(";");

            Predicate<Game> p = null;
            switch (command[1]) {
                case "Sum Left":
                    p = s -> s.val + list.get(s.index - 1).val == Integer.valueOf(command[2]);
                    break;
                case "Sum Right":
                    p = s -> s.val + list.get(s.index + 1).val == Integer.valueOf(command[2]);
                    break;
                case "Sum Left Right":
                    p = s -> s.val + list.get(s.index - 1).val + list.get(s.index + 1).val == Integer
                    .valueOf(command[2]);
                    break;
            }
            boolean exclude = command[0].equals("Exclude");
            processGame(list, p, exclude);
            line= br.readLine();
        }

        for (Game game : list) {
            if (game.index != 0 && game.index != list.size() - 1 && !game.mark) {
                System.out.print(game.val + " ");
            }
        }
    }

    private static void processGame(List<Game> list, Predicate<Game> p, Boolean exclude) {

        for (Game game : list) {
            if (game.index != 0 && game.index != list.size() - 1 && p.test(game)) {
                if (exclude) {
                    game.mark = true;
                } else {
                    game.mark = false;
                }
            }
        }
    }
}
