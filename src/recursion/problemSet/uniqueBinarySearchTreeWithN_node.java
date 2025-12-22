package recursion.problemSet;

import java.util.*;

public class uniqueBinarySearchTreeWithN_node {
    public static void main(String[] args) {
        how_many_BSTs(3);
    }

    static long how_many_BSTs(int n) {

        List<Integer> list = new ArrayList<>();

        for(int i = 1; i <= n; i++){
            list.add(i);
        }

        List<List<Integer>> allResults = new ArrayList<>();
        createAllPermutations(list, 0, allResults);
        Set<String> strSet = createEachBinaryTree(allResults);

        return strSet.size();
    }

    public static Set<String> createEachBinaryTree(List<List<Integer>> allResults ){
        Set<String> strSet = new HashSet<>();



        for(int i = 0; i < allResults.size(); i++){
            List<Integer> currList = allResults.get(i);
            PriorityQueue <Integer> top_k = new PriorityQueue <Integer> ();
            for(int j = 0; j < currList.size(); j++){
                top_k.add(currList.get(j));
            }

            String currStr = "";
            Iterator<Integer> iterator = top_k.iterator();

            while(iterator.hasNext()){
                currStr = currStr + iterator.next().toString();
            }
            if(!strSet.contains(currStr)){
                strSet.add(currStr);
            }
        }
        return strSet;
    }

    public static void createAllPermutations(List<Integer> list, int currInd, List<List<Integer>> allPerms){
        if(currInd == list.size()){
            List<Integer> copyList = new ArrayList<>(list);
            allPerms.add(copyList);
            return;
        }

        for(int i = currInd; i < list.size(); i++){
            swap(list, i, currInd);
            createAllPermutations(list, currInd + 1, allPerms);
            swap(list, i, currInd);
        }
    }

    public static void swap(List<Integer> list, int i, int j){
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

}
