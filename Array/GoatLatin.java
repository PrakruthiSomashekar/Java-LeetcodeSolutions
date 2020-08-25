package Array;
// Goat Latin

public class GoatLatin {

    public static void main(String[] args) {
        toGoatLatin("The quick brown fox jumped over the lazy dog");
    }

    public static String toGoatLatin(String S) {
        String[] arr = S.split(" ");
        StringBuilder builder = new StringBuilder();
        int i=1;
        for(String s: arr){
            int j=0;
            if(s.startsWith("a") || s.startsWith("A") || s.startsWith("e") || s.startsWith("E") || s.startsWith("i") || s.startsWith("I") || s.startsWith("o") || s.startsWith("O") || s.startsWith("u") || s.startsWith("U")){
                builder.append(s);
            }
            else {
                String word = s.substring(1,s.length());
                builder.append(word);
                builder.append(s.charAt(0));
            }
            builder.append("ma");
            while (j<i){
                builder.append("a");
                j++;
            }
            i++;
            builder.append(" ");
        }
        builder.deleteCharAt(builder.length()-1);
        return builder.toString();
    }
}
