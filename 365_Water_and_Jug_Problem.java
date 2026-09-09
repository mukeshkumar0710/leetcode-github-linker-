class Solution {
    public boolean canMeasureWater(int x, int y, int target) {
        // The total water cannot exceed the combined capacity of both jugs
        if (target > x + y) {
            return false;
        }

        // A target of 0 is always achievable (both empty)
        if (target == 0) {
            return true;
        }

        // Target must be a multiple of gcd(x, y)
        return target % gcd(x, y) == 0;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}