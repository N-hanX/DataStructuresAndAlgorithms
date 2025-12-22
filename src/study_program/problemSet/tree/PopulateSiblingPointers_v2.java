package study_program.problemSet.tree;

import java.util.LinkedList;
import java.util.Queue;

public class PopulateSiblingPointers_v2 {
    public static void main(String[] args) {
        BinaryTreeNode node1 = new BinaryTreeNode(100);
        BinaryTreeNode node2 = new BinaryTreeNode(200);
        BinaryTreeNode node3 = new BinaryTreeNode(400);
        BinaryTreeNode node4 = new BinaryTreeNode(500);
        BinaryTreeNode node5 = new BinaryTreeNode(300);
        BinaryTreeNode node6 = new BinaryTreeNode(600);
        BinaryTreeNode node7 = new BinaryTreeNode(700);

        node1.left = node2;
        node2.left = node3;
        node2.right = node4;
        node1.right = node5;
        node5.left = node6;
        node5.right = node7;

        BinaryTreeNode result = populate_sibling_pointers(node1);

        int a = 4;
    }

    static BinaryTreeNode populate_sibling_pointers(BinaryTreeNode root) {
        if(root == null)
            return null;

        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        queue.add(root);

        while(!queue.isEmpty()){
            BinaryTreeNode prev = null;

            // Number of nodes on the current level.
            int size = queue.size();

            for(int i = 0; i < size; i++){
                BinaryTreeNode currNode = queue.poll();

                if(prev != null){
                    // If this is not the first node in this level,
                    // make it next_right node of the previous one.
                    prev.next_right = currNode;
                }

                if(currNode.left != null){
                    queue.add(currNode.left);
                }

                if(currNode.right != null){
                    queue.add(currNode.right);
                }

                prev = currNode;
            }
        }
        return root;
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
