public class WordSearch {
    public boolean exist(char[][] board, String word) {
        char first = word.charAt(0);
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == first) {
                    boolean found = traverse(board, word, 1, i, j, n, m, word.length());
                    if (found)
                        return true;
                }
            }
        }
        return false;
    }

    private boolean traverse(char[][] board, String word, int index, int i, int j, int n, int m, int l) {
        if (index == word.length())
            return true;
        char c = board[i][j];
        board[i][j] = 0;
        boolean found = false;
        if (i != 0 && board[i - 1][j] == word.charAt(index)) {
            found = found || traverse(board, word, index + 1, i - 1, j, n, m, l);
        }
        if (j != 0 && board[i][j - 1] == word.charAt(index)) {
            found = found || traverse(board, word, index + 1, i, j - 1, n, m, l);
        }
        if (i != n - 1 && board[i + 1][j] == word.charAt(index)) {
            found = found || traverse(board, word, index + 1, i + 1, j, n, m, l);
        }
        if (j != m - 1 && board[i][j + 1] == word.charAt(index)) {
            found = found || traverse(board, word, index + 1, i, j + 1, n, m, l);
        }
        board[i][j] = c;
        return found;
    }

}