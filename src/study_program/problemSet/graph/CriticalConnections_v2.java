package study_program.problemSet.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CriticalConnections_v2 {
    public static void main(String[] args) {
        Integer number_of_servers = 5;
        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(0, 1));
        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(0, 2));
        ArrayList<Integer> arr3 = new ArrayList<>(Arrays.asList(0, 4));
        ArrayList<Integer> arr4 = new ArrayList<>(Arrays.asList(1, 2));
        ArrayList<Integer> arr5 = new ArrayList<>(Arrays.asList(1, 3));

        ArrayList<ArrayList<Integer>> connections = new ArrayList<>();
        connections.add(arr1);
        connections.add(arr2);
        connections.add(arr3);
        connections.add(arr4);
        connections.add(arr5);

//        Integer number_of_servers = 5;
//        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(0, 4));
//        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(0, 1));
//        ArrayList<Integer> arr3 = new ArrayList<>(Arrays.asList(1, 4));
//        ArrayList<Integer> arr4 = new ArrayList<>(Arrays.asList(1, 2));
//        ArrayList<Integer> arr5 = new ArrayList<>(Arrays.asList(2, 3));
//
//        ArrayList<ArrayList<Integer>> connections = new ArrayList<>();
//        connections.add(arr1);
//        connections.add(arr2);
//        connections.add(arr3);
//        connections.add(arr4);
//        connections.add(arr5);

//        Integer number_of_servers = 4;
//        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(0, 1));
//        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(0, 2));
//        ArrayList<Integer> arr3 = new ArrayList<>(Arrays.asList(0, 3));
//        ArrayList<Integer> arr4 = new ArrayList<>(Arrays.asList(1, 2));
//        ArrayList<Integer> arr5 = new ArrayList<>(Arrays.asList(2, 3));
//
//        ArrayList<ArrayList<Integer>> connections = new ArrayList<>();
//        connections.add(arr1);
//        connections.add(arr2);
//        connections.add(arr3);
//        connections.add(arr4);
//        connections.add(arr5);

        ArrayList<ArrayList<Integer>> result = find_critical_connections(number_of_servers, connections);

        int a;
    }

    /*
     * Asymptotic complexity in terms of the number of servers (= `n`) and the size of `connections` array (= `m`):
     * Time: O(n + m).
     * Auxiliary space: O(n + m).
     * Total space: O(n + m).
     */

    static ArrayList<ArrayList<Integer>> adj_list;

    // discovery_time --> Stores discovery times of visited vertices
    // lowest_time --> For any vertex v, lowest_time[v] stores the discovery time of the earliest discovered vertex
    // to which v or any of the vertices in the subtree rooted at v is having a back edge.
    static ArrayList<Integer> discovery_time, lowest_time;
    static ArrayList<Boolean> visited;
    static int timer;

    static void dfs(int vertex, int parent, ArrayList<ArrayList<Integer>> criticalConnections) {
        visited.set(vertex, true);

        // Set discovery time and initialize lowest time.
        lowest_time.set(vertex, ++timer);
        discovery_time.set(vertex, timer);

        for (int neighbor : adj_list.get(vertex)) {
            // Low time should never be updated for edge connecting a node to its parent.
            if (neighbor == parent) {
                continue;
            }

            // Indicates presence of a back edge.
            if (visited.get(neighbor)) {
                lowest_time.set(vertex, Math.min(lowest_time.get(vertex), discovery_time.get(neighbor)));
            } else {
                dfs(neighbor, vertex, criticalConnections);

                // Check if the edge is a bridge.
                if(discovery_time.get(vertex) < lowest_time.get(neighbor)) {
                    criticalConnections.add(new ArrayList<Integer>((Arrays.asList(neighbor, vertex))));
                }
                // Update the lowest_time of vertex in accordance with the existing back edges
                // from all such descendants which have neighbor on the path from vertex to itself(the descendant)
                // in the DFS tree.
                lowest_time.set(vertex, Math.min(lowest_time.get(neighbor), lowest_time.get(vertex)));
            }
        }
    }

    static ArrayList<ArrayList<Integer>> find_critical_connections(int number_of_servers, ArrayList<ArrayList<Integer>> connections) {
        ArrayList<ArrayList<Integer>> critical_connections = new ArrayList<>();

        adj_list = new ArrayList<>();
        for (int i = 0; i < number_of_servers; i++) {
            adj_list.add(new ArrayList<>());
        }

        // Creating adjacency list representation.
        for (int i = 0; i < connections.size(); i++) {
            int server1 = connections.get(i).get(0);
            int server2 = connections.get(i).get(1);
            adj_list.get(server1).add(server2);
            adj_list.get(server2).add(server1);
        }

        discovery_time = new ArrayList<>(Collections.nCopies(number_of_servers, 0));
        lowest_time = new ArrayList<>(Collections.nCopies(number_of_servers, 0));
        visited = new ArrayList<>(Collections.nCopies(number_of_servers, false));

        timer = 0;

        // Introducing a hypothetical parent -1 for node 0.
        dfs(0, -1, critical_connections);

        if(critical_connections.size() == 0) {
            critical_connections.add(new ArrayList<>((Arrays.asList(-1, -1))));
        }

        return critical_connections;
    }

}
