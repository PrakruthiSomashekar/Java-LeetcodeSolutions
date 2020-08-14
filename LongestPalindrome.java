// Longest Palindrome
// Given a string which consists of lowercase or uppercase letters, find the
// length of the longest palindromes that can be built with those letters.
public class LongestPalindrome {

    public static int longestPalindrome(String s) {
        int[] count = new int[128];
        for (char c: s.toCharArray())
            count[c]++;

        int ans = 0;
        for (int v: count) {
            ans += v / 2 * 2;
            if (ans % 2 == 0 && v % 2 == 1)
                ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccccdd"));
    }
}

