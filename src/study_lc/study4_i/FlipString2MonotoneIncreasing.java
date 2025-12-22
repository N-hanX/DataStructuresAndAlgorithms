package study_lc.study4_i;

import java.util.ArrayList;
import java.util.List;

public class FlipString2MonotoneIncreasing {
    public static void main(String[] args) {
        String s = "0101100011";

        int result = minFlipsMonoIncr(s);
        int a = 4;
    }

    public static int minFlipsMonoIncr(String s) {
        List<Integer> zeroIndices = new ArrayList<>();
        List<Integer> oneIndices = new ArrayList<>();

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '0'){
                zeroIndices.add(i);
            }else{
                oneIndices.add(i);
            }
        }

        int ptr0 = 0;
        int ptr1 = 0;

        int zero_size = 0;
        if(!zeroIndices.isEmpty()){
            zero_size = zeroIndices.size();
        }

        int one_size = 0;
        if(!oneIndices.isEmpty()){
            one_size = oneIndices.size();
        }

        while(zero_size != 0 && one_size != 0 && zeroIndices.get(ptr0) < oneIndices.get(ptr1)){
            ptr0++;
        }

        int remaining_0 = zero_size - ptr0;
        int remaining_1 = one_size - ptr1;

        return Math.min(remaining_0, remaining_1);
    }
}
