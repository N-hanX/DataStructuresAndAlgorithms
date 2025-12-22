package study_program.problemSet.tree;

public class MergeTwoBSTs3 {
    public static void main(String[] args) {
        BinaryTreeNode root1_5 = new BinaryTreeNode(5);
        BinaryTreeNode root1_3 = new BinaryTreeNode(3);
        BinaryTreeNode root1_2 = new BinaryTreeNode(2);
        BinaryTreeNode root1_4 = new BinaryTreeNode(4);
        BinaryTreeNode root1_6 = new BinaryTreeNode(6);
        BinaryTreeNode root1_7 = new BinaryTreeNode(7);

        BinaryTreeNode root2_8 = new BinaryTreeNode(8);
        BinaryTreeNode root2_1 = new BinaryTreeNode(1);
        BinaryTreeNode root2_9 = new BinaryTreeNode(9);

        root1_5.left = root1_3;
        root1_3.left = root1_2;
        root1_3.right = root1_4;

        root1_5.right = root1_6;;
        root1_6.right = root1_7;

        root2_8.left = root2_1;
        root2_8.right = root2_9;

        BinaryTreeNode new_root = merge_two_binary_search_trees(root1_5, root2_8);

        int a = 4;
    }

    static int countNodes(BinaryTreeNode head){
        int count = 0;

        while(head != null){
            head = head.right;
            count++;
        }
        return count;
    }

    static BinaryTreeNode sortedListToBSTRec(BinaryTreeNode[] headRef, int low, int high){
        if(headRef[0] == null){
            return null;
        }

        if(low > high){
            return null;
        }

        int mid = (low + high) / 2;

        BinaryTreeNode leftSubtree = sortedListToBSTRec(headRef, low, mid - 1);

        BinaryTreeNode root = headRef[0];
        headRef[0] = headRef[0].right;

        BinaryTreeNode rightSubtree = sortedListToBSTRec(headRef, mid + 1, high);

        root.left = leftSubtree;
        root.right = rightSubtree;

        return root;
    }

    static BinaryTreeNode sortedListToBST(BinaryTreeNode listHead){
        int nodeCount = countNodes(listHead);
        BinaryTreeNode[] headRef = new BinaryTreeNode[]{listHead};

        return sortedListToBSTRec(headRef, 0, nodeCount - 1);
    }

    static void BSTToInorderListRec(BinaryTreeNode root, BinaryTreeNode[] prevRef, BinaryTreeNode[] headRef){
        if(root == null){
            return;
        }

        BSTToInorderListRec(root.left, prevRef, headRef);

        if(prevRef[0] == null){
            prevRef[0] = root;
            headRef[0] = root;
        }else{
            prevRef[0].right = root;
            prevRef[0] = prevRef[0].right;
        }

        BSTToInorderListRec(root.right, prevRef, headRef);
    }

    static BinaryTreeNode BSTToInorderList(BinaryTreeNode root){
        BinaryTreeNode[] prevRef = new BinaryTreeNode[]{null};
        BinaryTreeNode[] headRef = new BinaryTreeNode[]{null};

        BSTToInorderListRec(root, prevRef, headRef);

        return headRef[0];
    }

    static BinaryTreeNode mergeSortedLists(BinaryTreeNode list1, BinaryTreeNode list2){
        if(list1 == null){
            return list2;
        }

        if(list2 == null){
            return list1;
        }

        BinaryTreeNode dummyHead = new BinaryTreeNode(0);
        BinaryTreeNode current = dummyHead;

        while(list1 != null || list2 != null){
            if(list1 == null) {
                current.right = list2;
                list2 = list2.right;
            }else if(list2 == null){
                current.right = list1;
                list1 = list1.right;
            }else{
                if(list1.value < list2.value){
                    current.right = list1;
                    list1 = list1.right;
                }else{
                    current.right = list2;
                    list2 = list2.right;
                }
            }
            current = current.right;
        }
        return dummyHead.right;
    }

    static BinaryTreeNode merge_two_binary_search_trees(BinaryTreeNode root1, BinaryTreeNode root2) {
        BinaryTreeNode list1 = BSTToInorderList(root1);
        BinaryTreeNode list2 = BSTToInorderList(root2);

        return sortedListToBST(mergeSortedLists(list1, list2));
    }
}
