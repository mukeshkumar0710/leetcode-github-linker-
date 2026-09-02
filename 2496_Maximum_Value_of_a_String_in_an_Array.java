class Solution {
    public int maximumValue(String[] strs) {
        int maxValue = 0;

        for (String s : strs) {
            boolean onlyDigits = true;

            for (char c : s.toCharArray()) {
                if (!Character.isDigit(c)) {
                    onlyDigits = false;
                    break;
                }
            }

            int val = onlyDigits ? Integer.parseInt(s) : s.length();
            maxValue = Math.max(maxValue, val);
        }

        return maxValue;
    }
}