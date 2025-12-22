package study_program.problemSet.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MergeTwoBSTs2 {
    public static void main(String[] args) {
        BinaryTreeNode root1_5 = new BinaryTreeNode(5);
        BinaryTreeNode root1_3 = new BinaryTreeNode(3);
        BinaryTreeNode root1_2 = new BinaryTreeNode(2);
        BinaryTreeNode root1_4 = new BinaryTreeNode(4);
        BinaryTreeNode root1_6 = new BinaryTreeNode(6);
        BinaryTreeNode root1_7 = new BinaryTreeNode(7);

        BinaryTreeNode root2_8 = new BinaryTreeNode(8);
        BinaryTreeNode root2_1 = new BinaryTreeNode(1);
        BinaryTreeNode root2_9 = new BinaryTreeNode(9);

        root1_5.left = root1_3;
        root1_3.left = root1_2;
        root1_3.right = root1_4;

        root1_5.right = root1_6;;
        root1_6.right = root1_7;

        root2_8.left = root2_1;
        root2_8.right = root2_9;

        BinaryTreeNode new_root = merge_two_binary_search_trees(root1_5, root2_8);

        int a = 4;
    }

    static Map<BinaryTreeNode, Integer> heights = new HashMap<>();

    public static BinaryTreeNode rightRotate(BinaryTreeNode root){
        BinaryTreeNode newRoot = root.left;
        BinaryTreeNode temp = newRoot.right;

        newRoot.right = root;
        root.left = temp;

        heights.put(root, Math.max(heights.getOrDefault(root, 0),
                heights.getOrDefault(root, 0)) + 1 );

        heights.put(newRoot, Math.max(heights.getOrDefault(newRoot, 0),
                heights.getOrDefault(root, 0)) + 1);

        return newRoot;
    }

    public static BinaryTreeNode leftRotate(BinaryTreeNode root){
        BinaryTreeNode newRoot = root.right;
        BinaryTreeNode temp = newRoot.left;

        newRoot.left = root;
        root.right = temp;

        heights.put(root, Math.max(heights.getOrDefault(root, 0),
                heights.getOrDefault(root, 0)) + 1 );

        heights.put(newRoot, Math.max(heights.getOrDefault(newRoot, 0),
                heights.getOrDefault(root, 0)) + 1);

        return newRoot;
    }

    public static BinaryTreeNode insertInAVLTree(BinaryTreeNode root, BinaryTreeNode newNode){
        if(root == null){
            heights.put(newNode, 1);
            newNode.left = null;
            newNode.right = null;
            return newNode;
        }

        if(newNode.value < root.value){
            root.left = insertInAVLTree(root.left, newNode);
        }else{
            root.right = insertInAVLTree(root.right, newNode);
        }

        heights.put(root, 1 + Math.max(heights.getOrDefault(root.left, 0),
                heights.getOrDefault(root.right, 0)));

        int balanceFactor = heights.getOrDefault(root.left, 0) -
                heights.getOrDefault(root.right, 0);

        if(Math.abs(balanceFactor) <= 1){
            return root;
        }

        if(balanceFactor > 1 && newNode.value < root.left.value){
            return rightRotate(root);
        }

        if(balanceFactor > 1 && newNode.value >= root.left.value){
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        if(balanceFactor < -1 && newNode.value > root.right.value){
            return leftRotate(root);
        }

        if(balanceFactor < -1 && newNode.value <= root.right.value){
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        return root;
    }

    public static void getInorder(BinaryTreeNode root, List<BinaryTreeNode> inorder){
        if(root == null)
            return;

        getInorder(root.left, inorder);
        inorder.add(root);
        getInorder(root.right, inorder);
    }

    public static BinaryTreeNode merge_two_binary_search_trees(BinaryTreeNode root1, BinaryTreeNode root2) {
        List<BinaryTreeNode> nodeList1 = new ArrayList<>();
        List<BinaryTreeNode> nodeList2 = new ArrayList<>();

        getInorder(root1, nodeList1);
        getInorder(root2, nodeList2);

        BinaryTreeNode root = null;

        for(BinaryTreeNode node : nodeList1){
            root = insertInAVLTree(root, node);
        }

        for(BinaryTreeNode node : nodeList2){
            root = insertInAVLTree(root, node);
        }

        return root;
    }


}
