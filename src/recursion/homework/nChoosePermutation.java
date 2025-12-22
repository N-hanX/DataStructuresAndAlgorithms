package recursion.homework;

import java.util.ArrayList;
import java.util.List;

public class nChoosePermutation {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        int k  = 2;
        List<List<Integer>> allResults = new ArrayList<>();
        ArrayList<Integer> combinationList = new ArrayList<>();


        boolean[] mask = new boolean[list.size()];

        combinationHelper(combinationList, k, list, allResults, mask, 0);
        int a = 4;
    }

    public static void combinationHelper(ArrayList<Integer> newList, int k, ArrayList<Integer> remainingList,
                                        List<List<Integer>> allResults, boolean[] mask, int startInd){
        // if k is zero, add the element in current element into the big list.

        if(k == 0){
            ArrayList<Integer> copy = new ArrayList<>(newList);
            allResults.add(copy);
            return;
        }

        if(remainingList.size() == 0){
            return;
        }


        for(int i = startInd; i < remainingList.size(); i++){
//            if(mask[i] == false){ no need to mask! because we eliminate first element
                // choose any element from the number list
                int anyElement =  remainingList.get(i);
                // remove this element from the mask
//                mask[i] = true;
                // create a list and add the elemnet
                newList.add(anyElement);
                // repeat the other sub problem with new list
                combinationHelper(newList, k - 1, remainingList, allResults, mask, i + 1);
                newList.remove(newList.size() - 1);
//                mask[i] = false;
//            }
        }
    }
}
