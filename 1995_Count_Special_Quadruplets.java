class Solution {
    public int countQuadruplets(int[] nums) {
        int n = nums.length;
        int count = 0;
        int[] countMap = new int[101];

        for (int b = n - 2; b >= 1; b--) {
            int c = b + 1;
            for (int d = c + 1; d < n; d++) {
                if (nums[d] - nums[c] >= 0) {
                    countMap[nums[d] - nums[c]]++;
                }
            }
            
            for (int a = 0; a < b; a++) {
                int sum = nums[a] + nums[b];
                if (sum <= 100) {
                    count += countMap[sum];
                }
            }
        }
        
        return count;
    }
}