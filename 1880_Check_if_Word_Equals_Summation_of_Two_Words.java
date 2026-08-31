class Solution {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        return getNumericalValue(firstWord) + getNumericalValue(secondWord) == getNumericalValue(targetWord);
    }

    private int getNumericalValue(String word) {
        int val = 0;
        for (char c : word.toCharArray()) {
            val = val * 10 + (c - 'a');
        }
        return val;
    }
}