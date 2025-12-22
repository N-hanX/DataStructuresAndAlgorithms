package study_program.lectureNotes.trees;

public class ConstructBinaryTreefromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};

        TreeNode root = buildTree(preorder, inorder);

        int a = 4;
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null)
            return null;

        return helper(preorder, inorder, 0, inorder.length - 1, 0);
    }

    public static TreeNode helper(int[] preorder, int[] inorder, int inorderStart,
                                  int inorderEnd, int currPreorderInd){

        if(inorderStart > inorderEnd || inorderStart < 0 || inorderEnd < 0
                || inorderStart >= inorder.length || inorderEnd >= inorder.length){
            return null;
        }

        //find the ind
        int the_num = preorder[currPreorderInd];

        int ind = -1;
        for(int i = inorderStart; i <= inorderEnd; i++){
            if(inorder[i] == the_num){
                ind = i;
                break;
            }
        }

        TreeNode root = new TreeNode(the_num);
        // if leftInd available it will be right after the element in preorder
        int leftRootIndInPreorder = currPreorderInd;
        if(ind - inorderStart > 0)
            leftRootIndInPreorder = currPreorderInd + 1;

        int rightRootIndInPreoder = currPreorderInd + ( ind - inorderStart + 1);

        root.left = helper(preorder, inorder, inorderStart, ind - 1, leftRootIndInPreorder);
        root.right = helper(preorder, inorder, ind + 1, inorderEnd,  rightRootIndInPreoder);

        return root;
    }
}
