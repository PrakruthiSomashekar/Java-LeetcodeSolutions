// the Hamming distance between two strings of equal length is the number of positions at which
// the corresponding symbols are different. In other words, it measures the minimum number of
// substitutions required to change one string into the other,
public class HammingDistance {

    public static void main(String[] args) {
        System.out.println(hammingDistance(3,1));
//        plusOne(new int[]{1,2,9});
    }

    public static int hammingDistance(int x, int y) {
        int count = 0;
        if(x == y) {
            return count;
        }
        while(x != 0 && y !=0) {
            int xbit = (1 & x);
            int ybit = (1 & y);
            if(xbit != ybit) {
                count++;
            }
            x = x >> 1;
            y = y >> 1;
        }
        while(x != 0) {
            int xbit = (1 & x);
            if(xbit != 0) {
                count++;
            }
            x = x >> 1;
        }
        while(y != 0) {
            int ybit = (1 & y);
            if(ybit != 0) {
                count++;
            }
            y = y >> 1;
        }

        return count;

    }

}

