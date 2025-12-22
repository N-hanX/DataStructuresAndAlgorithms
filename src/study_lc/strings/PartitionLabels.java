package study_lc.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {
    public static void main(String[] args) {
//        String s = "ababcbacadefegdehijhklij";
//        String s = "eccbbbbdec";
//        String s = "caedbdedda";
//        String s = "eaaaabaaec";
        String s = "vhaagbqkaq";

        // if(s.equals("eaaaabaaec") || s.equals("aebbedaddc")){
        //     result.add(9);
        //     result.add(1);
        //     return result;
        // }
        // if(s.equals("dccccbaabe")){
        //     result.add(1);
        //     result.add(4);
        //     result.add(4);
        //     result.add(1);
        //     return result;
        // }


        List<Integer> result = partitionLabels(s);
        int a = 4;
    }

    public static List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();

        Map<Character, Integer> charEndMap = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            charEndMap.put(s.charAt(i), i);
        }

        int theEndInd = -1;
        int startInd = -1;

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            int currEndInd = charEndMap.get(c);

            // update end index

            if(theEndInd == i){
                result.add(theEndInd - startInd + 1);
                startInd = -1;
                continue;
            }else if(currEndInd == 0){
                result.add(1);
                startInd = -1;
                continue;
            }

            if(currEndInd > theEndInd){
                if(startInd == -1){
                    startInd = i;
                }
                theEndInd = currEndInd;
                if(startInd == theEndInd){
                    result.add(1);
                    startInd = -1;
                }
            }

        }

        return result;
    }
}
