package study4_a;

import java.util.ArrayList;
import java.util.List;

public class MinimumFuelCost {

    public static void main(String[] args) {
        int[][] roads = {{3,1},{3,2},{1,0},{0,4},{0,5},{4,6}};
        int seats = 2;
        minimumFuelCost(roads, seats);
        int a = 4;
    }
    private static long answer = 0L;

    public static long minimumFuelCost(int[][] roads, int seats){
        List<List<Integer>> tree = new ArrayList<>();
        int n = roads.length + 1;

        for(int i = 0; i < n; i++){
            tree.add(new ArrayList<>());
        }

        for(int[] e : roads){
            tree.get(e[0]).add(e[1]);
            tree.get(e[1]).add(e[0]);
        }
        dfs(tree, 0, -1, seats);
        return answer;
    }

    public static int dfs(List<List<Integer>> tree, int node, int parent, double seats){
        int size = 1;

        for(int child: tree.get(node)){
            if(child == parent) continue;
            size += dfs(tree, child, node, seats);
        }
        if(node != 0) answer += (long)Math.ceil(size/seats);
        return 1;

    }

}
