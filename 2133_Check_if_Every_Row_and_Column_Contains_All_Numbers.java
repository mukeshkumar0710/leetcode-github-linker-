class Solution {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            boolean[] rowSeen = new boolean[n + 1];
            boolean[] colSeen = new boolean[n + 1];

            for (int j = 0; j < n; j++) {
                int rowVal = matrix[i][j];
                int colVal = matrix[j][i];

                if (rowSeen[rowVal] || colSeen[colVal]) {
                    return false;
                }

                rowSeen[rowVal] = true;
                colSeen[colVal] = true;
            }
        }

        return true;
    }
}