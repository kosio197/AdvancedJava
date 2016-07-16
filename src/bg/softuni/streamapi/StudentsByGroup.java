package bg.softuni.streamapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StudentsByGroup {

    private static class Student implements Comparable<Student> {

        private String Fname;
        private String Lname;
        private int group;

        public Student(String Fname, String Lname, int group) {

            this.Fname = Fname;
            this.Lname = Lname;
            this.group = group;
        }

        @Override
        public int compareTo(Student s) {

            return this.Fname.compareTo(s.Fname);
        }

    }

    public static void main(String[] args) throws IOException {

        List<Student> list = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inp = br.readLine();

        while (!inp.equals("END")) {

            String str[] = inp.split("\\s+");
            list.add(new Student(str[0], str[1], Integer.valueOf(str[2])));

            inp = br.readLine();
        }
        br.close();

        list.stream().filter(s -> s.group == 2).sorted().forEach(s -> System.out.println(s.Fname + " " + s.Lname));

    }

}
