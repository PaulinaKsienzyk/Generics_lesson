package comparisons.PreAcademy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import static comparisons.PreAcademy.SortType.*;

public class StudentsBinder {

    private List<PreAcademyStudent> students;
    private final String CVS_PATH;
    private final SortType sortType;

    public StudentsBinder(String CVS_PATH, SortType sortType) {
        this.CVS_PATH = CVS_PATH;
        this.sortType = sortType;
    }

    public List<PreAcademyStudent> sort() {
        switch (sortType) {
            case TOTAL_DESC:
                return sortTotalInDesc();
            case TOTAL_ASC:
                return sortTotalInAsc();
            case TASKS_DESC:
                return sort(PreAcademyStudent::getTasksPoints, true);
            case TASKS_ASC:
                return sort(PreAcademyStudent::getTasksPoints, false);
            case QUIZZES_DESC:
                return sort(PreAcademyStudent::getQuizzesPoints, true);
            case QUIZZES_ASC:
                return sort(PreAcademyStudent::getQuizzesPoints, false);
            case ACTIVITY_DESC:
                return sort(PreAcademyStudent::getLectureActivity, true);
            case ACTIVITY_ASC:
                return sort(PreAcademyStudent::getLectureActivity, false);
        }
        return students;
    }

    // sort using Comparable
    private List<PreAcademyStudent> sortTotalInDesc() {
        students.sort(Collections.reverseOrder());
        return students;
    }

    private List<PreAcademyStudent> sortTotalInAsc() {
        Collections.sort(students);
        return students;
    }


    // sort using Comparators
    private List<PreAcademyStudent> sort(Function<PreAcademyStudent, Integer> fieldToSortBy, boolean inDescOrder) {
        if (inDescOrder) {
            students.sort(Comparator.comparing(fieldToSortBy));
        } else {
            students.sort(Comparator.comparing(fieldToSortBy).reversed());
        }
        return students;
    }

    public static void main(String[] args) {

        StudentsBinder studentsBinder = new StudentsBinder("preAcademyStudents.csv", TOTAL_DESC);

        try (CVSWriter cvsWriter = new CVSWriter()) {
//            cvsWriter.givenDataArray_whenConvertToCSV_thenOutputCreated();
        }catch (Exception e) {
            System.out.println("Something goes wrong...");
        }
    }


}