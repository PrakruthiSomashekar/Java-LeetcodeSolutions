package Greedy;/*There are N children standing in a line. Each child is assigned a rating value.

        You are giving candies to these children subjected to the following requirements:

        Each child must have at least one candy.
        Children with a higher rating get more candies than their neighbors.
        What is the minimum candies you must give?*/

import java.util.Arrays;

public class Candies {
    public static void main(String[] args) {
        Candies c = new Candies();
        int[] arr = new int[]{1,0,2};
        System.out.println(c.candy(arr));
    }

    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        Arrays.fill(candies,1);
        for(int i=1;i<candies.length;i++){
            if(ratings[i]>ratings[i-1])
                candies[i] = candies[i-1]+1;
        }
        for(int i=candies.length-2;i>=0;i--){
            if(ratings[i+1]<ratings[i])
                candies[i] = Math.max(candies[i],candies[i+1]+1);
        }
        return Arrays.stream(candies).sum();
    }
}
