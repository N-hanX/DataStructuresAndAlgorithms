package sorting.problemSet;

import java.util.ArrayList;
import java.util.List;

public class MergeKSortedLinkedList {
    public static void main(String[] args) {

        SinglyLinkedListNode newNode = new SinglyLinkedListNode(1);
        SinglyLinkedListNode head1 = newNode;
        newNode.next  = new SinglyLinkedListNode(3);
        newNode = newNode.next;
        newNode.next = new SinglyLinkedListNode(5);

        SinglyLinkedListNode newNode2 = new SinglyLinkedListNode(3);
        SinglyLinkedListNode head2 = newNode2;
        newNode2.next  = new SinglyLinkedListNode(4);
        newNode2 = newNode2.next;

        SinglyLinkedListNode newNode3 = new SinglyLinkedListNode(7);
        SinglyLinkedListNode head3 = newNode3;
        newNode3 = newNode3.next;


//        SinglyLinkedListNode currNode = head3;
//        while(currNode.next != null){
//            System.out.println(currNode.data);
//            currNode = currNode.next;
//        }
//        System.out.println(currNode.data);

        List<SinglyLinkedListNode> lists = new ArrayList<SinglyLinkedListNode>() ;
        lists.add(head1);
        lists.add(head2);
        lists.add(head3);

        merge_k_lists(lists);
    }

    public static SinglyLinkedListNode merge_k_lists(List<SinglyLinkedListNode> lists) {
        SinglyLinkedListNode allSortedList = null;
        SinglyLinkedListNode theRealAllSortedList = null;

        boolean allFinished = false;

        SinglyLinkedListNode currNode = lists.get(0);
        int currMinData = currNode.data;
        int currMinDataIndex = 0;

        while(!allFinished){
            boolean isThereAnyNode = false;

            for(int i = 0; i < lists.size(); i++){
                currNode = lists.get(i);


                if(currNode != null){
                    isThereAnyNode = true;

                    for(int j = i; j < lists.size(); j++){
                        SinglyLinkedListNode compareNode = lists.get(j);

                        if(compareNode != null){
                            int compareNodeData = compareNode.data;
                            int compareNodeInd = j;

                            if(compareNodeData < currMinData){
                                currMinData = compareNodeData;
                                currMinDataIndex = compareNodeInd;
                            }
                        }
                    }

                    SinglyLinkedListNode minNode = lists.get(currMinDataIndex);
                    minNode = minNode.next;

                    //end of comparison
                    allSortedList = new SinglyLinkedListNode(currMinData);

                    if(theRealAllSortedList == null){
                        theRealAllSortedList = allSortedList;
                    }

                    allSortedList = allSortedList.next;

                }

                if(isThereAnyNode == true){
                    i = 0;
                }
            }
            if(!isThereAnyNode){
                // end of the merge
                allFinished = true;
            }
        }
//        return allSortedList;
        return null;
    }

}
