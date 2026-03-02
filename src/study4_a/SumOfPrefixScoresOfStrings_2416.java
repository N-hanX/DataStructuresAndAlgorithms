package study4_a;

import java.util.HashMap;
import java.util.Map;

public class SumOfPrefixScoresOfStrings_2416 {
    static void main() {
        SumOfPrefixScoresOfStrings_2416 instance = new SumOfPrefixScoresOfStrings_2416();
//        // TEST1
//        String[] words = new String[]{"abc","ab","bc","b"};
//        int[] results = instance.sumPrefixScores(words);

//        // TEST2
//        String[] words = new String[]{"abcd"};
//        int[] results = instance.sumPrefixScores(words);

//        // TEST3
//        String[] words = new String[]{"qtcqcmwcin","vkjotbrbzn","eoorlyfche","eoorlyhn","eoorlyfcxk","qfnmjilcom","eoorlyfche","qtcqcmwcnl","qtcqcrpjr"};
//        int[] results = instance.sumPrefixScores(words);

//        // TEST4
//        String[] words = new String[]{"dbhiwxxr","hyqbpabh","hyqlgnnxiy","wosbckxrb","wosbckxmfq"};
//        int[] results = instance.sumPrefixScores(words);


        // TEST5
//        int[] results = instance.sumPrefixScores(words);
//        int[] real_result = new int[]{588,1779,522,3063,2335,669,315,297,876,892,390,4386,61,1853,2878,2083,1870,2279,1345,2226,346,385,1094,3274,2004,3401,882,3398,987,2722,4374,889,1390,881,1578,302,1258,3564,1967,2129,749,2010,879,1023,2321,3386,2185,3621,1227,3397,2324,863,3635,2460,2058,1057,1475,2861,471,485,286,2030,3217,1368,748,3401,621,433,1781,4154,688,1898,370,646,564,2576,1626,3635,3490,3373,1867,1929,2353,2334,1984,710,708,2672,1155,315,3157,2388,850,1429,1426,1130,369,384,251,568,4386,2222,538,511,968,1472,2470,901,977,523,1472,594,3259,731,3370,1821,465,460,1506,2454,1220,1845,2537,3135,1055,1085,1870,1070,561,498,2971,968,3515,1450,1412,2470,844,634,1906,2439,1981,3554,1989,4152,833,456,1782,3115,492,2139,917,833,1344,1043,838,1580,970,2409,1508,420,1789,1860,4321,1017,2877,307,477,1398,744,1387,664,472,4001,639,4381,3396,3128,727,1954,706,453,1113,490,545,2043,2216,3395,1737,1444,2388,1736,1100,845,1867,1727,888,782,2133,3276,416,3135,479,505,1214,1990,1348,495,746,2309,3389,459,616};
//
//        for(int i = 0; i < results.length;i++){
//            if(i >= real_result.length || real_result[i] != results[i]){
//                System.out.println("Incorrect");
//                break;
//            }
//        }

//        // TEST6
//        String[] words = new String[]{"abc","ab","bc","b", "a"};
//        int[] results = instance.sumPrefixScores(words);


        // TEST7
        String[] words = new String[]{"dbhiwxxr","hyqbpabh","hyqlgnnxiy","wosbckxrb","wosbckxmfq"};
        int[] results = instance.sumPrefixScores(words);


        int a = 4;
    }
    Trie root;

    public int[] sumPrefixScores(String[] words) {
        createRootTrie(words);

        int[] result = new int[words.length];

        for(int i = 0; i < words.length; i++){
            result[i] = prefixScoreCalculationProcess(words[i]);
        }
        return result;
    }

    public int prefixScoreCalculationProcess(String word){
        int sum = 0;

        int index = 0;
        Trie currTrieParent = root;
        while(index < word.length()){
            int curr_sum = currTrieParent.childNodes.get(word.charAt(index)).prefixCount;
            sum += curr_sum;
            currTrieParent = currTrieParent.childNodes.get(word.charAt(index));
            index++;

        }

        return sum;
    }

    public void createRootTrie(String[] words){
        root = new Trie();

        for(String word: words){
            Trie tempTrie = root;

            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                if(tempTrie.childNodes.containsKey(c)){
                    tempTrie = tempTrie.childNodes.get(c);
                }else{
                    Trie newTrie = new Trie();
                    tempTrie.childNodes.put(c, newTrie);
                    tempTrie = newTrie;
                }
                tempTrie.prefixCount++;
            }
            tempTrie.endOfWord = true;
        }
    }

    class Trie{
        boolean endOfWord;
        Map<Character, Trie> childNodes;
        int prefixCount;

        public Trie(){
            endOfWord = false;
            childNodes = new HashMap<>();
            prefixCount = 0;
        }
    }
}
