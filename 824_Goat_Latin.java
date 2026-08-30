class Solution {
    public String toGoatLatin(String sentence) {
        Set<Character> vowels = new HashSet<>(Arrays.asList(
            'a', 'e', 'i', 'o', 'u',
            'A', 'E', 'I', 'O', 'U'
        ));

        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        StringBuilder aSuffix = new StringBuilder("a");

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            char firstChar = word.charAt(0);

            if (vowels.contains(firstChar)) {
                result.append(word);
            } else {
                result.append(word.substring(1)).append(firstChar);
            }

            result.append("ma").append(aSuffix);

            if (i < words.length - 1) {
                result.append(" ");
            }

            aSuffix.append("a");
        }

        return result.toString();
    }
}