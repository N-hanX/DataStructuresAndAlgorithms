package study_program.problemSet.linkedList_stack_queue;

import java.util.*;

public class SkipList_v2 {
    ListNode head;
    Map<Integer, ListNode> nodes;

    static class ListNode {
        Integer value;
        ListNode next;

        ListNode(Integer value) {
            this.value = value;
            this.next = null;
        }
    }

    public SkipList_v2() {
        head = null;
        nodes = new HashMap<>();
    }

    public void insert(int value) {
        ListNode newNode = new ListNode(value);

        if(head == null)
            head = newNode;
        else{
            newNode.next = head;
            head = newNode;
        }

        nodes.put(value, newNode);
    }

    public  Boolean is_present(int value) {
        if(nodes.containsKey(value))
            return true;
        return false;
    }

    public void remove(int value) {
        if(nodes.containsKey(value)){
            ListNode node = nodes.get(value);

            if(node.next != null) {
                node.value = node.next.value;
                node.next = node.next.next;
            }
            nodes.remove(value);
        }
    }

    static ArrayList<Boolean> implement_skip_list(ArrayList<ArrayList<Integer>> operations) {
        SkipList_v2 list = new SkipList_v2();

        ArrayList<Boolean> results = new ArrayList<>();

        for(int i = 0; i < operations.size(); i++){
            int operation = operations.get(i).get(0);
            int number = operations.get(i).get(1);

            if(operation == 0){
                list.insert(number);
            }else if(operation == 1){
                results.add(list.is_present(number));
            }else{
                list.remove(number);
            }
        }

        return results;
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
        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(0, 5));
        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(0, 10));
        ArrayList<Integer> arr3 = new ArrayList<>(Arrays.asList(0, 1));
        ArrayList<Integer> arr4 = new ArrayList<>(Arrays.asList(1, 0));
        ArrayList<Integer> arr5 = new ArrayList<>(Arrays.asList(2, 0));
        ArrayList<Integer> arr6 = new ArrayList<>(Arrays.asList(1, 1));

        ArrayList<Integer> arr7 = new ArrayList<>(Arrays.asList(2, 1));
        ArrayList<Integer> arr8 = new ArrayList<>(Arrays.asList(2, 10));
        ArrayList<Integer> arr9 = new ArrayList<>(Arrays.asList(0, 10));
        ArrayList<Integer> arr10 = new ArrayList<>(Arrays.asList(1, 10));

        ArrayList<ArrayList<Integer>> arrs = new ArrayList<>(Arrays.asList(arr1, arr2, arr3, arr4, arr5,
                arr6, arr7, arr8, arr9, arr10));

        ArrayList<Boolean> the_result = implement_skip_list(arrs);
        int a = 4;

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
//        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(0, 1));
//        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(2, 1));
//        ArrayList<Integer> arr3 = new ArrayList<>(Arrays.asList(0, 5));
//        ArrayList<Integer> arr4 = new ArrayList<>(Arrays.asList(2, 4));
//        ArrayList<Integer> arr5 = new ArrayList<>(Arrays.asList(0, 5));
//        ArrayList<Integer> arr6 = new ArrayList<>(Arrays.asList(2, 5));
//
//        ArrayList<Integer> arr7 = new ArrayList<>(Arrays.asList(0, 10));
//        ArrayList<Integer> arr8 = new ArrayList<>(Arrays.asList(1, 9));
//        ArrayList<Integer> arr9 = new ArrayList<>(Arrays.asList(0, 7));
//        ArrayList<Integer> arr10 = new ArrayList<>(Arrays.asList(1, 10));
//
//        ArrayList<Integer> arr11 = new ArrayList<>(Arrays.asList(2, 7));
//        ArrayList<Integer> arr12 = new ArrayList<>(Arrays.asList(2, 10));
//
//        ArrayList<ArrayList<Integer>> arrs = new ArrayList<>(Arrays.asList(arr1, arr2, arr3, arr4, arr5,
//                arr6, arr7, arr8, arr9, arr10, arr11, arr12));
//
//        implement_skip_list(arrs);
//        int a = 4;
    }
}
