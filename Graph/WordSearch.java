package Graph;// Given a 2D board and a word, find if the word exists in the grid.
//
//The word can be constructed from letters of sequentially adjacent cell,
// where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
//board = [['A','B','C','E'],
//        ['S','F','C','S'],
//        ['A','D','E','E']]
//
//Given word = "ABCCED", return true.
//Given word = "SEE", return true.
//Given word = "ABCB", return false.

public class WordSearch {

    boolean visited[][];
    public boolean exist(char[][] board, String word) {

        visited = new boolean[board.length][board[0].length];
        for (int i=0; i<board.length; i++){
            for (int j=0;j<board[0].length; j++){
                if(board[i][j] == word.charAt(0) && search(i,j,0,board, word))
                    return true;
            }
        }
        return false;
    }

    private boolean search(int i, int j, int index, char[][] board, String word) {
        if(index == word.length())
            return true;
        if(i>=board.length || i<0 || j>=board[0].length || j<0 || visited[i][j] || word.charAt(index)!=board[i][j])
            return false;

        visited[i][j] = true;
        if(search(i+1, j, index+1, board, word)||
                search(i-1, j, index+1, board, word)||
                search(i, j+1, index+1, board, word)||
                search(i, j-1, index+1, board, word))
            return true;

        visited[i][j]=false;
        return false;
    }

    public static void main(String[] args) {

        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        WordSearch search = new WordSearch();
        System.out.println(search.exist(board,"ABCCED"));

    }

}
