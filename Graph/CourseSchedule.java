package Graph;
// There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.
//Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
//Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {

    public static void main(String[] args) {
        CourseSchedule schedule = new CourseSchedule();
        int[][] pre = new int[][]{{1,0},{2,1}};
        System.out.println(schedule.canFinish(2,pre));
    }

    List<Integer>[] graph;
    boolean[] visited;
    boolean[] explored;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //  creating adjacency list representation of the graph
        graph = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < prerequisites.length; i++){
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }

        visited = new boolean[numCourses];
        explored = new boolean[numCourses];
        for(int i = 0; i < numCourses; i++){
            if(!visited[i]){
                if(isCyclic(i)){
                    return false;
                }
            }
        }

        return true;
    }

    boolean isCyclic(int u){
        visited[u] = true;
        for(Integer v : graph[u]){
            if(!visited[v]){
                if(isCyclic(v)){
                    return true;
                }
            }
            else if(!explored[v]){
                return true;
            }
        }
        // explored all the adjacent vertices for vertex "u" and thus marking "u" as explored
        explored[u] = true;
        return false;
    }
}
