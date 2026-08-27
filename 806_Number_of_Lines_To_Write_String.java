class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        int lines = 1;
        int current = 0;

        for (int i = 0; i < s.length(); i++) {
            int width = widths[s.charAt(i) - 'a'];

            if (current + width <= 100) {
                current += width;
            } else {
                lines++;
                current = width;
            }
        }

        return new int[]{lines, current};
        
    }
}