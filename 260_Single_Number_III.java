class Solution {
    public int[] singleNumber(int[] nums) {
        int xorSum = 0;
        for (int num : nums) {
            xorSum ^= num;
        }

        long lowestBit = (long) xorSum & -(long) xorSum;

        int a = 0;
        int b = 0;

       
        for (int num : nums) {
            if ((num & lowestBit) != 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }

        return new int[]{a, b};
    }
}