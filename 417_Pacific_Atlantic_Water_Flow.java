class Solution {
    private int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return result;
        }

        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        // DFS from vertical ocean borders
        for (int i = 0; i < m; i++) {
            dfs(heights, pacific, i, 0);       // Left edge (Pacific)
            dfs(heights, atlantic, i, n - 1);  // Right edge (Atlantic)
        }

        // DFS from horizontal ocean borders
        for (int j = 0; j < n; j++) {
            dfs(heights, pacific, 0, j);       // Top edge (Pacific)
            dfs(heights, atlantic, m - 1, j);  // Bottom edge (Atlantic)
        }

        // Collect all cells reachable by both oceans
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private void dfs(int[][] heights, boolean[][] visited, int r, int c) {
        visited[r][c] = true;

        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            // In bounds, not visited yet, and water can flow backwards (uphill or equal)
            if (nr >= 0 && nr < heights.length && nc >= 0 && nc < heights[0].length) {
                if (!visited[nr][nc] && heights[nr][nc] >= heights[r][c]) {
                    dfs(heights, visited, nr, nc);
                }
            }
        }
    }
}