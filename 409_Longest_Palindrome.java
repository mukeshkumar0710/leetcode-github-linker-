class Solution {
    public int longestPalindrome(String s) {
        int[] count = new int[128];
        for (char c : s.toCharArray()) {
            count[c]++;
        }

        int length = 0;
        for (int v : count) {
            length += (v / 2) * 2;
            if (length % 2 == 0 && v % 2 == 1) {
                length++;
            }
        }

        return length;
    }
}