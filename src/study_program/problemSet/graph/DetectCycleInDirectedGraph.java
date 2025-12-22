package study_program.problemSet.graph;

import java.util.*;

public class DetectCycleInDirectedGraph {
    public static void main(String[] args) {
//        {
//            "number_of_vertices": 5,
//                "number_of_edges": 7,
//                "edges": [
//[0, 1],
//[0, 3],
//[1, 3],
//[1, 2],
//[2, 3],
//[4, 0],
//[2, 4]
//]
//        }

        int number_of_vertices = 5;
        int number_of_edges = 7;
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        edges.add(new ArrayList<>(Arrays.asList(0, 1)));
        edges.add(new ArrayList<>(Arrays.asList(0, 3)));
        edges.add(new ArrayList<>(Arrays.asList(1, 3)));
        edges.add(new ArrayList<>(Arrays.asList(1, 2)));
        edges.add(new ArrayList<>(Arrays.asList(2, 3)));
        edges.add(new ArrayList<>(Arrays.asList(4, 0)));
        edges.add(new ArrayList<>(Arrays.asList(2, 4)));

        Boolean result = has_cycle(number_of_vertices, number_of_edges, edges);

        int a = 4;
    }


    static Boolean has_cycle(Integer number_of_vertices, Integer number_of_edges, ArrayList<ArrayList<Integer>> edges) {
        time = 0;
        Map<Integer, ArrayList<Integer>> adjList = new HashMap<>();
        for(int i = 0; i < number_of_vertices; i++){
            adjList.put(i, new ArrayList<>());
        }

        for(int i = 0; i < edges.size(); i++){
            ArrayList<Integer> currEdge = edges.get(i);
            int source = currEdge.get(0);
            int dest = currEdge.get(1);

            ArrayList<Integer> neighbors = adjList.get(source);
            neighbors.add(dest);
        }

        Set<Integer> visited = new HashSet<>();
        int[] arrival = new int[number_of_vertices];
        int[] destination = new int[number_of_vertices];

        for(int i = 0; i < number_of_vertices; i++){
            boolean result = dfs(i, adjList, visited, arrival, destination);
            if(result == true)
                return true;
        }
        return false;
    }

    static int time;
    static boolean dfs(Integer currVertex, Map<Integer, ArrayList<Integer>> adjList, Set<Integer> visited, int[] arrival,
                       int[] destination){

        arrival[currVertex] = time++;
        visited.add(currVertex);
        ArrayList<Integer> neighbors = adjList.get(currVertex);
        for(int i = 0; i < neighbors.size(); i++){
            int neighbor = neighbors.get(i);

            if(!visited.contains(neighbor)){
                visited.add(neighbor);
                boolean result = dfs(neighbor, adjList, visited, arrival, destination);
                if(result == true)
                    return true;
            }else{
                if(destination[neighbor] == 0){
                    return true;
                }
            }
        }

        destination[currVertex] = time++;
        return false;
    }
}
