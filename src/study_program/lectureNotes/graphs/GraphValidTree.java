package study_program.lectureNotes.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphValidTree {
    public static void main(String[] args) {
//        int n = 5;
//        int[][] edges = new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 4}};

        int n = 5;
        int[][] edges = new int[][]{{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};

        boolean result = isValid(n, edges);
        int a = 4;
    }

    public static Map<Integer, List<Integer>> createAdjList(int n, int[][] edges){
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for(int i = 0; i < n; i++){
            adjList.put(i, new ArrayList<>());
        }

        for(int i = 0; i < edges.length; i++){
            int[] currEdge = edges[i];

            int currVertex = currEdge[0];
            int otherVertex = currEdge[1];

            List<Integer> currAdjVertex = adjList.get(currVertex);
            currAdjVertex.add(otherVertex);

            List<Integer> othersAdjVertex = adjList.get(otherVertex);
            othersAdjVertex.add(currVertex);
        }

        return adjList;
    }

    public static boolean dfs_for_valid_tree(Map<Integer, List<Integer>> adjList, int currVertex,
                           int[] visited, int[] parent){
        if(visited[currVertex] > 0){
            return false;
        }

        visited[currVertex] = 1;
        List<Integer> currAdjVertices = adjList.get(currVertex);


        for(int i = 0; i < currAdjVertices.size(); i++){
            int otherVertex = currAdjVertices.get(i);

            if(parent[currVertex] == otherVertex){
                continue;
            }

            if(visited[otherVertex] == 0){
                parent[otherVertex] = currVertex;
                boolean result = dfs_for_valid_tree(adjList, otherVertex, visited, parent);
                if(result == false)
                    return false;
            }else{
                return false;
            }
        }
        return true;
    }

    public static boolean isValid(int n, int[][] edges){
        Map<Integer, List<Integer>> adjList = createAdjList(n, edges);
        int[] visited = new int[n];
        int[] parent = new int[n];

        return dfs_for_valid_tree(adjList, 0, visited, parent);
    }
}
