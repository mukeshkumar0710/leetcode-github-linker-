class Solution {
    public int deleteGreatestValue(int[][] grid) {
        for (int[] row : grid) {
            Arrays.sort(row);
        }

        int total = 0;
        int m = grid.length;
        int n = grid[0].length;

        for (int col = 0; col < n; col++) {
            int maxCol = 0;
            for (int row = 0; row < m; row++) {
                maxCol = Math.max(maxCol, grid[row][col]);
            }
            total += maxCol;
        }

        return total;
    }
}