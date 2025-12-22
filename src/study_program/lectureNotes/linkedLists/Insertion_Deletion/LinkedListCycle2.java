package study_program.lectureNotes.linkedLists.Insertion_Deletion;

public class LinkedListCycle2 {
    public static void main(String[] args) {
        LinkedListNode node0 = new LinkedListNode(0);
        LinkedListNode node1 = new LinkedListNode(1);
        LinkedListNode node2 = new LinkedListNode(2);
        LinkedListNode node3 = new LinkedListNode(3);
        LinkedListNode node4 = new LinkedListNode(4);

        LinkedListNode node5 = new LinkedListNode(5);
        LinkedListNode node6 = new LinkedListNode(6);
        LinkedListNode node7 = new LinkedListNode(7);
        LinkedListNode node8 = new LinkedListNode(8);

        LinkedListNode node9 = new LinkedListNode(9);
        LinkedListNode node10 = new LinkedListNode(10);
        LinkedListNode node11 = new LinkedListNode(11);
        LinkedListNode node12 = new LinkedListNode(12);

        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;

        node9.next = node10;
        node10.next = node11;
        node11.next = node12;
        node12.next = node4;

        LinkedListNode headOfCycle = getCycleHeadIndex(node1);

        int a = 5;
    }

    public static LinkedListNode getCycleHeadIndex(LinkedListNode head) {
        LinkedListNode hasCycleResult = hasCycle(head);

        if(hasCycleResult == null)
            return null;

        LinkedListNode nodeInCycle = hasCycleResult;


        // find cycle size

        int lenOfCycle = findCycleSize(nodeInCycle);


        return getTheStartOfCycle(hasCycleResult, head, lenOfCycle);
    }

    public static LinkedListNode getTheStartOfCycle(LinkedListNode nodeInCycle, LinkedListNode head, int lenOfCycle){
        // find the first node which is not in cycle then assign the next to. That is the start of cycle

        LinkedListNode walkingNode = head;
        LinkedListNode tempNodeInCycle = nodeInCycle;
        int indexOfTheNodeInCycle = 0;

        while(walkingNode != nodeInCycle){
            indexOfTheNodeInCycle++;
            walkingNode = walkingNode.next;
        }

        walkingNode = head;
        // binary search yaparak gezerim.

        int startInd = 0;
        int endInd = indexOfTheNodeInCycle;
        int mediumInd = startInd + (endInd - startInd) / 2;

        while(startInd < endInd){
            // find the node in mediumIndex then check is it cycle
            LinkedListNode theControllerNode = theNthNode(head, mediumInd);
            boolean checkTheNodeInCycle = isTheNodeInCycle(theControllerNode, lenOfCycle);

            if(checkTheNodeInCycle == true){
                endInd = mediumInd;
            }else{
                startInd = mediumInd;
            }

            mediumInd = startInd + (endInd - startInd) / 2;
            if(startInd == mediumInd || endInd == mediumInd){
                return theControllerNode;
            }
        }
        return theNthNode(head, mediumInd);
    }

    public static int findCycleSize(LinkedListNode nodeInCycle){
        int cycleLenCounter = 1;

        LinkedListNode temp = nodeInCycle.next;

        while(temp != nodeInCycle){
            temp = temp.next;
            cycleLenCounter++;
        }
        return cycleLenCounter;
    }

    public static boolean isTheNodeInCycle(LinkedListNode controllerNode, int lenOfCycle){
        LinkedListNode temp = controllerNode;
        temp = temp.next;

        int counter = 1;

        while(temp != controllerNode){
            temp = temp.next;
            counter++;
            if(counter == lenOfCycle && temp != controllerNode)
                return false;
            // how to end this
        }
        return true;
    }

    public static LinkedListNode theNthNode(LinkedListNode head, int theNthNode){
        int count = 0;

        while(count < theNthNode){
            head = head.next;
            count++;
        }
        return head;
    }



    public static LinkedListNode hasCycle(LinkedListNode head){
        LinkedListNode slowPointer = head;
        LinkedListNode fastPointer = head;

        while( (slowPointer == head) || (slowPointer != head && slowPointer != fastPointer)){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;

            if(fastPointer == null){
                return null;
            }
            fastPointer = fastPointer.next;
        }

        return slowPointer;
    }
}
