package Array;// Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1.
// In other words, one of the first string's permutations is the substring of the second string.

public class StringPermutation {

    public static void main(String[] args) {
        StringPermutation s = new StringPermutation();
        System.out.println(s.checkInclusion("ab","eidboaoo"));
    }

    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length())
            return false;
        int[] arr = new int[26];
        for(int i=0;i<s1.length();i++){
            arr[s2.charAt(i) - 'a']++;
            arr[s1.charAt(i) - 'a']--;
        }
        for(int i=s1.length();i<s2.length();i++){
            if(areAllZeroes(arr)){
                return true;
            }
            arr[s2.charAt(i) - 'a']++;
            arr[s2.charAt(i - s1.length()) - 'a']--;
        }
        if(areAllZeroes(arr)){
            return true;
        }
        return false;
    }

    boolean areAllZeroes(int[] cnt_arr){
        for(int i = 0; i < cnt_arr.length; i++){
            if(cnt_arr[i] != 0) return false;
        }
        return true;
    }

}
