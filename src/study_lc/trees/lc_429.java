package study_lc.trees;

import java.util.*;

public class lc_429 {
    public static void main(String[] args) {
        Node t1 = new Node(1);
        Node t2 = new Node(3);
        Node t3 = new Node(2);
        Node t4 = new Node(4);
        Node t5 = new Node(5);
        Node t6 = new Node(6);

        List<Node> t1_children = new ArrayList<>();
        t1_children.add(t2);
        t1_children.add(t3);
        t1_children.add(t4);
        t1.children = t1_children;

        List<Node> t2_children = new ArrayList<Node>();
        t2_children.add(t5);
        t2_children.add(t6);
        t2.children = t2_children;

        List<List<Integer>> result = n_ary_tree_level_order_traversal(t1);
        int a = 5;
    }

    public static List<List<Integer>> n_ary_tree_level_order_traversal(Node root){
        // we should keep every nodes in every level

        // first we should get the root

        // then we should get its children

        // then we should get root's children children

        // when we are doing this we need to use queue to process every node respectively
        // and get their children to the end of the queue
        // after process each node of n'th level, we should put them into the n'th list of every list

        Queue<Node> nQueue = new LinkedList<>();

        nQueue.add(root);
        List<List<Integer>> result = new ArrayList<>();

        while(!nQueue.isEmpty()){

            int the_curr_size_of_nth_level = nQueue.size();

            List<Integer> currList = new ArrayList<>();

            for(int i = 0; i < the_curr_size_of_nth_level; i++){
                Node node = nQueue.remove();
                currList.add(node.val);

                if(node.children != null){
                    for(int j = 0; j < node.children.size(); j++){
                        nQueue.add(node.children.get(j));
                    }
                }
            }
            result.add(currList);
        }
        return result;
    }
}
