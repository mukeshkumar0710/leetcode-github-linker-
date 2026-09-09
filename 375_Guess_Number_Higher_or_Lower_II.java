class Solution {
    public int getMoneyAmount(int n) {
        // dp[i][j] represents the minimum money needed to guarantee a win in the range [i, j]
        int[][] dp = new int[n + 2][n + 2];

        // Solve for ranges of increasing length
        for (int len = 2; len <= n; len++) {
            for (int i = 1; i <= n - len + 1; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;

                // Pick every possible guess k in [i, j]
                for (int k = i; k <= j; k++) {
                    // Worst-case cost for choosing k
                    int cost = k + Math.max(dp[i][k - 1], dp[k + 1][j]);
                    // Minimize the worst-case cost across all possible choices of k
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        return dp[1][n];
    }
}