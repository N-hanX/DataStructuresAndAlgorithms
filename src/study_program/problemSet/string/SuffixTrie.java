package study_program.problemSet.string;

import java.util.HashMap;
import java.util.Map;

public class SuffixTrie {
    static class TrieNode{
        char c;
        Map<Character, TrieNode> children = new HashMap<>();

        public TrieNode(){

        }

        public TrieNode(char c){
            this.c = c;
        }
    }

    static TrieNode suffixTreeRoot;

    static void createSuffix(String text){
        if(suffixTreeRoot == null)
            suffixTreeRoot = new TrieNode();

        for(int i = 0; i < text.length(); i++){
            String currSuffix = text.substring(i);
            Map<Character, TrieNode> children = suffixTreeRoot.children;

            for(int j = 0; j < currSuffix.length(); j++) {
                char capitalChar = currSuffix.charAt(j);

                if(!children.containsKey(capitalChar)){
                    TrieNode newNode = new TrieNode(capitalChar);
                    children.put(capitalChar, newNode);
                    children = newNode.children;
                }else{
                    TrieNode theNode = children.get(capitalChar);
                    children = theNode.children;
                }

                if( j == currSuffix.length() - 1)
                    children.put('$', new TrieNode());
            }
        }
    }

    public static boolean search(String word){
        Map<Character, TrieNode> children = suffixTreeRoot.children;

        if(children.isEmpty())
            return false;

        for(int i = 0; i < word.length(); i++){
            char currChar = word.charAt(i);

            if(!children.containsKey(currChar))
                return false;
            else{
                TrieNode theNode = children.get(currChar);
                children = theNode.children;
            }

            if(i == word.length() - 1 && children.containsKey('$')){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String word = "banana";

        createSuffix(word);
        Boolean result1 = search("anana");
        Boolean result2 = search("na");
        Boolean result3 = search("banana");
        Boolean result4 = search("b");
        Boolean result5 = search("banana3");
        Boolean result6 = search("banan");

        int a = 5;
    }
}
