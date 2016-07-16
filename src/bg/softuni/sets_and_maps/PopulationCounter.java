package bg.softuni.sets_and_maps;

import java.util.Map;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class PopulationCounter {

    static class City implements Comparable<City> {
        private String name;
        private int population;

        public City(String name, int population) {

            this.name = name;
            this.population = population;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPopulation() {
            return population;
        }

        public void setPopulation(int population) {
            this.population = population;
        }

        @Override
        public int compareTo(City o) {
            return population > o.population ? -1 : 1;
        }
    }

    static class Country implements Comparable<Country> {

        private String name;
        @SuppressWarnings("unused")
        private int allPopulation;
        private SortedSet<City> citys;

        public Country(String name, SortedSet<City> citys) {

            this.name = name;
            this.citys = citys;

        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Long getAllPopulation() {
            long result = 0;
            for (City city : citys) {
                result += city.population;
            }
            return result;
        }

        public void setAllPopulation(int allPopulation) {
            this.allPopulation = allPopulation;
        }

        public SortedSet<City> getCitys() {
            return citys;
        }

        public void setCitys(SortedSet<City> citys) {
            this.citys = citys;
        }

        @Override
        public int compareTo(Country o) {

            return getAllPopulation() > o.getAllPopulation() ? -1 : 1;
        }

    }

    private static Map<String, Country> countrys = new TreeMap<>();
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String inp = s.nextLine();

        while (!inp.equals("report")) {

            String str[] = inp.split("\\|");
            String city = str[0];
            String country = str[1];
            int population = Integer.valueOf(str[2]);

            SortedSet<City> citys;
            if (!countrys.containsKey(country)) {

                citys = new TreeSet<>();
                citys.add(new City(city, population));
                countrys.put(country, new Country(country, citys));

            } else {
                Country c = countrys.get(country);
                citys = c.getCitys();
                citys.add(new City(city, population));
                c.setCitys(citys);
                countrys.put(country, c);
            }
            inp = s.nextLine();
        }

        s.close();

        SortedSet<Country> set = new TreeSet<>();
        for (Map.Entry<String, Country> e : countrys.entrySet()) {
            set.add(e.getValue());
        }
        printAllCountry(set);
    }

    private static void printAllCountry(SortedSet<Country> set) {
        for (Country country : set) {
            System.out.printf("%s (total population: %d)\n", country.name, country.getAllPopulation());
            for (City c : country.citys) {
                System.out.printf("=>%s: %d\n", c.name, c.population);
            }
        }

    }
}
