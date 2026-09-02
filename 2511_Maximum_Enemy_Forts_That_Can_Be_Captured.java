class Solution {
    public int captureForts(int[] forts) {
        int maxForts = 0;
        int lastIdx = -1;

        for (int i = 0; i < forts.length; i++) {
            if (forts[i] != 0) {
                if (lastIdx != -1 && forts[i] != forts[lastIdx]) {
                    maxForts = Math.max(maxForts, i - lastIdx - 1);
                }
                lastIdx = i;
            }
        }

        return maxForts;
    }
}