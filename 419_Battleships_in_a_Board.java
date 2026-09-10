class Solution {
    public int countBattleships(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return 0;
        }

        int m = board.length;
        int n = board[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // If it's an empty cell, skip
                if (board[i][j] == '.') {
                    continue;
                }

                // If the cell directly above is 'X', this cell is not the head
                if (i > 0 && board[i - 1][j] == 'X') {
                    continue;
                }

                // If the cell directly to the left is 'X', this cell is not the head
                if (j > 0 && board[i][j - 1] == 'X') {
                    continue;
                }

                // Both checks passed: (i, j) is the head of a unique battleship
                count++;
            }
        }

        return count;
    }
}