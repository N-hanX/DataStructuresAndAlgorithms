package graph;

import java.util.*;

public class NumberOfConnectedComponentsInUndirectedGraph {
    public static void main(String[] args) {
        //[0 ,1], [1, 2], [0, 2], [3, 4]
        //[0, 1],
        //[2, 3],
        //[4, 5],
        //[6, 7],
        //[4, 7],
        //[5, 6]
        ArrayList<Integer> edge1 = new ArrayList<>(Arrays.asList(0, 1));
        ArrayList<Integer> edge2 = new ArrayList<>(Arrays.asList(2, 3));
        ArrayList<Integer> edge3 = new ArrayList<>(Arrays.asList(4, 5));
        ArrayList<Integer> edge4 = new ArrayList<>(Arrays.asList(6, 7));
        ArrayList<Integer> edge5 = new ArrayList<>(Arrays.asList(4, 7));
        ArrayList<Integer> edge6 = new ArrayList<>(Arrays.asList(5, 6));

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        result.add(edge1);
        result.add(edge2);
        result.add(edge3);
        result.add(edge4);
        result.add(edge5);
        result.add(edge6);

        int n = 8;

        Integer numberOfConnectedComponents = number_of_connected_components(n, result);

        int a = 5;
    }

    static Integer number_of_connected_components(Integer n, ArrayList<ArrayList<Integer>> edges) {
        Map<Integer, ArrayList<Integer>> setOfComponents = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        for(int i = 0; i < edges.size(); i++){
            ArrayList<Integer> currEdge = edges.get(i);

            int edge1 = currEdge.get(0);
            int edge2 = currEdge.get(1);

            if(setOfComponents.containsKey(edge1)){
                ArrayList<Integer> corner1List = setOfComponents.get(edge1);
                corner1List.add(edge2);
            }else{
                ArrayList<Integer> corner1List = new ArrayList<>();
                corner1List.add(edge2);
                setOfComponents.put(edge1, corner1List);
            }

            if(setOfComponents.containsKey(edge2)){
                ArrayList<Integer> corner2List = setOfComponents.get(edge2);
                corner2List.add(edge1);
            }else{
                ArrayList<Integer> corner2List = new ArrayList<>();
                corner2List.add(edge1);
                setOfComponents.put(edge2, corner2List);
            }
        }

        int numOfComps = 0;

        for(int i = 0; i < n; i++){
            if(!setOfComponents.containsKey(i)){
                numOfComps++;
                continue;
            }

            if(!visited.contains(i)){
                numOfComps++;
            }else{
                continue;
            }

            findAllEdges(visited, setOfComponents, i);
        }
        return numOfComps;
    }

    static void findAllEdges(Set<Integer> visited, Map<Integer, ArrayList<Integer>> setOfComponents, int i){
        if(visited.contains(i)){
            return;
        }
        ArrayList<Integer> edgeList = setOfComponents.get(i);
        visited.add(i);

        for(int j = 0; j < edgeList.size(); j++){
            int otherEdge = edgeList.get(j);

            if(visited.contains(otherEdge)){
                continue;
            }

            findAllEdges(visited, setOfComponents, otherEdge);
        }
    }
}
