class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }

        int total = 10; // For n = 1: 0, 1, 2, ..., 9
        int uniqueDigitsProduct = 9;
        int availableDigits = 9;

        for (int i = 2; i <= n && availableDigits > 0; i++) {
            uniqueDigitsProduct *= availableDigits;
            total += uniqueDigitsProduct;
            availableDigits--;
        }

        return total;
    }
}