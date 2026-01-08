package study4_a;

import java.util.*;

public class WordBreak_139 {
    static class TrieNode{
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

    static TrieNode root;
    public static boolean wordBreak(String s, List<String> wordDict) {
        root = createTrie(wordDict);
        Stack<Integer> startStack = new Stack<>();
        Stack<Integer> endStack = new Stack<>();

        // sliding window
        int i = 0;
        int j = 0;
        boolean[] visited = new boolean[s.length() + 1];
        while(i < s.length()){
            boolean found = false;
            while(j < s.length() && !visited[i]){
                String substring = s.substring(i, j + 1);
                // System.out.println(substring);
                if(isSegment(substring, root)){
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
                    // if nothing is found after the current start index 'i',
                    // this also means there is no other way possible and record this path as visited.
                    visited[i] = true;
                    i = startStack.pop();
                    j = endStack.pop() + 1;
                }else{
                    break;
                }
            }
        }
        return false;
    }

    public static boolean isSegment(String s, TrieNode root){
        TrieNode temp = root;
        int i = 0;

        while(i < s.length()){
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

    public static TrieNode createTrie(List<String> wordDict){
        TrieNode root = new TrieNode();

        for(int i = 0; i < wordDict.size(); i++){
            TrieNode temp = root;
            String word = wordDict.get(i);

            for(int j = 0; j < word.length(); j++){
                char curr_char = word.charAt(j);
                // traverse simultaneously through trie node (starting from root),
                // and the word from its start index while creating required nodes or choosing the existing node branch
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

    static void main() {
        System.out.println(wordBreak("leetcode",new ArrayList<>(Arrays.asList("leet","code"))));
    }
}
