class Solution {
    public int unequalTriplets(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int x : nums) {
            count.put(x, count.getOrDefault(x, 0) + 1);
        }

        int triplets = 0;
        int left = 0;
        int right = nums.length;

        for (int freq : count.values()) {
            right -= freq;
            triplets += left * freq * right;
            left += freq;
        }

        return triplets;
    }
}