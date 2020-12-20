package comparisons.PreAcademy;

public enum SortType {

    TOTAL_DESC(0),
    TOTAL_ASC(1),
    QUIZZES_DESC(2),
    QUIZZES_ASC(3),
    TASKS_DESC(4),
    TASKS_ASC(5),
    ACTIVITY_DESC(5),
    ACTIVITY_ASC(6);

    private int nr;

    SortType(int nr) {
        this.nr = nr;
    }

    public int getNr() {
        return nr;
    }
}
