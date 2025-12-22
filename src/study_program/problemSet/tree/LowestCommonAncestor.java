package study_program.problemSet.tree;

import java.util.ArrayList;

public class LowestCommonAncestor {
    public static void main(String[] args) {
        BinaryTreeNode node1 = new BinaryTreeNode(1);
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node6 = new BinaryTreeNode(6);
        BinaryTreeNode node7 = new BinaryTreeNode(7);
        BinaryTreeNode node8 = new BinaryTreeNode(8);
        BinaryTreeNode node9 = new BinaryTreeNode(9);

        node1.left = node2;
        node2.left = node4;
        node2.right = node5;
        node5.left = node8;
        node5.right = node9;
        node1.right = node3;
        node3.left = node6;
        node3.right = node7;

        Integer lowest_common_ancestor = lca(node1, node9, node8);

        int a;

    }

    static Integer lca(BinaryTreeNode root, BinaryTreeNode a, BinaryTreeNode b) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        find_lca(root, a, b, new ArrayList<>(), result);

        int count  = 0;
        int the_last_same_ind  = a.value;
        while(result.size() == 2 && (count < result.get(0).size() && count < result.get(1).size())){
            if(result.get(0).get(count) == result.get(1).get(count)){
                the_last_same_ind = result.get(0).get(count);
            }
            count++;
        }

        return the_last_same_ind;
    }

    static void find_lca(BinaryTreeNode root, BinaryTreeNode a, BinaryTreeNode b, ArrayList<Integer> curr_pathway,
                         ArrayList<ArrayList<Integer>> result){
        if(root == null){
            return;
        }
        if(root == a || root == b){
            curr_pathway.add(root.value);
            result.add(new ArrayList<>(curr_pathway));
            curr_pathway.remove(curr_pathway.size() - 1);
        }

        if(result.size() == 2){
            return;
        }
        curr_pathway.add(root.value);
        find_lca(root.left, a, b, curr_pathway, result);
        find_lca(root.right, a, b, curr_pathway, result);
        curr_pathway.remove(curr_pathway.size() - 1);
    }
}
