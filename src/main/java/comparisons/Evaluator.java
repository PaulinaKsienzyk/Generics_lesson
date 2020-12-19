package comparisons;

public class Evaluator {





    enum GRADE {
        FIVE(5),
        FOUR(4),
        THREE(3),
        TWO(2);

        private final int gradeNr;

        GRADE(int i) {
        this.gradeNr = i;
        }


        @Override
        public String toString() {
            return String.valueOf(gradeNr);
        }
    }
}
