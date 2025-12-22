package study_program.problemSet.tree;

public class IsSingleValueTree {
    public static void main(String[] args) {

        // expected output : 6
//        BinaryTreeNode node5_0 = new BinaryTreeNode(5);
//        BinaryTreeNode node5_1 = new BinaryTreeNode(5);
//        BinaryTreeNode node5_2 = new BinaryTreeNode(5);
//        BinaryTreeNode node5_3 = new BinaryTreeNode(5);
//        BinaryTreeNode node5_4 = new BinaryTreeNode(5);
//        BinaryTreeNode node5_5 = new BinaryTreeNode(5);
//
//        node5_0.left = node5_1;
//        node5_0.right = node5_2;
//        node5_1.left = node5_3;
//        node5_1.right = node5_4;
//        node5_2.right = node5_5;


        BinaryTreeNode node5_0 = new BinaryTreeNode(5);
        BinaryTreeNode node5_1 = new BinaryTreeNode(5);
        BinaryTreeNode node5_2 = new BinaryTreeNode(5);
        BinaryTreeNode node5_3 = new BinaryTreeNode(5);
        BinaryTreeNode node5_4 = new BinaryTreeNode(5);
        BinaryTreeNode node5_5 = new BinaryTreeNode(5);
        BinaryTreeNode node4 = new BinaryTreeNode(4);

        node5_0.left = node5_1;
        node5_0.right = node5_2;
        node5_1.left = node5_3;
        node5_1.right = node5_4;
        node5_2.left = node4;
        node5_2.right = node5_5;

        find_single_value_trees(node5_0);
        int a = 5;
    }

    static Integer find_single_value_trees(BinaryTreeNode root) {
        counter = 0;
        find_single_value_trees_helper(root);
        return counter;
    }

    static int counter;
    static Boolean find_single_value_trees_helper(BinaryTreeNode root) {
        if(root == null){
            return true;
        }

        Boolean result1 = find_single_value_trees_helper(root.left);
        Boolean result2 = find_single_value_trees_helper(root.right);

        Boolean directCheck = false;
        if ((root.left == null || (result1 && root.left.value == root.value))
                &&
                (root.right == null || (result2 && root.right.value == root.value))){
            counter++;
            return true;
        }
        return false;
    }


}
