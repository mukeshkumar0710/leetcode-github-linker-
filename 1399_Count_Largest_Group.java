class Solution {
    public int countLargestGroup(int n) {
        int[] count = new int[37];
        int maxSize = 0;

        for (int i = 1; i <= n; i++) {
            int sum = getDigitSum(i);
            count[sum]++;
            if (count[sum] > maxSize) {
                maxSize = count[sum];
            }
        }

        int result = 0;
        for (int c : count) {
            if (c == maxSize) {
                result++;
            }
        }

        return result;
    }

    private int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}