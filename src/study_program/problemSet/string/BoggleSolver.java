package study_program.problemSet.string;

import java.util.*;

public class BoggleSolver {
    public static void main(String[] args) {
        ArrayList<String> dictionary = new ArrayList<>(Arrays.asList("bst", "heap", "tree"));
        ArrayList<String> mat = new ArrayList<>(Arrays.asList("bsh", "tee", "arh"));

        ArrayList<String> result = boggle_solver(dictionary, mat);

        int a = 4;
    }

    static class Coordinator{
        int row;
        int col;

        public Coordinator(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coordinator that = (Coordinator) o;
            return row == that.row && col == that.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }

    static class TrieNode{
        char c;
        Coordinator coordinator;
        Map<Character, Set<TrieNode>> children;

        public TrieNode(char c, Coordinator coordinator) {
            this.c = c;
            this.coordinator = coordinator;
            children = new HashMap<>();
        }

        public TrieNode(){
            children = new HashMap<>();
        }
    }

    static TrieNode root;
    static Map<Coordinator, TrieNode> allTrie;

    static ArrayList<String> boggle_solver(ArrayList<String> dictionary, ArrayList<String> mat) {
        createTrie(mat);
        ArrayList<String> result = new ArrayList<>();

        for(int i = 0; i < dictionary.size(); i++){
            String word = dictionary.get(i);
            Map<Character, Set<TrieNode>> children = root.children;
            Set<TrieNode> visited = new HashSet<>();

            if(dfs_word(word, children, 0, visited))
                result.add(word);
        }

        return result;
    }

    static boolean dfs_word(String word, Map<Character, Set<TrieNode>> children, int currInd, Set<TrieNode> visited){
        if(currInd == word.length())
            return true;

        char character = word.charAt(currInd);

        if (children.containsKey(character)) {
            Set<TrieNode> possibilities = children.get(character);

            for (TrieNode node : possibilities) {
                visited.add(node);
                children = node.children;
                boolean result = dfs_word(word, children, currInd + 1, visited);
                if (result) {
                    return true;
                }
                visited.remove(node);
            }
        }
        return false;
    }


    static void createTrie(ArrayList<String> mat){
        allTrie = new HashMap<>();
        root = new TrieNode();
        Map<Character, Set<TrieNode>> children = root.children;

        for(int i = 0; i < mat.size(); i++){
            for(int j = 0; j < mat.get(0).length(); j++){
//                System.out.println("Row: "+ i + " col: " + j  + " Character: " + character);

                char character = mat.get(i).charAt(j);
                Coordinator coordinator = new Coordinator(i, j);
                TrieNode node = new TrieNode(character, coordinator);
                allTrie.put(new Coordinator(i, j), node);
                if(children.containsKey(mat.get(i).charAt(j))){
                    Set<TrieNode> currChildren = children.get(character);
                    currChildren.add(node);
                }else{
                    Set<TrieNode> newChild = new HashSet<>();
                    newChild.add(node);
                    children.put(character, newChild);
                }
            }
        }

        Set<Coordinator> visited = new HashSet<>();

        for(Coordinator coordinator : allTrie.keySet()){
            TrieNode child = allTrie.get(coordinator);
            dfs_createChildren(visited, child, mat);
        }
    }

    public static void dfs_createChildren(Set<Coordinator> visited, TrieNode child, ArrayList<String> mat){
        Coordinator coordinator = child.coordinator;;

        if(visited.contains(coordinator)){
            return;
        }
        Map<Character, Set<TrieNode>> children = child.children;
        visited.add(coordinator);

        int rowInd = coordinator.row;
        int colInd = coordinator.col;
//        System.out.println("Row: " + rowInd + " col:" + colInd);

        // create eight neighbor
        if(rowInd > 0){
            Coordinator neighborCoordinator = new Coordinator(rowInd - 1, colInd);
            TrieNode neighNode = addNeighbor(neighborCoordinator, children);

            dfs_createChildren(visited, neighNode, mat);
        }

        if(colInd > 0){
            Coordinator neighborCoordinator = new Coordinator(rowInd, colInd - 1);
            TrieNode neighNode = addNeighbor(neighborCoordinator, children);

            dfs_createChildren(visited, neighNode, mat);
        }

        if(rowInd < mat.size() - 1){
            Coordinator neighborCoordinator = new Coordinator(rowInd + 1, colInd);
            TrieNode neighNode = addNeighbor(neighborCoordinator, children);

            dfs_createChildren(visited, neighNode, mat);
        }

        if(colInd < mat.get(0).length() - 1){
            Coordinator neighborCoordinator = new Coordinator(rowInd, colInd + 1);
            TrieNode neighNode = addNeighbor(neighborCoordinator, children);

            dfs_createChildren(visited, neighNode, mat);
        }

        if(rowInd > 0 && colInd > 0){
            Coordinator neighborCoordinator = new Coordinator(rowInd - 1, colInd - 1);
            TrieNode neighNode = addNeighbor(neighborCoordinator, children);

            dfs_createChildren(visited, neighNode, mat);
        }

        if(rowInd < mat.size() - 1 && colInd < mat.get(0).length() - 1){
            Coordinator neighborCoordinator = new Coordinator(rowInd + 1, colInd + 1);
            TrieNode neighNode = addNeighbor(neighborCoordinator, children);

            dfs_createChildren(visited, neighNode, mat);
        }

        if(rowInd < mat.size() - 1 && colInd > 0){
            Coordinator neighborCoordinator = new Coordinator(rowInd + 1, colInd - 1);
            TrieNode neighNode = addNeighbor(neighborCoordinator, children);

            dfs_createChildren(visited, neighNode, mat);
        }

        if(rowInd > 0 && colInd < mat.get(0).length() - 1){
            Coordinator neighborCoordinator = new Coordinator(rowInd - 1, colInd + 1);
            TrieNode neighNode = addNeighbor(neighborCoordinator, children);

            dfs_createChildren(visited, neighNode, mat);
        }
    }

    public static TrieNode addNeighbor(Coordinator neighborCoordinator, Map<Character, Set<TrieNode>> children){
        TrieNode node = allTrie.get(neighborCoordinator);
        if(children.containsKey(node.c)){
            Set<TrieNode> neighbors = children.get(node.c);
            neighbors.add(node);
        }else{
            Set<TrieNode> neighbors = new HashSet<>();
            neighbors.add(node);
            children.put(node.c, neighbors);
        }
        return node;
    }
}
