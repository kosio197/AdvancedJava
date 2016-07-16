package bg.softuni.streamapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FilterStudentsPhone {

    private static class Student {

        private String Fname;
        private String Lname;
        private String mail;

        public Student(String Fname, String Lname, String mail) {

            this.Fname = Fname;
            this.Lname = Lname;
            this.mail = mail;
        }

    }

    public static void main(String[] args) throws IOException {

        List<Student> list = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inp = br.readLine();

        while (!inp.equals("END")) {

            String str[] = inp.split("\\s+");
            list.add(new Student(str[0], str[1], str[2]));

            inp = br.readLine();
        }
        br.close();

        list.stream().filter(s -> s.mail.startsWith("02") || s.mail.startsWith("+3592"))
        .forEach(s -> System.out.println(s.Fname + " " + s.Lname));

    }
}
