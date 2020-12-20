package comparisons.PreAcademy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentsBinder {

    private List<PreAcademyStudent> students;
    private final String CVS_PATH;
    private final SortType sortType;

    public StudentsBinder(String CVS_PATH, SortType sortType) {
        this.CVS_PATH = CVS_PATH;
        this.sortType = sortType;
    }

    // sort using Comparable
    private List<PreAcademyStudent> sortUsingTotalPoints() {
        List<PreAcademyStudent> sortList = new ArrayList<>(students);
        sortList.sort(Collections.reverseOrder());
        return sortList;
    }

    // sort using Comparators
    private List<PreAcademyStudent> sortUsingNaturalOrderings() {
        List<PreAcademyStudent> sortList = new ArrayList<>(students);
        sortList.sort(Comparator.comparing(PreAcademyStudent::getTasksPoints)
                .thenComparing(PreAcademyStudent::getQuizzesPoints)
                .thenComparing(PreAcademyStudent::getLectureActivity)
                .reversed());
        return sortList;
    }

    public static void main(String[] args) {

        StudentsBinder studentsBinder = new StudentsBinder("preAcademyStudents.csv", SortType.TOTAL_DESC);
        System.out.println(studentsBinder.sortUsingTotalPoints());
        System.out.println(studentsBinder.sortUsingNaturalOrderings());
    }


}