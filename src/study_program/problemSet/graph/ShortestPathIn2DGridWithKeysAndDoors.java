package study_program.problemSet.graph;

import java.util.*;

public class ShortestPathIn2DGridWithKeysAndDoors {
    public static void main(String[] args) {
//        ArrayList<String> list = new ArrayList<>(Arrays.asList("...B", ".b#.", "@#+."));
//        ArrayList<String> list = new ArrayList<>(Arrays.asList(
//        "+B...",
//        "####.",
//        "##b#.",
//        "a...A",
//        "##@##"));


        ArrayList<String> list = new ArrayList<>(Arrays.asList(
                "...B",
                ".b#.",
                "@#+."));
        ArrayList<ArrayList<Integer>> result = find_shortest_path(list);

        int a = 4;
    }

    static ArrayList<ArrayList<Integer>> find_shortest_path(ArrayList<String> grid) {
        return bfs(grid);
    }

    static ArrayList<ArrayList<Integer>> bfs(ArrayList<String> grid){
        Point startPoint = getStartPoint(grid);

        Set<Point> visited = new HashSet<>();
        Set<Character> keys = new HashSet<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<ArrayList<Integer>> bestResult = new ArrayList<>();

        Queue<Point> pathQueue = new LinkedList<>();
        pathQueue.add(startPoint);

        while(!pathQueue.isEmpty()) {
            Point currPoint = pathQueue.poll();
            int rowInd = currPoint.rowInd;
            int colInd = currPoint.colInd;

            if (rowInd < 0 || colInd < 0 || rowInd >= grid.size() || colInd >= grid.get(0).length()) {
                continue;
            }

            if (visited.contains(currPoint)) {
                continue;
            }

            char currChar = grid.get(rowInd).charAt(colInd);

            if (currChar == '@') {
                visited.add(currPoint);
                result.add(new ArrayList<>(Arrays.asList(rowInd, colInd)));
            }

            if (currChar == '+') {// the end
                visited.add(currPoint);
                result.add(new ArrayList<>(Arrays.asList(rowInd, colInd)));
                if(bestResult.isEmpty())
                    bestResult.addAll(result);
                if(bestResult.size() > result.size()){
                    bestResult = null;
                    bestResult.addAll(result);
                }
                continue;
            }

            if (currChar == '.') {
                visited.add(currPoint);
                result.add(new ArrayList<>(Arrays.asList(rowInd, colInd)));
            }

            if (currChar == '#') { // bunu at
                visited.add(currPoint);
                continue;
            }

            // sol komsusunu ekle musaitse ekle

            if (Character.isUpperCase(currChar) && keys.contains(Character.toLowerCase(currChar))) {
                // islem yapabilirsin
                visited.add(currPoint);
                result.add(new ArrayList<>(Arrays.asList(rowInd, colInd)));
            }

            if (Character.isUpperCase(currChar) && !keys.contains(Character.toLowerCase(currChar))) {
                continue;
            }

            if (Character.isLowerCase(currChar)) {
                visited.add(currPoint);
                result.add(new ArrayList<>(Arrays.asList(rowInd, colInd)));
                keys.add(currChar);
            }

            pathQueue.add(new Point(rowInd, colInd - 1));
            pathQueue.add(new Point(rowInd, colInd + 1));
            pathQueue.add(new Point(rowInd - 1, colInd));
            pathQueue.add(new Point(rowInd + 1, colInd));
        }
        return bestResult;
    }

    static class Point{
        Integer rowInd;
        Integer colInd;

        public Point(Integer rowInd, Integer colInd){
            this.rowInd = rowInd;
            this.colInd = colInd;
        }

        @Override
        public int hashCode() {
            return this.rowInd.hashCode() + this.colInd.hashCode();
        }

        @Override
        public boolean equals(Object o) {
            Point otherPoint = (Point)o;

            if(this.rowInd == otherPoint.rowInd && this.colInd == otherPoint.colInd){
                return true;
            }
            return false;
        }
    }

    public static Point getStartPoint(ArrayList<String> grid){
        int rowLength = grid.size();
        int colLength = grid.get(0).length();

        for(int i = 0; i < rowLength; i++){
            for(int j = 0; j < colLength; j++){
                if(grid.get(i).charAt(j) == '@'){
                    return new Point(i, j);
                }
            }
        }
        return null;
    }
}
