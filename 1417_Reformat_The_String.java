class Solution {
    public String reformat(String s) {
        List<Character> letters = new ArrayList<>();
        List<Character> digits = new ArrayList<>();

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                digits.add(c);
            } else {
                letters.add(c);
            }
        }

        if (Math.abs(letters.size() - digits.size()) > 1) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        boolean letterFirst = letters.size() >= digits.size();
        int i = 0, j = 0;

        while (i < letters.size() || j < digits.size()) {
            if (letterFirst) {
                if (i < letters.size()) {
                    sb.append(letters.get(i++));
                }
                if (j < digits.size()) {
                    sb.append(digits.get(j++));
                }
            } else {
                if (j < digits.size()) {
                    sb.append(digits.get(j++));
                }
                if (i < letters.size()) {
                    sb.append(letters.get(i++));
                }
            }
        }

        return sb.toString();
    }
}