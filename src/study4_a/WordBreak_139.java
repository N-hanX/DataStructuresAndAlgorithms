package study4_a;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class WordBreak_139 {
    class TrieNode{
        Map<Character, TrieNode> charMap;
        boolean end;
        public TrieNode(){
            charMap = new HashMap<>();
            end = false;
        }

        public void setEnd(){
            end = true;
        }
    }

    TrieNode root;
    public boolean wordBreak(String s, List<String> wordDict) {
        root = createTrie(wordDict);
        Stack<Integer> startStack = new Stack<>();
        Stack<Integer> endStack = new Stack<>();

        // sliding window
        int i = 0;
        int j = 0;
        // boolean[] visited = new boolean[s.length() + 1];
        while(i < s.length()){
            boolean found = false;
            while(j < s.length()){
                if(isSegment(s, root, i, j)){
                    startStack.push(i);
                    endStack.push(j);
                    found = true;
                    if(j + 1 == s.length()){
                        return true;
                    }
                    i = j + 1;
                    j = i;
                    break;
                }
                j++;
            }
            if(!found){
                // backtrack time
                if(!startStack.isEmpty()){
                    i = startStack.pop();
                    j = endStack.pop() + 1;
                }else{
                    break;
                }
            }
        }
        return false;
    }

    public boolean isSegment(String s, TrieNode root, int start, int end){
        TrieNode temp = root;
        int i = start;

        while(i <= end){
            char curr_char = s.charAt(i);
            if(temp.charMap.containsKey(curr_char)){
                temp = temp.charMap.get(curr_char);
            }else{
                return false;
            }
            i++;
        }
        return temp.end;
    }

    public TrieNode createTrie(List<String> wordDict){
        TrieNode root = new TrieNode();

        for(int i = 0; i < wordDict.size(); i++){
            TrieNode temp = root;
            String word = wordDict.get(i);

            for(int j = 0; j < word.length(); j++){
                char curr_char = word.charAt(j);
                if(temp.charMap.containsKey(curr_char)){
                    temp = temp.charMap.get(curr_char);
                }else{
                    TrieNode newNode = new TrieNode();
                    temp.charMap.put(curr_char, newNode);
                    temp = newNode;
                }

                if(j == word.length() - 1){
                    temp.setEnd();
                }
            }
        }
        return root;
    }
}
