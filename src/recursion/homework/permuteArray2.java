package recursion.homework;

import java.util.*;

public class permuteArray2 {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(1,2,3));
        get_permutations(nums);
    }


    static ArrayList<ArrayList<Integer>> get_permutations(ArrayList<Integer> arr) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> perm = new ArrayList<>();

        fillTheIndex(perm, result, arr);

        return result;
    }

    static void fillTheIndex(ArrayList<Integer> perm, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> arr){
        if(arr.size() == 0){
            ArrayList<Integer> copyPerm = new ArrayList<>(perm);
            result.add(copyPerm);
            return;
        }

        for(int i = 0; i < arr.size(); i++){
            int num = arr.get(i);
            perm.add(num);
            arr.remove(i);
            fillTheIndex(perm, result,arr);
            perm.remove(perm.size() - 1);
            arr.add(i, num);
        }
    }
}
