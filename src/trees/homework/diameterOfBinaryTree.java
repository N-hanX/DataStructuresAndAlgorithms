package trees.homework;

public class diameterOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.label = 2;

        TreeNode currentRoot = root;
        currentRoot.left_ptr = new TreeNode();
        currentRoot.left_ptr.label = 5;

        TreeNode currentRightRoot = root;
        currentRightRoot.right_ptr = new TreeNode();
        currentRightRoot.right_ptr.label = 4;

        TreeNode currentLeftLeftNode = currentRoot.left_ptr;
        currentLeftLeftNode.left_ptr = new TreeNode();
        currentLeftLeftNode.left_ptr.label = 0;

        currentLeftLeftNode.right_ptr = new TreeNode();
        currentLeftLeftNode.right_ptr.label = 1;


        TreeNode theRight = currentRightRoot.right_ptr;
        theRight.left_ptr = new TreeNode();
        theRight.left_ptr.label = 3;

        theRight.right_ptr = new TreeNode();
        theRight.right_ptr.label = 6;

        TreeNode currNode = root;

        IntegerObj maxNumber = new IntegerObj();
        maxNumber.number = 0;

        IntegerObj currLeftSizeOfCurrObj = new IntegerObj();
        currLeftSizeOfCurrObj.number = 0;

        IntegerObj currRightSizeOfCurrObj = new IntegerObj();
        currRightSizeOfCurrObj.number = 0;

        helper(currNode, maxNumber, currLeftSizeOfCurrObj, currRightSizeOfCurrObj);

//        return maxNumber.number;
        int a = 5;
    }

    public static void helper(TreeNode currNode, IntegerObj maxNumber, IntegerObj currLeftSizeOfCurrObj,
                              IntegerObj currRightSizeOfCurrObj) {
        if (currNode.left_ptr == null && currNode.right_ptr == null) {
            return;
        }

        if (currNode.left_ptr != null || currNode.right_ptr != null) {
            if (currNode.left_ptr != null) {
                helper(currNode.left_ptr, maxNumber, currLeftSizeOfCurrObj, currRightSizeOfCurrObj);
                currLeftSizeOfCurrObj.number = currLeftSizeOfCurrObj.number + 1;
            }
            if (currNode.right_ptr != null) {
                helper(currNode.right_ptr, maxNumber, currLeftSizeOfCurrObj, currRightSizeOfCurrObj);
                currRightSizeOfCurrObj.number = currRightSizeOfCurrObj.number + 1;
            }

            maxNumber.number = Integer.max(currLeftSizeOfCurrObj.number, currRightSizeOfCurrObj.number) + 1;
        }
    }

    public static class TreeNode{
        public int label;
        public TreeNode left_ptr;
        public TreeNode right_ptr;
    }

    public static class IntegerObj{
        public int number;
    }

}
