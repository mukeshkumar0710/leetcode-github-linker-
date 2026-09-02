class Solution {
    public boolean equalFrequency(String word) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0) {
                continue;
            }

            freq[i]--;

            if (checkEqual(freq)) {
                return true;
            }

            freq[i]++;
        }

        return false;
    }
    private boolean checkEqual(int[] freq) {
        int commonCount = 0;

        for (int count : freq) {
            if (count == 0) {
                continue;
            }
            if (commonCount == 0) {
                commonCount = count;
            } else if (count != commonCount) {
                return false;
            }
        }

        return true;
    }
}