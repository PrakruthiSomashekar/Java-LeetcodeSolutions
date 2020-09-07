package Array;// Given a string s and a string t, check if s is subsequence of t.

public class Subsequence {

    public static void main(String[] args) {
        Subsequence is = new Subsequence();
        System.out.println(is.isSubsequence("leetcode","abledetdfetteckohdfe"));
    }
    public boolean isSubsequence(String s, String t) {

        int parentLen = t.length();
        int childLen = s.length();
        int i=0;
        int j=0;
        while(i<parentLen && j<childLen){
            if(s.charAt(j) == t.charAt(i)){
                j++;
            }
            if (j == childLen)
                return true;
            i++;
        }
        return j == childLen;
    }
}
