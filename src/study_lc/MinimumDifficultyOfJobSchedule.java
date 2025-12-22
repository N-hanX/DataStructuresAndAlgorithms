package study_lc;

import java.util.ArrayList;

public class MinimumDifficultyOfJobSchedule {
    public static void main(String[] args) {
//        int[] difficulties = new int[]{6,5,4,3,2,1};
//        int d = 2;

//        int[] difficulties = new int[]{9, 9, 9};
//        int d = 4;

        int[] difficulties = new int[]{1, 1, 1};
        int d = 3;

//        int[] difficulties = new int[]{7, 1, 7, 1, 7, 1};
//        int d = 3;

        int result = minDifficulty(difficulties, d);

        int a = 4;
    }

    public static int minDifficulty(int[] jobDifficulty, int d) {
        if(jobDifficulty.length < d){
            return -1;
        }
        ArrayList<Integer> jobDifficulties = new ArrayList<>();

        for(int i = 0; i < jobDifficulty.length; i++){
            jobDifficulties.add(jobDifficulty[i]);
        }

        ArrayList<Integer> result = new ArrayList<>();

        int theMinimumInd = jobDifficulties.size() - d;
        for(int i = jobDifficulties.size() - 1; i > theMinimumInd; i--){
            result.add(jobDifficulties.get(i));
        }

        int theMax = jobDifficulties.get(0);
        for(int i = 0; i <= theMinimumInd; i++){
            int thecurr = jobDifficulties.get(i);
            if(theMax < thecurr){
                theMax = thecurr;
            }
        }
        result.add(theMax);

        int theTotal = 0;

        for(int i = 0; i < result.size(); i++){
            theTotal += result.get(i);
        }
        return theTotal;
    }
}
