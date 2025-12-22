package study_program.problemSet.string;

import java.util.HashMap;
import java.util.Map;

public class PatriciaTrie {

    static class TrieNode{
        int index_position;
        String subtext;
        Map<String, TrieNode> children = new HashMap<>();

        public TrieNode(String subtext){
            this.subtext = subtext;
            this.index_position = -1;
        }

        public TrieNode(){

        }

        public TrieNode(String subtext, int index_position){
            this.subtext = subtext;
            this.index_position = index_position;
        }
    }

    public static void main(String[] args) {
        String word = "nonsense";
        createTrie(word);

        int a = 4;
    }

    static TrieNode root;
    public static void createTrie(String word){
        root = new TrieNode();

        for(int i = word.length(); i >= 0; i--){
            Map<String, TrieNode> children = root.children;

            if(i == word.length()){
                children.put("$", new TrieNode("$", i));
                continue;
            }

            String subText = word.substring(i);
            int counter = 1;
            boolean foundSubTree = false;
            while(counter <= subText.length() && !foundSubTree) {
                String subText2 = subText.substring(0, counter);
                System.out.println(subText2);
                if (!children.containsKey(subText2)) {
                    counter++;
                }else{
                    TrieNode subTreeNode = children.get(subText2);
                    children = subTreeNode.children;
                    foundSubTree = true;
                    counter++;
                }
            }

            if(foundSubTree) {
                String remainingSubstring = subText.substring(counter - 1);
                TrieNode newNode = new TrieNode(remainingSubstring);
                children.put(remainingSubstring, newNode);
            }else{
                children.put(subText, new TrieNode(subText));
            }
            children.put("$", new TrieNode("$", i));
        }
    }
}
