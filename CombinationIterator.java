// Iterator for Combination
// Design an Iterator class, which has:
// A constructor that takes a string characters of sorted distinct lowercase English letters and a number combinationLength as arguments.
// A function next() that returns the next combination of length combinationLength in lexicographical order.
// A function hasNext() that returns True if and only if there exists a next combination.

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class CombinationIterator {

    Queue<String> queue = new LinkedList<>();

    public CombinationIterator(String characters, int combinationLength) {
        char[] array = new char[combinationLength];
        createAll(characters, combinationLength, array, 0, 0);
    }

    private void createAll(String str, int size, char[] array, int start, int index) {
        // if size reached end - adding combination to the queue
        if (index == size) {
            String nextOne = new String(array);
            // System.out.println(nextOne);
            queue.add(nextOne);
            return;
        }
        for (int i = start; i < str.length(); i++) {
            array[index] = str.charAt(i);
            createAll(str, size, array, i + 1, index + 1);
        }
    }

    public String next() {
        return queue.poll();
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }

    public static void main(String[] args) {
        CombinationIterator iterator = new CombinationIterator("abc",2);
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
    }
}