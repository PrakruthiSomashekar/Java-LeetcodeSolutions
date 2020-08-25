package Array;

public class ReverseString {

    public void reverseString(char[] s) {
        int i=0,j=s.length-1;
        while (i<j){
            char temp = s[i];
            s[i++] = s[j];
            s[j--] = temp;
        }
    }

    public static void main(String[] args) {
        ReverseString reverse = new ReverseString();
        char[] c = {'h','e','l','l','o'};
        reverse.reverseString(c);
        System.out.println(c);
    }
}
