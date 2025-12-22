package study_program.lectureNotes.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DetectCycleInDirectedGraph {
    public static void main(String[] args) {
//        number_of_vertices": 5,
//        "number_of_edges": 7,
//                "edges": [
//[0, 1],
//[0, 3],
//[1, 3],
//[1, 2],
//[2, 3],
//[4, 0],
//[2, 4]
//]
//        , {1, 3}, {1, 2}, {2, 3}, {4, 0}, {2, 4}};
        int number_of_vertices = 5;
        int number_of_edges = 7;
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>(Arrays.asList(
                new ArrayList<Integer>(Arrays.asList(0, 1)),
                new ArrayList<Integer>(Arrays.asList(0, 3)),
                new ArrayList<Integer>(Arrays.asList(1, 3)),
                new ArrayList<Integer>(Arrays.asList(1, 2)),
                new ArrayList<Integer>(Arrays.asList(2, 3)),
                new ArrayList<Integer>(Arrays.asList(4, 0)),
                new ArrayList<Integer>(Arrays.asList(2, 4))));

        Boolean result = has_cycle(number_of_vertices, number_of_edges,  edges);

        int a = 4;
    }

    static Boolean has_cycle(Integer number_of_vertices, Integer number_of_edges, ArrayList<ArrayList<Integer>> edges) {
        time = 0;
        Map<Integer, ArrayList<Integer>> adjList = new HashMap<>();

        for (int i = 0; i < number_of_vertices; i++) {
            adjList.put(i, new ArrayList<>());
        }


        for (int i = 0; i < number_of_edges; i++) {
            int source = edges.get(i).get(0);
            int destination = edges.get(i).get(1);
            ArrayList<Integer> neighbors = adjList.get(source);

            neighbors.add(destination);
        }

        int[] visited = new int[number_of_vertices];
        int[] arrival = new int[number_of_vertices];
        int[] destination = new int[number_of_vertices];

        for(int i = 0; i < number_of_vertices; i++){
            if(visited[i] == 0) {
                if (dfs_detect_cycle(i, adjList, visited, arrival, destination) == true)
                    return true;
            }
        }
        return false;
    }

    static int time;
    public static boolean dfs_detect_cycle(int source, Map<Integer, ArrayList<Integer>> adjList,
                              int[] visited, int[] arrival, int[] destination){
        arrival[source] = time++;
        visited[source] = 1;

        ArrayList<Integer> neighbors = adjList.get(source);
        for(int i = 0; i < neighbors.size(); i++){
            int neighbor = neighbors.get(i);

            if(visited[neighbor] == 1) {
                if(destination[neighbor] == 0)
                    return true;
            }else{
                boolean result = dfs_detect_cycle(neighbor, adjList, visited, arrival, destination);
                if(result == true)
                    return true;
            }
        }

        destination[source] = time++;
        return false;
    }
}
