class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            // Map value to 0-based index
            int index = Math.abs(nums[i]) - 1;

            // If the element at this index is already negative, we've seen this number before
            if (nums[index] < 0) {
                result.add(index + 1);
            } else {
                // Mark as visited by negating
                nums[index] = -nums[index];
            }
        }

        return result;
    }
}