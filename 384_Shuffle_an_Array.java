class Solution {
    private final int[] original;
    private final Random rand;

    public Solution(int[] nums) {
        this.original = nums;
        this.rand = new Random();
    }

    public int[] reset() {
        return original;
    }

    public int[] shuffle() {
        int[] shuffled = original.clone();

        // Fisher-Yates shuffle
        for (int i = shuffled.length - 1; i > 0; i--) {
            // Pick a random index from 0 to i (inclusive)
            int j = rand.nextInt(i + 1);

            // Swap shuffled[i] and shuffled[j]
            int temp = shuffled[i];
            shuffled[i] = shuffled[j];
            shuffled[j] = temp;
        }

        return shuffled;
    }
}
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */