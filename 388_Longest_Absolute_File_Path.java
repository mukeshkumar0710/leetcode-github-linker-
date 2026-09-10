class Solution {
    public int lengthLongestPath(String input) {
        String[] lines = input.split("\n");
        // max depth cannot exceed lines.length + 1
        int[] levelLengths = new int[lines.length + 1];
        int maxLength = 0;

        for (String line : lines) {
            // Find depth by counting leading '\t' characters
            int depth = line.lastIndexOf('\t') + 1;
            int nameLength = line.length() - depth;

            if (line.contains(".")) {
                // It's a file: total length is parent directories + file name
                int totalLength = levelLengths[depth] + nameLength;
                maxLength = Math.max(maxLength, totalLength);
            } else {
                // It's a directory: record path length up to this level including '/'
                levelLengths[depth + 1] = levelLengths[depth] + nameLength + 1;
            }
        }

        return maxLength;
    }
}