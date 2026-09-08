class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> digits = new ArrayList<>();

        for (int num : nums) {
            String s = Integer.toString(num);
            for (int i = 0; i < s.length(); i++) {
                digits.add(s.charAt(i) - '0');
            }
        }

        int[] result = new int[digits.size()];
        for (int i = 0; i < digits.size(); i++) {
            result[i] = digits.get(i);
        }

        return result;
    }
}