package study4_a;

import java.util.*;

public class WordSearchII_212 {
    static void main() {
        WordSearchII_212 wordSearchII212 = new WordSearchII_212();

        // TEST1
//        char[][] board = new char[][]{{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
//        String[] words = new String[]{"oath","pea","eat","rain"};
//        List<String> result = wordSearchII212.findWords(board, words);
//        int a = 4;


        // TEST2
//        char[][] board = new char[][]{{'a','b'}, {'c','d'}};
//        String[] words = new String[]{"abcb"};
//        List<String> result = wordSearchII212.findWords(board, words);
//        int a = 4;

        // TEST3
//        char[][] board = new char[][]{{'a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a'}};
//        String[] words = new String[]{"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
//        List<String> result = wordSearchII212.findWords(board, words);
//        int a = 4;

        // TEST4
        char[][] board = new char[][]{{'o','a','b','n'},{'o','t','a','e'},{'a','h','k','r'},{'a','f','l','v'}};
        String[] words = new String[]{"oa","oaa"};
        List<String> result = wordSearchII212.findWords(board, words);
        int a = 4;

    }

    boolean[][] visited;
    Trie root;
    Set<String> resultSet;

    class Trie{
        Trie[] next = new Trie[26];
        String theWord;
        public Trie(){
            theWord = null;
        }
    }

    public void createBoardTrie_v2(String[] words){
        if (root == null) {
            root = new Trie();
        }

        for (String word : words) {
            Trie temp = root;
            for (int j = 0; j < word.length(); j++) {
                char curr_char = word.charAt(j);
                if (temp != null && temp.next[curr_char - 'a']  == null) {
                    temp.next[curr_char - 'a'] = new Trie();
                }
                temp = temp.next[curr_char - 'a'];
            }
            if (temp != null)
                temp.theWord = word;
        }
    }

    public List<String> findWords(char[][] board, String[] words){
        createBoardTrie_v2(words);
        Trie temp = root;
        visited = new boolean[board.length][board[0].length];
        resultSet = new HashSet<>();

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++) {
                traverseTrieWithBoard(board, i, j, temp);
            }
        }

        List<String> result = new ArrayList<>();
        result.addAll(resultSet);
        return result;
    }

    public void traverseTrieWithBoard(char[][] board, int indx, int indy, Trie root) {
        if (outOfBoard(board, indx, indy) || (!outOfBoard(board, indx, indy) && visited[indx][indy])) {
            return;
        }

        char curr_char = board[indx][indy];

        if (root.next[curr_char - 'a'] == null) {
            return;
        }
        root = root.next[curr_char - 'a'];
        if (root.theWord != null) {
            resultSet.add(root.theWord);
        }


        visited[indx][indy] = true;
        traverseTrieWithBoard(board, indx, indy + 1, root);
        traverseTrieWithBoard(board, indx, indy - 1, root);
        traverseTrieWithBoard(board, indx - 1, indy, root);
        traverseTrieWithBoard(board, indx + 1, indy, root);

        visited[indx][indy] = false;
    }

    public boolean outOfBoard(char[][] board, int indx, int indy){
        if(board.length <= indx || indx < 0){
            return true;
        }

        if(board[0].length <= indy || indy < 0){
            return true;
        }
        return false;
    }
}
