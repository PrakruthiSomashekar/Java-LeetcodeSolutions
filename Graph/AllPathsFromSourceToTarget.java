package Graph;
// 797. All Paths From Source to Target
// Given a directed, acyclic graph of N nodes.  Find all possible paths from node 0 to node N-1, and return them in any order.
//
//The graph is given as follows:  the nodes are 0, 1, ..., graph.length - 1.  graph[i] is a list of all nodes j
// for which the edge (i, j) exists.

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllPathsFromSourceToTarget {

    public static void main(String[] args) {
        int[][] graph = {{1,2},{3},{3},{}};
        List<List<Integer>> result = allPathsSourceTarget(graph);
        for(List<Integer> list: result)
            System.out.println(list);
    }

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList();
        dfs(graph, 0, graph.length - 1, new ArrayList(), result);
        return result;
    }

    private static void dfs(int[][] graph, int source, int destination, List<Integer> list, List<List<Integer>> result) {
        if(source == destination) result.add(list);
        list.add(source);
        for(Integer vertex : graph[source]) {
            List<Integer> copyList = new ArrayList<>(list);
            dfs(graph, vertex, destination, copyList, result);
        }
    }

}
