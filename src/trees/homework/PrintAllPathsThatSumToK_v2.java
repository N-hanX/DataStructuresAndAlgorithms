package trees.homework;

import java.util.ArrayList;
import java.util.Arrays;

public class PrintAllPathsThatSumToK_v2 {

    public static void main(String[] args) {
        BinaryTreeNode node1 = new BinaryTreeNode(10);
        BinaryTreeNode node2 = new BinaryTreeNode(25);
        BinaryTreeNode node3 = new BinaryTreeNode(45);
        BinaryTreeNode node4 = new BinaryTreeNode(30);
        BinaryTreeNode node5 = new BinaryTreeNode(40);
        BinaryTreeNode node6 = new BinaryTreeNode(50);

        node1.left = node2;
        node2.left = node3;
        node1.right = node4;
        node4.left = node5;
        node4.right = node6;

        int sum = 80;

        ArrayList<ArrayList<Integer>> result = all_paths_sum_k(node1, sum);

        int a = 5;

    }

    static ArrayList<ArrayList<Integer>> all_paths_sum_k(BinaryTreeNode root, Integer k) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> currPath = new ArrayList<>();

        currSum = 0;
        all_paths_sum_k(root, k, currPath, result);

        if(result.isEmpty()){
            result.add(new ArrayList<>(Arrays.asList(-1)));
        }

        return result;
    }

    static int currSum;
    static void all_paths_sum_k(BinaryTreeNode root, Integer k,
                                                         ArrayList<Integer> currPath,
                                                         ArrayList<ArrayList<Integer>> result) {
        if(root != null){
            currPath.add(root.value);
            currSum = currSum + root.value;
        }
        if(root == null)
            return;

        if(root.left == null && root.right == null){
            if(currSum == k){
                result.add(new ArrayList<>(currPath));
                currPath.remove(currPath.size() - 1);
                currSum = currSum - root.value;
                return;
            }
            currPath.remove(currPath.size() - 1);
            currSum = currSum - root.value;
            return;
        }

        all_paths_sum_k(root.left, k, currPath, result);
        all_paths_sum_k(root.right, k, currPath, result);

        currPath.remove(currPath.size() - 1);
        currSum = currSum - root.value;
    }
}
