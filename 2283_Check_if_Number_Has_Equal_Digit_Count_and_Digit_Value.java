class Solution {
    public boolean digitCount(String num) {
        int[] count = new int[10];
        int n = num.length();

        for (int i = 0; i < n; i++) {
            count[num.charAt(i) - '0']++;
        }

        for (int i = 0; i < n; i++) {
            int expected = num.charAt(i) - '0';
            if (count[i] != expected) {
                return false;
            }
        }

        return true;
    }
}