// 520. Detect Capital
// Given a word, you need to judge whether the usage of capitals in it is right or not.
// All letters in this word are capitals, like "USA".
// All letters in this word are not capitals, like "leetcode".
// Only the first letter in this word is capital, like "Google".

public class DetectCapital {

    public static void main(String[] args) {
        System.out.println(detectCapitalUse("USA"));
        System.out.println(detectCapitalUse("leetcode"));
        System.out.println(detectCapitalUse("FlaG"));
    }

    public static boolean detectCapitalUse(String word) {
        int count = 0;

        for(int i=0;i<word.length();i++){
            if(Character.isUpperCase(word.charAt(i)))
                count++;

        }

        if(count == word.length())
            return true;
        else if(count == 1 && Character.isUpperCase(word.charAt(0)))
            return true;
        else if(count == 0)
            return true;
        else return false;
    }
}
