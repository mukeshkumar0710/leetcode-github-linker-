class Solution {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();

        // The first number cannot exceed half the total length
        for (int i = 1; i <= n / 2; i++) {
            // Numbers with leading zeros cannot have length > 1
            if (num.charAt(0) == '0' && i > 1) {
                break;
            }

            String s1 = num.substring(0, i);

            // The remaining part must be at least as long as max(s1.length, s2.length)
            for (int j = 1; Math.max(i, j) <= n - i - j; j++) {
                if (num.charAt(i) == '0' && j > 1) {
                    break;
                }

                String s2 = num.substring(i, i + j);

                if (isValidSequence(s1, s2, i + j, num)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isValidSequence(String s1, String s2, int k, String num) {
        while (k < num.length()) {
            String sum = addStrings(s1, s2);
            if (!num.startsWith(sum, k)) {
                return false;
            }
            k += sum.length();
            s1 = s2;
            s2 = sum;
        }
        return true;
    }

    private String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;

        while (i >= 0 || j >= 0 || carry != 0) {
            int digit1 = i >= 0 ? num1.charAt(i--) - '0' : 0;
            int digit2 = j >= 0 ? num2.charAt(j--) - '0' : 0;
            int total = digit1 + digit2 + carry;
            sb.append(total % 10);
            carry = total / 10;
        }

        return sb.reverse().toString();
    }
}