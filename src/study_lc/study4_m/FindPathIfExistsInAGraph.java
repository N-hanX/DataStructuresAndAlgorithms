package study_lc.study4_m;

import java.util.*;

public class FindPathIfExistsInAGraph {

    public static void main(String[] args) {
        int[][] edges = new int[][]{{0,1}, {1,2}, {2,0}};
        int source = 0;
        int destination = 2;
        int n = 3;

//        int[][] edges = new int[][]{{0,1}, {0,2}, {3,5}, {5,4}, {4,3}};
//        int source = 0;
//        int destination = 5;
//        int n = 6;

        boolean result = validPath(n, edges, source, destination);

        int a = 4;
    }

    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        neighborMap = new HashMap<>();
        visited = new HashSet<>();

        for(int i = 0; i < n; i++){
            neighborMap.put(i, new ArrayList<>());
        }

        for(int i = 0; i < edges.length; i++){
            int[] currEdge = edges[i];
            int a = currEdge[0];
            int b = currEdge[1];

            List<Integer> currNeighborList = neighborMap.get(a);
            currNeighborList.add(b);

            currNeighborList = neighborMap.get(b);
            currNeighborList.add(a);
        }

        return dfs(source, destination);
    }

    static Map<Integer, List<Integer>> neighborMap;
    static Set<Integer> visited;
    public static boolean dfs(int curr_source, int destination){
        if(visited.contains(curr_source))
            return false;

        if(curr_source == destination)
            return true;

        visited.add(curr_source);


        List<Integer> currNeighborList = neighborMap.get(curr_source);
        for(int i = 0; i < currNeighborList.size(); i++){
            int the_neigh = currNeighborList.get(i);
            if(dfs(the_neigh, destination)){
                return true;
            }
        }
        return false;
    }

}
