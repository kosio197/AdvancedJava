package bg.softuni.stacks_and_queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PoisonousPlants {

    static class Plant {
        private int index;
        private final double pesticide;

        public Plant(int index, double p) {
            this.index = index;
            this.pesticide = p;
        }

        public double getPesticide() {
            return pesticide;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

    }

    private static Queue<Plant> Q = new LinkedList<>();
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int count = s.nextInt();
        if (count > 100000)
            System.out.println(count);
        s.nextLine();
        for (int i = 0; i < count; i++) {
            Q.add(new Plant(i, s.nextDouble()));
        }

        System.out.println(processPlants());
        s.close();
    }

    private static int day = -1;
    private static int processPlants() {
        day++;
        boolean isDie = false;
        int size = Q.size();
        if (size > 1) {
            for (int i = 0; i < size; i++) {

                Plant p = Q.poll();

                if (Q.peek().pesticide > p.pesticide && Q.peek().index != 0) {
                    Q.peek().index = -1;
                    isDie = true;
                }

                if (p.index >= 0) {
                    Q.add(p);
                }
            }
        }

        if (isDie) {

            processPlants();
        }
        return day;
    }
}

