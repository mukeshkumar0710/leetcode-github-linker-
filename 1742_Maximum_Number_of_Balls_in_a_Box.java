class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        int[] count = new int[46];
        int max = 0;

        for (int i = lowLimit; i <= highLimit; i++) {
            int num = i;
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            count[sum]++;
            max = Math.max(max, count[sum]);
        }

        return max;
    }
}