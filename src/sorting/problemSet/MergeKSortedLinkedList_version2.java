package sorting.problemSet;

import java.util.ArrayList;
import java.util.List;

public class MergeKSortedLinkedList_version2 {
    public static void main(String[] args) {

        LinkedListNode newNode = new LinkedListNode(1);
        LinkedListNode head1 = newNode;
        newNode.next = new LinkedListNode(3);
        newNode = newNode.next;
        newNode.next = new LinkedListNode(5);

        LinkedListNode newNode2 = new LinkedListNode(3);
        LinkedListNode head2 = newNode2;
        newNode2.next = new LinkedListNode(4);
        newNode2 = newNode2.next;

        LinkedListNode newNode3 = new LinkedListNode(7);
        LinkedListNode head3 = newNode3;
        newNode3 = newNode3.next;


        List<LinkedListNode> lists = new ArrayList<LinkedListNode>();
        lists.add(head1);
        lists.add(head2);
        lists.add(head3);

        LinkedListNode result = merge_k_lists(lists);
        int a = 5;
    }

    public static LinkedListNode merge_k_lists(List<LinkedListNode> lists) {

        // bu donguyu defalarca kez tekrrarlicaz.
        // bu donguyu sonlandiran bir sart gerekiyor.
        // o sartta eger ki butun liste null olduysa
        // bu sarti yerine getirip getirmedigini kontrol eden bir degisken tutalim.
        // bu degiskeni once hepsi null diye deger atayalim.
        // bu degisken ayni kalirsa dongu bitmistir.
        // bu degisken null degilse dongu devam edecektir.


        // sonuc listesini tanimlayalim.
        //

        LinkedListNode head = new LinkedListNode(-1);
        LinkedListNode prev = head;
        boolean is_there_any_not_null_node = true;

        while (is_there_any_not_null_node == true) {
            LinkedListNode min_node = null; // buna hangi degeri atayacagiz.
            int min_node_ind = -1;

            is_there_any_not_null_node = false;
            for (int i = 0; i < lists.size(); i++) {
                LinkedListNode currNode = lists.get(i);

                if (currNode != null)
                    is_there_any_not_null_node = true;

                if (currNode == null)
                    continue;

                System.out.println("currNode " + currNode.value);

                if (min_node == null) {
                    min_node = currNode;
                    min_node_ind = i;
                }
                System.out.println("the min_node" + min_node.value);


                if (currNode.value <= min_node.value) {
                    min_node = currNode;
                    min_node_ind = i;

                }
            }

            if (is_there_any_not_null_node == false)
                continue;

            LinkedListNode the_min_node = lists.get(min_node_ind);
            prev.next = the_min_node;

            prev = prev.next;
            lists.set(min_node_ind, the_min_node.next);

            if (lists.get(min_node_ind) != null)
                System.out.println("next mind_node" + lists.get(min_node_ind).value);

        }

        return head.next;
    }
}
