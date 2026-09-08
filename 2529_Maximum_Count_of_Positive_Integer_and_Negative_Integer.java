class Solution {
    public int maximumCount(int[] nums) {
        int negCount = lowerBound(nums, 0);       
        int firstPosIndex = lowerBound(nums, 1);  
        int posCount = nums.length - firstPosIndex;
        
        return Math.max(negCount, posCount);
    }
    
    private int lowerBound(int[] nums, int target) {
        int left = 0, right = nums.length;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
}