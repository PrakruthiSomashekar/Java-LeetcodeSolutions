// return the number in the array whose frequency is 1 with O(1) space and logn time complexity

public class SingleElement {

    public static void main(String[] args) {
        SingleElement s = new SingleElement();
        System.out.println(s.singleNonDuplicate(new int[]{3, 3, 7, 7, 10, 11, 11}));
    }

    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == nums[mid - 1]) {
                if ((nums.length - mid + 1) % 2 == 0)
                    right = mid - 2;
                else left = mid + 1;
            } else if (nums[mid] == nums[mid + 1]) {
                if ((nums.length - mid + 1) % 2 == 0)
                    left = mid + 2;
                else right = mid - 1;
            } else return nums[mid];
        }
        return nums[left];
    }
}
