package trees.homework;

public class kSmallestElement {


    static int currSmallestNumber;
    static boolean found = false;
    static int theElement = -1;

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.val = 7;

        TreeNode currentRoot = root;
        currentRoot.left_ptr = new TreeNode();
        currentRoot.left_ptr.val = 5;

        TreeNode currentRightRoot = root;
        currentRightRoot.right_ptr = new TreeNode();
        currentRightRoot.right_ptr.val = 9;

        TreeNode currentLeftLeftNode = currentRoot.left_ptr;
        currentLeftLeftNode.left_ptr = new TreeNode();
        currentLeftLeftNode.left_ptr.val = 1;

        currentLeftLeftNode.right_ptr = new TreeNode();
        currentLeftLeftNode.right_ptr.val = 6;



        TreeNode theRight = currentRightRoot.right_ptr;
        theRight.left_ptr = new TreeNode();
        theRight.left_ptr.val = 8;

        theRight.right_ptr = new TreeNode();
        theRight.right_ptr.val = 10;


        currSmallestNumber = 0;

        TreeNode currNode = root;

        int k = 7;
        helper(currNode, k);




        int a = 5;
//        return theElement;

    }


    static void helper(TreeNode currNode, int k){
        if(currNode == null){
            return;
        }

        if(found){
            return;
        }

        if(!found) {
            if (currNode.left_ptr == null && currNode.right_ptr == null) {
                if (currSmallestNumber == k - 1) {
                    found = true;
                    theElement = currNode.val;
                } else {
                    currSmallestNumber++;
                    return;
                }
            }

            helper(currNode.left_ptr, k);
            currSmallestNumber++; // kendisini de sayiyoruz
            if (currSmallestNumber == k) {
                found = true;
                theElement = currNode.val;
                return;
            }

            helper(currNode.right_ptr, k);
        }

    }

    public static class TreeNode{
        public int val;
        public TreeNode left_ptr;
        public TreeNode right_ptr;
    }


}
