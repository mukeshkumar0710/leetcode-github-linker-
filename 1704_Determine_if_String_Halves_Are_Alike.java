class Solution {
    public boolean halvesAreAlike(String s) {
        String vowels = "aeiouAEIOU";
        int count = 0;
        int mid = s.length() / 2;

        for (int i = 0; i < mid; i++) {
            if (vowels.indexOf(s.charAt(i)) != -1) {
                count++;
            }
            if (vowels.indexOf(s.charAt(mid + i)) != -1) {
                count--;
            }
        }

        return count == 0;

        
    }
}