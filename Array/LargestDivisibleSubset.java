package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies:
//
//Si % Sj = 0 or Sj % Si = 0.
public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            if(nums[i+1]%nums[i] == 0) {
                if(!list.contains(nums[i]))
                    list.add(nums[i]);
                if(!list.contains(nums[i+1]))
                    list.add(nums[i+1]);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        LargestDivisibleSubset divisibleSubset = new LargestDivisibleSubset();
        List<Integer> list = divisibleSubset.largestDivisibleSubset(new int[]{3,4,8,12,15,18});
        for (Integer i: list)
            System.out.print(i+", ");
    }
}
