package trees.homework;

import java.util.ArrayList;

public class binarySearchTreeFromPreorderTraversal {

    public static void main(String[] args) {
        ArrayList<Integer> currList = new ArrayList();
        currList.add(0);
        currList.add(-100);
        currList.add(-90);
        currList.add(70);
        currList.add(20);
        currList.add(10);
        currList.add(100);
        currList.add(80);



        int leftIndex = 0;
        int rightIndex = currList.size() - 1;
        TreeNode root = helper(leftIndex, rightIndex, currList);
        int a = 5;
//        return root;
    }

    public static TreeNode helper(int leftIndex, int rightIndex, ArrayList<Integer> list){
        if(leftIndex > rightIndex){
            return null;
        }

        // define the current Node
        TreeNode newNode = new TreeNode();
        newNode.label = list.get(leftIndex);

        // found the rightIndex
        int theNewRightIndex = -1;
        for(int i = leftIndex + 1; i <= rightIndex; i++){
            if(list.get(i) > newNode.label){
                theNewRightIndex = i;
                break;
            }
        }

        //
        if(theNewRightIndex == -1){// hepsi o node'dan kucuk
            newNode.left_ptr = helper(leftIndex + 1, rightIndex, list  );
            return newNode;
        }

        //  su anki node'dan kucuk olan her node node'un solunda kalacak.
        newNode.left_ptr = helper(leftIndex + 1, theNewRightIndex - 1, list );

        //  su anki node'dan buyuk olan her node node'un solunda kalacak.
        newNode.right_ptr = helper(theNewRightIndex, rightIndex, list);

        return newNode;
    }


    public static class TreeNode{
        public int label;
        public TreeNode left_ptr;
        public TreeNode right_ptr;
    }


}
