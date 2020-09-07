package Array;
// Write a program that outputs the string representation of numbers from 1 to n.
// But for multiples of three it should output “Fizz” instead of the number and for the
// multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    public static void main(String[] args) {
        System.out.println(fizzBuzz(15));
    }

    public static List<String> fizzBuzz(int n) {

        List<String> result = new ArrayList();
        int i=1;
        while(i<=n){
            if(i%15 == 0)
                result.add("FizzBuzz");
            else if(i%3 == 0)
                result.add("Fizz");
            else if(i%5 == 0)
                result.add("Buzz");
            else result.add(Integer.toString(i));

            i++;
        }
        return result;
    }
}
