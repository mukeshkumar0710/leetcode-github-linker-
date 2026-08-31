class Solution {
    public int[] getNoZeroIntegers(int n) {
        for (int a = 1; a < n; a++) {
            int b = n - a;
            if (isNoZero(a) && isNoZero(b)) {
                return new int[]{a, b};
            }
        }
        return new int[]{};
    }

    private boolean isNoZero(int val) {
        while (val > 0) {
            if (val % 10 == 0) {
                return false;
            }
            val /= 10;
        }
        return true;
    }
}