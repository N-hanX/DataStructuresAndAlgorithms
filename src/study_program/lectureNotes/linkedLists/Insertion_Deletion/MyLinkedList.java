package study_program.lectureNotes.linkedLists.Insertion_Deletion;

public class MyLinkedList {
    public static void main(String[] args) {
        // ["MyLinkedList","addAtHead","get","addAtHead","addAtHead","deleteAtIndex","addAtHead","get","get","get",
        // "addAtHead","deleteAtIndex"]
        // [[],[4],[1],[1],[5],[3],[7],[3],[3],[3],[1],[4]]

        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(4);
        linkedList.get(1);
        linkedList.addAtHead(1);
        linkedList.addAtHead(5);
        linkedList.deleteAtIndex(3);
        linkedList.addAtHead(7);
        linkedList.get(3);
        linkedList.get(3);
        linkedList.get(3);
        linkedList.addAtHead(1);
        linkedList.deleteAtIndex(4);

        // ["MyLinkedList","addAtTail","get"]
        // [[],[1],[0]]
//        MyLinkedList linkedList = new MyLinkedList();
//        linkedList.addAtTail(1);
//        linkedList.get(0);

        // ["MyLinkedList","addAtHead","addAtTail","addAtIndex","get","deleteAtIndex","get"]
        // [[],[1],[3],[1,2],[1],[1],[1]]
//        MyLinkedList linkedList = new MyLinkedList();
//        linkedList.addAtHead(1);
//        linkedList.addAtTail(3);
//        linkedList.addAtIndex(1,2);
//        linkedList.get(1);
//        linkedList.deleteAtIndex(1);
//        linkedList.get(1);

        int a = 4;
    }

    class Node{
        int val;
        Node next;

        public Node(int val){
            this.val = val;
            this.next = null;
        }
    }

    Node head;
    public MyLinkedList() {
        this.head = null;
    }

    public int get(int index) {
        Node walkingNode = head;

        int counter = 0;
        while(counter < index && walkingNode != null){
            walkingNode = walkingNode.next;
            counter++;
        }
        if(walkingNode != null)
            return walkingNode.val;
        else
            return -1;
    }

    public void addAtHead(int val) {
        Node node = new Node(val);

        if (this.head != null) {
            node.next = head;
        }
        this.head = node;
    }

    public void addAtTail(int val) {
        if(this.head == null){
            this.head = new Node(val);
            return;
        }

        Node theTailNode = head;

        while(theTailNode.next != null){
            theTailNode = theTailNode.next;
        }

        Node newNode = new Node(val);
        theTailNode.next = newNode;
    }

    public void addAtIndex(int index, int val) {
        if(index == 0){
            addAtHead(val);
            return;
        }

        int counter = 1;
        Node prevNode = head;
        Node newNode = new Node(val);

        while(counter < index && prevNode != null){
            prevNode = prevNode.next;
            counter++;
        }
        if(prevNode == null)
            return;

        Node tempNextNode = prevNode.next;
        prevNode.next = newNode;
        newNode.next = tempNextNode;
    }

    public void deleteAtIndex(int index) {
        if(index == 0){
            Node nextHead = head.next;
            head = nextHead;
            return;
        }

        int counter = 1;
        Node prevNode = head;

        while(counter < index && prevNode != null){
            prevNode = prevNode.next;
            counter++;
        }
        if(prevNode == null)
            return;

        Node nextNode = prevNode.next;
        if(nextNode != null){
            nextNode = nextNode.next;
        }
        prevNode.next = nextNode;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
