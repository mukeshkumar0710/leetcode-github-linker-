class Solution {
    public int countPrimeSetBits(int left, int right) {
        int primeMask = 0b10100010100010101100;
        int count = 0;

        for (int i = left; i <= right; i++) {
            int setBits = Integer.bitCount(i);
            if (((primeMask >> setBits) & 1) == 1) {
                count++;
            }
        }

        return count;
    }
}