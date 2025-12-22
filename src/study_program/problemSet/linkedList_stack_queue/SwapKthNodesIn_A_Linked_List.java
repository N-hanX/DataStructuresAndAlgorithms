package study_program.problemSet.linkedList_stack_queue;

public class SwapKthNodesIn_A_Linked_List {
    public static void main(String[] args) {
//        1, 2, 3, 4, 7, 0
//        LinkedListNode node1 = new LinkedListNode(1);
//        LinkedListNode node2 = new LinkedListNode(2);
//        LinkedListNode node3 = new LinkedListNode(3);
//        LinkedListNode node4 = new LinkedListNode(4);
//        LinkedListNode node7 = new LinkedListNode(7);
//        LinkedListNode node0 = new LinkedListNode(0);
//        LinkedListNode node20 = new LinkedListNode(20);
//
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node7;
//        node7.next = node0;
//        node0.next = node20;
//
//        int k = 4;

//        LinkedListNode node10 = new LinkedListNode(10);
//        LinkedListNode node20 = new LinkedListNode(20);
//
//        node10.next = node20;
//
//        int k = 1;
//
//        {
//            "head": [1, 2, 3, 4, 5, 6, 7],
//            "k": 3
//        }


//        {
//            "head": [-20, 10, 20, -10],
//            "k": 3
//        }


        LinkedListNode node_20 = new LinkedListNode(-20);
        LinkedListNode node10 = new LinkedListNode(10);
        LinkedListNode node20 = new LinkedListNode(20);
        LinkedListNode node_10 = new LinkedListNode(-10);

        node_20.next = node10;
        node10.next = node20;
        node20.next = node_10;

        int k = 2;

        LinkedListNode result = swap_nodes(node_20, k);

        int a = 5;

    }

    static LinkedListNode swap_nodes(LinkedListNode head, Integer k) {
        LinkedListNode temp = head;

        int total_size = 0;
        while(temp != null){
            temp = temp.next;
            total_size++;
        }

        if( k == 1 && total_size == 1){
            return head;
        }

        if( k == 1 || k == total_size){
            return k_is_head(head, total_size, 1);
        }

        if( k - 1 == total_size - k){
            return head;
        }

        if( Math.abs(k - 1 - (total_size - k)) == 1){
            return consecutive_nodes(head, total_size, k);
        }

        int endInd = total_size - k + 1;
        int prevEndInd = total_size - k;

        int prev_k_ind = k - 1;

        int count = 1;

        temp = head;

        while(count < prev_k_ind){
            temp = temp.next;
            count++;
        }

        LinkedListNode prev_k_node = temp;

        count = 1;
        temp = head;
        while(count < prevEndInd){
            temp = temp.next;
            count++;
        }

        LinkedListNode prev_end_node = temp;

        LinkedListNode kth_node = prev_k_node.next;
        LinkedListNode temp_kth_node_next = kth_node.next;

        LinkedListNode end_node = prev_end_node.next;
        LinkedListNode temp_end_node_next = end_node.next;


        prev_k_node.next = end_node;
        end_node.next =  temp_kth_node_next;

        prev_end_node.next  = kth_node;
        kth_node.next = temp_end_node_next;



        return head;
    }

    static LinkedListNode k_is_head(LinkedListNode head, int total_len, int k){
        LinkedListNode prev_head_node = new LinkedListNode(-1);
        prev_head_node.next = head;
        LinkedListNode head_next = head.next;


        LinkedListNode temp = head;
        if(total_len == 2){
            prev_head_node.next = head_next;
            head_next.next = head;
            head_next.next.next = null;
            return prev_head_node.next;
        }

        int count = 1;
        int prevEndInd = total_len - k;
        temp = head;
        while(count < prevEndInd){
            temp = temp.next;
            count++;
        }

        LinkedListNode prev_end_node = temp;

        LinkedListNode kth_node = prev_head_node.next;
        LinkedListNode temp_kth_node_next = kth_node.next;

        LinkedListNode end_node = prev_end_node.next;
        LinkedListNode temp_end_node_next = end_node.next;

        prev_head_node.next = end_node;
        end_node.next =  temp_kth_node_next;

        prev_end_node.next  = kth_node;
        kth_node.next = temp_end_node_next;



        return prev_head_node.next;
    }

    static LinkedListNode consecutive_nodes(LinkedListNode head, int total_len, int k){
        LinkedListNode temp = head;

        int count = 1;

        if(total_len - k < k){
            k = total_len - k;
        }

        while(count < k - 1){
            temp = temp.next;
            count++;
        }

        LinkedListNode prev_node = temp;
        LinkedListNode k_th_node = temp.next;
        LinkedListNode end_node = k_th_node.next;
        LinkedListNode end_node_next = end_node.next;

        prev_node.next = end_node;
        end_node.next = k_th_node;
        k_th_node.next = end_node_next;
        return head;
    }
}
