package study_program.problemSet.linkedList_stack_queue;

public class RemoveNthNodeFromTheEndOf_A_List {
    public static void main(String[] args) {
//        {
//            "n": 2,
//                "head": [0, 1, 10, 5, 7]
//        }



//        LinkedListNode node0 = new LinkedListNode(0);
//        LinkedListNode node1 = new LinkedListNode(1);
//        LinkedListNode node10 = new LinkedListNode(10);
//        LinkedListNode node5 = new LinkedListNode(5);
//        LinkedListNode node7 = new LinkedListNode(7);
//
//        node0.next = node1;
//        node1.next = node10;
//        node10.next = node5;
//        node5.next = node7;
//
//        int n = 2;

        LinkedListNode node1 = new LinkedListNode(1);
        int n = 1;

        LinkedListNode node = remove_nth_node_from_end(n, node1);

        int a = 5;
    }

    static LinkedListNode remove_nth_node_from_end(Integer n, LinkedListNode head) {
        int total_num_of_nodes = 0;

        LinkedListNode temp = head;

        while(temp != null){
            temp = temp.next;
            total_num_of_nodes++;
        }

        int the_target_node_index = total_num_of_nodes - n;

        LinkedListNode prev_node_before_target = new LinkedListNode(Integer.MIN_VALUE);
        LinkedListNode next_node_after_target;

        temp = head;
        int ind_counter = 0;

        if(the_target_node_index > 0){
            while(ind_counter < the_target_node_index){
                prev_node_before_target = temp;
                temp = temp.next;
                ind_counter++;
            }
            next_node_after_target = temp.next;

            prev_node_before_target.next = next_node_after_target;
        }else{
            return head.next;
        }



        return head;
    }


}
