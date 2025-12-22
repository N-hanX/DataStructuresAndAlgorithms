package study_lc.study4_m;

import java.util.ArrayList;
import java.util.Collections;

public class LowestCommonAncestorOfBinaryTreeIII_1650 {
    public static void main(String[] args) {
        Node node_3 = new Node(3);
        Node node_5 = new Node(5);
        Node node_6 = new Node(6);
        Node node_2 = new Node(2);
        Node node_7 = new Node(7);
        Node node_4 = new Node(4);
        Node node_1 = new Node(1);
        Node node_0 = new Node(0);
        Node node_8 = new Node(8);
        Node node_10 = new Node(10);

        node_3.left = node_5;
        node_3.right = node_1;
        node_3.parent = null;

        node_5.left = node_6;
        node_5.right = node_2;
        node_5.parent = node_3;

        node_6.parent = node_5;

        node_7.parent = node_2;
        node_10.parent = node_4;

        node_2.left = node_7;
        node_2.right = node_4;
        node_2.parent = node_5;

        node_4.right = node_10;
        node_4.parent = node_2;

        node_1.left = node_0;
        node_1.right = node_8;
        node_1.parent = node_3;

        node_0.parent = node_1;
        node_8.parent = node_1;

//        Node result = lowestCommonAncestor(node_5, node_4);
        Node result = lowestCommonAncestor(node_3, node_0);

        int a = 4;
    }

    static ArrayList<Node> firstParentList;
    static ArrayList<Node> secondParentList;

    public static Node lowestCommonAncestor(Node p, Node q) {
        firstParentList = new ArrayList<>();
        secondParentList = new ArrayList<>();

        Node temp_p = p;
        while(temp_p != null){
            firstParentList.add(temp_p);
            temp_p = temp_p.parent;
        }
        Collections.reverse(firstParentList);

        Node temp_q = q;
        while(temp_q != null){
            secondParentList.add(temp_q);
            temp_q = temp_q.parent;
        }
        Collections.reverse(secondParentList);

        Node last_node = firstParentList.get(0);
        for(int i = 0; i < firstParentList.size() && i < secondParentList.size(); i++){
            if(firstParentList.get(i).equals(secondParentList.get(i))){
                last_node = firstParentList.get(i);
            }
        }

        return last_node;
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int val){
            this.val = val;
        }
    }
}
