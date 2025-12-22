package study_program.problemSet.tree;

import java.util.ArrayList;
import java.util.Arrays;

public class PostOrderExample {
    public static void main(String[] args) {
        BinaryTreeNode node1 = new BinaryTreeNode("/usr/user1", 0);

        BinaryTreeNode node2 = new BinaryTreeNode("images/", 0);
        BinaryTreeNode node5 = new BinaryTreeNode("family/", 0);
        BinaryTreeNode node6 = new BinaryTreeNode("school/", 0);
        BinaryTreeNode node7 = new BinaryTreeNode("vacation/", 0);
        ArrayList<BinaryTreeNode> imagesChildren = new ArrayList<>(Arrays.asList(node5, node6, node7));
        node2.children = imagesChildren;

        BinaryTreeNode node3 = new BinaryTreeNode("files/", 0);
        BinaryTreeNode node8 = new BinaryTreeNode("lectures/", 0);
        BinaryTreeNode node9 = new BinaryTreeNode("thesis/", 0);
        BinaryTreeNode node10 = new BinaryTreeNode("internship/", 0);
        ArrayList<BinaryTreeNode> filesChildren = new ArrayList<>(Arrays.asList(node8, node9, node10));
        node3.children = filesChildren;

        BinaryTreeNode node4 = new BinaryTreeNode("notes/", 0);
        BinaryTreeNode node11 = new BinaryTreeNode("math/", 0);
        BinaryTreeNode node12 = new BinaryTreeNode("physics/", 0);
        BinaryTreeNode node13 = new BinaryTreeNode("phil/", 0);
        ArrayList<BinaryTreeNode> notesChildren = new ArrayList<>(Arrays.asList(node11, node12, node13));
        node4.children = notesChildren;

        ArrayList<BinaryTreeNode> mainChildren = new ArrayList<>(Arrays.asList(node2, node3, node4));
        node1.children = mainChildren;

        BinaryTreeNode node14 = new BinaryTreeNode("linear.pdf", 100);
        BinaryTreeNode node15 = new BinaryTreeNode("probability.pdf", 210);
        BinaryTreeNode node16 = new BinaryTreeNode("calculus.pdf", 120);
        ArrayList<BinaryTreeNode> mathChildren = new ArrayList<>(Arrays.asList(node14, node15, node16));
        node11.children = mathChildren;

        BinaryTreeNode node17 = new BinaryTreeNode("15oct2010.jpg", 700);
        BinaryTreeNode node18 = new BinaryTreeNode("15jan2009.jpg", 800);
        BinaryTreeNode node19 = new BinaryTreeNode("15jun2012.jpg", 680);
        ArrayList<BinaryTreeNode> familyPhotos = new ArrayList<>(Arrays.asList(node17, node18, node19));
        node5.children = familyPhotos;

        int totalSpace = getTotalSpace(node1);

        int a = 4;
    }

    public static int getTotalSpace(BinaryTreeNode root){
        int total = 0;

        if(root == null){
            return 0;
        }

        if(root.children == null)
            return root.space;


        for(int i = 0; i < root.children.size(); i++){
            total += getTotalSpace(root.children.get(i));
        }
        return total;
    }


    static class BinaryTreeNode {
        String fileName;
        int space;
        ArrayList<BinaryTreeNode> children;

        BinaryTreeNode(String fileName, int space) {
            this.fileName = fileName;
            this.space = space;
        }
    }
}
