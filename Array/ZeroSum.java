package Array;// find the triplet combination in the list

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZeroSum {

    public static void main(String[] args) {
        ZeroSum s = new ZeroSum();
        int[] num = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> list = s.threeSum(num);
        for (List<Integer> integers : list) System.out.println(integers);
    }

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> parentList = new ArrayList<>();
        Arrays.sort(nums);
        int root = Integer.MIN_VALUE;
        for(int i=0;i<nums.length-2;i++){

            int middle = i+1;
            int highest = nums.length-1;
            while(middle<highest && nums[highest]> -(nums[i]+nums[middle]))
                highest--;

            int prev = Integer.MIN_VALUE;
            while(middle<highest && nums[i]!=root){   //root evaluation is to avoid duplicates
                if(nums[i]+nums[middle]+nums[highest]==0 && nums[middle]!=prev){ //nums[middle]!=prev is to avoid duplicate answer list in parent list like[[1,0,-1],[1,0,-1]]
                    parentList.add(Arrays.asList(nums[i],nums[middle],nums[highest]));
                    prev = nums[middle++];
                    highest--;
                }
                else if(nums[i]+nums[middle]+nums[highest]>0)
                    highest--;
                else prev = nums[middle++];
            }
            root = nums[i];

        }
        return parentList;
    }

}
