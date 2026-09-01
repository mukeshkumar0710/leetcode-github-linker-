class Solution {
    public int countVowelSubstrings(String word) {
        int count = 0;
        int n = word.length();

        for (int i = 0; i < n; i++) {
            if (!isVowel(word.charAt(i))) {
                continue;
            }

            Set<Character> seen = new HashSet<>();
            for (int j = i; j < n; j++) {
                char ch = word.charAt(j);
                if (!isVowel(ch)) {
                    break; 
                }
                seen.add(ch);
                if (seen.size() == 5) {
                    count++;
                }
            }
        }

        return count;
    }
    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}