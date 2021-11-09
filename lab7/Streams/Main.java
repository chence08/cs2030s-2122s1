/**
 * @author: Chen YiJia
 * */

import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.LinkedList;
import java.util.Optional;

/* 
 * 1. No Iteration
 * 2. No Recursion
 * 3. No If/Else statements
 * */
class Main {
    // Task 1: Twin Primes
    /**
     * @param number greater or equal to 3
     */
    static boolean isPrime(int number) {
        // Generate integers from 2 to number/2 (strictly speaking
        // sqrt(number) is a tighter bound). Check that number is
        // NOT divisible by any of these integers. If yes, then it is
        // prime.
        return IntStream.rangeClosed(2, number / 2).noneMatch(i -> number % i == 0);
    }

    static long countTwinPrimes(int n) {
        IntStream numbers = IntStream.rangeClosed(3, n);
        IntStream primes = numbers.filter(x -> isPrime(x));
        
        // For every prime, check that either of its neighbour is
        // also prime.
        IntStream twinPrimes = primes.filter(x -> isPrime(x + 2) || isPrime(x - 2));
        return twinPrimes.count();
    }

    /* 
     * 20/21S2 Task 2: Greatest Common Divisor
     * With the help of a Pair class, iterate the stream while
     * updating the input values. Look for the first occurence where
     * the second integer equal to 0, its corresponding first integer
     * would be the gcd.
     * */
    static int gcd(int m, int n) {
        return Stream.iterate(new Pair(m, n), x -> new Pair(x.getSecond(), x.getFirst() % x.getSecond()))
            .filter(y -> y.getSecond() == 0).findFirst().get().getFirst();
    }
    
    /*
     * 21/22S2 Task 2: Reverse String	
     * */
    static String reverseWithStack(String str) {
        LinkedList<String> stack = new LinkedList<>();
        str.chars().mapToObj(c -> String.valueOf((char) c)).forEach(stack::push);
        return stack.stream().reduce("", (x, y) -> x + y);
    }

    static String reverse(String str) {
        return str.chars().mapToObj(c -> String.valueOf((char) c)).reduce("", (x, y) -> y + x);
    }

    /* Task 3: Counting Repeats
     * hasRepeats would check that the current index is a distinct
     * repeat if its previous element is different but the next
     * element is same. It returns a 1 for a valid repeat, a 0
     * otherwise. Use IntStream to generate the full indexes of the
     * array and map it with the hasRepeats method, this would
     * indicate all the instances of valid repeats as 1s in the
     * stream. To count them, take the sum.
	*/
    static long countRepeats(int... array) {
        int zeroIndex = Optional.of(1).filter(one -> array[0] == array[1]).orElse(0);
        return zeroIndex + 
            IntStream.range(1, array.length - 1).map(idx -> hasRepeats(idx, array)).sum();
    } 

    static int hasRepeats(int idx, int[] array) {
        int previous = array[idx - 1];
        int current = array[idx];
        int after = array[idx + 1];
        return Optional.of(1).filter(one -> previous != current && current == after).orElse(0);
    }

    /* Task 4:
     * We can only operate on the stream once.
     * We have to keep track of 4 parameters: count, sum, min and
     * max. Intuitively, this involves some accumulation, so we shall
     * be using the reduce method in streams.
     *
     * The reduce method requires an identity object and accumulator
     * function that takes in 2 objects. All these objects must be of
     * the same type and the accumulator must return the same type of
     * object. Therefore, I've used a helper class IntegerStatistics
     * to wrap around each of the stream elements before I proceed
     * with the reduction operation. Finally, I call upon the math
     * formula to get the normalizedMean.
     * */
    static double normalizedMean(Stream<Integer> stream) {
        return stream.map(x -> new IntegerStatistics(x))
            .reduce(new IntegerStatistics(),
                    (s1, s2) -> IntegerStatistics.accumulator(s1, s2)).getNormalizedMean();
    }
}
