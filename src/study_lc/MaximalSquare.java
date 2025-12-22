package study_lc;

import java.util.LinkedList;
import java.util.Queue;

public class MaximalSquare {
    public static void main(String[] args) {
        char[][] matrix = new char[][]
                {{'1','0','1','0','0'},
                 {'1','0','1','1','1'},
                 {'1','1','1','1','1'},
                 {'1','0','0','1','0'}};

//        char[][] matrix = new char[][]{{'0', '1'}};
//        char[][] matrix = new char[][]{{'1', '1'}, {'1', '1'}};

//        char[][] matrix = new char[][]
//                {{'1','1','1','1','1'},
//                {'1','1','1','1','1'},
//                {'0','0','0','0','0'},
//                {'1','1','1','1','1'},
//                {'1','1','1','1','1'}};

////
//        char[][] matrix = new char[][]
//                {{'1','1','1','1','0'},
//                {'1','1','1','1','0'},
//                {'1','1','1','1','1'},
//                {'1','1','1','1','1'},
//                {'0','0','1','1','1'}};

        int result = maximalSquare(matrix);
        int a = 4;
    }

    static class Coordinate{
        int x;
        int y;
        public Coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static int maximalSquare(char[][] matrix) {
        int max_val = 0;

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(max_val == 0 && matrix[i][j] == '1'){
                    max_val = 1;
                }
                boolean[][] visited = new boolean[matrix.length][matrix[0].length];
                max_val = bfs(matrix, i, j, max_val, visited);
            }
        }
        return max_val;
    }

    public static int bfs(char[][] matrix, int x, int y, int max_val, boolean[][] visited){
        Queue<Coordinate> neighbors = new LinkedList<>();

        neighbors.add(new Coordinate(x, y));
        boolean is_done = false;
        int curr_val = 0;

        while (!neighbors.isEmpty()){
            int neighbor_size = neighbors.size();

            int counter = 0;

            boolean is_all_neighbor_one = true;

            while(counter < neighbor_size){
                Coordinate currCoordinate = neighbors.poll();

                int curr_x = currCoordinate.x;
                int curr_y = currCoordinate.y;

                if(curr_x > matrix.length - 1 || curr_y > matrix[0].length - 1){
                    is_done = true;
                    is_all_neighbor_one = false;
                    break;
                }

                if(matrix[curr_x][curr_y] == '0'){
                    is_done = true;
                    is_all_neighbor_one = false;
                    break;
                }else{
                    // add new neighbor

                    if( curr_x + 1 == matrix.length || curr_y + 1 == matrix[0].length){
                        is_done = true;
                    } else if( curr_x + 1 <= matrix.length - 1 && curr_y + 1 <= matrix[0].length - 1){
                        if(!visited[curr_x + 1][curr_y + 1]){
                            neighbors.add(new Coordinate(curr_x + 1, curr_y + 1));
                            visited[curr_x + 1][curr_y + 1] = true;
                        }
                        if(!visited[curr_x][curr_y + 1]){
                            neighbors.add(new Coordinate(curr_x, curr_y + 1));
                            visited[curr_x][curr_y + 1] = true;
                        }
                        if(!visited[curr_x + 1][curr_y]){
                            neighbors.add(new Coordinate(curr_x + 1, curr_y));
                            visited[curr_x + 1][curr_y] = true;
                        }
                    }
                }
                counter++;
            }
            if(is_all_neighbor_one){
                curr_val = curr_val + neighbor_size;
            }
            if(is_done)
                break;
        }

        if(curr_val > max_val)
            return curr_val;

        return max_val;
    }
}
