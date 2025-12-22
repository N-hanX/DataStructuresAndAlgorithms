package study_lc;

import java.util.*;

public class RottingOranges {
    public static void main(String[] args) {
//        int[][] grid = new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
//
////        [[2,1,1],[0,1,1],[1,0,1]]
//        int[][] grid = new int[][]{{2,1,1},{0,1,1},{1,0,1}};

        int[][] grid = new int[][]{{0,2}};

        int result = orangesRotting(grid);

        int a = 4;
    }

    static class Coordinate{
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coordinate that = (Coordinate) o;
            return x == that.x && y == that.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public static int orangesRotting(int[][] grid) {
        Queue<Coordinate> rottenCoordinates = new LinkedList<>();
        Set<Coordinate> visited = new HashSet<>();

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2){
                    rottenCoordinates.add(new Coordinate(i, j));
                }
            }
        }

        int time = 0;

        while(!rottenCoordinates.isEmpty()){
            int currSize = rottenCoordinates.size();

            int sizeCounter = 0;

            while(sizeCounter < currSize){
                Coordinate currCoordinate = rottenCoordinates.poll();

                if(visited.contains(currCoordinate)){
                    break;
                }

                visited.add(currCoordinate);

                int x = currCoordinate.x;
                int y = currCoordinate.y;

                if(x > 0 && grid[x - 1][y] == 1){
                    Coordinate newCoordinate = new Coordinate(x - 1, y);
                    grid[x - 1][y] = 2;
                    if(!visited.contains(newCoordinate)){
                        rottenCoordinates.add(newCoordinate);
                    }
                }

                if(y > 0 && grid[x][y - 1] == 1){
                    Coordinate newCoordinate = new Coordinate(x, y - 1);
                    grid[x][y - 1] = 2;
                    if(!visited.contains(newCoordinate)){
                        rottenCoordinates.add(newCoordinate);
                    }
                }

                if(y + 1 < grid[0].length && grid[x][y + 1] == 1){
                    Coordinate newCoordinate = new Coordinate(x, y + 1);
                    grid[x][y + 1] = 2;
                    if(!visited.contains(newCoordinate)){
                        rottenCoordinates.add(newCoordinate);
                    }
                }

                if(x + 1 < grid.length && grid[x + 1][y] == 1){
                    Coordinate newCoordinate = new Coordinate(x + 1, y);
                    grid[x + 1][y] = 2;
                    if(!visited.contains(newCoordinate)){
                        rottenCoordinates.add(newCoordinate);
                    }
                }

                sizeCounter++;
            }
            if(!rottenCoordinates.isEmpty())
                time++;
        }

        // if there is any left fresh
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }

        return time;
    }
}
