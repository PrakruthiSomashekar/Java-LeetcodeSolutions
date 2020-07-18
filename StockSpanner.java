// The span of the stock's price today is defined as the maximum number of consecutive days
// (starting from today and going backwards) for which the price of the stock was less than or equal to today's price.
//For example, if the price of a stock over the next 7 days were [100, 80, 60, 70, 60, 75, 85],
// then the stock spans would be [1, 1, 1, 2, 1, 4, 6]

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StockSpanner {
    Stack<int[]> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int span = 1;
        while (!stack.isEmpty() && price >= stack.peek()[0]) { // If the current price is greater than stack peek.
            span += stack.peek()[1];
            stack.pop();
        }
        stack.push(new int[]{price, span});
        return span;
    }

    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(100));
        stockSpanner.next(80);
        stockSpanner.next(60);
        stockSpanner.next(70);
        stockSpanner.next(60);
        System.out.println(stockSpanner.next(75));
        stockSpanner.next(85);
    }
}
