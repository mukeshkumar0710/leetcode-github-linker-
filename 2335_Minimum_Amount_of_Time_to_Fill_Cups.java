class Solution {
    public int fillCups(int[] amount) {
        Arrays.sort(amount);
        int sum = amount[0] + amount[1] + amount[2];

        if (amount[2] >= amount[0] + amount[1]) {
            return amount[2];
        }

        return (sum + 1) / 2;
    }
}