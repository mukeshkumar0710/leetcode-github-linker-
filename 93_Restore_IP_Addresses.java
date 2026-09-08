class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) {
            return result;
        }
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int start, List<String> segments, List<String> result) {
        if (segments.size() == 4) {
            if (start == s.length()) {
                result.add(String.join(".", segments));
            }
            return;
        }

        for (int len = 1; len <= 3 && start + len <= s.length(); len++) {
            String sub = s.substring(start, start + len);

            if (isValid(sub)) {
                segments.add(sub);
                backtrack(s, start + len, segments, result);
                segments.remove(segments.size() - 1);
            }
        }
    }

    private boolean isValid(String sub) {
        if (sub.length() > 1 && sub.charAt(0) == '0') {
            return false;
        }
        int val = Integer.parseInt(sub);
        return val >= 0 && val <= 255;
    }
}