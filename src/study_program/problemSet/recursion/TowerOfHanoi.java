package study_program.problemSet.recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class TowerOfHanoi {
    public static void main(String[] args) {
        int n = 4;

        ArrayList<ArrayList<Integer>> results = tower_of_hanoi(n);

        int a = 4;

    }

    static ArrayList<ArrayList<Integer>> tower_of_hanoi(Integer n) {
        ArrayList<Integer> tower1 = new ArrayList<>();
        ArrayList<Integer> tower2 = new ArrayList<>();
        ArrayList<Integer> tower3 = new ArrayList<>();

        ArrayList<ArrayList<Integer>> towers = new ArrayList<>();

        towers.add(tower1);
        towers.add(tower2);
        towers.add(tower3);

        ArrayList<ArrayList<Integer>> allThePaths = new ArrayList<>();
        ArrayList<ArrayList<Integer>> theResult = new ArrayList<>();

        int counter = n;

        while(counter >= 1){
            tower1.add(counter);
            counter--;
        }

        helper(towers, allThePaths, n, theResult);

        return theResult;
    }

    static void helper(ArrayList<ArrayList<Integer>> towers,ArrayList<ArrayList<Integer>> allThePaths,
                       int n, ArrayList<ArrayList<Integer>> theResult){
        if(towers.get(2).size() == n) {
            theResult = new ArrayList<>();
            theResult.addAll(allThePaths);
            return;
        }

        if(allThePaths.size() > (2 ^ n) ){
            return;
        }

        int firstTowerSize = towers.get(0).size();
        int secondTowerSize = towers.get(1).size();
        int thirdTowerSize =  towers.get(2).size();

        Integer firstTowerTop = null;
        Integer secondTowerTop = null;
        Integer thirdTowerTop = null;

        if(firstTowerSize > 0)
            firstTowerTop = towers.get(0).get(firstTowerSize - 1);

        if(secondTowerSize > 0)
            secondTowerTop = towers.get(1).get(secondTowerSize - 1);

        if(thirdTowerSize > 0)
            thirdTowerTop = towers.get(2).get(thirdTowerSize - 1);

        // 1 -> 2
        if(firstTowerTop != null && (secondTowerTop == null || firstTowerTop < secondTowerTop) ){
            towers.get(1).add(firstTowerTop);
            towers.get(0).remove(firstTowerSize - 1);

            allThePaths.add(new ArrayList<>(Arrays.asList(1, 2)));
            helper(towers, allThePaths, n, theResult);
            allThePaths.remove(allThePaths.size() - 1);

            towers.get(0).add(firstTowerTop);
            towers.get(1).remove(secondTowerSize);
        }

        // 1 -> 3
        if(firstTowerTop != null && (thirdTowerTop == null || firstTowerTop < thirdTowerTop)){
            towers.get(2).add(firstTowerTop);
            towers.get(0).remove(firstTowerSize - 1);

            allThePaths.add(new ArrayList<>(Arrays.asList(1, 3)));
            helper(towers, allThePaths, n, theResult);
            allThePaths.remove(allThePaths.size() - 1);

            towers.get(0).add(firstTowerTop);
            towers.get(2).remove(thirdTowerSize);
        }

        // 2 -> 3
        if(secondTowerTop != null && (thirdTowerTop == null || secondTowerTop < thirdTowerTop)){
            towers.get(2).add(secondTowerTop);
            towers.get(1).remove(secondTowerSize - 1);

            allThePaths.add(new ArrayList<>(Arrays.asList(2, 3)));
            helper(towers, allThePaths, n, theResult);
            allThePaths.remove(allThePaths.size() - 1);

            towers.get(1).add(secondTowerTop);
            towers.get(2).remove(thirdTowerSize);
        }

        // 2 -> 1
        if(secondTowerTop != null && (firstTowerTop == null || firstTowerTop > secondTowerTop)){
            towers.get(0).add(secondTowerTop);
            towers.get(1).remove(secondTowerSize - 1);

            allThePaths.add(new ArrayList<>(Arrays.asList(2, 1)));
            helper(towers, allThePaths, n, theResult);
            allThePaths.remove(allThePaths.size() - 1);

            towers.get(1).add(secondTowerTop);
            towers.get(0).remove(firstTowerSize);
        }

        // 3 -> 1
        if(thirdTowerTop != null && (firstTowerTop == null || firstTowerTop > thirdTowerTop)){
            towers.get(0).add(thirdTowerTop);
            towers.get(2).remove(thirdTowerSize - 1);

            allThePaths.add(new ArrayList<>(Arrays.asList(3, 1)));
            helper(towers, allThePaths, n, theResult);
            allThePaths.remove(allThePaths.size() - 1);

            towers.get(2).add(thirdTowerTop);
            towers.get(0).remove(firstTowerSize);
        }

        // 3 -> 2
        if(thirdTowerTop != null && (secondTowerTop == null || secondTowerTop > thirdTowerTop)){
            towers.get(1).add(thirdTowerTop);
            towers.get(2).remove(thirdTowerSize - 1);

            allThePaths.add(new ArrayList<>(Arrays.asList(3, 2)));
            helper(towers, allThePaths, n, theResult);
            allThePaths.remove(allThePaths.size() - 1);

            towers.get(2).add(thirdTowerTop);
            towers.get(1).remove(secondTowerSize);
        }

    }
}
