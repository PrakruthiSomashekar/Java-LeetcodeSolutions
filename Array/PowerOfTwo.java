package Array;// Given an integer, write a function to determine if it is a power of two.

public class PowerOfTwo {

    public static void main(String[] args) {
        PowerOfTwo two = new PowerOfTwo();
        System.out.println(two.isPowerOfTwo(218));
    }

    public boolean isPowerOfTwo(int n) {
        if(n<=0)
            return false;
        return (n&(-n)) == n;
    }
}
