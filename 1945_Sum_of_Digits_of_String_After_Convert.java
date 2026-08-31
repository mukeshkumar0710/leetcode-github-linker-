class Solution {
    public int getLucky(String s, int k) {
        int sum = 0;

        for (char c : s.toCharArray()) {
            int val = c - 'a' + 1;
            sum += val / 10 + val % 10;
        }

        while (--k > 0) {
            int nextSum = 0;
            while (sum > 0) {
                nextSum += sum % 10;
                sum /= 10;
            }
            sum = nextSum;
        }

        return sum;
    }
}