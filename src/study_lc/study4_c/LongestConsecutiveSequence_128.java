package study_lc.study4_c;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence_128 {
    public static void main(String[] args) {
        int[] nums = new int[]{100,4,200,1,3,2};

        int result = longestConsecutive(nums);
        int a =4;
    }

    public static int longestConsecutive(int[] nums) {
        Set<Integer> allNumbers = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        int longest = 0;

        for(int i = 0; i < nums.length; i++){
            allNumbers.add(nums[i]);
        }

        for(int i = 0; i < nums.length; i++){
            int currNum = nums[i];
            int currLen = 1;
            if(visited.contains(currNum)){
                continue;
            }else{
                visited.add(currNum);
                int nextNum = currNum + 1;
                while(allNumbers.contains(nextNum)){
                    visited.add(nextNum);
                    nextNum++;
                    currLen++;
                }

                int prevNum = currNum - 1;
                while(allNumbers.contains(prevNum)){
                    visited.add(prevNum);
                    prevNum--;
                    currLen++;
                }

                if(longest < currLen){
                    longest = currLen;
                }
            }
        }
        return longest;
    }
}
