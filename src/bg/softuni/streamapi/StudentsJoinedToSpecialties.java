package bg.softuni.streamapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentsJoinedToSpecialties {


    static class StudentSpecialty {

        private String specialtyFName;
        private String specialtyLName;
        private int facultyNumber;

        public StudentSpecialty(String n1, String n2, int f) {
            this.specialtyFName = n1;
            this.specialtyLName = n2;
            this.facultyNumber = f;
        }
    }

    static class Student implements Comparable<Student> {

        private String studentFName;
        private String studentLName;
        private int studentNumber;

        public Student(int f, String n1, String n2) {
            this.studentFName = n1;
            this.studentLName = n2;
            this.studentNumber = f;
        }



        @Override
        public int compareTo(Student s) {

            if (this.studentFName.compareTo(s.studentFName) != 0) {
                return this.studentFName.compareTo(s.studentFName);
            } else

                return this.studentLName.compareTo(s.studentLName);
        }
    }

    static class Pear {

        private StudentSpecialty ss;
        private Student st;

        public Pear(StudentSpecialty ss, Student st) {
            this.ss = ss;
            this.st = st;
        }

        @Override
        public String toString() {
            return st.studentFName + " " + st.studentLName + " " + ss.facultyNumber + " " + ss.specialtyFName + " "
                    + ss.specialtyLName;
        }
    }

    public static void main(String[] args) throws IOException {

        Map<Integer, List<StudentSpecialty>> speciality = new HashMap<>();

        Map<Integer, List<Pear>> join = new HashMap<>();

        List<Student> studentsList = new ArrayList<>();


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inp = br.readLine();

        while (!inp.equals("Students:")) {

            String[] str = inp.split("\\s+");
            int num = Integer.valueOf(str[2]);
            List<StudentSpecialty> next = speciality.get(num);
            if (next == null) {
                next = new ArrayList<>();
            }
            next.add(new StudentSpecialty(str[0], str[1], num));
            speciality.put(num, next);

            inp = br.readLine();
        }

        inp = br.readLine();
        while (!inp.equals("END")) {
            String[] str = inp.split("\\s+");

            int num = Integer.valueOf(str[0]);
            Student st = new Student(num, str[1], str[2]);

            studentsList.add(st);

            if (speciality.containsKey(num)) {
                List<Pear> pears = join.get(num);
                if (pears == null) {
                    pears = new ArrayList<>();
                }
                List<StudentSpecialty> ls = speciality.get(num);
                for (StudentSpecialty ss : ls) {
                    pears.add(new Pear(ss, st));
                }

                join.put(num, pears);
            }
            inp = br.readLine();
        }

        studentsList.sort(null);
        for (Student s : studentsList) {
            List<Pear> j = join.get(s.studentNumber);
            if (j != null) {
                for (Pear pear : j) {
                    System.out.println(pear);
                }
            }
        }
    }
}
