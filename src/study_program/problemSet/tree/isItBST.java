package study_program.problemSet.tree;

public class isItBST {
    public static void main(String[] args) {
        BinaryTreeNode node100 = new BinaryTreeNode(100);
        BinaryTreeNode node80 = new BinaryTreeNode(80);
        BinaryTreeNode node70 = new BinaryTreeNode(70);
        BinaryTreeNode node60 = new BinaryTreeNode(60);
        BinaryTreeNode node90 = new BinaryTreeNode(90);
        BinaryTreeNode node120 = new BinaryTreeNode(120);

        BinaryTreeNode node200 = new BinaryTreeNode(200);
        BinaryTreeNode node100_2 = new BinaryTreeNode(100);
        BinaryTreeNode node80_2 = new BinaryTreeNode(80);
        BinaryTreeNode node250 = new BinaryTreeNode(250);
        BinaryTreeNode node290 = new BinaryTreeNode(290);
        BinaryTreeNode node150 = new BinaryTreeNode(150);

        node100.left = node80;
        node100.right = node200;
        node80.left = node70;
        node70.left = node60;
        node70.right = node90;
        node80.right = node120;
        node200.left = node100_2;
        node100_2.left = node80_2;
        node200.right = node250;
        node250.right = node290;
        node290.left = node150;

        Boolean result = is_bst(node100);
        int a;
    }
    static int compare_value = Integer.MIN_VALUE;

    static Boolean is_bst(BinaryTreeNode root) {
        return bst_checker(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    static Boolean bst_checker(BinaryTreeNode root, int min_accepted_value, int max_accepted_value) {
        if(root == null)
            return true;

        if(root.value < min_accepted_value || root.value > max_accepted_value){
            return false;
        }

        Boolean leftResult = bst_checker(root.left, min_accepted_value, root.value);
        Boolean rightResult = bst_checker(root.right, root.value, max_accepted_value);

        return leftResult && rightResult;
    }
}
