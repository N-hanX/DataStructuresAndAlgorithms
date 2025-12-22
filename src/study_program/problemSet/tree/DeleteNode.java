package study_program.problemSet.tree;

import java.util.ArrayList;

public class DeleteNode {
    public static void main(String[] args) {
        BinaryTreeNode node44 = new BinaryTreeNode(44);
        BinaryTreeNode node17 = new BinaryTreeNode(17);
        BinaryTreeNode node8 = new BinaryTreeNode(8);
        BinaryTreeNode node32 = new BinaryTreeNode(32);
        BinaryTreeNode node28 = new BinaryTreeNode(28);
        BinaryTreeNode node29 = new BinaryTreeNode(29);

        BinaryTreeNode node88 = new BinaryTreeNode(88);
        BinaryTreeNode node65 = new BinaryTreeNode(65);
        BinaryTreeNode node54 = new BinaryTreeNode(54);
        BinaryTreeNode node82 = new BinaryTreeNode(82);
        BinaryTreeNode node76 = new BinaryTreeNode(76);

        BinaryTreeNode node80 = new BinaryTreeNode(80);
        BinaryTreeNode node97 = new BinaryTreeNode(97);
        BinaryTreeNode node93 = new BinaryTreeNode(93);

        node44.left = node17;
        node17.left = node8;
        node17.right = node32;
        node32.left = node28;
        node28.right = node29;

        node44.right = node88;
        node88.left = node65;
        node65.left = node54;
        node65.right = node82;

        node82.left = node76;
        node76.right = node80;

        node88.right = node97;
        node97.left = node93;

//        BinaryTreeNode result1 = deleteNode(node44, node8);
//        BinaryTreeNode result2 = deleteNode(node44, node32);
//        BinaryTreeNode result3 = deleteNode(node44, node65);
        BinaryTreeNode result3 = deleteNode(node44, node17);

        int a = 4;
    }

    public static BinaryTreeNode deleteNode(BinaryTreeNode root, BinaryTreeNode key){
        BinaryTreeNode curr = root;
        BinaryTreeNode prev = null;

        while(curr != key){
            if(curr.value < key.value){
                prev = curr;
                curr = curr.right;
            }else if(curr.value > key.value){
                prev = curr;
                curr = curr.left;
            }
        }

        if(key.left == null && key.right == null){
            deleteLeafNode(prev, key);
        }else if(key.left != null && key.right != null) {
            deleteNodeWithTwoKid(prev, key);
        }else if(key.left != null || key.right != null) {
            deleteNodeWithOneKid(prev, key);
        }
        return root;
    }

    public static void deleteLeafNode(BinaryTreeNode prev, BinaryTreeNode key){
        if(prev.left == key){
            prev.left = null;
        }

        if(prev.right == key){
            prev.right = null;
        }
    }

    public static void deleteNodeWithOneKid(BinaryTreeNode prev, BinaryTreeNode key){
        if(prev.left == key){
            if(key.left != null){
                prev.left = key.left;
            }else{
                prev.left = key.right;
            }
        }
        if(prev.right == key){
            if(key.left != null){
                prev.right = key.left;
            }else{
                prev.right = key.right;
            }
        }
    }

    public static void deleteNodeWithTwoKid(BinaryTreeNode prev, BinaryTreeNode key){
        ArrayList<BinaryTreeNode> result = getSuccessor(key);

        BinaryTreeNode successor = result.get(0);
        BinaryTreeNode successor_prev = result.get(1);

        BinaryTreeNode successor_right_kid = successor.right;
        BinaryTreeNode successor_left_kid = successor.left;

        if(prev.left == key){
            prev.left = successor;
        }else{
            prev.right = successor;
        }
        BinaryTreeNode left_child = key.left;
        BinaryTreeNode right_child = key.right;
        successor.left = left_child;
        successor.right = right_child;

        if(successor_left_kid != null || successor_right_kid != null){
            if(successor_left_kid != null){
                successor_prev.left = successor_left_kid;
            }else{
                successor_prev.left = successor_right_kid;
            }
        }
    }

    public static ArrayList<BinaryTreeNode> getSuccessor(BinaryTreeNode key){
        BinaryTreeNode curr = key;
        BinaryTreeNode prev = key;

        curr = curr.right;
        while(curr.left != null){
            prev = curr;
            curr = curr.left;
        }

        ArrayList<BinaryTreeNode> result = new ArrayList<>();
        result.add(curr);
        result.add(prev);

        return result;
    }
}
