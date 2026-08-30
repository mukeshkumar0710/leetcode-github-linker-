class Solution {
    public boolean checkRecord(String s) {
        int absentCount = 0;
        int consecutiveLate = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == 'A') {
                absentCount++;
                if (absentCount >= 2) {
                    return false;
                }
                consecutiveLate = 0;
            } else if (c == 'L') {
                consecutiveLate++;
                if (consecutiveLate >= 3) {
                    return false;
                }
            } else {
                consecutiveLate = 0;
            }
        }

        return true;
    }
}