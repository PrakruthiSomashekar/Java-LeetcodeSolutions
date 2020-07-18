package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CourseSchedule2 {

    List<Integer>[] graph;
    Stack<Integer> stack = new Stack();
    boolean[] visited;
    Boolean[] explored;
    boolean hasCycle = false;

    public static void main(String[] args) {
        CourseSchedule2 schedule = new CourseSchedule2();
        int[][] pre = new int[][]{{1,0},{2,1}};
        System.out.println(schedule.findOrder(3,pre));
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        graph = new List[numCourses];
        visited = new boolean[numCourses];
        explored = new Boolean[numCourses];

        for(int i = 0; i < numCourses; i++)
            graph[i] = new ArrayList();

        for(int[] edge : prerequisites)
            graph[edge[1]].add(edge[0]);


        for(int i = 0; i < numCourses; i++)  {
            if(!visited[i]) dfs(i);
            if(hasCycle) return new int[]{} ;
        }

        int[] result = new int[numCourses];

        int i = 0;
        while(!stack.isEmpty())
            result[i++] = stack.pop();
        return result;
    }

    void dfs(int u){
        //System.out.print(" " + u);
        if(explored[u] != null && !explored[u]) {
            hasCycle = true;
            return;
        }
        if(visited[u]) return;
        visited[u] = true;
        explored[u] = false;
        for(int v : graph[u])
            dfs(v);
        explored[u] = true;

        stack.push(u);
    }
}
