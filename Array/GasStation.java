package Array;
// Gas Station
// There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
// You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
// Return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1.

public class GasStation {

    public static void main(String[] args) {
        System.out.println(canCompleteCircuit(new int[]{5,1,2,3,4}, new int[]{4,4,1,5,1}));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {

        int total = 0, tank = 0, index = 0;
        for (int i = 0; i < cost.length; i++) {
            int consume = gas[i] - cost[i];
            tank += consume;
            if (tank < 0) {
                index = i + 1;
                tank = 0;
            }
            total += consume;
        }
        return total < 0 ? -1 : index;
    }
}
