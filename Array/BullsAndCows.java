// Bulls and Cows
// You are playing the following Bulls and Cows game with your friend:
// You write down a number and ask your friend to guess what the number is.
// Each time your friend makes a guess, you provide a hint that indicates how many digits in said guess
// match your secret number exactly in both digit and position (called "bulls") and
// how many digits match the secret number but locate in the wrong position (called "cows").
package Array;

import java.util.ArrayList;
import java.util.List;

public class BullsAndCows {

    public static void main(String[] args) {
        System.out.println(getHint("1123","0111"));
    }

    public static String getHint(String secret, String guess) {
        StringBuilder result = new StringBuilder();
        List<Character> list = new ArrayList<>();
        char[] guessArray = guess.toCharArray();
        int As = 0;
        int Bs = 0;
        for(int i=0; i<secret.length(); i++){
            if(secret.charAt(i) == guess.charAt(i)) {
                As++;
                guessArray[i] = 'a';
            }
            else list.add(secret.charAt(i));
        }
        result.append(As);
        result.append("A");
        for(int i=0; i<secret.length(); i++){
            if(list.contains(guessArray[i])) {
                Bs++;
                list.remove((Character) guess.charAt(i));
            }
        }
        result.append(Bs);
        result.append("B");
        return result.toString();
    }
}
