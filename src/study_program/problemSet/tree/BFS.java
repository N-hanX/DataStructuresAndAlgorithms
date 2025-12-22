package study_program.problemSet.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
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

        BinaryTreeNode node68 = new BinaryTreeNode(68);

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

        node76.left = node68;

        printTree_BFS(node44);

        int a = 4;
    }

    public static void printTree_BFS(BinaryTreeNode root){
        Queue<BinaryTreeNode> queue = new LinkedList();
        queue.add(root);

        while(!queue.isEmpty()){
            BinaryTreeNode currNode = queue.poll();
            System.out.print(currNode.value + " ,");
            if(currNode.left != null)
                queue.add(currNode.left);

            if(currNode.right != null)
                queue.add(currNode.right);
        }
    }
}
