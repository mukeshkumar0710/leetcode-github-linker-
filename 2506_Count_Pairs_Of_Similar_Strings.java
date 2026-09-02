class Solution {
    public int similarPairs(String[] words) {
        Map<Integer, Integer> maskCount = new HashMap<>();
        int pairs = 0;

        for (String word : words) {
            int mask = 0;
            for (char c : word.toCharArray()) {
                mask |= 1 << (c - 'a');
            }

            int count = maskCount.getOrDefault(mask, 0);
            pairs += count;
            maskCount.put(mask, count + 1);
        }

        return pairs;
    }
}