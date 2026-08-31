class Solution {
    public String reorderSpaces(String text) {
        int spaceCount = 0;
        for (char c : text.toCharArray()) {
            if (c == ' ') {
                spaceCount++;
            }
        }

        String[] words = text.trim().split("\\s+");
        int wordCount = words.length;

        StringBuilder sb = new StringBuilder();

        if (wordCount == 1) {
            sb.append(words[0]);
            for (int i = 0; i < spaceCount; i++) {
                sb.append(' ');
            }
            return sb.toString();
        }

        int spacesBetween = spaceCount / (wordCount - 1);
        int extraSpaces = spaceCount % (wordCount - 1);

        String spaceGap = " ".repeat(spacesBetween);

        for (int i = 0; i < wordCount; i++) {
            sb.append(words[i]);
            if (i < wordCount - 1) {
                sb.append(spaceGap);
            }
        }

        for (int i = 0; i < extraSpaces; i++) {
            sb.append(' ');
        }

        return sb.toString();
    }
}