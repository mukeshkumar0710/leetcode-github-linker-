class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int hold = -prices[0];
        int sold = 0;
        int rest = 0;

        for (int i = 1; i < prices.length; i++) {
            int prevHold = hold;
            int prevSold = sold;
            int prevRest = rest;

            // hold: continue holding or buy stock after cooldown (rest)
            hold = Math.max(prevHold, prevRest - prices[i]);
            // sold: sell the stock currently held
            sold = prevHold + prices[i];
            // rest: continue resting or cooldown after selling yesterday
            rest = Math.max(prevRest, prevSold);
        }

        return Math.max(sold, rest);
    }
}