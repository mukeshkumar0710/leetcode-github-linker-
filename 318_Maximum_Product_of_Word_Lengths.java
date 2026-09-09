class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] masks = new int[n];
        int[] lengths = new int[n];

        // Precompute the bitmask and length for each word
        for (int i = 0; i < n; i++) {
            int mask = 0;
            String word = words[i];
            lengths[i] = word.length();

            for (int k = 0; k < lengths[i]; k++) {
                mask |= 1 << (word.charAt(k) - 'a');
            }
            masks[i] = mask;
        }

        int maxProd = 0;

        // Compare pairs using bitwise AND
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((masks[i] & masks[j]) == 0) {
                    maxProd = Math.max(maxProd, lengths[i] * lengths[j]);
                }
            }
        }

        return maxProd;
    }
}