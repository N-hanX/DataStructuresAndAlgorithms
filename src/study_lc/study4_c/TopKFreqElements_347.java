package study_lc.study4_c;

import java.util.*;

public class TopKFreqElements_347 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3};
        int k = 2;

        int[] result = topKFrequent(nums, k);
        int a = 4;
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numFreq = new HashMap<>();
        Map<Integer, ArrayList<Integer>> freqAndNum = new HashMap<>();

        int the_max_freq = 1;

        for(int i = 0; i < nums.length; i++){
            int curr_num = nums[i];

            if(numFreq.containsKey(curr_num)){
                int freq = numFreq.get(curr_num);
                numFreq.put(curr_num, freq + 1);
                if(freq + 1 > the_max_freq){
                    the_max_freq = freq + 1;
                }
                // System.out.println("curr_num " + curr_num + " : " + (freq + 1));
            }else{
                numFreq.put(curr_num, 1);
                // System.out.println("curr_num " + curr_num + " :  1");
            }
        }

        Set<Integer> visited = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            int curr_num = nums[i];
            if(visited.contains(curr_num)){
                continue;
            }
            visited.add(curr_num);

            int freq = numFreq.get(curr_num);
            if(!freqAndNum.containsKey(freq)){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(curr_num);
                freqAndNum.put(freq, list);
                // System.out.println("curr_num " + curr_num + " : " + freq);
            }else{
                ArrayList<Integer> list = freqAndNum.get(freq);
                list.add(curr_num);
                freqAndNum.put(freq, list);
            }
        }

        int the_counter = 0;
        int max_k_counter = the_max_freq;
        int[] result = new int[k];

        while(the_counter < k){
            // System.out.println("max_k_counter " + max_k_counter);

            if(freqAndNum.containsKey(max_k_counter)){
                for(int i = 0; i < freqAndNum.get(max_k_counter).size(); i++){
                    if(the_counter < k){
                        // System.out.println("freq and num " + freqAndNum.get(max_k_counter).get(i));
                        // System.out.println("the_counter " + the_counter);
                        result[the_counter] = freqAndNum.get(max_k_counter).get(i);
                        the_counter++;
                    }else{
                        break;
                    }
                }
            }
            max_k_counter--;
        }
        return result;
    }
}
