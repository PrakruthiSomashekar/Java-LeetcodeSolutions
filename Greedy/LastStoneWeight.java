package Greedy;
// Each turn, we choose the two heaviest stones and smash them together.
// Suppose the stones have weights x and y with x <= y.  The result of this smash is:
//If x == y, both stones are totally destroyed;
//If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
//At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LastStoneWeight {
    public static void main(String[] args) {
        LastStoneWeight last = new LastStoneWeight();
        int[] arr = {7,6,7,6,9};
        System.out.println(last.lastStoneWeight(arr));
    }

    public int lastStoneWeight(int[] stones) {
        if(stones.length == 0)
            return 0;
        else if(stones.length == 1)
            return stones[0];
        List<Integer> list = new ArrayList<>();
        for (int stone : stones) list.add(stone);

        for(int i=0;i<stones.length-1;i++) {
            Collections.sort(list);
            Collections.reverse(list);
            list.add(list.remove(0) - list.remove(0));
        }
        return list.get(0);
    }
}
