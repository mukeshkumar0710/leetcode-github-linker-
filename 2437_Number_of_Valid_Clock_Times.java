class Solution {
    public int countTime(String time) {
        int count = 0;

        for (int h = 0; h < 24; h++) {
            for (int m = 0; m < 60; m++) {
                String cur = String.format("%02d:%02d", h, m);
                boolean match = true;

                for (int i = 0; i < 5; i++) {
                    if (time.charAt(i) != '?' && time.charAt(i) != cur.charAt(i)) {
                        match = false;
                        break;
                    }
                }

                if (match) {
                    count++;
                }
            }
        }

        return count;
    }
}