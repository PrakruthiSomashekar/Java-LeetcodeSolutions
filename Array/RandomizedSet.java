package Array;// Design a data structure that supports all following operations in average O(1) time.
//
//insert(val): Inserts an item val to the set if not already present.
//remove(val): Removes an item val from the set if present.
//getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomizedSet {
    List<Integer> list;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        list = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(list.contains(val))
            return false;
        else list.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {

            return list.remove((Integer)val);
    }

    /** Get a random element from the set. */
    public int getRandom() {
        Random ran = new Random();
        int random = ran.nextInt(list.size());
        return list.get(random);
    }

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        System.out.println(randomizedSet.insert(1));
        System.out.println(randomizedSet.remove(2));
        System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.getRandom());
    }
}
