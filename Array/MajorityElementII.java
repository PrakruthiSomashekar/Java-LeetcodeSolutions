package Array;
// Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MajorityElementII {

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{2,2}));
    }

    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums.length == 0)
            return res;
        HashMap<Integer,Integer> map = new HashMap<>();
        int len = nums.length/3;

        for(int i: nums){
            if(map.containsKey(i))
                map.put(i,map.get(i)+1);
            else map.put(i,1);

            if(map.get(i) > len && !res.contains(i))
                res.add(i);
        }
        return res;
    }
}
