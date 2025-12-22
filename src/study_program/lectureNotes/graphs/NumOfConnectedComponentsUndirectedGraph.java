package study_program.lectureNotes.graphs;

import java.util.*;

public class NumOfConnectedComponentsUndirectedGraph {
    public static void main(String[] args) {
//        int n = 5;
//        int[][] edges = new int[][]{{0, 1}, {1, 2}, {3, 4}};

        int n = 5;
        int[][] edges = new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}};

        int result = findNumOfComponents(n, edges);

        int a = 4;

    }

    public static int findNumOfComponents(int n, int[][] edges){
        Map<Integer, ArrayList<Integer>> edgeMap = new HashMap<>();
        for(int i = 0; i < n; i++){
            edgeMap.put(i, new ArrayList<>());
        }

        for(int i = 0; i < edges.length; i++){
            int curr_vertices = edges[i][0];
            int cross_vertices = edges[i][1];

            List<Integer> vertexSet = edgeMap.get(curr_vertices);
            vertexSet.add(cross_vertices);

            vertexSet = edgeMap.get(cross_vertices);
            vertexSet.add(curr_vertices);
        }

        int[] visited = new int[n];

        int component_counter = 0;
        for(int i = 0; i < n; i++){
            if(visited[i] == 0){
                helper(edgeMap, i, visited);
                component_counter++;
            }
        }

        return component_counter;
    }

    public static void helper(Map<Integer, ArrayList<Integer>> edgeMap, int curr_vertex, int[] visited){
        if(visited[curr_vertex] > 0){
            return;
        }

        visited[curr_vertex] = 1;
        ArrayList<Integer> adjList = edgeMap.get(curr_vertex);
        for(int i = 0; i < adjList.size(); i++){
            int cross_vertex = adjList.get(i);
            helper(edgeMap, cross_vertex, visited);
        }
    }
}
