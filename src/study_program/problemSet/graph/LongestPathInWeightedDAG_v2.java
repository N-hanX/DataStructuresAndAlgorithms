package study_program.problemSet.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class LongestPathInWeightedDAG_v2 {
    public static void main(String[] args) {

        //        {
//            "dag_nodes": 4,
//                "dag_from": [1, 1, 1, 3],
//            "dag_to": [2, 3, 4, 4],
//            "dag_weight": [2, 2, 4, 3],
//            "from_node": 1,
//                "to_node": 4
//        }
        Integer dag_nodes = 4;
        ArrayList<Integer> dag_from = new ArrayList<>(Arrays.asList(1, 1, 1, 3));
        ArrayList<Integer> dag_to = new ArrayList<>(Arrays.asList(2, 3, 4, 4));
        ArrayList<Integer> dag_weight = new ArrayList<>(Arrays.asList(2, 2, 4, 3));
        Integer from_node = 1;
        Integer to_node = 4;


        ArrayList<Integer> result = find_longest_path(dag_nodes, dag_from, dag_to, dag_weight, from_node, to_node);

        int a = 4;

    }

    /*
     * Asymptotic complexity in terms of the number of nodes `n` and number of edges `m`:
     * Time: O(n + m).
     * Auxiliary space: O(n + m).
     * Total space: O(n + m).
     */

    static void dfs(int from, ArrayList<ArrayList<int[]>> node_wise_edges,
                    ArrayList<Integer> topological_order, ArrayList<Boolean> visited)
    {
        visited.set(from, true);

        for (int i = 0; i < node_wise_edges.get(from).size(); i++)
        {
            int to = node_wise_edges.get(from).get(i)[0];

            // If the node is not visited then visit it and do dfs from that node.
            if (visited.get(to) == false)
            {
                dfs(to, node_wise_edges, topological_order, visited);
            }
        }

        topological_order.add(from);
    }

    /*
    I will quickly try to summarize how topological main.sorting works. In topological main.sorting we try to
    order nodes such that, nodes reachable from any ith node comes after the ith node. Suppose we have
    only 2 nodes 1 and 2 and one edge 1 -> 2 then topological order will be [1 2] because 2 is
    reachable from node 1, hence it should come after 1. We can use dfs to find the topological order.
    In dfs we visit node then its children and then "come back" to that node "after" we have finished
    visiting all its reachable nodes. So when we have completed visiting all children nodes, then all
    children will have "already" finished visiting their children and will have pushed them self in
    topological order! So now if we add the current node then all its children will be already added!
    Try some examples and it will be more clear!
    */
    static ArrayList<Integer> topological_sort(int dag_nodes, ArrayList<ArrayList<int[]>> node_wise_edges)
    {
        ArrayList<Integer> topological_order = new ArrayList<>();

        // Keeps track of visited nodes.
        ArrayList<Boolean> visited = new ArrayList<>();
        for (int i = 0; i <= dag_nodes + 1; i++) {
            visited.add(false);
        }

        for (int i = 1; i <= dag_nodes; i++)
        {
            // If the node is not visited then visit it and do dfs from that node.
            if (visited.get(i) == false)
            {
                dfs(i, node_wise_edges, topological_order, visited);
            }
        }

        // We have added the nodes at the end of topological_order vector that will give nodes in reverse
        // order of topological order.
        Collections.reverse(topological_order);
        return topological_order;
    }

    static ArrayList<Integer> find_longest_path(Integer dag_nodes, ArrayList<Integer> dag_from, ArrayList<Integer> dag_to,
                                                ArrayList<Integer> dag_weight, Integer from_node, Integer to_node)
    {
        int dag_edges = dag_from.size();

        // Separate edges node-wise for quick access in future.
        ArrayList<ArrayList<int[]>> node_wise_edges = new ArrayList<>();

        for (int i = 0; i <= dag_nodes; i++) {
            node_wise_edges.add(new ArrayList<>());
        }

        for (int i = 0; i < dag_edges; i++)
        {
            node_wise_edges.get(dag_from.get(i)).add(new int[]{dag_to.get(i), dag_weight.get(i)});
        }

        // Find topological order of given dag.
        ArrayList<Integer> topological_order = topological_sort(dag_nodes, node_wise_edges);

        // Longest_path[i] contains longest path from from_node to ith node (found till now).
        ArrayList<Long> longest_path = new ArrayList<>(Collections.nCopies(dag_nodes + 1, -1L));

        // Parent[i] contains node through which Longest_path[i] updated last time. Suppose our final
        // answer is path (1 -> 5 -> 3) then Parent[3] will be 5. This is just to track the path. Using
        // this we will reconstruct the path.
        ArrayList<Integer> parent = new ArrayList<>(Collections.nCopies(dag_nodes + 1, 0));

        longest_path.set(from_node, 0L);

        // Iterate over each node in topological order and update nodes which are connected to the
        // current node.
        for (int i = 0; i < dag_nodes; i++)
        {
            int from = topological_order.get(i);

            // We initialized longest_path of node from_node as 0 and all other nodes as -1, hence
            // update will start only at from_node. If you are confused then better to try some examples
            // while understanding this code.
            if (longest_path.get(from) >= 0)
            {
                // "each edge" goes from upper level to lower level hence once we have found our
                // destination node, it will not get updated by any other node so we can stop updating
                // here. This is just an optimization, if we remove this if then also code will work
                // fine.
                if (from == to_node)
                {
                    break;
                }
                for (int j = 0; j < node_wise_edges.get(from).size(); j++)
                {
                    int to = node_wise_edges.get(from).get(j)[0];
                    long weight = node_wise_edges.get(from).get(j)[1];
                    // If longer path possible then update.
                    if (longest_path.get(to) <= longest_path.get(from) + weight)
                    {
                        longest_path.set(to, longest_path.get(from) + weight);
                        // Also keep track of node through which it gets updated.
                        parent.set(to, from);
                    }
                }
            }
        }

        // Find the path in reverse order! And then reverse it!
        ArrayList<Integer> path = new ArrayList<>();
        path.add(to_node);
        while (to_node != from_node)
        {
            to_node = parent.get(to_node);
            path.add(to_node);
        }
        // Till now we have found the path in reverse order.
        Collections.reverse(path);
        return path;
    }

}
