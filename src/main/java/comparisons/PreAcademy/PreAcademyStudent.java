package comparisons.PreAcademy;

public class PreAcademyStudent implements Comparable<PreAcademyStudent>{

    private final String name;
    private final int totalPoints;
    private final int quizzesPoints;
    private final int tasksPoints;
    private final int lectureActivity;

    public PreAcademyStudent(String name, int quizzesPoints, int tasksPoints, int lectureActivity) {
        this.name = name;
        this.quizzesPoints = quizzesPoints;
        this.tasksPoints = tasksPoints;
        this.lectureActivity = lectureActivity;
        totalPoints = this.quizzesPoints + this.tasksPoints + this.lectureActivity;
    }

    @Override
    public int compareTo(PreAcademyStudent preAcademyStudent) {
        return Integer.compare(this.totalPoints, preAcademyStudent.totalPoints);
    }

    @Override
    public String toString() {
        return this.name + "-" + String.valueOf(this.totalPoints);
    }

    public int getQuizzesPoints() {
        return quizzesPoints;
    }

    public int getTasksPoints() {
        return tasksPoints;
    }

    public int getLectureActivity() {
        return lectureActivity;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {

    }
}
