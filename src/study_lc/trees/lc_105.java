package study_lc.trees;

import study_lc.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class lc_105 {


    public static void main(String[] args) {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};

        Map<Integer, Integer> inOrderHashMap;
        inOrderHashMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < inorder.length; i++){
            inOrderHashMap.put(inorder[i], i);
        }

        lc_105 l = new lc_105();
        TreeNode root = l.makeTree(preorder, 0, preorder.length - 1, inorder, 0,
                inorder.length - 1, inOrderHashMap);
        int a = 5;
    }

    public TreeNode makeTree(int[] preOrder, int preOrder_start, int preOrder_end,
                             int[] inOrder, int inOrder_start, int inOrder_end, Map<Integer, Integer> inOrderHashMap){

        if(preOrder_start > preOrder_end){
            return null;
        }

        TreeNode node = new TreeNode(preOrder[preOrder_start]);
        int inorderIndexOfThisNode = inOrderHashMap.get(preOrder[preOrder_start]);
        int count =  inorderIndexOfThisNode - inOrder_start;
        node.left = makeTree(preOrder, preOrder_start + 1,
                preOrder_start + count, inOrder, inOrder_start,
                inOrder_start + count - 1, inOrderHashMap);

        node.right = makeTree(preOrder, preOrder_start + count + 1, preOrder_end,
                inOrder, inorderIndexOfThisNode + 1, inOrder_end, inOrderHashMap);

        return node;
    }
}
