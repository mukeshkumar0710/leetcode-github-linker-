class Solution {
    public int countValidWords(String sentence) {
        String[] tokens = sentence.trim().split("\\s+");
        int count = 0;

        for (String token : tokens) {
            if (!token.isEmpty() && isValid(token)) {
                count++;
            }
        }

        return count;
    }

    private boolean isValid(String token) {
        int hyphenCount = 0;
        int punctCount = 0;
        int n = token.length();

        for (int i = 0; i < n; i++) {
            char ch = token.charAt(i);
            if (Character.isDigit(ch)) {
                return false;
            }
            if (ch == '-') {
                hyphenCount++;
                if (hyphenCount > 1) {
                    return false;
                }
                if (i == 0 || i == n - 1) {
                    return false;
                }
                if (!Character.isLowerCase(token.charAt(i - 1)) || !Character.isLowerCase(token.charAt(i + 1))) {
                    return false;
                }
            }

            if (ch == '!' || ch == '.' || ch == ',') {
                punctCount++;
                if (punctCount > 1 || i != n - 1) {
                    return false; 
                }
            }
        }

        return true;
    }
}