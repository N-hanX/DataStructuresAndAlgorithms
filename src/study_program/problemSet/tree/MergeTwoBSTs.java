package study_program.problemSet.tree;

public class MergeTwoBSTs {
    public static void main(String[] args) {
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        BinaryTreeNode node4 = new BinaryTreeNode(4);

        BinaryTreeNode node6 = new BinaryTreeNode(6);
        BinaryTreeNode node7 = new BinaryTreeNode(7);
        BinaryTreeNode node8 = new BinaryTreeNode(8);

        node5.left = node3;
        node3.left = node2;
        node3.right = node4;

        node5.right = node6;
        node6.right = node7;
        node7.right = node8;

        var mergebsts = new MergeTwoBSTs();
        mergebsts.zincirYap(node5);
        System.out.println("finidhed");
    }

    public BinaryTreeNode zincirYap(BinaryTreeNode currentNode) {
        if (currentNode.right != null) {
            currentNode.right = zincirYap(currentNode.right);
        }
        if (currentNode.left != null) {
            BinaryTreeNode solZincirinBasi = zincirYap(currentNode.left);
            currentNode.left = null;
            findRightEndAndAppend(solZincirinBasi, currentNode);
            return solZincirinBasi;
        } else {
            return currentNode;
        }

    }
    public void findRightEndAndAppend(BinaryTreeNode root, BinaryTreeNode toAdd) {
        while (root.right != null) {
            root = root.right;
        }
        root.right = toAdd;
    }


}
