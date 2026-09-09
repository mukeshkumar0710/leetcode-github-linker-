class Solution {
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= first) {
                first = num; // Smallest value seen so far
            } else if (num <= second) {
                second = num; // Smallest value seen that is greater than first
            } else {
                // Found a number greater than both first and second
                return true;
            }
        }

        return false;
    }
}