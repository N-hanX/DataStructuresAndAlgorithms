package study_lc.study4_c;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class InsertDeleteGetRandomTimeCompO_1_lc380 {
    class RandomizedSet {
        Set<Integer> randomSet;
        Map<Integer, Integer> indexAndVal;
        Map<Integer, Integer> valAndIndex;
        int curr_max;

        public RandomizedSet() {
            randomSet = new HashSet<>();
            indexAndVal = new HashMap<>();
            valAndIndex = new HashMap<>();
            curr_max = 0;
        }

        public boolean insert(int val) {
            if(randomSet.contains(val)){
                return false;
            }

            indexAndVal.put(curr_max, val);
            valAndIndex.put(val, curr_max);
            randomSet.add(val);
            curr_max++;
            return true;
        }

        public boolean remove(int val) {
            if(!randomSet.contains(val)){
                return false;
            }

            int index = valAndIndex.get(val);
            valAndIndex.remove(val);
            indexAndVal.remove(index);
            randomSet.remove(val);
            return true;

        }

        public int getRandom() {
            while(true){
                int rand = (int)(Math.random() * curr_max);
                if(indexAndVal.containsKey(rand)){
                    return indexAndVal.get(rand);
                }
            }
        }
    }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
}
