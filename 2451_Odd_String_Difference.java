class Solution {
    public String oddString(String[] words) {
        int[] diff0 = getDiff(words[0]);
        int[] diff1 = getDiff(words[1]);

        if (Arrays.equals(diff0, diff1)) {
            for (int i = 2; i < words.length; i++) {
                if (!Arrays.equals(diff0, getDiff(words[i]))) {
                    return words[i];
                }
            }
        } else {
            int[] diff2 = getDiff(words[2]);
            return Arrays.equals(diff0, diff2) ? words[1] : words[0];
        }

        return "";
    }
    private int[] getDiff(String s) {
        int[] diff = new int[s.length() - 1];
        for (int i = 0; i < s.length() - 1; i++) {
            diff[i] = s.charAt(i + 1) - s.charAt(i);
        }
        return diff;
    }
}