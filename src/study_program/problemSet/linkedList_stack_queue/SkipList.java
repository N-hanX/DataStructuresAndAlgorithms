package study_program.problemSet.linkedList_stack_queue;

import java.util.ArrayList;
import java.util.Arrays;

public class SkipList {

    static class ListNode {
        Integer value;
        ListNode next;

        ListNode(Integer value) {
            this.value = value;
            this.next = null;
        }
    }

    public static ListNode findMedianPoint(ListNode start, ListNode end){
        ListNode prev = new ListNode(-1);
        ListNode slower = prev;
        ListNode faster = prev;

        prev.next = start;

        while(faster != end){
            slower = slower.next;
            faster = faster.next;
            if(faster != end){
                faster = faster.next;
            }
        }
        return slower;
    }

//    [0, value] means insert(value),
//    [1, value] means is_present(value), and
//    [2, value] means remove(value).

    static ArrayList<Boolean> implement_skip_list(ArrayList<ArrayList<Integer>> operations) {
        ListNode temp = new ListNode(Integer.MIN_VALUE);
        ListNode head = null;
        ArrayList<Boolean> results = new ArrayList<>();

        for(int i = 0; i < operations.size(); i++){
            int operation = operations.get(i).get(0);
            int number = operations.get(i).get(1);

            if(operation == 0){
                // find thePlace
                if(head == null){
                    head = new ListNode(number);
                    temp.next = head;
                    temp = temp.next;
                }
                else{
                    if(head.value > number){
                        ListNode newHead = new ListNode(number);
                        newHead.next = head;
                        head = newHead;
                    }else
                        insertNumber(head, null, number);
                }
            }else if(operation == 1){
                ListNode startNode = head;
                Boolean result = medianHelper(startNode, null, number);
                results.add(result);
            }else{
                if(head != null && head.value == number) {
                    head = head.next;
                }else
                    removeNumber(head, null, number);
            }
        }

        return results;
    }

    public static void removeNumber(ListNode startNode, ListNode endNode, int number){
        if(startNode == null && endNode == null)
            return;

        if(startNode == endNode && startNode.value != number)
            return;

        if(startNode.next != null && startNode.next.value == number){
            ListNode nextNode = startNode.next.next;
            startNode.next = nextNode;
            return;
        }

        ListNode medianPoint = findMedianPoint(startNode, endNode);

        if(medianPoint.next != null && medianPoint.next.value == number){
            ListNode nextNode = medianPoint.next.next;
            medianPoint.next = nextNode;
            return;
        }

        if(medianPoint.next != null && medianPoint.next.value < number){
            removeNumber(medianPoint.next, endNode, number);
        }else{
            removeNumber(startNode, medianPoint, number);
        }
    }

    public static void insertNumber(ListNode startNode, ListNode endNode, int number){
        if(startNode == null){
            return;
        }

        if(endNode != null && endNode.value < number){
            ListNode newNode = new ListNode(number);
            endNode.next = newNode;
            return;
        }

        ListNode medianPoint = findMedianPoint(startNode, endNode);

        if(medianPoint.value == number){
            ListNode newNode = new ListNode(number);
            medianPoint.next = newNode;
            return;
        }

        if(medianPoint.value < number && medianPoint.next != null && medianPoint.next.value > number){
            ListNode tempNext = medianPoint.next;
            ListNode newNode = new ListNode(number);
            medianPoint.next = newNode;
            newNode.next = tempNext;
            return;
        }

        if(medianPoint.value < number){
            if(medianPoint.next == null){
                ListNode newNode = new ListNode(number);
                medianPoint.next = newNode;
                return;
            }
            insertNumber(medianPoint.next, endNode, number);
        }else{
            insertNumber(startNode, medianPoint, number);
        }
    }

    public static Boolean medianHelper(ListNode startNode, ListNode endNode, int number){
        if(startNode == null && endNode == null){
            return false;
        }

        if(startNode == endNode && startNode.value != number)
            return false;

        ListNode medianPoint = findMedianPoint(startNode, endNode);
        if(medianPoint.value == number){
            return true;
        }

        if(medianPoint.value < number){
            return medianHelper(medianPoint.next, endNode, number);
        }else{
            return medianHelper(startNode, medianPoint, number);
        }
    }

    public static void main(String[] args) {

//            "operations": [
//[0, 5],
//[0, 10],
//[0, 1],
//[1, 0],
//[2, 0],
//[1, 1],
//[2, 1],
//[2, 10],
//[0, 10],
//[1, 10]
//]
//        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(0, 5));
//        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(0, 10));
//        ArrayList<Integer> arr3 = new ArrayList<>(Arrays.asList(0, 1));
//        ArrayList<Integer> arr4 = new ArrayList<>(Arrays.asList(1, 0));
//        ArrayList<Integer> arr5 = new ArrayList<>(Arrays.asList(2, 0));
//        ArrayList<Integer> arr6 = new ArrayList<>(Arrays.asList(1, 1));
//
//        ArrayList<Integer> arr7 = new ArrayList<>(Arrays.asList(2, 1));
//        ArrayList<Integer> arr8 = new ArrayList<>(Arrays.asList(2, 10));
//        ArrayList<Integer> arr9 = new ArrayList<>(Arrays.asList(0, 10));
//        ArrayList<Integer> arr10 = new ArrayList<>(Arrays.asList(1, 10));
//
//        ArrayList<ArrayList<Integer>> arrs = new ArrayList<>(Arrays.asList(arr1, arr2, arr3, arr4, arr5,
//                arr6, arr7, arr8, arr9, arr10));
//
//        implement_skip_list(arrs);
//        int a = 4;

//        "operations": [
//[0, 1],
//[2, 1],
//[0, 5],
//[2, 4],
//[0, 5],
//[2, 5],
//[0, 10],
//[1, 9],
//[0, 7],
//[1, 10],
//[2, 7],
//[2, 10]
//]
        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(0, 1));
        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(2, 1));
        ArrayList<Integer> arr3 = new ArrayList<>(Arrays.asList(0, 5));
        ArrayList<Integer> arr4 = new ArrayList<>(Arrays.asList(2, 4));
        ArrayList<Integer> arr5 = new ArrayList<>(Arrays.asList(0, 5));
        ArrayList<Integer> arr6 = new ArrayList<>(Arrays.asList(2, 5));

        ArrayList<Integer> arr7 = new ArrayList<>(Arrays.asList(0, 10));
        ArrayList<Integer> arr8 = new ArrayList<>(Arrays.asList(1, 9));
        ArrayList<Integer> arr9 = new ArrayList<>(Arrays.asList(0, 7));
        ArrayList<Integer> arr10 = new ArrayList<>(Arrays.asList(1, 10));

        ArrayList<Integer> arr11 = new ArrayList<>(Arrays.asList(2, 7));
        ArrayList<Integer> arr12 = new ArrayList<>(Arrays.asList(2, 10));

        ArrayList<ArrayList<Integer>> arrs = new ArrayList<>(Arrays.asList(arr1, arr2, arr3, arr4, arr5,
                arr6, arr7, arr8, arr9, arr10, arr11, arr12));

        ArrayList<Boolean> the_result = implement_skip_list(arrs);
        int a = 4;
    }
}

