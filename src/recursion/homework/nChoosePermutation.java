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
        // k sifirsa su anki listedeki elemani buyuk listeye ekle


        if(k == 0){
            ArrayList<Integer> copy = new ArrayList<>(newList);
            allResults.add(copy);
            return;
        }

        if(remainingList.size() == 0){
            return;
        }


        for(int i = startInd; i < remainingList.size(); i++){
//            if(mask[i] == false){ MASKE GEREK KALMADI! CUNKU ILK ELEMANI EKARTE EDIYORUZ
                // choose any element from the number list
                int anyElement =  remainingList.get(i);
                // remove this element from the mask
//                mask[i] = true;
                // bir tane liste yarat ve bu elemani ekle
                newList.add(anyElement);
                // diger alt problemi bu yeni listeyle bir daha yap
                combinationHelper(newList, k - 1, remainingList, allResults, mask, i + 1);
                newList.remove(newList.size() - 1);
//                mask[i] = false;
//            }
        }
    }
}
