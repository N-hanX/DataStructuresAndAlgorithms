package recursion.problemSet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class nqueenProblem {

    public static void main(String[] args) {
        int n = 5;
        find_all_arrangements(n);
    }

    static String[][] find_all_arrangements(int n) {
        List<Integer> currList = new ArrayList<>();
        Set<Integer> columns = new HashSet<>();
        Set<Integer> leftDiagonals = new HashSet<>();
        Set<Integer> rightDiagonals = new HashSet<>();
        List<List<Integer>> allResults = new ArrayList<>();

        helper(0, currList, columns, leftDiagonals, rightDiagonals, n, allResults);

        String[][] result = new String[allResults.size()][currList.size()];


        for(int i = 0; i < allResults.size(); i++){
            String[] currResult = new String[n];
            List<Integer> currStringList = allResults.get(i);

            for(int currRow = 0; currRow < n; currRow++){
                String currRowString = "";
                for(int currCol = 0; currCol < n; currCol++){
                    if(currStringList.get(currRow) == currCol){
                        currRowString = currRowString + "q";
                    }else{
                        currRowString = currRowString + "-";
                    }
                }
                currResult[currRow] = currRowString;
            }
            result[i] = currResult;
        }
        return result;
    }


    public static void helper (int currRow, List<Integer> currList, Set<Integer> columns,
                               Set<Integer> leftDiagonals, Set<Integer> rightDiagonals, int n, List<List<Integer>> allResults){
        if( currRow == n){
            List<Integer> copyList = new ArrayList<>(currList);
            allResults.add(copyList);
            return;
        }

        for(int currColumn = 0; currColumn < n; currColumn++){
            if(is_safe(currList, currRow, currColumn, columns, leftDiagonals, rightDiagonals)){
                currList.add(currColumn);
                columns.add(currColumn);
                leftDiagonals.add(currRow - currColumn);
                rightDiagonals.add(currRow + currColumn);

                helper(currRow + 1, currList, columns, leftDiagonals, rightDiagonals, n,allResults);

                currList.remove(currList.size() - 1);
                columns.remove(currColumn);
                leftDiagonals.remove(currRow - currColumn);
                rightDiagonals.remove(currRow + currColumn);
            }
        }
    }

    public static boolean is_safe(List<Integer> currList, int currRow, int currColumn, Set<Integer> columns,
                                  Set<Integer> leftDiagonals, Set<Integer> rightDiagonals){
        if(currList.isEmpty()){
            return true;
        }
        if(columns.contains(currColumn)){
           return false;
        }else{
            // bir onceki satirdaki column solunda mi sagin da mi?
            if(currList.get(currRow - 1) - 1 == currColumn || currList.get(currRow - 1) + 1 == currColumn){
                return false;
            }
            // diagonal uzerinde sah var mi
            if(leftDiagonals.contains(currRow - currColumn)  || rightDiagonals.contains(currRow + currColumn)){
                return false;
            }
        }
        return true;
    }
}
