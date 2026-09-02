class Solution {
    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        Set<Integer> sums = new HashSet<>();

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            sums.add(nums[left] + nums[right]);
            left++;
            right--;
        }

        return sums.size();
    }
}