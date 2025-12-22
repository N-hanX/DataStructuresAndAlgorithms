package study_lc;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangles {
    public static void main(String[] args) {
        getRow(33);
        int a = 5;
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();

        if(rowIndex == 0){
            result.add(1);
            return result;
        }else if(rowIndex == 1){
            result.add(1);
            result.add(1);
            return result;
        }else{
            result.add(1);
            result.add(1);

            int temp = 2;

            while(temp <= rowIndex){
                int currInd = 1;
//                System.out.println("temp: "  + temp);
                List<Integer> currResult = new ArrayList<>();
                currResult.add(1);
                while(currInd <= result.size() - 1){
//                    System.out.println("CurrInd: "  + currInd);
                    int currIndResult = result.get(currInd) + result.get(currInd - 1);
//                    System.out.println(currIndResult);
                    currResult.add( currIndResult);
                    currInd++;
                }
                currResult.add(1);
                // Collections.copy(result,currResult);
                result = currResult;
                temp++;
            }
            return result;
        }
    }
}
