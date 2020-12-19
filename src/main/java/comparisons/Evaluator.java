package comparisons;

import java.util.HashMap;
import java.util.Map;

public class Evaluator {

    private final int totalNrOfPoints;
    private final Map<Character, Range> marks;

    public Evaluator(int totalNrOfPoints) {
        this.totalNrOfPoints = totalNrOfPoints;

        marks = new HashMap<>();
        marks.put('A', Range.between(90, 100));
        marks.put('B', Range.between(80, 89));
        marks.put('C', Range.between(70, 79));
        marks.put('D', Range.between(60, 69));
        marks.put('E', Range.between(0, 59));
    }

    private int convertToPercentages(int points) {
        return (points * 100) / totalNrOfPoints;
    }

    public char evaluateGrade(int points) {
        int inPercentages = convertToPercentages(points);
        return marks.entrySet()
                .stream()
                .filter(r -> r.getValue().contains(points))
                .map(Map.Entry::getKey)
                .findAny()
                .orElse('E');
    }
}
