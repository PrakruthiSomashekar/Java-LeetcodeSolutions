// Given an unsorted integer array, find the smallest missing positive integer.

public class FirstMissingPositive {

    public static void main(String[] args) {
        FirstMissingPositive f = new FirstMissingPositive();
        int[] arr = {1,2,0};
        System.out.println(f.firstMissingPositive(arr));
    }

    public int firstMissingPositive(int[] nums) {
        boolean ifOne = false;
        // preprocessing
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 1)
                ifOne = true;
            if(nums[i] > nums.length || nums[i] < 0)
                nums[i] = 1;

        }
        if(!ifOne)
            return 1;

        for(int i=0;i<nums.length;i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0)
                nums[index] = -1 * nums[index];
        }

        for(int i=0;i<nums.length;i++){
            if(nums[i]>0)
                return i+1;
        }
        return nums.length+1;
    }

}
