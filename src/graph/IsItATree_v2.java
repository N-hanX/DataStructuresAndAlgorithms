package graph;

import java.util.*;

public class IsItATree_v2 {
    public static void main(String[] args) {
//        ArrayList<Integer> edge_start = new ArrayList<>(Arrays.asList(0, 0, 0));
//        ArrayList<Integer> edge_end = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<Integer> edge_start = new ArrayList<>(Arrays.asList(0, 0, 1, 2));
        ArrayList<Integer> edge_end = new ArrayList<>(Arrays.asList(3, 1, 2, 0));
        int n = 4;

        Boolean isTree = is_it_a_tree(n, edge_start, edge_end);

        int a = 5;
    }


    static Boolean is_it_a_tree(Integer node_count, ArrayList<Integer> edge_start, ArrayList<Integer> edge_end) {
        Map<Integer, ArrayList<Integer>> edgeList = new HashMap<>();

        for(int i = 0; i < edge_start.size(); i++){
            int curr_root = edge_start.get(i);
            int curr_child = edge_end.get(i);

            if(edgeList.containsKey(curr_root)){
                ArrayList<Integer> children = edgeList.get(curr_root);
                children.add(curr_child);
            }else{
                ArrayList<Integer> children = new ArrayList<>();
                children.add(curr_child);
                edgeList.put(curr_root, children);
            }
        }

        //

        boolean result = true;

        boolean isConnected = true;
        Set<Integer> visited = new HashSet<>();

        for(int i = 0; i < edge_start.size(); i++){
            int edgeInd = edge_start.get(i);

            if(visited.contains(edgeInd)){
                continue;
            }

            Set<Integer> visited_parents = new HashSet<>();
            checkTreeSpecifs(edgeList, visited_parents, edgeInd, visited);
            if(acyclic == true){
                return false;
            }
            visited.add(edgeInd);
        }

        for(int i = 0; i < node_count; i++){
            if(!visited.contains(i)){
                return false;
            }
        }

        return !acyclic;
    }

    static boolean acyclic = false;
    static void checkTreeSpecifs(Map<Integer, ArrayList<Integer>> edgeList, Set<Integer> visited_parent, int edgeInd,
                                 Set<Integer> visited){
        if(visited_parent.contains(edgeInd)){
            acyclic = true;
            return;
        }

        visited_parent.add(edgeInd);
        visited.add(edgeInd);

        if(!edgeList.containsKey(edgeInd))
            return;

        for(int i = 0; i < edgeList.get(edgeInd).size(); i++){
            int otherEdge = edgeList.get(edgeInd).get(i);

            checkTreeSpecifs(edgeList, visited_parent, otherEdge, visited);
        }
    }
}
