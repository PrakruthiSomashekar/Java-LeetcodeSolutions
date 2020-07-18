package Graph;// Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of any size
// Each person may dislike some other people, and they should not go into the same group.
// Return true if and only if it is possible to split everyone into two groups in this way
// DFS

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PossibleBipartition {
    ArrayList<Integer>[] graph;
    Map<Integer, Integer> color;

    public static void main(String[] args) {
        PossibleBipartition p = new PossibleBipartition();
        System.out.println(p.possibleBipartition(5,new int[][]{{1,2},{2,3},{3,4},{4,5},{1,5}}));
    }

    public boolean possibleBipartition(int N, int[][] dislikes) {

        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; ++i)
            graph[i] = new ArrayList();

        for (int[] edge: dislikes) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        color = new HashMap();
        for (int node = 1; node <= N; ++node)
            if (!color.containsKey(node) && !dfs(node, 0))
                return false;
        return true;
    }

    public boolean dfs(int node, int c) {
        if (color.containsKey(node))
            return color.get(node) == c;
        color.put(node, c);

        for (int nei: graph[node])
            if (!dfs(nei, c ^ 1))
                return false;
        return true;
    }
}
