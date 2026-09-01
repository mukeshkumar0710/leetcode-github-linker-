class Solution {
    public int countPoints(String rings) {
        int[] rodMask = new int[10];

        for (int i = 0; i < rings.length(); i += 2) {
            char color = rings.charAt(i);
            int rod = rings.charAt(i + 1) - '0';

            if (color == 'R') {
                rodMask[rod] |= 1;
            } else if (color == 'G') {
                rodMask[rod] |= 2;
            } else if (color == 'B') {
                rodMask[rod] |= 4;
            }
        }

        int count = 0;
        for (int mask : rodMask) {
            if (mask == 7) {
                count++;
            }
        }

        return count;
    }
}