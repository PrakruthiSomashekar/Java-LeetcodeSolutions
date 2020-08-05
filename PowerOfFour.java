// Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

public class PowerOfFour {

    public static void main(String[] args) {
        System.out.println(isPowerOfFour(-2147483648));
        System.out.println(isPowerOfFour(8));
        System.out.println(isPowerOfFour(256));
    }

    public static boolean isPowerOfFour(int num) {
      // return Math.log(num)/Math.log(2)%2 == 0;
        return num > 0 &&
                (num & (num - 1)) == 0 &&
                (num & 0x55555555) != 0;
    }
}
