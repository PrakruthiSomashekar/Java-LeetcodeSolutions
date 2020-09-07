// Repeated Substring pattern
// Given a non-empty string check if it can be constructed by taking
// a substring of it and appending multiple copies of the substring together.
// You may assume the given string consists of lowercase English letters only and its length will not exceed 10000
package Array;

public class RepeatedSubstringPattern {

    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("abcaabcaabca"));
    }
// abcaabca, bcaabcaabcaabc
    public static boolean repeatedSubstringPattern(String s) {
        return (s + s).substring(1, 2 * s.length() - 1).contains(s);
    }
}
