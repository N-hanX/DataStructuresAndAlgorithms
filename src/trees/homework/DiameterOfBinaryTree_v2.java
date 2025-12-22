package trees.homework;

public class DiameterOfBinaryTree_v2 {
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode();
        root.value = 2;

        BinaryTreeNode currentRoot = root;
        currentRoot.left = new BinaryTreeNode();
        currentRoot.left.value = 5;

        BinaryTreeNode currentRightRoot = root;
        currentRightRoot.right = new BinaryTreeNode();
        currentRightRoot.right.value = 4;

        BinaryTreeNode currentLeftLeftNode = currentRoot.left;
        currentLeftLeftNode.left = new BinaryTreeNode();
        currentLeftLeftNode.left.value = 0;

        currentLeftLeftNode.right = new BinaryTreeNode();
        currentLeftLeftNode.right.value = 1;

        BinaryTreeNode theRight = currentRightRoot.right;
        theRight.left = new BinaryTreeNode();
        theRight.left.value = 3;

        theRight.right = new BinaryTreeNode();
        theRight.right.value = 6;


        binary_tree_diameter(root);

        int a = 5;
    }

    static Integer binary_tree_diameter(BinaryTreeNode root) {
        calculate_binary_tree_diameter(root);

        return maxValue;
    }

    static private int maxValue=0;
    static int calculate_binary_tree_diameter(BinaryTreeNode node){
        if(node == null)
            return 0;

        int leftDiameter = 0;
        int rightDiameter = 0;
        if(node.left != null)
            leftDiameter = 1 + calculate_binary_tree_diameter(node.left );

        if(node.right != null)
            rightDiameter = 1 + calculate_binary_tree_diameter(node.right);

        if(maxValue < leftDiameter + rightDiameter){
            maxValue = leftDiameter + rightDiameter;
        }

        return Math.max(leftDiameter, rightDiameter);
    }

    public static class BinaryTreeNode{
        public int value;
        public BinaryTreeNode left;
        public BinaryTreeNode right;
    }
}
