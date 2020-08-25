package Array;

public class BuySellStock {
    public static void main(String[] args) {
        BuySellStock b = new BuySellStock();
        System.out.println(b.maxProfit(new int[]{7, 6, 5, 4, 3, 1}));
    }

    public int maxProfit(int[] prices) {
        int max = 0;
        int min = prices[0];
        for(int i=0;i<prices.length;i++){
            if(min>prices[i])
                min = prices[i-1];
            if(prices[i] - min > 0){
                max = Math.max(max,prices[i]-min);
            }
        }
        return max;
    }
}
