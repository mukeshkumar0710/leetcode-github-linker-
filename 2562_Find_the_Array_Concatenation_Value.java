class Solution {
    public long findTheArrayConcVal(int[] nums) {
        long totalConcVal = 0;
        int i = 0;
        int j = nums.length - 1;

        while (i < j) {
            String combined = Integer.toString(nums[i]) + Integer.toString(nums[j]);
            totalConcVal += Long.parseLong(combined);
            i++;
            j--;
        }

        if (i == j) {
            totalConcVal += nums[i];
        }

        return totalConcVal;
    }
}