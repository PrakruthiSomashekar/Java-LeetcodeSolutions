// Given a sorted array and a target value, return the index if the target is found. If not,
// return the index where it would be if it were inserted in order.

public class SearchInsertPos {

    public static void main(String[] args) {
        SearchInsertPos s = new SearchInsertPos();
        System.out.println(s.searchInsert(new int[]{1, 3, 5, 6},2));
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid]<target){
                left = mid+1;
            }
            else right = mid-1;
        }
        return left;
    }
}
