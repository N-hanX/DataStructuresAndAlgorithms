package trees.homework;

import java.util.ArrayList;
import java.util.Arrays;

public class ConstructBinarySearchTreeFromItsPreorderTraversal_v2 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(10, 9, 8, 7, 6, 5, 2, 3, 4 ));

        BinaryTreeNode node = build_binary_search_tree(list);

        int a =5;
    }

    static BinaryTreeNode build_binary_search_tree(ArrayList<Integer> preorder) {
        return build_binary_search_tree(preorder, 0, preorder.size());
    }

    static BinaryTreeNode build_binary_search_tree(ArrayList<Integer> preorder, int currInd, int endInd){

        if(currInd >= preorder.size()){
            return null;
        }

        int currRootValue = preorder.get(currInd);
        BinaryTreeNode node = new BinaryTreeNode(currRootValue);

        int leftChildStart = currInd + 1;

        // search left child if available
        BinaryTreeNode leftNode = null;
        BinaryTreeNode rightNode = null;


        if(leftChildStart < endInd && preorder.get(leftChildStart) > currRootValue){
            leftChildStart = currInd;
        }

        int rightChildStart = currInd + 1;

        if(  endInd == preorder.size() && preorder.get(currInd) > preorder.get(endInd - 1)){
            rightChildStart = preorder.size();
        }else{
            while(  rightChildStart < endInd && preorder.get(currInd) > preorder.get(rightChildStart)){
                rightChildStart++;
            }
        }

        if(leftChildStart == currInd)
            node.left = null;
        else if(leftChildStart < endInd && leftChildStart < rightChildStart)
            node.left = build_binary_search_tree(preorder, leftChildStart, rightChildStart);
        else
            node.left = null;

        if(rightChildStart == endInd || rightChildStart == preorder.size())
            node.right = null;
        else
            node.right = build_binary_search_tree(preorder, rightChildStart, endInd);


        return node;
    }

}

