package study_program.problemSet.string;

import java.util.HashMap;

public class TrieImplementation {

    static class TrieNode{
        char c;
        HashMap<Character, TrieNode> children = new HashMap<>();
        boolean isLeaf;

        public TrieNode(){

        }

        public TrieNode(Character c){
            this.c = c;
        }

        public void setChildren(HashMap<Character, TrieNode> children){
            this.children = children;
        }

        public boolean isLeaf(){
            return isLeaf;
        }

        public void setLeaf(boolean isLeaf){
            this.isLeaf = isLeaf;
        }
    }

    static TrieNode rootNode;

    public static void main(String[] args) {
        // amac trie'i bir sozluk amaciyla yaratalim. ve bu sozlukte belli bir sozcuk var mi bakalim
        insert("artist");
        insert("buck");
        insert("bunny");
        insert("dog");

        boolean result1 = search("bunny");
        boolean result2 = search("bucks");
        boolean result3 = search("dogg");

        int a = 4;
    }

    public static boolean search(String word){
        if(rootNode == null)
            return false;

        HashMap<Character, TrieNode> children = rootNode.children;
        TrieNode currNode= null;

        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(children.containsKey(c)){
                currNode = children.get(c);
                children = currNode.children;
            }else{
                currNode = null;
                break;
            }
        }
        if(currNode != null && currNode.isLeaf){
            return true;
        }
        return false;
    }

    public static void insert(String word){
        if(rootNode == null){
            rootNode = new TrieNode();
        }

        if(word == null)
            return;

        HashMap<Character, TrieNode> children = rootNode.children;

        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode currNode;

            if(children.containsKey(c)){
                currNode = children.get(c);
            }else{
                currNode = new TrieNode(c);
                children.put(c, currNode);
            }

            children = currNode.children;

            if(i == word.length() - 1){
                currNode.setLeaf(true);
            }
        }
    }
}
