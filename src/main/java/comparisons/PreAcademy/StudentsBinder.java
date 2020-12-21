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
        students = CVSReader.read(CVS_PATH);
    }
    
    public void sort() {
        switch (sortType) {
            case TOTAL_DESC:
                sortTotalInDesc();
                break;
            case TOTAL_ASC:
                sortTotalInAsc();
                break;
            case TASKS_DESC:
                sort(PreAcademyStudent::getTasksPoints, true);
                break;
            case TASKS_ASC:
                sort(PreAcademyStudent::getTasksPoints, false);
                break;
            case QUIZZES_DESC:
                sort(PreAcademyStudent::getQuizzesPoints, true);
                break;
            case QUIZZES_ASC:
                sort(PreAcademyStudent::getQuizzesPoints, false);
                break;
            case ACTIVITY_DESC:
                sort(PreAcademyStudent::getLectureActivity, true);
                break;
            case ACTIVITY_ASC:
                sort(PreAcademyStudent::getLectureActivity, false);
                break;
        }
    }

    // sort using Comparable
    private void sortTotalInDesc() {
        students.sort(Collections.reverseOrder());
    }

    private void sortTotalInAsc() {
        Collections.sort(students);
    }


    // sort using Comparators
    private void sort(Function<PreAcademyStudent, Integer> fieldToSortBy, boolean inDescOrder) {
        if (inDescOrder) {
            students.sort(Comparator.comparing(fieldToSortBy));
        } else {
            students.sort(Comparator.comparing(fieldToSortBy).reversed());
        }
    }
    
    public List<String[]> convertToDataArray() {
        List<String[]> data = new ArrayList<>();
        for (var student : students) {
            String[] studentData = new String[4];
            studentData[0] = student.getName();
            studentData[1] = String.valueOf(student.getQuizzesPoints());
            studentData[2] = String.valueOf(student.getTasksPoints());
            studentData[3] = String.valueOf(student.getLectureActivity());
            data.add(studentData);
        }
        return data;
    }

    public static void main(String[] args) {

        StudentsBinder studentsBinder = new StudentsBinder("preAcademyStudents.csv", TOTAL_ASC);
        studentsBinder.sort();

        try (CVSWriter cvsWriter = new CVSWriter()) {
            cvsWriter.givenDataArray_whenConvertToCSV_thenOutputCreated(studentsBinder.convertToDataArray(),
                    "sortedStudents.csv");
        }catch (Exception e) {
            System.out.println("Something goes wrong...");
        }
    }


}