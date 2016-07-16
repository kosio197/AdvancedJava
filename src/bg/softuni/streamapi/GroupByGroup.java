package bg.softuni.streamapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByGroup {

    private static class Student {

        private String Fname;
        private String Lname;
        private int group;

        public Student(String Fname, String Lname, int group) {

            this.Fname = Fname;
            this.Lname = Lname;
            this.group = group;
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

        Map<Integer, List<Student>> map = new HashMap<>();
        map = list.stream().collect(Collectors.groupingBy(st -> st.group));

        for (Map.Entry<Integer, List<Student>> e : map.entrySet()) {
            System.out.print(e.getKey() + " - ");
            for (int i = 0; i < e.getValue().size() - 1; i++) {
                System.out.print(e.getValue().get(i).Fname + " " + e.getValue().get(i).Lname + ", ");
            }
            System.out.println(e.getValue().get(e.getValue().size() - 1).Fname + " "
                    + e.getValue().get(e.getValue().size() - 1).Lname);
        }

    }
}
