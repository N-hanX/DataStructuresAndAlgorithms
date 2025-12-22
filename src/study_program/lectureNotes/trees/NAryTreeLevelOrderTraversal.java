package study_program.lectureNotes.trees;

import java.util.*;

public class NAryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node3 = new Node(3);
        Node node2 = new Node(2);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        node1.children = new ArrayList<>(Arrays.asList(node3, node2, node4));
        node3.children = new ArrayList<>(Arrays.asList(node5, node6));

        List<List<Integer>> result = levelOrder(node1);

        int a = 5;
    }

    public static List<List<Integer>> levelOrder(Node root) {
        if(root == null)
            return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty()){
            int level_size = queue.size();
            List<Integer> currLevelNode = new ArrayList<>();
            int temp = 0;

            while(temp < level_size){
                Node node = queue.poll();
                currLevelNode.add(node.val);

                if(node.children != null){
                    queue.addAll(node.children);
                }
                temp++;
            }
            result.add(currLevelNode);
        }
        return result;
    }


    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
