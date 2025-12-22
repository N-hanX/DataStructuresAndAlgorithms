package study_program.problemSet.adhoc;

import java.util.ArrayList;
import java.util.Arrays;

public class PascalsTriangle {
    public static void main(String[] args) {

        int n = 10;

        ArrayList<ArrayList<Integer>> result = find_pascal_triangle(n);

    }

    static ArrayList<ArrayList<Integer>> find_pascal_triangle(Integer n) {
        int mod = 10^9 + 7;

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if(n == 1){
            ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1));
            result.add(arr);
            return result;
        }else if(n == 2){
            ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1));
            ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(1, 1));
            result.add(arr);
            result.add(arr1);
            return result;
        }else{
            ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(1));
            ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(1, 1));


            result.add(arr1);
            result.add(arr2);
            for(int i = 2; i < n; i++){

                int currInd = 0;
                int endInd = i - 1;

                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(1);

                int halfEndInd;
                if((i + 1) % 2 == 0){
                    halfEndInd = (i + 1) / 2 - 1;
                }else{
                    halfEndInd = (i + 1) / 2;
                }

                while(currInd < halfEndInd) {
                    int total = (result.get(i - 1).get(currInd) + result.get(i - 1).get(currInd + 1)) % mod;
                    arr.add(total);
                    currInd++;
                }

                if((i + 1) % 2 == 0)


                arr.add(1);
                result.add(arr);
            }
            return result;
        }
    }

}
