class Solution {
    public String originalDigits(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        int[] digits = new int[10];

        // Step 1: Digits with characters that appear uniquely across 0-9
        digits[0] = count['z' - 'a']; // 'z' is only in "zero"
        digits[2] = count['w' - 'a']; // 'w' is only in "two"
        digits[4] = count['u' - 'a']; // 'u' is only in "four"
        digits[6] = count['x' - 'a']; // 'x' is only in "six"
        digits[8] = count['g' - 'a']; // 'g' is only in "eight"

        // Step 2: Digits that become unique once the first set is accounted for
        digits[3] = count['h' - 'a'] - digits[8];             // 'h' in "three", "eight"
        digits[5] = count['f' - 'a'] - digits[4];             // 'f' in "five", "four"
        digits[7] = count['s' - 'a'] - digits[6];             // 's' in "seven", "six"
        digits[1] = count['o' - 'a'] - digits[0] - digits[2] - digits[4]; // 'o' in "zero", "one", "two", "four"
        digits[9] = count['i' - 'a'] - digits[5] - digits[6] - digits[8]; // 'i' in "five", "six", "eight", "nine"

        // Build the result string in ascending order
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            while (digits[i]-- > 0) {
                sb.append(i);
            }
        }

        return sb.toString();
    }
}