class Solution {
    public int findClosestNumber(int[] nums) {
        int closest = nums[0];

        for (int num : nums) {
            int absNum = Math.abs(num);
            int absClosest = Math.abs(closest);

            if (absNum < absClosest || (absNum == absClosest && num > closest)) {
                closest = num;
            }
        }

        return closest;
    }
}