package study_program.problemSet.graph;

import java.util.*;

public class LongestPathInWeightedDAG {
    public static void main(String[] args) {
//        {
//            "dag_nodes": 4,
//                "dag_from": [1, 1, 1, 3],
//            "dag_to": [2, 3, 4, 4],
//            "dag_weight": [2, 2, 4, 3],
//            "from_node": 1,
//                "to_node": 4
//        }
//        Integer dag_nodes = 4;
//        ArrayList<Integer> dag_from = new ArrayList<>(Arrays.asList(1, 1, 1, 3));
//        ArrayList<Integer> dag_to = new ArrayList<>(Arrays.asList(2, 3, 4, 4));
//        ArrayList<Integer> dag_weight = new ArrayList<>(Arrays.asList(2, 2, 4, 3));
//        Integer from_node = 1;
//        Integer to_node = 4;

//        {
//            "dag_nodes": 3,
//                "dag_from": [3, 2],
//            "dag_to": [2, 1],
//            "dag_weight": [2000000000, 2000000000],
//            "from_node": 3,
//                "to_node": 1
//        }

//        Integer dag_nodes = 3;
//        ArrayList<Integer> dag_from = new ArrayList<>(Arrays.asList(3,2));
//        ArrayList<Integer> dag_to = new ArrayList<>(Arrays.asList(2, 1));
//        ArrayList<Integer> dag_weight = new ArrayList<>(Arrays.asList(2000000000, 2000000000));
//        Integer from_node = 3;
//        Integer to_node = 1;
//
//        {
//            "dag_nodes": 5,
//                "dag_from": [5, 4, 3, 2, 5, 5, 3],
//            "dag_to": [4, 3, 2, 1, 1, 3, 1],
//            "dag_weight": [1, 1, 1, 1, 3, 3, 1],
//            "from_node": 5,
//                "to_node": 1
//        }

//        Integer dag_nodes = 5;
//        ArrayList<Integer> dag_from = new ArrayList<>(Arrays.asList(5, 4, 3, 2, 5, 5, 3));
//        ArrayList<Integer> dag_to = new ArrayList<>(Arrays.asList(4, 3, 2, 1, 1, 3, 1));
//        ArrayList<Integer> dag_weight = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 3, 3, 1));
//        Integer from_node = 5;
//        Integer to_node = 1;

//        {
//            "dag_nodes": 6,
//                "dag_from": [1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 4, 4, 5],
//            "dag_to": [2, 3, 4, 5, 6, 3, 4, 5, 6, 4, 5, 6, 5, 6, 6],
//            "dag_weight": [1603279907, 786622764, 1379634170, 506857005, 1909591643, 1054657824, 134818800, 683696174, 245922337, 874046417, 1833794262, 1260174793, 185349978, 349077340, 1733615803],
//            "from_node": 1,
//                "to_node": 6
//        }


        Integer dag_nodes = 6;
        ArrayList<Integer> dag_from = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 4, 4, 5));
        ArrayList<Integer> dag_to = new ArrayList<>(Arrays.asList(2, 3, 4, 5, 6, 3, 4, 5, 6, 4, 5, 6, 5, 6, 6));
        ArrayList<Integer> dag_weight = new ArrayList<>(Arrays.asList(1603279907, 786622764, 1379634170, 506857005, 1909591643, 1054657824, 134818800, 683696174, 245922337, 874046417, 1833794262, 1260174793, 185349978, 349077340, 1733615803));
        Integer from_node = 1;
        Integer to_node = 6;

        ArrayList<Integer> result = find_longest_path(dag_nodes, dag_from, dag_to, dag_weight, from_node, to_node);

        int a = 4;
    }

    static class Point{
        int source;
        int dest;
        int weight;


        public Point(int source, int dest) {
            this.source = source;
            this.dest = dest;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return source == point.source && dest == point.dest;
        }

        @Override
        public int hashCode() {
            return Objects.hash(source, dest);
        }
    }

    static ArrayList<Integer> find_longest_path(Integer dag_nodes, ArrayList<Integer> dag_from,
                                                ArrayList<Integer> dag_to, ArrayList<Integer> dag_weight,
                                                Integer from_node, Integer to_node) {
        result = new ArrayList<>();
        if(from_node == to_node){
            result.add(from_node);
            return result;
        }

        Map<Integer, ArrayList<Integer>> adjList = new HashMap<>();
        Map<Point, Integer> weightMap = new HashMap<>();

        for(int i = 1; i <= dag_nodes; i++ ){
            adjList.put(i, new ArrayList<>());
        }

        for(int i = 0; i < dag_to.size(); i++){

            int source = dag_from.get(i);
            int dest = dag_to.get(i);
            int weight = dag_weight.get(i);

            ArrayList<Integer> neighbors = adjList.get(source);
            neighbors.add(dest);

            weightMap.put(new Point(source, dest), weight);
        }

        maxWeight = 0L;

        Set<Integer> visited = new HashSet<>();
        dfs(from_node, new ArrayList<>(), adjList, weightMap, visited,0L, to_node);

        return result;
    }

    static Long maxWeight;
    static ArrayList<Integer> result;
    public static void dfs(int currVertex, ArrayList<Integer> currPath, Map<Integer, ArrayList<Integer>> adjMap,
                          Map<Point, Integer> weightMap,
                           Set<Integer> visited, Long currWeight, int to_node){

        if(visited.contains(currVertex)){
            return;
        }

        visited.add(currVertex);
        currPath.add(currVertex);
        ArrayList<Integer> neighbors = adjMap.get(currVertex);
        for(int i = 0; i < neighbors.size(); i++){
            int neighbor = neighbors.get(i);
            int weight = weightMap.get(new Point(currVertex, neighbor));
            Long prevWeight = currWeight;
            currWeight = currWeight + weight;
            dfs(neighbor, currPath, adjMap, weightMap, visited, currWeight, to_node);
            currWeight = prevWeight;
        }

        if(currVertex == to_node && maxWeight < currWeight){
            maxWeight = currWeight;
            result = new ArrayList<>(currPath);
        }
        currPath.remove(currPath.size() - 1);
        visited.remove(currVertex);
    }

}
