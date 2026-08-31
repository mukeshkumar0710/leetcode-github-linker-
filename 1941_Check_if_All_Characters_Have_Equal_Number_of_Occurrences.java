class Solution {
    public boolean areOccurrencesEqual(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int targetCount = 0;
        for (int count : freq) {
            if (count > 0) {
                if (targetCount == 0) {
                    targetCount = count;
                } else if (count != targetCount) {
                    return false;
                }
            }
        }

        return true;
    }
}