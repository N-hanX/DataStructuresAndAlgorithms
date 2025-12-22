package study_lc.trees;

import study_lc.TreeNode;

public class lc_108 {

    public static void main(String[] args) {
        int[] arr = new int[]{-10, -3, 0, 5, 9};
        lc_108 l = new lc_108();
        TreeNode t = l.convertSortedArr2BST(arr);
        int a = 5;
    }

    public TreeNode convertSortedArr2BST(int[] arr){
        return helper(arr, 0, arr.length - 1);
    }

    public TreeNode helper(int[] arr, int startInd, int endInd){
        if(startInd > endInd){
            return null;
        }

        int midInd = (startInd + endInd) / 2;
        TreeNode node = new TreeNode(arr[midInd]);

        node.left = helper(arr, startInd, midInd - 1);
        node.right = helper(arr,midInd + 1, endInd);
        return node;
    }
}
