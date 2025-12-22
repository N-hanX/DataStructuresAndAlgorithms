package study_lc;

public class WordSearch {
    public static void main(String[] args) {
//        String word = "ABCCED";
//        String word = "SEE";
//        String word = "ABCB";
//        char[][] board = new char[][]{{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};

        String word = "cdba";
        char[][] board = new char[][]{{'a', 'b'}, {'c', 'd'}};

        boolean result = exist(board, word);

        int a = 4;
    }

    public static boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];

        int rowLen = board.length;
        int colLen = board[0].length;

        for(int i = 0; i < rowLen; i++ ){
            for(int j = 0; j < colLen; j++ ){
                visited = new boolean[board.length][board[0].length];
                boolean result = dfs(board, visited, word, i, j, new StringBuilder(), 0);
                if(result)
                    return true;
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board, boolean[][] visited, String word, int rowInd, int colInd,
                              StringBuilder currStringBuilder, int currInd){
        int rowLen = board.length - 1;
        int colLen = board[0].length - 1;

        if(rowInd > rowLen || rowInd < 0 || colInd > colLen || colInd < 0){
            return false;
        }

        if(visited[rowInd][colInd]){
            return false;
        }

        if(currInd >= word.length() || word.charAt(currInd) != board[rowInd][colInd])
            return false;


        visited[rowInd][colInd] = true;
        currStringBuilder.append(board[rowInd][colInd]);


        if(currStringBuilder.toString().equals(word))
            return true;

        boolean result1 = dfs(board, visited, word, rowInd - 1, colInd, currStringBuilder, currInd + 1);
        if(result1)
            return true;

        boolean result2 = dfs(board, visited, word, rowInd, colInd - 1, currStringBuilder, currInd + 1);
        if(result2)
            return true;

        boolean result3 = dfs(board, visited, word, rowInd + 1, colInd, currStringBuilder, currInd + 1);
        if(result3)
            return true;

        boolean result4 = dfs(board, visited, word, rowInd, colInd + 1, currStringBuilder, currInd + 1);
        if(result4)
            return true;

        visited[rowInd][colInd] = false;
        currStringBuilder.deleteCharAt(currStringBuilder.length() - 1);
        return false;
    }
}
