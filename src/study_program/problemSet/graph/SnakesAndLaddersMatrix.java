package study_program.problemSet.graph;

import java.util.*;

public class SnakesAndLaddersMatrix {
    public static void main(String[] args) {
//        ArrayList<Integer> moves = new ArrayList<>(Arrays.asList(
//                -1, 18, -1, -1, -1, -1, -1, -1, 2, -1, -1, 15, -1, -1, -1, -1, -1, -1, -1, -1));
//        int n = 20;
//
//        ArrayList<Integer> moves = new ArrayList<>(Arrays.asList(
//                -1, -1, -1, -1, -1, -1, -1, -1));
//        int n = 8;

//        ArrayList<Integer> moves = new ArrayList<>(Arrays.asList(
//                -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 3, -1, 3, -1, -1, -1, -1, -1, -1));
//        int n = 19;

        ArrayList<Integer> moves = new ArrayList<>(Arrays.asList(
                -1, -1, -1, 1, -1, -1, -1, -1, -1, 15, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
                -1, 45, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 41, -1, -1, -1, -1, -1));
        int n = 46;

        Integer result = minimum_number_of_rolls(n, moves);

        int a = 4;
    }

    static Integer minimum_number_of_rolls(Integer n, ArrayList<Integer> moves) {
        boolean[] visited = new boolean[n];

        Queue<Node> queue = new LinkedList<>();

        Node node = new Node();
        node.index = 0;
        node.dist = 0;
        queue.add(node);

        while(!queue.isEmpty()){
            node = queue.poll();

            if(visited[node.index]){
                continue;
            }

            visited[node.index] = true;

            if(node.index == n - 1){
                return node.dist;
            }

            for(int i = 1; i <= 6; i++){
                int goes_to = node.index + i;

                if(goes_to >= n){
                    break;
                }

                int snake_ladder = moves.get(goes_to);

                if(snake_ladder != -1){
                    System.out.println ("snake_ladder:" + snake_ladder);
                    goes_to = snake_ladder;
                }

                Node new_node = new Node();
                new_node.index = goes_to;
                new_node.dist = node.dist + 1;
                queue.add(new_node);

                System.out.println(node.index + " ->" + new_node.index + " :dist:" + new_node.dist);
            }
        }
        return -1;
    }

    static class Node{
        int index;
        int dist;
    }
}