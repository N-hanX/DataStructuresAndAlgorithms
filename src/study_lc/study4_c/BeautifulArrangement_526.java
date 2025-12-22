package study_lc.study4_c;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BeautifulArrangement_526 {
    public static void main(String[] args) {
        int result = countArrangement(11);

        int a = 3;
    }

    public static int countArrangement(int n) {
        counter = 0 ;
        createPermutation(n, new HashSet<>(), new ArrayList<>());
        return counter;
    }

    static int counter;
    public static void createPermutation(int n, Set<Integer> visitedIndices, List<Integer> currList){
        if(visitedIndices.size() == n){
            int curr_counter = 0;
            for(int i = 1; i <= n; i++){
                if(currList.get(i - 1) % i == 0 || i % currList.get(i - 1) == 0 ){
                    // System.out.println("val: " + currList.get(i - 1));
                    curr_counter++;
                }else{
                    return;
                }
            }
            if(curr_counter == n){
                counter++;
            }

            return;
        }

        for(int i = 1; i <= n; i++){
            if(!visitedIndices.contains(i)){
                int curr_index = currList.size() + 1;
                if(curr_index % i != 0 && i % curr_index != 0 ){
                    continue;
                }
                currList.add(i);
                visitedIndices.add(i);
                createPermutation(n, visitedIndices, currList);
                currList.remove(currList.size() - 1);
                visitedIndices.remove(i);
            }
        }
    }
}
