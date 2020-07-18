package Greedy;
// Suppose you have a random list of people standing in a queue. Each person is described by a pair of
// integers (h, k), where h is the height of the person and k is the number of people in front of this person
// who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueueByHeight {

    public static void main(String[] args) {
        QueueByHeight queue = new QueueByHeight();
        int[][] arr = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        int[][] res = queue.reconstructQueue(arr);
        for (int[] re : res) System.out.println(re[0]+" "+re[1]);
    }

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (p1, p2) -> p1[0] == p2[0] ? p1[1] - p2[1] : p2[0] - p1[0]);
        List<int[]> list = new ArrayList<>();
        for (int[] person : people) {
            list.add(person[1], person); // placing people based on the K value
        }
        return list.toArray(people);
    }
}
