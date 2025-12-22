package study_program.lectureNotes.linkedLists.Insertion_Deletion;

import java.util.HashMap;
import java.util.Map;

public class PseudoRandomNumbers {
    public static void main(String[] args) {
        createPseudoRandomNumbers(5, 3, 8, 21);
    }

    static void createPseudoRandomNumbers(int L, int Z, int i, int M){
        LinkedListNode head = new LinkedListNode(L);
        LinkedListNode walkingNode = head;

        Map<Integer, LinkedListNode> randomNumbers = new HashMap<>();

        randomNumbers.put(L, head);

        int newRandom = calculateNextNumber(L, Z, i, M);
        LinkedListNode newRandomNode = new LinkedListNode(newRandom);
        LinkedListNode prevNode = walkingNode;

        while(!randomNumbers.containsKey(newRandom)){
            // already calculated
            randomNumbers.put(newRandom, newRandomNode);
            walkingNode.next = newRandomNode;
            walkingNode = walkingNode.next;
            prevNode = walkingNode;

            //next step
            newRandom = calculateNextNumber(newRandom, Z, i, M);
            newRandomNode = new LinkedListNode(newRandom);

            //check point
            if(randomNumbers.containsKey(newRandom))
                break;
        }

        LinkedListNode headOfCycle = randomNumbers.get(newRandom);
        prevNode.next = headOfCycle;



        int lengthOfCycle = lengthOfCycle(headOfCycle);

        int a = 5;
    }

    static int lengthOfCycle(LinkedListNode head){
        LinkedListNode walkingNode = head;
        walkingNode = walkingNode.next;

        int count = 1;
        while(walkingNode != head){
            walkingNode = walkingNode.next;
            count++;
        }
        return count;
    }

    static int calculateNextNumber(int L, int Z, int i, int M){
        return ((Z * L) + i) % M;
    }

}
