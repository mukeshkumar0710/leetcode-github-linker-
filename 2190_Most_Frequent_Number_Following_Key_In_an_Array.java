class Solution {
    public int mostFrequent(int[] nums, int key) {
        int[] count = new int[1001];
        int maxCount = 0;
        int result = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == key) {
                int target = nums[i + 1];
                count[target]++;
                
                if (count[target] > maxCount) {
                    maxCount = count[target];
                    result = target;
                }
            }
        }

        return result;
    }
}