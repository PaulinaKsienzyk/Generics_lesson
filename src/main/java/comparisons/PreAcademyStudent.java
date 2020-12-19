package comparisons;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PreAcademyStudent implements Comparable<PreAcademyStudent>{

    int points;

    public PreAcademyStudent(int points) {
        this.points = points;
    }

    @Override
    public int compareTo(PreAcademyStudent preAcademyStudent) {
        return Integer.compare(this.points, preAcademyStudent.points);
    }

    @Override
    public String toString() {
        return String.valueOf(this.points);
    }

    public static void main(String[] args) {
        PreAcademyStudent s10 = new PreAcademyStudent(10);
        PreAcademyStudent s5 = new PreAcademyStudent(5);
        PreAcademyStudent s15 = new PreAcademyStudent(15);

        List<PreAcademyStudent> students = new ArrayList<>();
        students.add(s10);
        students.add(s5);
        students.add(s15);

        Collections.sort(students, Comparator.reverseOrder());
        System.out.println(students);

        System.out.println(s5.compareTo(s10));
        System.out.println(s15.compareTo(s5));
        System.out.println(s10.compareTo(s10));


    }
}
