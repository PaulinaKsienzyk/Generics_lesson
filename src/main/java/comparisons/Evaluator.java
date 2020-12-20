package comparisons;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Evaluator {

    private List<PreAcademyStudent> students;

    public Evaluator(List<PreAcademyStudent> students) {
        this.students = students;
    }

    // sort using Comparable
    private List<PreAcademyStudent> sortUsingTotalPoints() {
        List<PreAcademyStudent> sortList = new ArrayList<>(students);
        sortList.sort(Collections.reverseOrder());
        return sortList;
    }

    // sort using Comparator
    private List<PreAcademyStudent> sortUsingNaturalOrderings() {
        List<PreAcademyStudent> sortList = new ArrayList<>(students);
        sortList.sort(Comparator.comparing(PreAcademyStudent::getTasksPoints)
                .thenComparing(PreAcademyStudent::getQuizzesPoints)
                .thenComparing(PreAcademyStudent::getLectureActivity));
        return sortList;
    }

    public static void main(String[] args) {
        List<PreAcademyStudent> students = new ArrayList<>();
        PreAcademyStudent s1 = new PreAcademyStudent(5, 10, 15);
        PreAcademyStudent s2 = new PreAcademyStudent(17, 10, 7);
        PreAcademyStudent s3 = new PreAcademyStudent(5, 20, 3);
        students.add(s1);
        students.add(s2);
        students.add(s3);

        Evaluator evaluator = new Evaluator(students);
        System.out.println(evaluator.sortUsingTotalPoints());
        System.out.println(evaluator.sortUsingNaturalOrderings());
    }


}