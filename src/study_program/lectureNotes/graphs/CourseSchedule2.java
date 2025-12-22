package study_program.lectureNotes.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CourseSchedule2 {
    public static void main(String[] args) {
//        int numCourses = 2;
//        int[][] prerequisites = new int[][]{{1,0}};

        int numCourses = 4; //[1,0],[2,0],[3,1],[3,2]]
        int[][] prerequisites = new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}};

        int[] result = findOrder(numCourses, prerequisites);
        int m = 4;
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        time = 0;
        Map<Integer, ArrayList<Integer>> adjList = new HashMap<>();

        for(int i = 0; i < numCourses; i++){
            adjList.put(i, new ArrayList<>());
        }

        int edgeLength = prerequisites.length;

        for(int i = 0; i < edgeLength; i++){
            int source = prerequisites[i][1];
            int destination = prerequisites[i][0];

            ArrayList<Integer> neighbors = adjList.get(source);
            neighbors.add(destination);
        }

        int[] visited = new int[numCourses];
        int[] arrival = new int[numCourses];
        int[] destination = new int[numCourses];

        int[] sortedCourse = new int[numCourses];
        ArrayList<Integer> sortedCourseList = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            if(visited[i] == 0){
                boolean result = dfs(i, adjList, visited, arrival, destination, sortedCourseList);
                if(result == false){
                    return new int[0];
                }
            }
        }

        for(int i = 0; i < numCourses; i++){
            sortedCourse[i] = sortedCourseList.get(sortedCourseList.size() - 1 - i);
        }
        return sortedCourse;
    }

    static int time;
    public static boolean dfs(int source, Map<Integer, ArrayList<Integer>> adjList,
                        int[] visited, int[] arrival, int[] destination, ArrayList<Integer> sortedCourse){
        arrival[source] = time++;
        visited[source] = 1;
        ArrayList<Integer> neighbors = adjList.get(source);

        for(int i = 0; i < neighbors.size(); i++){
            int neighbor = neighbors.get(i);

            if(visited[neighbor] == 0){
                boolean result = dfs(neighbor, adjList, visited, arrival, destination, sortedCourse);
                if(result == false)
                    return false;
            }else{
                if(destination[neighbor] == 0){
                    return false;
                }
            }
        }
        destination[source] = time++;
        sortedCourse.add(source);
        return true;
    }
}
