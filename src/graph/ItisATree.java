package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItisATree {
    static Map<Integer, List<Integer>> adjacentList;
    static boolean visited[];
    static int numberOfConnectedComponents;
    static boolean itIsFirstEdge;
    static boolean itIsTree;

    public static void main(String[] args) {
        int n = 7;

        List<Integer> edge_start = new ArrayList<>();
        edge_start.add(6);
        edge_start.add(4);
        edge_start.add(4);
        edge_start.add(4);
        edge_start.add(2);
        edge_start.add(1);

        List<Integer> edge_end = new ArrayList<>();
        edge_end.add(5);
        edge_end.add(3);
        edge_end.add(5);
        edge_end.add(0);
        edge_end.add(0);
        edge_end.add(0);


        boolean it_is_tree = is_it_a_tree(n, edge_start, edge_end);

        int a = 5;
//        return numberOfConnectedComponents;
    }

    public static boolean is_it_a_tree(int n,  List<Integer> edge_start, List<Integer> edge_end){
        itIsFirstEdge = true;
        itIsTree = true;

        adjacentList = new HashMap<Integer, List<Integer>>();
        visited = new boolean[n];
        numberOfConnectedComponents = 0;

        for(int i = 0; i < edge_start.size(); i++){
            int currEdge1 = edge_start.get(i);
            int currEdge2 = edge_end.get(i);

            if(adjacentList.containsKey(currEdge1)){
                List<Integer> adjList = adjacentList.get(currEdge1);
                adjList.add(currEdge2);
            }else{
                List<Integer> adjList = new ArrayList<>();
                adjList.add(currEdge2);
                adjacentList.put(currEdge1, adjList);
            }

            if(adjacentList.containsKey(currEdge2)){
                List<Integer> adjList = adjacentList.get(currEdge2);
                adjList.add(currEdge1);
            }else{
                List<Integer> adjList = new ArrayList<>();
                adjList.add(currEdge1);
                adjacentList.put(currEdge2, adjList);
            }


        }

        for(int currEdgeIndex = 0; currEdgeIndex < edge_start.size(); currEdgeIndex++){
            if(!visited[edge_start.get(currEdgeIndex)] ){
                itIsFirstEdge = true;
                numberOfConnectedComponents++;
                helper(edge_start.get(currEdgeIndex));
            }
        }

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                itIsTree = false;
            }
        }

        return itIsTree;
    }

    public static void helper(int currEdge){
        System.out.println("curr edge:" + currEdge);
        if(!visited[currEdge] && itIsFirstEdge){
            visited[currEdge] = true;
            itIsFirstEdge = false;
        }else if(visited[currEdge] && !itIsFirstEdge){
            itIsTree = false;
            return;
        }else if(!visited[currEdge]){
            visited[currEdge] = true;
        }


        List<Integer> currAdjacentList = adjacentList.get(currEdge);
        if(currAdjacentList == null){
            return;
        }

        for(int i = 0; i < currAdjacentList.size(); i++){
            helper(currAdjacentList.get(i));
        }
    }
}
