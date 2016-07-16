package bg.softuni.stacks_and_queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TruckTour {

    static class Pump {

        private final int number;
        private final double tank;
        private final double distance;

        public Pump(int num, double tank, double distance) {

            this.number = num;
            this.tank = tank;
            this.distance = distance;
        }

        public int getNumber() {
            return number;
        }

        public double getTank() {
            return tank;
        }

        public double getDistance() {
            return distance;
        }

        @Override
        public boolean equals(Object o) {
            Pump p = (Pump) o;
            return this.number == p.number;
        }
    }

    private static Queue<Pump> qPump = new LinkedList<>();

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        for (int i = 0; i < n; i++) {
            qPump.add(new Pump(i, s.nextDouble(), s.nextDouble()));
        }

        for (int i = 0; i < n; i++) {
            if (checkTour()) {
                System.out.println(i);
                break;
            }
        }

        s.close();
    }

    private static boolean checkTour() {

        Pump p = qPump.poll();
        qPump.add(p);
        Queue<Pump> q = new LinkedList<>();
        q.addAll(qPump);

        double tank = p.getTank();
        double distance = p.getDistance();

        if (tank >= distance) {
            for (int i = 0; i < q.size(); i++) {
                Pump next = q.poll();
                tank += next.getTank();
                distance += next.getDistance();
                if (tank < distance) {
                    break;
                }
            }

        }

        return tank >= distance ? true : false;
    }
}

