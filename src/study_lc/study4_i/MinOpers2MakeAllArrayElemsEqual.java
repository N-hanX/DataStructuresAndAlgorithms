package study_lc.study4_i;

import java.util.*;

public class MinOpers2MakeAllArrayElemsEqual {
    public static void main(String[] args) {
//        int[] nums = new int[]{3,1,6,8};
//        int[] queries = new int[]{1, 5};
        int[] nums = new int[]{2,9,6,3};
        int[] queries = new int[]{10};


//        int[]nums = new int[]{58,5,26,89,15,48,13,1,29,3,46,64,70,63,47,43,74,24,19,55,15,89,91,8,51,3};
//        int[] queries = new int[]{89};

        List<Long> result = minOperations(nums, queries);

        int a = 4;
    }

    public static List<Long> minOperations(int[] nums, int[] queries) {
        ArrayList<Integer> nums_arr = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){
            nums_arr.add(nums[i]);
        }

        Collections.sort(nums_arr);

        ArrayList<Long> result = new ArrayList<>();
        Map<Integer, Long> resultMap = new HashMap<>();
        for(int i = 0; i < queries.length; i++){
            int query = queries[i];

            int the_ind = binarySearch(nums_arr, query, 0, nums_arr.size());

            if(!resultMap.containsKey(query)){
                Long curr_total = calculateTotalQuery(nums_arr, query, the_ind);
                resultMap.put(query, curr_total);
            }
        }

        for(int i = 0; i < queries.length; i++){
            int query = queries[i];
            result.add(resultMap.get(query));
        }

        return result;
    }

    public static Long calculateTotalQuery(ArrayList<Integer> nums_arr, int query, int index){
        Long leftCalculator = 0L;
        Long numOfLeft = 0L;
        Long total = 0L;


        for(int i = 0; i <= index; i++){
            if(nums_arr.get(i) == query || nums_arr.get(i) > query)
                continue;

            numOfLeft++;
            leftCalculator += nums_arr.get(i);
        }


        total += (query * numOfLeft ) - leftCalculator;


        Long rightCalculator = 0L;
        Long numOfRight = 0L;

        while(nums_arr.size() > index && (query == nums_arr.get(index) || query > nums_arr.get(index))) {
            index++;
        }

        for(int i = index; i < nums_arr.size(); i++){
            if(nums_arr.get(i) == query)
                continue;

            numOfRight++;
            rightCalculator += nums_arr.get(i);
        }

        total +=  rightCalculator - (query * numOfRight);


        return total;
    }

    public static int binarySearch( ArrayList<Integer> nums_arr, int query, int startInd, int endInd){
        if(startInd == endInd)
            return startInd;

        int middleInd = (endInd - startInd) / 2 + startInd;

        if(startInd == middleInd || endInd == middleInd){
            return startInd;
        }

        if(nums_arr.get(middleInd) > query){
            return binarySearch(nums_arr, query, startInd, middleInd);
        }else if(nums_arr.get(middleInd) < query)
            return binarySearch(nums_arr, query, middleInd, endInd);
        else
            return middleInd;
    }
}
