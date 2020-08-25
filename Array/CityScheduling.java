package Array;// here are 2N people a company is planning to interview. The cost of flying the i-th person to city A is costs[i][0],
// and the cost of flying the i-th person to city B is costs[i][1].
//Return the minimum cost to fly every person to a city such that exactly N people arrive in each city.

import java.util.Arrays;
import java.util.Comparator;

public class CityScheduling {

    public static void main(String[] args) {
        CityScheduling cityScheduling = new CityScheduling();
        int[][] arr = {{10,20},{30,200},{400,50},{30,20}};
        System.out.println(cityScheduling.twoCitySchedCost(arr));
    }

    public int twoCitySchedCost(int[][] costs) {
        int sum=0;
        Comparator<int[]> comparator = (a, b) -> Math.abs(b[0] - b[1]) - Math.abs(a[0] - a[1]);
        Arrays.sort(costs, comparator);
        int c1=0;
        int c2=0;
        for(int i=0;i<costs.length;i++){
            if((costs[i][0]<=costs[i][1] && c1<(costs.length/2)) || c2==costs.length/2){
                sum += costs[i][0];
                c1++;
            }
            else {
                sum += costs[i][1];
                c2++;
            }
        }
        return sum;
    }
}
