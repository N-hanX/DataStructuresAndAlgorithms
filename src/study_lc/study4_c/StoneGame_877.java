package study_lc.study4_c;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class StoneGame_877 {
    public static void main(String[] args) {
        int[] piles = new int[]{5,3,4,5};
        boolean result = stoneGame(piles);

        int a = 4;
    }

    static class RangeScore{
        int left;
        int right;
        int hashcode;

        public RangeScore(int left, int right){
            this.left = left;
            this.right = right;
            this.hashcode = Objects.hash(left, right);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            RangeScore that = (RangeScore) o;
            return left == that.left && right == that.right;
        }

        @Override
        public int hashCode() {
            return this.hashcode;
        }
    }

    static Map<RangeScore, Integer> rangeScoreSet;
    public static  boolean stoneGame(int[] piles) {
        rangeScoreSet = new HashMap<>();

        int result = calculateDiffForEachChose(piles, 0, piles.length - 1, 1);
        if(result > 0)
            return true;

        return false;
    }

    public static  int calculateDiffForEachChose(int[] piles, int leftInd, int rightInd, int turn){
        // System.out.println("left: " + leftInd + " right: " + rightInd);

        // System.out.println("curr main.recursion");
        if(leftInd >= rightInd){
            return 0;
        }

        if(rangeScoreSet.containsKey(new RangeScore(leftInd, rightInd))){
            // System.out.println("calculated");

            int the_calculatedScore = rangeScoreSet.get(new RangeScore(leftInd, rightInd));
            return the_calculatedScore;
        }

        int score = 0;

        if(rightInd - leftInd == 1){
            int max_score = Math.max(piles[leftInd], piles[rightInd]);
            int min_score = Math.min(piles[leftInd], piles[rightInd]);

            // System.out.println("end of left right indeks: " + leftInd + " : " + rightInd);
            // System.out.println("end of left: " + piles[leftInd]);
            // System.out.println("end of right: " + piles[rightInd]);

            if(turn == 1){
                score = max_score - min_score;
            }else{
                score = min_score - max_score;
            }

        }else{
            // System.out.println();
            // System.out.println("left: " + leftInd + " right: " + rightInd);
            int leftChosenPrevScore = calculateDiffForEachChose(piles, leftInd + 1, rightInd, turn * -1);
            int rightChosenPrevScore = calculateDiffForEachChose(piles, leftInd , rightInd - 1, turn * -1);


            // System.out.println("&&");
            // System.out.println("left: " + piles[leftInd]);
            // System.out.println("right: " + piles[rightInd]);


            // System.out.println("left chosen prev score: " + leftChosenPrevScore);
            // System.out.println("right chosen prev score: " + rightChosenPrevScore);

            if(turn == 1){
                score = Math.max(leftChosenPrevScore + piles[leftInd], rightChosenPrevScore + piles[rightInd]);
            }else{
                score = Math.max(leftChosenPrevScore - piles[leftInd], rightChosenPrevScore - piles[rightInd]);
            }
            // System.out.println("turn: " + turn + " -score: " + score);
            RangeScore newScore = new RangeScore(leftInd, rightInd);
            rangeScoreSet.put(newScore, score);
        }


        return score;
    }
}
