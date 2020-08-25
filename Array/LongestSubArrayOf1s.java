package Array;

public class LongestSubArrayOf1s {

    public int longestSubarray(int[] nums) {
        int cnt0 = 0;
        int l = 0;
        int max_len = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                cnt0++;

            while (cnt0 > 1) {
                if (nums[l] == 0)
                    cnt0--;
                l++;
            }

            max_len = Math.max(max_len, i - l + 1);
        }

        return max_len;
    }

    public static void main(String[] args) {
        LongestSubArrayOf1s l = new LongestSubArrayOf1s();
        System.out.println(l.longestSubarray(new int[]{0,1,1,1,0,1,1,0,1}));
    }
}
