class Solution {
    public int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        int maxFreq = 0;
        int result = -1;

        for (int num : nums) {
            if (num % 2 == 0) {
                int count = freq.getOrDefault(num, 0) + 1;
                freq.put(num, count);

                if (count > maxFreq || (count == maxFreq && (result == -1 || num < result))) {
                    maxFreq = count;
                    result = num;
                }
            }
        }

        return result;
    }
}