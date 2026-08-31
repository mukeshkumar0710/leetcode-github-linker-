class Solution {
    public int numDifferentIntegers(String word) {
        Set<String> set = new HashSet<>();
        int n = word.length();
        int i = 0;

        while (i < n) {
            if (Character.isDigit(word.charAt(i))) {
                int start = i;
                while (i < n && Character.isDigit(word.charAt(i))) {
                    i++;
                }

                while (start < i - 1 && word.charAt(start) == '0') {
                    start++;
                }

                set.add(word.substring(start, i));
            } else {
                i++;
            }
        }

        return set.size();
    }
}