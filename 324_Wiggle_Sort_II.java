class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        // Fill odd indices with larger half from the end down
        int left = (n - 1) / 2; // End of smaller half
        int right = n - 1;      // End of larger half

        for (int i = 1; i < n; i += 2) {
            nums[i] = sorted[right--];
        }

        // Fill even indices with smaller half from the end down
        for (int i = 0; i < n; i += 2) {
            nums[i] = sorted[left--];
        }
    }
}