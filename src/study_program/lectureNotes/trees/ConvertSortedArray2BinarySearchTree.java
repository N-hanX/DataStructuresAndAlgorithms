package study_program.lectureNotes.trees;

public class ConvertSortedArray2BinarySearchTree {
    public static void main(String[] args) {
        int[] nums = new int[]{-10,-3,0,5,9};
        TreeNode root = sortedArrayToBST(nums);

        int a = 4;
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return helper(0, nums.length - 1, nums);
    }

    public static TreeNode helper(int startInd, int endInd, int[] nums){
        if(startInd < 0 || endInd < 0 || startInd >= nums.length || endInd >= nums.length || startInd > endInd)
            return null;

        if(startInd == endInd){
            return new TreeNode(nums[startInd]);
        }

        int middleInd = (endInd - startInd) / 2 + startInd;

        TreeNode root = new TreeNode(nums[middleInd]);

        root.left = helper(startInd, middleInd - 1, nums);
        root.right = helper(middleInd + 1, endInd, nums);

        return root;
    }
}
