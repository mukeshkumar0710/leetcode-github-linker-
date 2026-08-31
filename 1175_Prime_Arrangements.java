class Solution {
    public int numPrimeArrangements(int n) {
        int primeCount = countPrimes(n);
        int nonPrimeCount = n - primeCount;

        long mod = 1_000_000_007L;
        long result = 1;

        for (int i = 2; i <= primeCount; i++) {
            result = (result * i) % mod;
        }

        for (int i = 2; i <= nonPrimeCount; i++) {
            result = (result * i) % mod;
        }

        return (int) result;
    }
    private int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    private boolean isPrime(int val) {
        if (val < 2) return false;
        for (int i = 2; i * i <= val; i++) {
            if (val % i == 0) return false;
        }
        return true;
    }
}