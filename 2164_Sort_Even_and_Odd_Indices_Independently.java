class Solution {
    public int[] sortEvenOdd(int[] nums) {
        int n = nums.length;
        int evenCount = (n + 1) / 2;
        int oddCount = n / 2;

        int[] even = new int[evenCount];
        int[] odd = new int[oddCount];

        int eIdx = 0, oIdx = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                even[eIdx++] = nums[i];
            } else {
                odd[oIdx++] = nums[i];
            }
        }

        Arrays.sort(even);
        Arrays.sort(odd);

        eIdx = 0;
        oIdx = oddCount - 1;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                nums[i] = even[eIdx++];
            } else {
                nums[i] = odd[oIdx--];
            }
        }

        return nums;
    }
}