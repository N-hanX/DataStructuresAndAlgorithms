package study_program.problemSet.tree;

import java.util.ArrayList;

public class UpsideDown {
    public static void main(String[] args) {
        BinaryTreeNode node1 = new BinaryTreeNode(1);
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        BinaryTreeNode node3 = new BinaryTreeNode(3);

        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node6 = new BinaryTreeNode(6);
        BinaryTreeNode node7 = new BinaryTreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node4.left = node6;
        node4.right = node7;

        BinaryTreeNode new_root = flip_upside_down(node7);
        int a;
    }

    static BinaryTreeNode new_root;

    static BinaryTreeNode flip_upside_down(BinaryTreeNode root) {
        if(root == null){
            return null;
        }
        new_root = null;
        ArrayList<BinaryTreeNode> result = new ArrayList<>();
        traverse_and_update_nodes(root, null);

        return new_root;
    }

    static void traverse_and_update_nodes(BinaryTreeNode root, BinaryTreeNode parent) {
        if(root.left == null) {
            new_root = root;
            if(parent != null)
                new_root.left = parent.right;
            else
                new_root.left = null;
            new_root.right = parent;
            return;
        }

        traverse_and_update_nodes(root.left, root);
        root.right = parent;
        if(parent != null)
            root.left = parent.right;
        else
            root.left = null;
    }
}
