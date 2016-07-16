package bg.softuni.streamapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ExcellentStudents {

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
            String x="";
            for (int i = 2; i < str.length; i++) {
                x += str[i];
            }

            list.add(new Student(str[0], str[1], x));

            inp = br.readLine();
        }
        br.close();

        list.stream().filter(s -> s.mail.contains("6")).forEach(s -> System.out.println(s.Fname + " " + s.Lname));

    }
}
