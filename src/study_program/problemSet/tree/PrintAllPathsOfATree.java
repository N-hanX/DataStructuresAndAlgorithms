package study_program.problemSet.tree;

import java.util.ArrayList;

public class PrintAllPathsOfATree {
    public static void main(String[] args) {
        BinaryTreeNode node_1 = new BinaryTreeNode(1);
        BinaryTreeNode node_2 = new BinaryTreeNode(2);
        BinaryTreeNode node_3 = new BinaryTreeNode(3);
        BinaryTreeNode node_4 = new BinaryTreeNode(4);
        BinaryTreeNode node_5 = new BinaryTreeNode(5);
        BinaryTreeNode node_6 = new BinaryTreeNode(6);
        BinaryTreeNode node_7 = new BinaryTreeNode(7);

        node_1.left = node_2;
        node_1.right = node_3;
        node_2.left = node_4;
        node_2.right = node_5;
        node_3.left = node_6;
        node_3.right = node_7;

        BinaryTreeNode node = null;

        ArrayList<ArrayList<Integer>> result = all_paths_of_a_binary_tree(node);

        int a = 5;
    }

    static ArrayList<ArrayList<Integer>> all_paths_of_a_binary_tree(BinaryTreeNode root) {
        if(root == null)
            return null;

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        printPath(root, new ArrayList<>(), result);

        return result;
    }

    static void printPath(BinaryTreeNode root, ArrayList<Integer> currList, ArrayList<ArrayList<Integer>> result){
        if(root == null)
            return;

        if(root.left == null && root.right == null){
            currList.add(root.value);
            ArrayList<Integer> newResult = new ArrayList<>(currList);
            result.add(newResult);
            currList.remove(currList.size() - 1);
            return;
        }

        currList.add(root.value);
        printPath(root.left, currList, result);
        printPath(root.right, currList, result);
        currList.remove(currList.size() - 1);
    }
}
