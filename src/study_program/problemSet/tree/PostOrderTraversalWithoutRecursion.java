package study_program.problemSet.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class PostOrderTraversalWithoutRecursion {
    public static void main(String[] args) {
        BinaryTreeNode node100 = new BinaryTreeNode(100);
        BinaryTreeNode node200 = new BinaryTreeNode(200);
        BinaryTreeNode node400 = new BinaryTreeNode(400);
        BinaryTreeNode node500 = new BinaryTreeNode(500);
        BinaryTreeNode node300 = new BinaryTreeNode(300);

        node100.left = node200;
        node100.right = node300;
        node200.left = node400;
        node200.right = node500;

        postorder_traversal(node100);

        int a;
    }

    static ArrayList<Integer> postorder_traversal(BinaryTreeNode root) {
        if(root == null)
            return null;

        ArrayList<Integer> result = new ArrayList<>();
        Stack<BinaryTreeNode> treeStack = new Stack<>();
        treeStack.add(root);

        while(!treeStack.isEmpty()){
            BinaryTreeNode currTopNode = treeStack.peek();

            if(currTopNode.left != null){
                treeStack.add(currTopNode.left);
                currTopNode.left = null;
            }else if(currTopNode.right != null){
                treeStack.add(currTopNode.right);
                currTopNode.right = null;
            }else{
                treeStack.pop();
                result.add(currTopNode.value);
            }
        }


        return result;
    }

    static ArrayList<Integer> postorder_traversal_v2(BinaryTreeNode root) {
        if(root == null)
            return null;

        ArrayList<Integer> result = new ArrayList<>();
        Set<BinaryTreeNode> visited = new HashSet<>();

        Stack<BinaryTreeNode> treeStack = new Stack<>();
        treeStack.add(root);
        visited.add(root);

        while(!treeStack.isEmpty()){
            BinaryTreeNode theTopNode = treeStack.peek();
            if(theTopNode.left == null && theTopNode.right == null){
                theTopNode = treeStack.pop();
                result.add(theTopNode.value);
            }else{
                if(theTopNode.left != null && !visited.contains(theTopNode.left)) {
                    treeStack.add(theTopNode.left);
                    visited.add(theTopNode.left);
                }else if (theTopNode.right != null && !visited.contains(theTopNode.right)) {
                    treeStack.add(theTopNode.right);
                    visited.add(theTopNode.right);
                }else{
                    theTopNode = treeStack.pop();
                    result.add(theTopNode.value);
                }
            }
        }

        return result;
    }
}
