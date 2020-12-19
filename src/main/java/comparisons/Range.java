package comparisons;

public class Range {

    int bottomBound;
    int upperBound;

    private Range(int i, int j) {
        bottomBound = i;
        upperBound = j;
    }

    public static Range between(int fromInclusive, int toInclusive) {
        return new Range(fromInclusive, toInclusive);
    }

    public int getMax() {
        return upperBound;
    }

    public int getMin() {
        return bottomBound;
    }


}
