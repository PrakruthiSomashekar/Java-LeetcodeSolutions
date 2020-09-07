package Array;// Design a HashSet without using any built-in hash table libraries.
//
//To be specific, your design should include these functions:
//
//add(value): Insert a value into the HashSet.
//contains(value) : Return whether the value exists in the HashSet or not.
//remove(value): Remove a value in the HashSet. If the value does not exist in the HashSet, do nothing.

public class DesignHashset {

    boolean[] a;
    public DesignHashset() {
        a = new boolean[1000001];
    }

    public void add(int key) {
        a[key] = true;
    }

    public void remove(int key) {
        a[key] = false;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return a[key];
    }

    public static void main(String[] args) {
        DesignHashset set = new DesignHashset();
        set.add(1);
        set.add(2);
        System.out.println(set.contains(1));
        System.out.println(set.contains(3));
        set.add(2);
        System.out.println(set.contains(2));
        set.remove(2);
        System.out.println(set.contains(2));
    }
}
