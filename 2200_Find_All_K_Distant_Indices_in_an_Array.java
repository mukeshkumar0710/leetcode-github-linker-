class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        int lastAdded = 0;

        for (int j = 0; j < n; j++) {
            if (nums[j] == key) {
                int start = Math.max(lastAdded, j - k);
                int end = Math.min(n - 1, j + k);

                for (int i = start; i <= end; i++) {
                    result.add(i);
                }

                lastAdded = end + 1;
            }
        }

        return result;
    }
}