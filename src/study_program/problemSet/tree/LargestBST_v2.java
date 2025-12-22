package study_program.problemSet.tree;

public class LargestBST_v2 {
    public static void main(String[] args) {
//        BinaryTreeNode node1 = new BinaryTreeNode(450);
//        BinaryTreeNode node2 = new BinaryTreeNode(200);
//        BinaryTreeNode node3 = new BinaryTreeNode(100);
//        BinaryTreeNode node4 = new BinaryTreeNode(450);
//        BinaryTreeNode node5 = new BinaryTreeNode(500);
//        BinaryTreeNode node6 = new BinaryTreeNode(470);
//        BinaryTreeNode node7 = new BinaryTreeNode(700);
//
//        node1.left = node3;
//        node3.left = node2;
//        node3.right = node4;
//        node1.right = node5;
//        node5.left = node6;
//        node5.right = node7;

        BinaryTreeNode node1 = new BinaryTreeNode(10);
        BinaryTreeNode node2 = new BinaryTreeNode(20);
        BinaryTreeNode node3 = new BinaryTreeNode(30);

        node1.left = node2;
        node2.left = node3;

        Integer result = find_largest_bst(node1);
        int a = 4;
    }

    static Integer find_largest_bst(BinaryTreeNode root) {
        Node_Info result = helper(root);

        if(result == null)
            return 0;

        return result.bst_size;
    }

    static Node_Info helper(BinaryTreeNode node){
        if(node == null){
            return null;
        }

        if(node.left == null && node.right == null){
            Node_Info leaf_node = new Node_Info(node.value);
            leaf_node.is_bst = true;
            leaf_node.max_node_in_bst = leaf_node.value;
            leaf_node.min_node_in_bst = leaf_node.value;
            leaf_node.bst_size = 1;

            return leaf_node;
        }

        Node_Info left_info = helper(node.left);
        Node_Info curr_node = new Node_Info(node.value);
        Node_Info right_info = helper(node.right);

        // su andaki node'u guncelle ve bst mi tespit et
        if(left_info != null && right_info != null){
            if(left_info.is_bst && right_info.is_bst){
                if(left_info.value <= node.value && right_info.value >= node.value ){
                    curr_node.bst_size = left_info.bst_size + right_info.bst_size + 1;
                    curr_node.max_node_in_bst = right_info.value;
                    curr_node.min_node_in_bst = left_info.value;
                    curr_node.is_bst = true;
                }else{
                    curr_node.bst_size = Math.max(left_info.bst_size, right_info.bst_size);
                    curr_node.is_bst = false;
                }
            }else if(left_info.is_bst){
                left_update(left_info, curr_node);
            }else if(right_info.is_bst){
                right_update(right_info, curr_node);
            }
        }else if(left_info != null){
            left_update(left_info, curr_node);
        }else if(right_info != null){
            right_update(right_info, curr_node);
        }else{
            curr_node.is_bst = true;
            curr_node.bst_size = 1;
        }
        return curr_node;
    }

    public static void right_update(Node_Info right_info, Node_Info curr_node){
        if(right_info.is_bst){
            if(right_info.value >= curr_node.value){
                curr_node.bst_size = right_info.bst_size + 1;
                curr_node.min_node_in_bst = Integer.MIN_VALUE;
                curr_node.max_node_in_bst = right_info.value;
                curr_node.is_bst = true;
            }else{ // bst degil ve
                curr_node.is_bst = false;
                curr_node.bst_size = right_info.bst_size;
            }
        }else{
            curr_node.is_bst = false;
            curr_node.bst_size = right_info.bst_size;
        }
    }

    public static void left_update(Node_Info left_info, Node_Info curr_node){
        if(left_info.is_bst) {
            if(left_info.value <= curr_node.value) {
                curr_node.bst_size = left_info.bst_size + 1;
                curr_node.max_node_in_bst = Integer.MAX_VALUE;
                curr_node.min_node_in_bst = left_info.value;
                curr_node.is_bst = true;
                return;
            }else { // bst degil ve
                curr_node.is_bst = false;
                curr_node.bst_size = left_info.bst_size;
            }
        }else{
            curr_node.is_bst = false;
            curr_node.bst_size = left_info.bst_size;
        }
    }

    static class Node_Info {
        Integer value;
        boolean is_bst;
        Integer bst_size;
        Integer min_node_in_bst;
        Integer max_node_in_bst;

        public Node_Info(Integer value) {
            this.value = value;
        }
    }
}
