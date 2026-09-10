class Solution {
    public int compress(char[] chars) {
        int write = 0; // Position to write compressed output
        int read = 0;  // Position to read consecutive characters

        while (read < chars.length) {
            char currChar = chars[read];
            int count = 0;

            // Count the length of the current group of identical characters
            while (read < chars.length && chars[read] == currChar) {
                read++;
                count++;
            }

            // Write the character
            chars[write++] = currChar;

            // If the group length is > 1, write each digit of the count
            if (count > 1) {
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[write++] = c;
                }
            }
        }

        return write;
    }
}