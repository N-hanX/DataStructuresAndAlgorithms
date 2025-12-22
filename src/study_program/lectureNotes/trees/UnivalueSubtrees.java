package study_program.lectureNotes.trees;


public class UnivalueSubtrees {
    public static void main(String[] args) {
        TreeNode node5_1 = new TreeNode(5);
        TreeNode node5_2 = new TreeNode(5);
        TreeNode node5_3 = new TreeNode(5);
        TreeNode node5_4 = new TreeNode(5);
        TreeNode node5_5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);

        node5_1.left = node1;
        node5_1.right = node5_2;
        node1.left = node5_3;
        node1.right = node5_4;
        node5_2.right = node5_5;

        int result = findUnivalueSubtress(node5_1);

        int a = 4;
    }

    static int counter;
    public static int findUnivalueSubtress(TreeNode root){
        counter = 0;
        helper(root, null);
        return counter;
    }

    public static boolean helper(TreeNode root, TreeNode ancestor){
        if(root == null){
            return true;
        }

        if(root.left == null && root.right == null){
            System.out.println(root.val);
            counter++;
            return true;
        }

        boolean leftResult = helper(root.left, root);
        boolean rightResult = helper(root.right, root);

        System.out.println(root.val);

        if(ancestor != null && root.val == ancestor.val && leftResult && rightResult){
            counter++;
            return true;
        }else if(ancestor == null && leftResult && rightResult){
            counter++;
            return true;
        }else
            return false;
    }
}
