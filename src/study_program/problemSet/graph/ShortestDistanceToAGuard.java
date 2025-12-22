package study_program.problemSet.graph;

import java.util.*;

public class ShortestDistanceToAGuard {
    public static void main(String[] args) {


//            'grid': [
//['O', 'O', 'O', 'O', 'G'],
//['O', 'W', 'W', 'O', 'O'],
//['O', 'O', 'O', 'W', 'O'],
//['G', 'W', 'W', 'W', 'O'],
//['O', 'O', 'O', 'O', 'G']
//]


        ArrayList<ArrayList<Character>> grid = new ArrayList<>();
        grid.add(new ArrayList<>(Arrays.asList('O', 'O', 'O', 'O', 'G')));
        grid.add(new ArrayList<>(Arrays.asList('O', 'W', 'W', 'O', 'O')));
        grid.add(new ArrayList<>(Arrays.asList('O', 'O', 'O', 'W', 'O')));
        grid.add(new ArrayList<>(Arrays.asList('G', 'W', 'W', 'W', 'O')));
        grid.add(new ArrayList<>(Arrays.asList('O', 'O', 'O', 'O', 'G')));

        ArrayList<ArrayList<Integer>> result = find_shortest_distance_from_a_guard(grid);

        int a = 4;
    }

    static ArrayList<ArrayList<Integer>> find_shortest_distance_from_a_guard(
            ArrayList<ArrayList<Character>> grid) {

        int rowLength = grid.size();
        int colLength = grid.get(0).size();
        ArrayList<ArrayList<Integer>> distance = new ArrayList<>();

        for(int i = 0; i < rowLength; i++){
            ArrayList<Integer> currRow = new ArrayList<>();
            for(int j = 0; j < colLength; j++){
                currRow.add(-1);
            }
            distance.add(currRow);
        }

        Set<Point> visited = new HashSet<>();
        Queue<Point> queue = new LinkedList<>();
        for(int i = 0; i < rowLength; i++){
            for(int j = 0; j < colLength; j++){
                char currChar = grid.get(i).get(j);

                if(currChar == 'G'){
                    distance.get(i).set(j, 0);
                    Point p = new Point(i, j,0, 'G');
                    queue.add(p);
                }
            }
        }

        while(!queue.isEmpty()){
            Point currPoint = queue.poll();

            if(visited.contains(currPoint))
                continue;

            visited.add(currPoint);
            distance.get(currPoint.row).set(currPoint.col, currPoint.dist);

            if(currPoint.character == 'W')
                continue;

            ArrayList<ArrayList<Integer>> neighbors = getNeighbors(currPoint.row, currPoint.col, grid);
            for(int i = 0; i < neighbors.size(); i++){
                ArrayList<Integer> currNeighbor = neighbors.get(i);
                int row = currNeighbor.get(0);
                int col = currNeighbor.get(1);
                char character = grid.get(row).get(col);
                int dist = currPoint.dist + 1;

                Point newNeighbor = new Point(row, col, dist, character);
                queue.add(newNeighbor);
            }
        }

        return distance;
    }

    static class Point{
        int row;
        int col;
        int dist;
        char character;

        public Point(int row, int col, int dist, char character){
            this.row = row;
            this.col = col;
            this.dist = dist;
            this.character = character;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return row == point.row && col == point.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }

    static ArrayList<ArrayList<Integer>> getNeighbors(int currRow, int currCol, ArrayList<ArrayList<Character>> grid){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if(currRow - 1 >= 0 && currRow - 1 < grid.size() && grid.get(currRow - 1).get(currCol) != 'W' &&
                grid.get(currRow - 1).get(currCol) != 'G'){
            ArrayList<Integer> theNeighbor = new ArrayList<>();
            theNeighbor.add(currRow - 1);
            theNeighbor.add(currCol);
            result.add(theNeighbor);
        }
        if(currRow + 1 >= 0 && currRow + 1 < grid.size() && grid.get(currRow + 1).get(currCol) != 'W' &&
                grid.get(currRow + 1).get(currCol) != 'G'){
            ArrayList<Integer> theNeighbor = new ArrayList<>();
            theNeighbor.add(currRow + 1);
            theNeighbor.add(currCol);
            result.add(theNeighbor);
        }

        if(currCol + 1 >= 0 && currCol + 1 < grid.get(0).size() && grid.get(currRow).get(currCol + 1) != 'W' &&
                grid.get(currRow).get(currCol + 1) != 'G'){
            ArrayList<Integer> theNeighbor = new ArrayList<>();
            theNeighbor.add(currRow);
            theNeighbor.add(currCol + 1);
            result.add(theNeighbor);
        }
        if(currCol - 1 >= 0 && currCol - 1 < grid.size() && grid.get(currRow).get(currCol - 1) != 'W' &&
                grid.get(currRow).get(currCol - 1) != 'G'){
            ArrayList<Integer> theNeighbor = new ArrayList<>();
            theNeighbor.add(currRow);
            theNeighbor.add(currCol - 1);
            result.add(theNeighbor);
        }
        return result;
    }

}
