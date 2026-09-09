class Solution {
    private static final int MOD = 1337;

    public int superPow(int a, int[] b) {
        a %= MOD;
        int result = 1;

        for (int digit : b) {
            // result = (result^10 * a^digit) % MOD
            result = (modPow(result, 10) * modPow(a, digit)) % MOD;
        }

        return result;
    }

    // Computes (base^exp) % MOD using fast exponentiation
    private int modPow(int base, int exp) {
        int res = 1;
        base %= MOD;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = (res * base) % MOD;
            }
            base = (base * base) % MOD;
            exp >>= 1;
        }

        return res;
    }
}