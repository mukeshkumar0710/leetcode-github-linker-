class Solution {
    public List<Integer> intersection(int[][] nums) {
        int[] count = new int[1001];
        int n = nums.length;

        for (int[] row : nums) {
            for (int val : row) {
                count[val]++;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            if (count[i] == n) {
                result.add(i);
            }
        }

        return result;
    }
}