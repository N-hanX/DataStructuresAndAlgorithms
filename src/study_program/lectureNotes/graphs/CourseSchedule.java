package study_program.lectureNotes.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CourseSchedule {
    public static void main(String[] args) {

//         numCourses = 2, prerequisites = [[1,0]]

//        numCourses = 2, prerequisites = [[1,0],[0,1]]
//        int n = 2;
//        int[][] prerequisites = new int[][]{{1, 0}};
//        int[][] prerequisites = new int[][]{{1, 0}, {0, 1}};

        int n = 20;
        int[][] prerequisites = new int[][]{{0,10},{3,18},{5,5},{6,11},
                {11,14},{13,1},{15,1},{17,4}};

        boolean result = canFinish(n, prerequisites);

        int m = 4;
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        time = 0;
        Map<Integer, ArrayList<Integer>> adjList = new HashMap<>();

        for(int i = 0; i < numCourses; i++){
            adjList.put(i, new ArrayList<>());
        }

        int edgeLength = prerequisites.length;

        for(int i = 0; i < edgeLength; i++){
            int source = prerequisites[i][0];
            int destination = prerequisites[i][1];

            ArrayList<Integer> neighbors = adjList.get(source);
            neighbors.add(destination);
        }

        int[] visited = new int[numCourses];
        int[] arrival = new int[numCourses];
        int[] destination = new int[numCourses];

        for(int i = 0; i < prerequisites.length; i++){
            int source = prerequisites[i][0];
            if(visited[source] == 0 ){
                boolean result = dfs(source, adjList, visited, arrival, destination);

                if(result == false){
                    return false;
                }
            }
        }

        return true;
    }

    static int time;
    public static boolean dfs(int source, Map<Integer, ArrayList<Integer>> adjList,
                    int[] visited, int[] arrival, int[] destination){
        arrival[source] = time++;
        visited[source] = 1;
        ArrayList<Integer> neighbors = adjList.get(source);
        for(int i = 0; i < neighbors.size(); i ++){
            int neighbor = neighbors.get(i);
//            System.out.println(source + " - " + neighbor);
            if(source == neighbor)
                return false;

            if(visited[neighbor] == 1){
                if(destination[neighbor] == 0)
                    return false;
            }else{
                boolean result = dfs(neighbor, adjList, visited, arrival, destination);
                if(result == false)
                    return false;
            }
        }
        destination[source] = time++;
        return true;
    }
}
