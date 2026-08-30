class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> result = new ArrayList<>();
        int n = s.length();
        int i = 0;

        for (int j = 0; j < n; j++) {
            if (j == n - 1 || s.charAt(j) != s.charAt(j + 1)) {
                if (j - i + 1 >= 3) {
                    result.add(Arrays.asList(i, j));
                }
                i = j + 1;
            }
        }

        return result;
    }
}