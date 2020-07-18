// Given an array w of positive integers, where w[i] describes the weight of index i,
// write a function pickIndex which randomly picks an index in proportion to its weight.

public class RandomPick {

    int[] w_sum;
    public RandomPick(int[] w) {
        w_sum = new int[w.length];
        int sum = 0;
        for(int i = 0; i < w.length; i++){
            sum += w[i];
            w_sum[i] = sum;
        }
    }

    public int pickIndex() {
        double target = w_sum[w_sum.length - 1] * Math.random();
        for(int i = 0; i < w_sum.length; i++){
            if(target < w_sum[i]) return i;
        }
        return -1;
    }
}
