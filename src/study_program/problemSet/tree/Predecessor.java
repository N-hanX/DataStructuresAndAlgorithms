package study_program.problemSet.tree;

public class Predecessor {
    public static void main(String[] args) {
        BinaryTreeNode node44 = new BinaryTreeNode(44);
        BinaryTreeNode node17 = new BinaryTreeNode(17);
        BinaryTreeNode node8 = new BinaryTreeNode(8);
        BinaryTreeNode node32 = new BinaryTreeNode(32);
        BinaryTreeNode node28 = new BinaryTreeNode(28);
        BinaryTreeNode node29 = new BinaryTreeNode(29);

        BinaryTreeNode node88 = new BinaryTreeNode(88);
        BinaryTreeNode node65 = new BinaryTreeNode(65);
        BinaryTreeNode node54 = new BinaryTreeNode(54);
        BinaryTreeNode node82 = new BinaryTreeNode(82);
        BinaryTreeNode node76 = new BinaryTreeNode(76);

        BinaryTreeNode node80 = new BinaryTreeNode(80);
        BinaryTreeNode node97 = new BinaryTreeNode(97);
        BinaryTreeNode node93 = new BinaryTreeNode(93);

        node44.left = node17;
        node17.left = node8;
        node17.right = node32;
        node32.left = node28;
        node28.right = node29;

        node44.right = node88;
        node88.left = node65;
        node65.left = node54;
        node65.right = node82;

        node82.left = node76;
        node76.right = node80;

        node88.right = node97;
        node97.left = node93;

        Integer predecessor1 = getPredecessor(node44, node54);
        Integer predecessor2 = getPredecessor(node44, node65);


        int a = 4;
    }

    public static Integer getPredecessor(BinaryTreeNode root, BinaryTreeNode key){
        BinaryTreeNode curr = root;

        while(curr != key){
            if(curr.value > key.value){
                curr = curr.left;
            }else{
                curr = curr.right;
            }
        }

        if(curr != null && curr.left != null){
            curr = curr.left;
            while(curr != null && curr.right != null){
                curr = curr.right;
            }
            return curr.value;
        }

        curr = root;
        Integer first_kid = null;
        while(curr != key){
            if(curr.value < key.value){
               first_kid = curr.value;
               curr = curr.right;
            }else{
                curr = curr.left;
            }
        }

        if(first_kid != null)
            return first_kid;

        return null;
    }
}
