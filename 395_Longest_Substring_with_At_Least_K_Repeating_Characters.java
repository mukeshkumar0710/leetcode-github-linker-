class Solution {
    public int longestSubstring(String s, int k) {
        return divideAndConquer(s, 0, s.length(), k);
    }

    private int divideAndConquer(String s, int start, int end, int k) {
        if (end - start < k) {
            return 0;
        }

        // Count frequencies of characters in the current substring
        int[] count = new int[26];
        for (int i = start; i < end; i++) {
            count[s.charAt(i) - 'a']++;
        }

        // Search for a character that violates the condition (frequency < k)
        for (int i = start; i < end; i++) {
            if (count[s.charAt(i) - 'a'] < k) {
                // Find the next character that is valid to skip adjacent invalid chars
                int next = i + 1;
                while (next < end && count[s.charAt(next) - 'a'] < k) {
                    next++;
                }

                // Split at the invalid character(s) and take the maximum length
                int left = divideAndConquer(s, start, i, k);
                int right = divideAndConquer(s, next, end, k);

                return Math.max(left, right);
            }
        }

        // If all characters meet the frequency >= k condition, the whole window is valid
        return end - start;
    }
}