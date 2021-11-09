/**
 * @author: Chen YiJia
 * */

import java.util.Optional;

class IntegerStatistics {
    private final int count;
    private final int sum;
    private final int min;
    private final int max;

    IntegerStatistics(int count, int sum, int min, int max) {
        this.count = count;
        this.sum = sum;
        this.min = min;
        this.max = max;
    }

    // identity
    IntegerStatistics() {
        this(0, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    // Wrapper Class for Integer
    IntegerStatistics(int value) {
        this(1, value, value, value);
    }

    // BinaryOperator<T> accumulator for the reduce method.
    static IntegerStatistics accumulator(IntegerStatistics s1, IntegerStatistics s2) {
        int newCount = s1.count + s2.count;
        int newSum = s1.sum + s2.sum;
        int newMin = Math.min(s1.min, s2.min);
        int newMax = Math.max(s1.max, s2.max);
        return new IntegerStatistics(newCount, newSum, newMin, newMax);
    }

    double getNormalizedMean() {
        return Optional.of(0D).filter(zero -> min == max || count == 0).
            orElse(((double) sum / count - min) / (max - min));
    }
}
