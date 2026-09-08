class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int prev2 = 1; // Represents dp[i - 2]
        int prev1 = 1; // Represents dp[i - 1]

        for (int i = 1; i < s.length(); i++) {
            int current = 0;

            // Single digit decoding (1-9)
            if (s.charAt(i) != '0') {
                current += prev1;
            }

            // Two-digit decoding (10-26)
            int twoDigit = (s.charAt(i - 1) - '0') * 10 + (s.charAt(i) - '0');
            if (twoDigit >= 10 && twoDigit <= 26) {
                current += prev2;
            }

            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}