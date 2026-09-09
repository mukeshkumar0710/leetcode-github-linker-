class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1; // Carry is present where both bits are 1
            a = a ^ b;                // XOR performs addition without carrying
            b = carry;
        }
        return a;
    }
}