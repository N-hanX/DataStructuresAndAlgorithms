package study_lc.study4_m;

import java.util.ArrayList;

public class BinaryTreeVerticalOrderTraversal_314 {
    public static void main(String[] args) {
//        Node node_3 = new Node(3);
//        Node node_9 = new Node(9);
//        Node node_20 = new Node(20);
//        Node node_15 = new Node(15);
//        Node node_7 = new Node(7);
//
//        node_3.left = node_9;
//        node_3.right = node_20;
//        node_20.left = node_15;
//        node_20.right = node_7;

//        Node node_3 = new Node(3);
//        Node node_9 = new Node(9);
//        Node node_4 = new Node(4);
//        Node node_0 = new Node(0);
//        Node node_8 = new Node(8);
//        Node node_1 = new Node(1);
//        Node node_7 = new Node(7);
//
//        node_3.left = node_9;
//        node_3.right = node_8;
//        node_9.left = node_4;
//        node_9.right = node_0;
//        node_8.left = node_1;
//        node_8.right = node_7;

        Node node_3 = new Node(3);
        Node node_9 = new Node(9);
        Node node_4 = new Node(4);
        Node node_0 = new Node(0);
        Node node_8 = new Node(8);
        Node node_1 = new Node(1);
        Node node_7 = new Node(7);
        Node node_5 = new Node(5);
        Node node_2 = new Node(2);

        node_3.left = node_9;
        node_3.right = node_8;
        node_9.left = node_4;
        node_9.right = node_0;
        node_8.left = node_1;
        node_8.right = node_7;

        node_0.left = node_5;
        node_1.right = node_2;

        ArrayList<ArrayList<Integer>> result = findVerticalOrder(node_3);
        int a = 3;
    }

    static int min_level;
    static int max_level;
    static ArrayList<ArrayList<Integer>> result;

    public static ArrayList<ArrayList<Integer>> findVerticalOrder(Node curr_node){
        min_level = 0;
        max_level = 0;
        result = new ArrayList<>();
        find_level_range(0, curr_node);
        for(int i = min_level; i <= max_level; i++){
            result.add(new ArrayList<>());
        }
        traverseTree(0, curr_node);

        ArrayList<ArrayList<Integer>> nonEmptyResult = new ArrayList<>();
        for(int i = 0; i < result.size(); i++){
            ArrayList<Integer> currList = result.get(i);
            if(!currList.isEmpty()){
                nonEmptyResult.add(currList);
            }
        }

        return nonEmptyResult;
    }

    public static void find_level_range(int currLevel, Node curr_node){
        if(curr_node == null)
            return;

        find_level_range(currLevel - 1, curr_node.left);
        if(min_level > currLevel){
            min_level = currLevel;
        }
        if(max_level < currLevel){
            max_level = currLevel;
        }
        find_level_range(currLevel + 1, curr_node.right);
    }

    public static void traverseTree(int currLevel, Node curr_node){
        if(curr_node == null)
            return;

        ArrayList<Integer> list = result.get(currLevel + min_level * -1);
        list.add(curr_node.val);
        traverseTree(currLevel - 1, curr_node.left);
        traverseTree(currLevel + 1, curr_node.right);
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node(int val){
            this.val = val;
        }
    }
}
