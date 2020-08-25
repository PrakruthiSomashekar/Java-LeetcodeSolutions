package Array;// Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
// sliding window approach : https://www.youtube.com/watch?time_continue=649&v=q9I5g0XyjEA&feature=emb_title

import java.util.ArrayList;
import java.util.List;

public class StringAnagrams {

    public List<Integer> findAnagrams(String s, String p) {
        int m = s.length(), n = p.length();
        if(n > m) return new ArrayList<>();

        int[] cnt_arr = new int[26];
        for(int i = 0; i < n; i++){
            cnt_arr[s.charAt(i) - 'a']++;
            cnt_arr[p.charAt(i) - 'a']--;
        }

        List<Integer> list = new ArrayList<>();
        for(int i = n; i < m; i++){
            if(areAllZeroes(cnt_arr)){
                list.add(i - n);
            }
            cnt_arr[s.charAt(i) - 'a']++;
            cnt_arr[s.charAt(i - n) - 'a']--;
        }
        if(areAllZeroes(cnt_arr)){
            list.add(m - n);
        }

        return list;
    }

    boolean areAllZeroes(int[] cnt_arr){
        for(int i = 0; i < cnt_arr.length; i++){
            if(cnt_arr[i] != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        StringAnagrams s = new StringAnagrams();
        System.out.println(s.findAnagrams("abab","ab"));
    }
}
