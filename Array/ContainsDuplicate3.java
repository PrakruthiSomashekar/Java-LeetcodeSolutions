// Contains Duplicates III
// Given an array of integers, find out whether there are two distinct indices i and j
// in the array such that the absolute difference between nums[i] and nums[j]
// is at most t and the absolute difference between i and j is at most k.
package Array;

import java.util.Arrays;
import java.util.TreeSet;

public class ContainsDuplicate3 {

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (t < 0) {
            return false;
        }

        // sliding window
        TreeSet<Long> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            // abs difference
            // |nums[i] - nums[j]| <= t

            // if nums[j] <= nums[i] then:
            // nums[i] - t <= nums[j]

            // if nums[j] >= nums[i] then:
            // nums[j] <= t + nums[i]

            // which is:
            // nums[i] - t <= nums[j] <= t + nums[i]

            // basically, is there anything in the range [num - t, num + t]?

            if (!set.subSet((long) nums[i] - t, true, (long) nums[i] + t, true).isEmpty()) {
                return true;
            }

            set.add((long) nums[i]);
            if (set.size() > k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsNearbyAlmostDuplicate(new int[]{1,5,9,1,5,9}, 2, 3));
    }
}
