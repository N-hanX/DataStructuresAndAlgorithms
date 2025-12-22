package graph;

import java.util.*;

public class NumberOfConnectedGraphs {
    static Map<Integer, List<Integer>> adjacentList;
    static boolean visited[];
    static int numberOfConnectedComponents;

    public static void main(String[] args) {
        int n = 6;
        List<List<Integer>> edges = exampleEdges2();
        int a = number_of_connected_components(n, edges);

//        return numberOfConnectedComponents;
    }

    public static int number_of_connected_components(int n, List<List<Integer>> edges) {
        adjacentList = new HashMap<Integer, List<Integer>>();
        visited = new boolean[n];
        numberOfConnectedComponents = 0;

        for(int i = 0; i < edges.size(); i++){
            int currEdge1 = edges.get(i).get(0);
            int currEdge2 = edges.get(i).get(1);

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

        for(int currEdgeIndex = 0; currEdgeIndex < n; currEdgeIndex++){
            if(!visited[currEdgeIndex]){
                numberOfConnectedComponents++;
                helper(currEdgeIndex);
            }
        }
        return numberOfConnectedComponents;
    }

    public static void helper(int currEdge){
        System.out.println("curr edge:" + currEdge);
        if(!visited[currEdge]){
            visited[currEdge] = true;
        }else{
            return;
        }
        if(currEdge == 3){
            int a = 5;
        }

        List<Integer> currAdjacentList = adjacentList.get(currEdge);
        if(currAdjacentList == null){
            return;
        }

        for(int i = 0; i < currAdjacentList.size(); i++){
            helper(currAdjacentList.get(i));
        }
    }

    public static List<List<Integer>> exampleEdges(){
        List<List<Integer>> edges = new ArrayList<>();

        List<Integer> ex1 = new ArrayList<>();
        ex1.add(0);
        ex1.add(1);
        edges.add(ex1);

        List<Integer> ex2 = new ArrayList<>();
        ex2.add(1);
        ex2.add(2);
        edges.add(ex2);

        List<Integer> ex3 = new ArrayList<>();
        ex3.add(0);
        ex3.add(2);
        edges.add(ex3);

        List<Integer> ex4 = new ArrayList<>();
        ex4.add(3);
        ex4.add(4);
        edges.add(ex4);

        return edges;
    }


    public static List<List<Integer>> exampleEdges2(){
        List<List<Integer>> edges = new ArrayList<>();

        List<Integer> ex1 = new ArrayList<>();
        ex1.add(0);
        ex1.add(1);
        edges.add(ex1);

        List<Integer> ex2 = new ArrayList<>();
        ex2.add(0);
        ex2.add(2);
        edges.add(ex2);

        List<Integer> ex3 = new ArrayList<>();
        ex3.add(2);
        ex3.add(0);
        edges.add(ex3);

        List<Integer> ex4 = new ArrayList<>();
        ex4.add(2);
        ex4.add(2);
        edges.add(ex4);

        List<Integer> ex5 = new ArrayList<>();
        ex5.add(4);
        ex5.add(5);
        edges.add(ex5);

        List<Integer> ex6 = new ArrayList<>();
        ex6.add(5);
        ex6.add(5);
        edges.add(ex6);

        return edges;
    }
}
