package study_program.problemSet.tree;

import java.util.ArrayList;

public class PopulateSiblingPointers {
    public static void main(String[] args) {
//        BinaryTreeNode node1 = new BinaryTreeNode(100);
//        BinaryTreeNode node2 = new BinaryTreeNode(200);
//        BinaryTreeNode node3 = new BinaryTreeNode(400);
//        BinaryTreeNode node4 = new BinaryTreeNode(500);
//        BinaryTreeNode node5 = new BinaryTreeNode(300);
//        BinaryTreeNode node6 = new BinaryTreeNode(600);
//        BinaryTreeNode node7 = new BinaryTreeNode(700);
//
//        node1.left = node2;
//        node2.left = node3;
//        node2.right = node4;
//        node1.right = node5;
//        node5.left = node6;
//        node5.right = node7;

        BinaryTreeNode node1 = new BinaryTreeNode(0);
        BinaryTreeNode node2 = new BinaryTreeNode(1);
        BinaryTreeNode node3 = new BinaryTreeNode(2);
        BinaryTreeNode node4 = new BinaryTreeNode(3);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node6 = new BinaryTreeNode(6);
        BinaryTreeNode node7 = new BinaryTreeNode(7);
        BinaryTreeNode node8 = new BinaryTreeNode(4);

        node1.left = node2;
        node2.left = node4;
        node4.right = node8;
        node1.right = node3;
        node3.left = node5;
        node3.right = node6;
        node6.right = node7;

        BinaryTreeNode result = populate_sibling_pointers(node1);

        int a = 4;
    }

    static BinaryTreeNode populate_sibling_pointers(BinaryTreeNode root) {
        ArrayList<ArrayList<BinaryTreeNode>> result = new ArrayList<>();

        helper(root, 0, result);
        arrangeNextLevel(result);

        return root;
    }

    static void arrangeNextLevel(ArrayList<ArrayList<BinaryTreeNode>> result){
        for(int i = 0; i < result.size(); i++){
            ArrayList<BinaryTreeNode> currLevelNodes = result.get(i);

            int j = 0;
            while( j < currLevelNodes.size()){
                BinaryTreeNode currNode = currLevelNodes.get(j);
                if(currNode == null) {
                    j++;
                    continue;
                }

                BinaryTreeNode nextNode = null;
                if(j + 1 == currLevelNodes.size()) {
                    j++;
                    continue;
                }
                if(j + 1 != currLevelNodes.size()){
                    nextNode = currLevelNodes.get(j + 1);
                    currNode.next_right = nextNode;
                    j++;
                    continue;
                }
            }
        }
    }

    static void helper(BinaryTreeNode root, int level, ArrayList<ArrayList<BinaryTreeNode>> result){
        if(root == null)
            return;

        if(result.size() != level){
            ArrayList<BinaryTreeNode> currLevel = result.get(level);
            currLevel.add(root);
        }else{
            ArrayList<BinaryTreeNode> newLevel = new ArrayList<>();
            result.add(newLevel);
            newLevel.add(root);
        }

        helper(root.left, level + 1, result);
        helper(root.right, level + 1, result);
    }

    static class BinaryTreeNode {
        Integer value;
        BinaryTreeNode left;
        BinaryTreeNode right;
        BinaryTreeNode next_right;

        BinaryTreeNode(Integer value) {
            this.value = value;
            this.left = null;
            this.right = null;
            this.next_right = null;
        }
    }
}
