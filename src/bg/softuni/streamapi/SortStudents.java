package bg.softuni.streamapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SortStudents {

    private static class Student implements Comparable<Student> {

        private String Fname;
        private String Lname;

        public Student(String Fname, String Lname) {

            this.Fname = Fname;
            this.Lname = Lname;

        }

        @Override
        public int compareTo(Student o) {

            if (this.Lname.compareTo(o.Lname) > 0) {
                return 1;
            } else if (this.Lname.compareTo(o.Lname) < 0) {
                return -1;
            }
            return o.Fname.compareTo(this.Fname);
        }

    }

    public static void main(String[] args) throws IOException {

        List<Student> list = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inp = br.readLine();

        while (!inp.equals("END")) {

            String str[] = inp.split("\\s+");
            list.add(new Student(str[0], str[1]));

            inp = br.readLine();
        }
        br.close();

        list.stream().sorted()
        .forEach(s -> System.out.println(s.Fname + " " + s.Lname));

    }
}
