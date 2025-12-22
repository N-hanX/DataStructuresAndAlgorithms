package study_lc;

public class ClimbStair {
    public static void main(String[] args) {
        int n = 10;
        int[] numOfClimbs = new int[n];

        if(n == 0){
//            return 0;
        }else if (n == 1){
//            return 1;
        }else if(n == 2){
//            return 2;
        }


        if(n > 1){
            numOfClimbs[0] = 1;
            numOfClimbs[1] = 2;
        }


        for(int i = 2; i < n; i++){
            numOfClimbs[i] = numOfClimbs[i-1] + numOfClimbs[i-2];
        }
//        return numOfClimbs[n-1];

    }
}
