package graph;

import java.util.*;

public class SearchMaze {
    static class Coordinate{
        int x, y;
        public Coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }

        public boolean equals(Object otherObj){
            Coordinate other = (Coordinate) otherObj;

            return other.x == this.x && other.y == this.y;
        }

        public int hashCode(){
            return Objects.hash(x, y);
        }

        public String toString(){
            return "x:" + this.x + " _ y: " + this.y + "\n";
        }
    }
    public static enum Color{WHITE, BLACK};

    // 1 -> wall, 0 -> road
    public static void main(String[] args) {
        List<List<Color>> colors = new ArrayList<>(
                Arrays.asList(
                        Arrays.asList(Color.WHITE, Color.WHITE),
                        Arrays.asList(Color.WHITE, Color.WHITE),
                        Arrays.asList(Color.WHITE, Color.WHITE),
                        Arrays.asList(Color.WHITE, Color.WHITE)
                )
        );
        SearchMaze maze = new SearchMaze();

        List<Coordinate> result = maze.isPathAvailable(colors, new Coordinate(0,0), new Coordinate(3, 1));
        System.out.println(result);
    }



    public List<Coordinate> isPathAvailable(List<List<Color>> maze, Coordinate start, Coordinate end){
        List<Coordinate> result = new ArrayList<>();

        if(!dfs(maze, start, end, result)){
            return Collections.emptyList();
        }
        return result;
    }

    public boolean isReachable(Coordinate nextLocation, List<List<Color>>  maze){
        if(nextLocation.x < 0 || nextLocation.y < 0 ||
                nextLocation.x >= maze.size() || nextLocation.y >= maze.get(0).size() ||
                maze.get(nextLocation.x).get(nextLocation.y) == Color.BLACK){
            return false;
        }
        return true;
    }

    public boolean dfs(List<List<Color>> maze, Coordinate curr, Coordinate end, List<Coordinate> result){
//        System.out.println("coord: " + curr);
        if(!isReachable(curr, maze)){
            return false;
        }

//        System.out.println("coord: " + curr);
        maze.get(curr.x).set(curr.y, Color.BLACK);
        result.add(curr);

        if(curr.equals(end)){
            return true;
        }

        final int[][] movement = new int[][]{{-1, 0,}, {1, 0}, {0, -1}, {0, 1}};

        for(int[] curr_neigh: movement){
            if(dfs(maze, new Coordinate(curr.x + curr_neigh[0], curr.y + curr_neigh[1]), end, result)){
                return true;
            }
        }
        result.remove(result.size() - 1);
        return false;
    }
}
