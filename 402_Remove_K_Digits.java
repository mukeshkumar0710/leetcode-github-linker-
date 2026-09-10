class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        if (k >= n) return "0";

        StringBuilder stack = new StringBuilder();

        for (int i = 0; i < n; i++) {
            char c = num.charAt(i);

            // Pop larger digits from the stack while we still have deletions available
            while (k > 0 && stack.length() > 0 && stack.charAt(stack.length() - 1) > c) {
                stack.deleteCharAt(stack.length() - 1);
                k--;
            }

            stack.append(c);
        }

        // If k removals remain, remove them from the end (since it's non-decreasing)
        while (k > 0 && stack.length() > 0) {
            stack.deleteCharAt(stack.length() - 1);
            k--;
        }

        // Strip leading zeros
        int nonZeroIdx = 0;
        while (nonZeroIdx < stack.length() && stack.charAt(nonZeroIdx) == '0') {
            nonZeroIdx++;
        }

        String result = stack.substring(nonZeroIdx);
        return result.isEmpty() ? "0" : result;
    }
}