package study_lc.slidingWindow;

public class DietPlanPerformance {
    public static void main(String[] args) {
//        [1,2,3,4,5]
        int[] calories = new int[]{1,2,3,4,5};
        int k = 1;
        int lower = 3;
        int upper = 3;

        int result = dietPlanPerformance(calories,k,lower, upper);
        int a = 4;
    }

    public static int dietPlanPerformance(int[] calories, int k, int lower, int upper) {

        int startInd = 0;
        int endInd = k - 1;
        int result = 0;
        int total_len = calories.length;

        //first part
        int ind_counter = startInd;
        int currTotal = 0;
        while(ind_counter <= endInd){
            currTotal += calories[ind_counter];
            ind_counter++;
        }

        if(currTotal < lower){
            result--;
        }

        if(currTotal > upper){
            result++;
        }

        endInd++;
        while(endInd < total_len){
            currTotal = currTotal - calories[startInd] + calories[endInd];

            if(currTotal < lower){
                result--;
            }

            if(currTotal > upper){
                result++;
            }
            startInd++;
            endInd++;
        }
        return result;

    }
}
