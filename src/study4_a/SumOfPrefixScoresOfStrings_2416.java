package study4_a;

import java.util.HashMap;
import java.util.Map;

public class SumOfPrefixScoresOfStrings_2416 {
    Trie root;
    public int[] sumPrefixScores(String[] words) {
        createRootTrie(words);
        int[] result = new int[words.length];

        for(int i = 0; i < words.length; i++){
            System.out.println("Word: " + words[i]);
            result[i] = prefixScoreCalculationProcess(words[i]);
            System.out.println("End: " + words[i]);
        }
        return result;
    }

    public int prefixScoreCalculationProcess(String word){
        int sum = 0;
        StringBuilder prefix = new StringBuilder();

        int index = 0;

        while(index < word.length()){
            prefix.append(word.charAt(index));
            System.out.println("Prefix: " + prefix);

            Trie currTrieParent = getParentNode(prefix);
            if(currTrieParent == null){
                break;
            }
            if(currTrieParent.childNodes.size() == 0){
                sum++;
            }else{
                sum = sum + calculateScore(currTrieParent);
            }

            index++;
            System.out.println();
        }

        return sum;
    }

    public Trie getParentNode(StringBuilder prefix){
        int index = 0;

        Trie tempRoot = root;

        for(int i = 0; i < prefix.length(); i++){
            // if(i == prefix.length() - 1 && tempRoot.childNodes.containsKey(prefix.charAt(index))){
            //     return tempRoot;
            // }

            if(tempRoot.childNodes.containsKey(prefix.charAt(index))){
                tempRoot = tempRoot.childNodes.get(prefix.charAt(index));
            }else{
                return null;
            }
        }
        return tempRoot;
    }

    public int calculateScore(Trie currNode){
        // traverseThroughNode
        if(currNode == null){
            return 0;
        }

        int count = 0;
        if(currNode.endOfWord){
            count++;
        }

        for(Character currChar: currNode.childNodes.keySet()){
            System.out.println("curr_score: " + count);
            System.out.println("curr char: " + currChar);
            count = count + calculateScore(currNode.childNodes.get(currChar));
            System.out.println("curr_score: " + count);
        }
        return count;
    }

    public void createRootTrie(String[] words){
        root = new Trie();

        for(String word: words){
            Trie tempTrie = root;

            for(int i = 0; i < word.length(); i++){
                if(root.childNodes.containsKey(word.charAt(i))){
                    tempTrie = root.childNodes.get(word.charAt(i));
                }else{
                    Trie newTrie = new Trie();
                    tempTrie.childNodes.put(word.charAt(i), newTrie);
                    tempTrie = newTrie;
                }
            }

            tempTrie.endOfWord = true;
        }
    }

    class Trie{
        boolean endOfWord;
        Map<Character, Trie> childNodes;

        public Trie(){
            endOfWord = false;
            childNodes = new HashMap<>();
        }

        // public void addCharNode(Character curr_char){
        //     if
        // }

        public void setTheEndOfWord(){
            endOfWord = true;
        }
    }
}
