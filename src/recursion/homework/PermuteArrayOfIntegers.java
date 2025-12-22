package recursion.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PermuteArrayOfIntegers {
    public static void main(String[] args) {
        ArrayList<Integer> ints = new ArrayList<Integer>(Arrays.asList(1,2,2));
        get_permutations(ints);
    }

    static ArrayList<ArrayList<Integer>> get_permutations(ArrayList<Integer> arr) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> currPerm = new ArrayList<>();
        Set<String> permInStringSet = new HashSet<>();
        createPermutation(permInStringSet, arr, currPerm, result);
        return result;

    }

    static void createPermutation(Set<String> permInStringSet, ArrayList<Integer> arr, ArrayList<Integer> currPerm, ArrayList<ArrayList<Integer>> result){
        if(arr.size() == 0){
            StringBuilder stringBuilder = new StringBuilder();

            for(int i = 0; i < currPerm.size(); i++){
                stringBuilder.append(currPerm.get(i));
            }
            String currPermInString = stringBuilder.toString();
            if(!permInStringSet.contains(currPermInString)){
                permInStringSet.add(currPermInString);
                result.add(new ArrayList<>(currPerm));
            }

            return;
        }

        for(int i = 0; i < arr.size(); i++){
            int num = arr.get(i);
            currPerm.add(num);
            arr.remove(i);
            createPermutation(permInStringSet, arr, currPerm, result);
            currPerm.remove(currPerm.size() - 1);
            arr.add(i, num);
        }
    }

}
