package Array;// Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the
// number of 1's in their binary representation and return them as an array.

public class BitsCounting {

    public int[] countBits(int num) {
        int[] res = new int[num+1];
        res[0] = 0;
        for(int i=1;i<=num;i++){
            res[i] = res[i >> 1] + i % 2;   // >> left shift by 1 position
        }
        return res;
    }

    public static void main(String[] args) {
        BitsCounting b = new BitsCounting();
        int[] res = b.countBits(5);
        for(int i=0;i<res.length;i++)
            System.out.println(res[i]);
    }
}
