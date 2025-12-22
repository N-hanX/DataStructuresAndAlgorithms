package study_lc;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
//        int k = 3;
//        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};

        int k = 3;
        int[] nums = new int[]{1,3,1,2,0,5};

        int[] result = maxSlidingWindow(nums, k);
        int a = 4;
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> maxValues = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        int counter = 0;
        int len = nums.length;

        counter = 0;
        while(counter < k){
            int currVal = nums[counter];

            if(maxValues.isEmpty()){
                maxValues.add(currVal);
            }else if(!maxValues.isEmpty() && maxValues.peek() < currVal){
                while(!maxValues.isEmpty() && maxValues.peek() < currVal){
                    maxValues.pop();
                }
                maxValues.add(currVal);
            }else if(!maxValues.isEmpty() && maxValues.peek() >= currVal){
                while(!maxValues.isEmpty() && maxValues.peekLast() < currVal){
                    maxValues.removeLast();
                }
                maxValues.addLast(currVal);
            }
            counter++;
        }

        // ilk windowun maxi ve cikarimi
        result.add(maxValues.peek());
        if(maxValues.peek() == nums[0]){
            maxValues.pop();
        }

        while(counter < len){
            int currVal = nums[counter];

            if(maxValues.isEmpty()){
                maxValues.add(currVal);
            }else if(!maxValues.isEmpty() && maxValues.peek() < currVal){
                while(!maxValues.isEmpty() && maxValues.peek() < currVal){
                    maxValues.pop();
                }
                maxValues.add(currVal);
            }else if(!maxValues.isEmpty() && maxValues.peek() >= currVal){
                while(!maxValues.isEmpty() && maxValues.peekLast() < currVal){
                    maxValues.removeLast();
                }
                maxValues.addLast(currVal);
            }

            result.add(maxValues.peek());
            if(maxValues.peek() == nums[counter - k + 1]){
                maxValues.pop();
            }

            counter++;
        }

        int[] resultArr = new int[result.size()];

        for(int i = 0; i < result.size(); i++){
            resultArr[i] = result.get(i);
        }

        return resultArr;
    }
}
