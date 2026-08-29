class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] minRow = new int[m];
        for (int i = 0; i < m; i++) {
            int minVal = matrix[i][0];
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] < minVal) {
                    minVal = matrix[i][j];
                }
            }
            minRow[i] = minVal;
        }
     
        int[] maxCol = new int[n];
        for (int j = 0; j < n; j++) {
            int maxVal = matrix[0][j];
            for (int i = 1; i < m; i++) {
                if (matrix[i][j] > maxVal) {
                    maxVal = matrix[i][j];
                }
            }
            maxCol[j] = maxVal;
        }
        
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == minRow[i] && matrix[i][j] == maxCol[j]) {
                    result.add(matrix[i][j]);
                }
            }
        }
        
        return result;
    }
}