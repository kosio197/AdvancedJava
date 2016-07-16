package bg.softuni.streamapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class WeakStudents {

    private static class Student {

        private String Fname;
        private String Lname;
        private List<Integer> mail;

        public Student(String Fname, String Lname, List<Integer> mail) {

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
            List<Integer> x = new ArrayList<>();

            for (int i = 2; i < str.length; i++) {
                x.add(Integer.valueOf(str[i]));
            }

            list.add(new Student(str[0], str[1], x));

            inp = br.readLine();
        }
        br.close();

        list.stream().filter(s -> {

            int sum = 0;
            for (int i = 0; i < s.mail.size(); i++) {
                if (s.mail.get(i) <= 3) {
                    sum++;
                }
            }
            return sum < 2 ? false : true;
        }).forEach(s -> System.out.println(s.Fname + " " + s.Lname));

    }
}
