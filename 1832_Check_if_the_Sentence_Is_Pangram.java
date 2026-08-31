class Solution {
    public boolean checkIfPangram(String sentence) {
        if (sentence.length() < 26) {
            return false;
        }

        int seen = 0;
        for (char c : sentence.toCharArray()) {
            seen |= (1 << (c - 'a'));
        }

        return seen == (1 << 26) - 1;
    }
}