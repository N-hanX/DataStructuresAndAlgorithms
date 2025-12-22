package graph;

import java.awt.desktop.PreferencesEvent;
import java.util.*;

public class ShortestPathIn2DGridWithKeysAndDoors {
    public static void main(String[] args) {
        ArrayList<String> grid = new ArrayList<>(Arrays.asList("...B",".b#.", "@#+."));

        find_shortest_path(grid);

    }


    static ArrayList<ArrayList<Integer>> find_shortest_path(ArrayList<String> grid) {
        Set<Location> visitedLocations = new HashSet<>();
        ArrayList<ArrayList<Location>> allResults = new ArrayList<>();
        ArrayList<Location> currPath = new ArrayList<>();
        Set<Character> keys = new HashSet<>();
        traverseGrid(grid, visitedLocations, allResults, currPath, keys, 0, 0);

        int max = -1;
        ArrayList<Location> result = null;
        for(int i = 0; i < allResults.size(); i++){
            if(allResults.get(i).size() > max){
                max = allResults.get(i).size();
                result = allResults.get(i);
            }
        }

        ArrayList<ArrayList<Integer>> int_result = new ArrayList<>();

        for(int i = 0; i < result.size(); i++){
            int row = result.get(i).rowInd;
            int col = result.get(i).colInd;

            int_result.add(new ArrayList<>(Arrays.asList(row, col)));
        }

        return int_result;
    }

    static Boolean startIsFound = false;

    static void traverseGrid(ArrayList<String> grid, Set<Location> visitedLocations,
                             ArrayList<ArrayList<Location>> allResults, ArrayList<Location> currPath,
                             Set<Character> keys, int rowInd, int colInd){

        if(rowInd < 0 || colInd < 0 || rowInd >= grid.size() || colInd >= grid.get(0).length()){
            return;
        }

        Location location = new Location(rowInd, colInd);

        if(visitedLocations.contains(location)){
            return;
        }
//        System.out.println(rowInd + "-" + colInd);

        visitedLocations.add(location);
        char currChar = grid.get(rowInd).charAt(colInd);

        if(startIsFound) {
            if (currChar == '.') {
                currPath.add(location);
            } else if (currChar == '#') {
                return;
            } else if (currChar == '+') {
                currPath.add(location);
                ArrayList<Location> newPath = new ArrayList<>(currPath);
                allResults.add(newPath);
                currPath.remove(currPath.size() - 1);
                return;
            }else if(Character.isAlphabetic(currChar) && Character.isUpperCase(currChar)){
                // it is a door
                char its_key = Character.toLowerCase(currChar);
                if(keys.contains(its_key)){
                    currPath.add(location);
                }else{
                    return;
                }
            }else if(Character.isAlphabetic(currChar) && Character.isLowerCase(currChar)){
                keys.add(currChar);
                currPath.add(location);
            }else{
                return;
            }
        }

        if(grid.get(rowInd).charAt(colInd) == '@'){
            visitedLocations = new HashSet<>();
            visitedLocations.add(location);
            startIsFound = true;
            currPath.add(location);
        }


        traverseGrid(grid, visitedLocations, allResults, currPath, keys, rowInd + 1, colInd);


        traverseGrid(grid, visitedLocations, allResults, currPath, keys, rowInd, colInd + 1);

        traverseGrid(grid, visitedLocations, allResults, currPath, keys, rowInd, colInd - 1);


        traverseGrid(grid, visitedLocations, allResults, currPath, keys, rowInd - 1, colInd);


        if(currChar == '@'){
            startIsFound = false;
        }

//        System.out.println("final" + rowInd + "-" + colInd);


        if(currPath.size() > 0)
            currPath.remove(currPath.size() - 1);
        visitedLocations.remove(location);
        keys.remove(currChar);
    }

    static class Location{
        int rowInd;
        int colInd;

        public Location(int rowInd, int colInd){
            this.colInd = colInd;
            this.rowInd = rowInd;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Location location = (Location) o;
            return rowInd == location.rowInd && colInd == location.colInd;
        }

        @Override
        public int hashCode() {
            return Objects.hash(rowInd, colInd);
        }

        //        @Override
//        public boolean equals(Object other) {
//            Location locationObj = (Location)other;
//            if(this.colInd == locationObj.colInd && this.rowInd == locationObj.rowInd){
//                return true;
//            }
//            return false;
//        }
    }


}
