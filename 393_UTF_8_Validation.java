class Solution {
    public boolean validUtf8(int[] data) {
        int remainingBytes = 0;

        for (int num : data) {
            if (remainingBytes == 0) {
                // Determine how many bytes this character consists of
                if ((num >> 7) == 0b0) {
                    remainingBytes = 0; // 1-byte character: 0xxxxxxx
                } else if ((num >> 5) == 0b110) {
                    remainingBytes = 1; // 2-byte character: 110xxxxx
                } else if ((num >> 4) == 0b1110) {
                    remainingBytes = 2; // 3-byte character: 1110xxxx
                } else if ((num >> 3) == 0b11110) {
                    remainingBytes = 3; // 4-byte character: 11110xxx
                } else {
                    return false; // Invalid leading byte
                }
            } else {
                // Continuation bytes must start with 10xxxxxx
                if ((num >> 6) != 0b10) {
                    return false;
                }
                remainingBytes--;
            }
        }

        // Must end with 0 unfinished continuation bytes
        return remainingBytes == 0;
    }
}