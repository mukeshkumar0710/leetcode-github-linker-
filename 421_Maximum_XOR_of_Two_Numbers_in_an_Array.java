class Solution {
    public int findMaximumXOR(int[] nums) {
        int maxXor = 0;
        int mask = 0;

        // Check each bit from MSB (bit 30) down to LSB (bit 0)
        for (int i = 30; i >= 0; i--) {
            // Include bit i in the mask
            mask |= (1 << i);

            Set<Integer> prefixes = new HashSet<>();
            for (int num : nums) {
                prefixes.add(num & mask);
            }

            // Greedily hypothesize that bit i can be set to 1 in maxXor
            int candidate = maxXor | (1 << i);

            // Property: If a ^ b = candidate, then a ^ candidate = b
            for (int prefix : prefixes) {
                if (prefixes.contains(prefix ^ candidate)) {
                    maxXor = candidate;
                    break;
                }
            }
        }

        return maxXor;
    }
}