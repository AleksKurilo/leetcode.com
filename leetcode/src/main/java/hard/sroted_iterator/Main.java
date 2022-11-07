package hard.sroted_iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

import static java.util.Arrays.asList;

/**
 *
 * Given:
 * N sorted iterators of integers.
 *
 * The task:
 * Implement iterator (Iterator<Integer>) that produces globally sorted sequence from the given N iterators.
 * Task must be solved in the most efficient way possible
 * (i.e it's not allowed  to copy entire content of iterators into some structure and then sort it).
 *
 * For example:
 * Iterator A1: 6, 8, 19, 21, 32, 66, 67, 77, 89
 * Iterator A2: 1, 3, 5,  24, 33, 45, 57, 59, 89
 * Iterator A3: 2, 4, 9,  18, 22, 44, 46, 89, 89
 *
 * Final globally sorted Iterator must produce:
 *
 * 1 (from A2)
 * 2 (from A3)
 * 3 (from A2)
 * 4 (from A3)
 * 5 (from A2)
 * 6 (from A1)
 * 8 (from A1)
 * 9 (from A3)
 * 18 (from A3)
 * 19 (from A1)
 * 21 (from A1)
 * 22 (from A3)
 * ...
 *
 * Solution
 * Solution is O(logN) per element, not the complexity to iterate over all values.
 *
 * Solution does not keep all values in the priority queue at once, only the single "next" value
 * from each of the N lists. Hence, the priority queue has (at most) N elements at all times,
 * so its operations are all O(log N).
 */
class MergeIterator<T extends Comparable> implements Iterator<T> {

    private final PriorityQueue<IteratorState> priorityQueue;

    public MergeIterator(List<List<T>> listOfList) {
        priorityQueue = new PriorityQueue<>();
        for (List<T> list : listOfList) {
            Iterator<T> iterator = list.iterator();
            if (iterator.hasNext()) {
                priorityQueue.add(new IteratorState(iterator));
            }
        }
    }

    public T next() {
        IteratorState it = priorityQueue.poll();
        T retriveValue = it.getValue();
        if (it.hasNext()) {
            it.next();
            priorityQueue.add(it);
        }
        return retriveValue;
    }

    public boolean hasNext() {
        return !priorityQueue.isEmpty();
    }

    class IteratorState implements Comparable<IteratorState> {
        private final Iterator<T> iterator;
        private T value;

        public IteratorState(Iterator<T> i) {
            iterator = i;
            next();
        }

        public boolean hasNext() {
            return iterator.hasNext();
        }

        public T getValue() {
            return value;
        }

        public void next() {
            if (iterator.hasNext()) {
                value = iterator.next();
            } else {
                value = null;
            }
        }

        public int compareTo(IteratorState o) {
            return value.compareTo(o.getValue());
        }
    }
}


class Main {
    private static <T extends Comparable> List<T> mergeSort(List<List<T>> listOfList) {
        MergeIterator<T> i = new MergeIterator<T>(listOfList);
        List<T> retval = new ArrayList<>();
        while (i.hasNext()) {
            retval.add(i.next());
        }
        return retval;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        List<Integer> result = mergeSort(asList(
                asList(1, 3, 5),
                asList(2, 4, 6),
                asList(7, 9),
                asList(8),
                asList(0, 10),
                asList()));

        System.out.println("Test: merge in sort array multiple sort arrays");
        result.forEach(number -> System.out.println(number));

        System.out.println("Test: merge in sort array empty array");
        result = mergeSort(asList());
        result.forEach(number -> System.out.println(number));
    }
}
