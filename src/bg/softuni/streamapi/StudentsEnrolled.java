package bg.softuni.streamapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StudentsEnrolled {

    private static class Student {

        private String Fnum;
        private List<Integer> set;

        public Student(String Fnum, List<Integer> set) {

            this.Fnum = Fnum;
            this.set = set;
        }

    }

    public static void main(String[] args) throws IOException {

        List<Student> list = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inp = br.readLine();

        while (!inp.equals("END")) {

            String str[] = inp.split("\\s+");
            List<Integer> x = new ArrayList<>();

            for (int i = 1; i < str.length; i++) {
                x.add(Integer.valueOf(str[i]));
            }

            list.add(new Student(str[0], x));

            inp = br.readLine();
        }
        br.close();

        list.stream().filter(s -> s.Fnum.charAt(4) == '1' && (s.Fnum.charAt(5) == '4' || s.Fnum.charAt(5) == '5'))
        .forEach(s -> {
            for (int i = 0; i < s.set.size() - 1; i++) {
                        System.out.print(s.set.get(i) + " ");
            }
            System.out.println(s.set.get(s.set.size() - 1));
        });

    }
}
