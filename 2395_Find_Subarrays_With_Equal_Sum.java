class Solution {
    public boolean findSubarrays(int[] nums) {
        Set<Integer> seenSums = new HashSet<>();

        for (int i = 0; i < nums.length - 1; i++) {
            int sum = nums[i] + nums[i + 1];
            if (!seenSums.add(sum)) {
                return true;
            }
        }

        return false;
    }
}