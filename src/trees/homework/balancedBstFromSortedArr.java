package trees.homework;

import com.sun.source.tree.Tree;

public class balancedBstFromSortedArr {

    public static void main(String[] args) {
        int[] arr = { 8, 10, 12, 15, 16, 20, 25};

        TreeNode tree = helper(arr, 0, arr.length);
//        return tree;
        int a = 5;
    }

    public static TreeNode helper (int[] arr, int startInd, int endInd){
        if(startInd >= endInd  ){
            return null;
        }

        int middleInd = (startInd + endInd)/2;
        TreeNode currNode = new TreeNode(arr[middleInd]);

        currNode.left_ptr = helper(arr, startInd , middleInd);
        currNode.right_ptr = helper(arr, middleInd + 1, endInd);

        return currNode;
    }
    static class TreeNode
    {
        int val;
        TreeNode left_ptr;
        TreeNode right_ptr;

        TreeNode(int _val)
        {
            val = _val;
            left_ptr = null;
            right_ptr = null;
        }
    }

}
