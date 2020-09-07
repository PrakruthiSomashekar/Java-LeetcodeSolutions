// 952. Largest component size by common factor
// Given a non-empty array of unique positive integers A, consider the following graph:
//
//There are A.length nodes, labelled A[0] to A[A.length - 1];
//There is an edge between A[i] and A[j] if and only if A[i] and A[j] share a common factor greater than 1.
//Return the size of the largest connected component in the graph.

package Graph;

import java.util.HashMap;
import java.util.Map;

public class LargestComponentSize {

    public int largestComponentSize(int[] A) {
        Map<Integer,Integer> parent = new HashMap<>();

        for (int num : A)
            for (int fact = 2; fact*fact<=num; fact++)
                if (num % fact == 0){
                    union(num,fact,parent);
                    union(num,num/fact,parent);
                }

        int max = 1;
        Map<Integer,Integer> freq = new HashMap<>();
        for (Integer v : A) {
            int f = find(v,parent);
            if (freq.containsKey(f)) {
                freq.put(f, freq.get(f)+1);
                max=Math.max(max,freq.get(f));
            }
            else freq.put(f,1);
        }
        return max;
    }

    public void union(int n, int m, Map<Integer,Integer> p) {
        int findN = find(n,p);
        int findM = find(m,p);
        if (findN < findM) p.put(findM,findN);
        else p.put(findN,findM);
    }

    public int find(Integer i, Map<Integer,Integer> parent) {
        if (parent.get(i) == null) parent.put(i,i);
        while (i != parent.get(i)) i = parent.get(i);
        return i;
    }

    public static void main(String[] args) {
        LargestComponentSize size = new LargestComponentSize();
        size.largestComponentSize(new int[]{4,6,15,35});
    }
}
