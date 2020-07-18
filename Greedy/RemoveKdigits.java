package Greedy;// Greedy algorithm
// Given a non-negative integer num represented as a string, remove k digits from the number so that the new number
// is the smallest possible

import java.util.Stack;

public class RemoveKdigits {

    public static void main(String[] args) {
        RemoveKdigits r = new RemoveKdigits();
        System.out.println(r.removeKdigits("5337",2));
    }

    public String removeKdigits(String num, int k) {
        if(num.length()==0 || num.length() == k)
            return "0";

        int index = 0;
        Stack<Character> stack = new Stack<>();
        while(index<num.length()){
            while(k>0 && !stack.empty() && stack.peek()>num.charAt(index)){
                stack.pop();
                k--;
            }
            stack.push(num.charAt(index));
            index++;
        }
        while (k>0){
            stack.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.empty()){
            char number = stack.pop();
            sb.append(number);
        }
        sb.reverse();
        while(sb.length()>1 && sb.charAt(0)=='0')
            sb.deleteCharAt(0);
        return sb.toString();

    }

}
