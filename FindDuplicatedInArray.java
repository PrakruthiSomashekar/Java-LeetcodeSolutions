// Find All Duplicates in an Array
// Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
//Find all the elements that appear twice in this array.

import java.util.ArrayList;
import java.util.List;

public class FindDuplicatedInArray {

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicateList = new ArrayList<>();
        boolean[] arr = new boolean[nums.length+1];

        for(int i: nums){
            if(!arr[i])
                arr[i] = true;
            else
                duplicateList.add(i);
        }
        return duplicateList;
    }

    public static void main(String[] args) {
        List<Integer> res = findDuplicates(new int[]{4,3,2,7,8,2,3,1});
        System.out.println(res.toString());
    }
}
