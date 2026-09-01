class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        int[] mask = new int[101];

        for (int num : nums1) {
            mask[num] |= 1; 
        }
        for (int num : nums2) {
            mask[num] |= 2; 
        }
        for (int num : nums3) {
            mask[num] |= 4; 
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            if (Integer.bitCount(mask[i]) >= 2) {
                result.add(i);
            }
        }

        return result;
    }
}