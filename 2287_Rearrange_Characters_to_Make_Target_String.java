class Solution {
    public int rearrangeCharacters(String s, String target) {
        int[] countS = new int[26];
        int[] countTarget = new int[26];

        for (int i = 0; i < s.length(); i++) {
            countS[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < target.length(); i++) {
            countTarget[target.charAt(i) - 'a']++;
        }

        int minCopies = Integer.MAX_VALUE;

        for (int i = 0; i < 26; i++) {
            if (countTarget[i] > 0) {
                minCopies = Math.min(minCopies, countS[i] / countTarget[i]);
            }
        }

        return minCopies;
    }
}